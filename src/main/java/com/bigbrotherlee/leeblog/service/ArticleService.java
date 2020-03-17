package com.bigbrotherlee.leeblog.service;

import com.bigbrotherlee.leeblog.domain.entity.Article;
import com.bigbrotherlee.leeblog.domain.entity.RealUser;
import com.github.pagehelper.PageInfo;

public interface ArticleService {
	public Article getArticleById(Integer articleId);
	public PageInfo<Article> getArticleBySamllId(String smallId,int index,int length);
	public PageInfo<Article> getArticleByUserId(String userId,int index,int length);
	public PageInfo<Article> search(String key,int index,int length);
	public PageInfo<Article> search(Article article,int index,int length);
	public void addArticle(Article article);
	public void deleteArticle(Integer articleId,RealUser user);
	public void updateArticle(Article article,RealUser user);
}
