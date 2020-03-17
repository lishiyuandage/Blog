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
import com.bigbrotherlee.leeblog.domain.entity.ClassificationBig;
import com.bigbrotherlee.leeblog.service.ClassifyBigService;
import com.github.pagehelper.PageInfo;

@RestController
@RequestMapping("/big")
public class ClassBigController {
	@Autowired
	private ClassifyBigService classifyBigService;
	
	@GetMapping("/get/{id}")
	public ClassificationBig get(@PathVariable("id") String classId) {
		return classifyBigService.get(classId);
	}
	
	@GetMapping("/get/{index}/{length}")
	public PageInfo<ClassificationBig> get(@PathVariable int index,@PathVariable int length){
		return classifyBigService.getByKey("_",index,length);
	}
	
	@GetMapping("/get/{key}/{index}/{length}")
	public PageInfo<ClassificationBig> get(@PathVariable String key,@PathVariable int index,@PathVariable int length ){
		return classifyBigService.getByKey(key, index, length);
	}
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable("id") Integer id) {
		classifyBigService.deleteClassify(id);
	}
	
	@PutMapping(value="/update",produces="text/html; charset=UTF-8")
	public String  update(ClassificationBig big,HttpSession session) {
		try {
			if(ObjectUtils.anyNotNull(session.getAttribute("admin"),session.getAttribute("realuser"))) {
				classifyBigService.updateClassify(big);
				return "更新成功";
			}
			return "权限不足";
		}catch (Exception e) {
			return "更新出错";
		}
	}
	
	@PostMapping(value="/add",produces="text/html; charset=UTF-8")
	public String add(ClassificationBig big,HttpSession session) {
		try {
			if(ObjectUtils.anyNotNull(session.getAttribute("admin"),session.getAttribute("realuser"))) {
				classifyBigService.addClassify(big);
				return "添加成功";
			}
			return "权限不足";
		}catch (Exception e) {
			return "添加出错";
		}
	}
	
}
