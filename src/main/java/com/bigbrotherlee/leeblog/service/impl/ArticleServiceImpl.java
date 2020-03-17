package com.bigbrotherlee.leeblog.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bigbrotherlee.leeblog.domain.entity.Article;
import com.bigbrotherlee.leeblog.domain.entity.RealUser;
import com.bigbrotherlee.leeblog.mapper.ArticleMapper;
import com.bigbrotherlee.leeblog.service.ArticleService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service("articleService")
@Transactional
public class ArticleServiceImpl implements ArticleService {
	@Autowired
	private ArticleMapper articleMapper;
	
	@Override
	public Article getArticleById(Integer articleId) {
		Article article=articleMapper.findById(articleId);
		if(article!=null) {
			article.setArticleSee(article.getArticleSee()+1);
			articleMapper.updateArticle(article);
		}
		return article;
	}

	@Override
	public PageInfo<Article> getArticleBySamllId(String smallId,int index,int length) {
		PageHelper.startPage(index, length);
		List<Article> list=articleMapper.findBySmallId(smallId);
		PageInfo<Article> info=new PageInfo<Article>(list);
		return info;
	}

	@Override
	public PageInfo<Article> search(String key,int index,int length) {
		PageHelper.startPage(index, length);
		List<Article> list=articleMapper.searchByKey("%"+key+"%");
		PageInfo<Article> info=new PageInfo<Article>(list);
		return info;
	}

	@Override
	public PageInfo<Article> search(Article article,int index,int length) {
		PageHelper.startPage(index, length);
		List<Article> list=articleMapper.searchByArticle(article);
		PageInfo<Article> info=new PageInfo<Article>(list);
		return info;
	}

	@Override
	public void addArticle(Article article) {
		articleMapper.createArticle(article);
	}

	@Override
	public void deleteArticle(Integer articleId,RealUser user) {
		Article article=articleMapper.findById(articleId);
		System.out.println(article+"=================");
		System.out.println(user+"---------------------");
		if(user.getUserId().equals(article.getUser().getUserId())) {
			articleMapper.deleteArricle(articleId);
		}
	}

	@Override
	public void updateArticle(Article article,RealUser user) {
		Article realarticle=articleMapper.findById(article.getArticleId());
		if(user.getUserId().equals(realarticle.getUser().getUserId())) {
			articleMapper.updateArticle(article);
		}
	}
	@Override
	public PageInfo<Article> getArticleByUserId(String userId, int index, int length) {
		PageHelper.startPage(index, length);
		List<Article> list=articleMapper.findByUserId(userId);
		PageInfo<Article> info=new PageInfo<>(list);
		return info;
	}

}
