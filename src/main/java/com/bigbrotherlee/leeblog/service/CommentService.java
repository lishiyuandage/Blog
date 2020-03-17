package com.bigbrotherlee.leeblog.service;

import com.bigbrotherlee.leeblog.domain.entity.Comment;
import com.github.pagehelper.PageInfo;

public interface CommentService {
	PageInfo<Comment> getByArticleId(Integer articleId,int index,int length);
	void add(Comment comment);
	void delete(Integer commentId);
}
