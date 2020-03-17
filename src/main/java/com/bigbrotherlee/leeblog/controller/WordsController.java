package com.bigbrotherlee.leeblog.controller;

import java.util.Date;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bigbrotherlee.leeblog.domain.entity.RealUser;
import com.bigbrotherlee.leeblog.domain.entity.Words;
import com.bigbrotherlee.leeblog.service.WordsService;
import com.github.pagehelper.PageInfo;

@RestController
@RequestMapping("words")
public class WordsController {
	@Autowired
	private WordsService wordsService;
	
	@PostMapping(value="add",produces="text/html; charset=UTF-8")
	public String add(HttpSession session,Words words) {
		Object o=session.getAttribute("realuser");
		if(o!=null) {
			words.setUser((RealUser)o);
			words.setWordsCreateDate(new Date());
			wordsService.addWords(words);
			return "添加成功";
		}else {
			return "权限不足";
		}
	}
	@DeleteMapping("/delete/{wordsId}")
	public void delete(HttpSession session,@PathVariable String wordsId) {
		Object o=session.getAttribute("realuser");
		if(o!=null) {
			wordsService.deleteWords(wordsId,(RealUser)o);
		}
	}
	@GetMapping("/get/{wordsId}")
	public Words get(@PathVariable String wordsId) {
		return wordsService.getWordsById(wordsId);
	}
	@GetMapping("/get/{key}/{index}/{length}")
	public PageInfo<Words> get(@PathVariable String key,@PathVariable int index,@PathVariable int length){
		return wordsService.searchByKey(key, index, length);
	}
	@GetMapping("/getUser/{index}/{length}")
	public PageInfo<Words> getByUser(HttpSession session,@PathVariable int index,@PathVariable int length){
		String userId=((RealUser)session.getAttribute("realuser")).getUserId();
		return wordsService.searchByUserId(userId, index, length);
	}
}
