package com.bigbrotherlee.leeblog.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bigbrotherlee.leeblog.domain.entity.Comment;
import com.bigbrotherlee.leeblog.mapper.CommentMapper;
import com.bigbrotherlee.leeblog.service.CommentService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service("commentService")
@Transactional
public class CommentServiceImpl implements CommentService {
	@Autowired
	private CommentMapper commentMapper;
	@Override
	public PageInfo<Comment> getByArticleId(Integer articleId, int index, int length) {
		PageHelper.startPage(index, length, "commentCreateDate desc");
		List<Comment> list=commentMapper.find(articleId);
		return new PageInfo<>(list);
	}

	@Override
	public void add(Comment comment) {
		comment.setCommentHide(false);
		comment.setCommentCreateDate(new Date());
		commentMapper.create(comment);
	}

	@Override
	public void delete(Integer commentId) {
		commentMapper.delete(commentId);
	}

}
