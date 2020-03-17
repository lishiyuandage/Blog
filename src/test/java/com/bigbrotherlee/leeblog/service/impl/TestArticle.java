package com.bigbrotherlee.leeblog.service.impl;

import java.util.Date;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import com.bigbrotherlee.leeblog.domain.entity.Article;
import com.bigbrotherlee.leeblog.domain.entity.ClassificationSmall;
import com.bigbrotherlee.leeblog.domain.entity.RealUser;
import com.bigbrotherlee.leeblog.service.ArticleService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TestArticle {
	@Autowired
	private ArticleService articleService;
	public void setArticleService(ArticleService articleService) {
		this.articleService = articleService;
	}
	@Test
	public void test1() {
		Article article=new Article();
		RealUser user=new RealUser();
		user.setUserId("1");
		ClassificationSmall small=new ClassificationSmall();
		small.setSmallId(1);
		article.setArticleClose(true);
		article.setArticleCreateDate(new Date());
		article.setArticleContent("你好世界你好世界你好世界你好世界你好世界你好世界你好世界你好世界你好世界你好世界你好世界你好世界你好世界你好世界你好世界你好世界你好世界你好世界你好世界你好世界你好世界你好世界");
		article.setArticleHide(true);
		article.setArticleImage("image/head.jpg");
		article.setArticleSee(1);
		article.setSmall(small);
		article.setArticleTitle("标题");
		article.setUser(user);
		articleService.addArticle(article);
		System.out.println(article);
	}
	@Test
	public void test2() {
		 Article article=articleService.getArticleById(1);
		try {
			System.out.println(new ObjectMapper().writeValueAsString(article));
		} catch (JsonProcessingException e) {
			System.out.println(e.getMessage());
		}
	}
}
