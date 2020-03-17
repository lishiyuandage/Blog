package com.bigbrotherlee.leeblog.controller;

import javax.servlet.http.HttpSession;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bigbrotherlee.leeblog.domain.entity.ClassificationSmall;
import com.bigbrotherlee.leeblog.service.ClassifySmallService;
import com.github.pagehelper.PageInfo;

//类别实际只要一张表就可以了
@RestController
@RequestMapping("small")
public class ClassSmallController {
	@Autowired
	private ClassifySmallService classifySmallService;
	@GetMapping("/get/{index}/{length}")
	public PageInfo<ClassificationSmall> get(@PathVariable int index,@PathVariable int length ,String key) {
		return classifySmallService.find(index, length);
	}
	@GetMapping("/get/{bigId}/{index}/{length}")
	public PageInfo<ClassificationSmall> get(@PathVariable int index,@PathVariable int length,@PathVariable int bigId) {
		return classifySmallService.find(bigId, index, length);
	}
	@DeleteMapping("/delete/{smallId}")
	public void delete(HttpSession session ,@PathVariable String smallId) {
		if(ObjectUtils.anyNotNull(session.getAttribute("admin"),session.getAttribute("realuser"))) {
			classifySmallService.deleteSmall(smallId);
		}
	}
	@PostMapping(value="/add",produces="text/html; charset=UTF-8")
	public String  add(HttpSession session,ClassificationSmall small) {
		try {
			if(ObjectUtils.anyNotNull(session.getAttribute("admin"),session.getAttribute("realuser"))) {
				classifySmallService.addSmall(small);
				return "添加成功";
			}else {
				return "权限不足";
			}
		}catch(Exception e) {
			return "出错";
		}
		
	}
	@PutMapping(value="/update",produces="text/html; charset=UTF-8")
	public String  update(HttpSession session,ClassificationSmall small) {
		try {
		if(ObjectUtils.anyNotNull(session.getAttribute("admin"),session.getAttribute("realuser"))) {
			classifySmallService.updateSmall(small);
			return "修改成功";
		}else {
			return "权限不足";
		}
		}catch(Exception e) {
			return "出错";
		}
	}
}
