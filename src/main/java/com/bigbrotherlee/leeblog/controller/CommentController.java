package com.bigbrotherlee.leeblog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bigbrotherlee.leeblog.domain.entity.Comment;
import com.bigbrotherlee.leeblog.service.CommentService;
import com.github.pagehelper.PageInfo;

@RestController
@RequestMapping("comment")
public class CommentController {
	@Autowired
	private CommentService commentService;
	
	@GetMapping("/get/{articleId}/{index}/length")
	public PageInfo<Comment> get(@PathVariable Integer articleId ,@PathVariable int index, @PathVariable int length){
		return commentService.getByArticleId(articleId, index, length);
	}
	@PostMapping("/add")
	public void add(Comment comment) {
		commentService.add(comment);
	}
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable Integer id) {
		commentService.delete(id);
	}
}
