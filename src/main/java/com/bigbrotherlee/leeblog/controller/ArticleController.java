package com.bigbrotherlee.leeblog.controller;

import java.net.URLDecoder;
import java.util.Date;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import com.bigbrotherlee.leeblog.domain.entity.Article;
import com.bigbrotherlee.leeblog.domain.entity.RealUser;
import com.bigbrotherlee.leeblog.domain.entity.Tag;
import com.bigbrotherlee.leeblog.service.ArticleService;
import com.bigbrotherlee.leeblog.service.TagService;
import com.bigbrotherlee.leeblog.service.TagTempService;
import com.github.pagehelper.PageInfo;
import utils.LeeConstant;

@RestController
@RequestMapping("/article")
public class ArticleController {
	@Autowired
	private ArticleService articleService;
	@Autowired
	private TagService tagService;
	@Autowired
	private TagTempService tagTempService;
	@GetMapping("/get/{id}")
	public Article get(@PathVariable Integer id) {
		return articleService.getArticleById(id);
	}
	@GetMapping("/get/{index}/{length}")
	public PageInfo<Article> getSelf(HttpSession session,@PathVariable int index,@PathVariable int length){
		String id=((RealUser)session.getAttribute("realuser")).getUserId();
		return articleService.getArticleByUserId(id, index, length);
	}
	@GetMapping("/author/{userId}/get/{index}/{length}")
	public PageInfo<Article> getByAuthor(@PathVariable String userId,@PathVariable int index,@PathVariable int length){
		return articleService.getArticleByUserId(userId, index, length);
	}
	@GetMapping("/get/{smallId}/{index}/{length}")
	public PageInfo<Article> get(@PathVariable String smallId,@PathVariable int index,@PathVariable int length){
		return articleService.getArticleBySamllId(smallId, index, length);
	}
	@GetMapping("/search/{key}/{index}/{length}")
	public PageInfo<Article> search(@PathVariable String key,@ PathVariable int index,@PathVariable int length){
		return articleService.search(key, index, length);
	}
	@GetMapping("/search/{articleTitle}/{articleContent}/{index}/{length}")
	public PageInfo<Article> search(@PathVariable(required=false) String articleTitle,@PathVariable(required=false) String articleContent,@PathVariable int index,@PathVariable int length){
		Article article=new Article();
		try {
			article.setArticleTitle(URLDecoder.decode(articleTitle, LeeConstant.ENCODING));
			article.setArticleContent(URLDecoder.decode(articleContent, LeeConstant.ENCODING));
		}catch (Exception e) {
			
		}
		return articleService.search(article, index, length);
	}
	
	@PostMapping(value="/add")
	public Article add(HttpSession session,Article article,String [] tag) {
		Object o=session.getAttribute("realuser");
		if(o!=null) {
			RealUser user=(RealUser) o;
			article.setUser(user);
			article.setArticleCreateDate(new Date());
			articleService.addArticle(article);
			for(String t:tag) {
				Tag realtag=tagService.getTagByName(t);
				if(realtag==null) {
					realtag=new Tag();
					realtag.setTagName(t);
					tagService.addTag(realtag);
				}
				tagTempService.addTagToArticle(realtag.getTagId(), article.getArticleId());
			}
		}
		return article;
	}
	@DeleteMapping("/delete/{id}")
	public void delete(HttpSession session,@PathVariable Integer id) {
		Object o=session.getAttribute("realuser");
		if(o!=null) {
			RealUser user=(RealUser) o;
			articleService.deleteArticle(id, user);
		}
	}
	@PutMapping("/update")
	public void update(HttpSession session,Article article) {
		Object o=session.getAttribute("realuser");
		if(o!=null) {
			RealUser user=(RealUser) o;
			articleService.updateArticle(article, user);
		}
	}
	@GetMapping("/editor/{id}")
	public ModelAndView showEditor(@PathVariable Integer id,HttpSession session) {
		ModelAndView mav=new ModelAndView("/WEB-INF/manage/Editor.jsp");
		RealUser user=(RealUser)session.getAttribute("realuser");
		Article a=articleService.getArticleById(id);
		if(user.getUserId().equals(a.getUser().getUserId())) {
			mav.addObject("article", a);
		}
		return mav;
	}
	@GetMapping("/show/{id}")
	public ModelAndView  show(@PathVariable Integer id) {
		return new ModelAndView("/details.jsp");
	}
	@GetMapping("/small/{id}")
	public ModelAndView  small(@PathVariable Integer id) {
		return new ModelAndView("/WEB-INF/index/index-small.jsp");
	}
	@GetMapping("/tag/{id}")
	public ModelAndView  tag(@PathVariable Integer id) {
		return new ModelAndView("/WEB-INF/index/index-tag.jsp");
	}
	@GetMapping("/author/{id}")
	public ModelAndView  author(@PathVariable Integer id) {
		return new ModelAndView("/WEB-INF/index/index-author.jsp");
	}
	
}
