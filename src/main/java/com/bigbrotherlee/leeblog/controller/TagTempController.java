package com.bigbrotherlee.leeblog.controller;

import javax.servlet.http.HttpSession;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bigbrotherlee.leeblog.service.TagTempService;

@RestController
@RequestMapping("/tagtemp")
public class TagTempController {
	@Autowired
	private TagTempService tagTempService;
	@PostMapping("/add")
	public void add(Integer tagId,Integer articleId) {
		tagTempService.addTagToArticle(tagId, articleId);
	}
	@DeleteMapping("/delete/{tagId}/{articleId}")
	public void delete(HttpSession session,@PathVariable Integer tagId,@PathVariable Integer articleId) {
		if(ObjectUtils.anyNotNull(session.getAttribute("admin"),session.getAttribute("realuser"))) {
			tagTempService.removeTagToArticle(tagId, articleId);
		}
	}
}
