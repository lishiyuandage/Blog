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
import com.bigbrotherlee.leeblog.domain.entity.Tag;
import com.bigbrotherlee.leeblog.service.TagService;
import com.github.pagehelper.PageInfo;

@RestController
@RequestMapping(value="/tag",produces="application/json; charset=UTF-8")
public class TagController {
	@Autowired
	private TagService tagService;
	@GetMapping("/get/{tagId}")
	public Tag get(@PathVariable String tagId) {
		return tagService.getTagById(tagId);
	}
	@GetMapping("/getByName/{name}")
	public Tag getByName(@PathVariable("name") String tagName) {
		return tagService.getTagByName(tagName);
	}
	@GetMapping("/get/{index}/{length}")
	public PageInfo<Tag> get(@PathVariable int index,@PathVariable int length){
		return tagService.findTagByKey(null, index, length);
	}
	@GetMapping("/get/{key}/{index}/{length}")
	public PageInfo<Tag> get(@PathVariable int index,@PathVariable int length,@PathVariable String key){
		return tagService.findTagByKey(key, index, length);
	}
	@PostMapping(value="/add",produces="text/html; charset=UTF-8")
	public String  add(Tag tag,HttpSession session) {
		try {
			if(ObjectUtils.anyNotNull(session.getAttribute("admin"),session.getAttribute("realuser"))) {
				tagService.addTag(tag);
				return "添加成功";
			}
			return "权限不足";
		}catch(Exception exception) {
			return "添加出错";
		}
	}
	@DeleteMapping(value="/delete/{tagId}",produces="text/html; charset=UTF-8")
	public String delete(HttpSession session,@PathVariable String tagId) {
		try {
			if(ObjectUtils.anyNotNull(session.getAttribute("admin"),session.getAttribute("realuser"))) {
				tagService.deleteTag(tagId);
				return "已删除";
			}else {
				return "权限不足";
			}
		}catch (Exception e) {
			return "删除出错";
		}
	}
	@PutMapping(value="/update",produces="text/html; charset=UTF-8")
	public String update(Tag tag,HttpSession session) {
		try {
			if(ObjectUtils.anyNotNull(session.getAttribute("admin"),session.getAttribute("realuser"))) {
				tagService.updateTag(tag);
				return "已修改";
			}else {
				return "权限不足";
			}
		}catch (Exception e) {
			return "修改出错";
		}
	}	
}
