package com.bigbrotherlee.leeblog.service;

public interface TagTempService {
	public void addTagToArticle(Integer tagId,Integer articleId);
	public void removeTagToArticle(Integer tagId,Integer articleId);
}
