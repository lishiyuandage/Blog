package com.bigbrotherlee.leeblog.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bigbrotherlee.leeblog.domain.entity.RealUser;
import com.bigbrotherlee.leeblog.domain.entity.Words;
import com.bigbrotherlee.leeblog.mapper.WordsMapper;
import com.bigbrotherlee.leeblog.service.WordsService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service("wordsService")
@Transactional
public class WordsServiceImpl implements WordsService {
	@Autowired
	private WordsMapper wordsMapper;
	
	@Override
	public void addWords(Words words) {
		wordsMapper.create(words);
	}

	@Override
	public void deleteWords(String wordsId,RealUser user) {
		Words words=wordsMapper.findById(wordsId);
		if(user.getUserId().equals(words.getUser().getUserId())) {//本人删除
			wordsMapper.delete(wordsId);
		}
	}

	@Override
	public Words getWordsById(String wordsId) {
		return wordsMapper.findById(wordsId);
	}

	@Override
	public PageInfo<Words> searchByKey(String key, int index, int length) {
		PageHelper.startPage(index, length, "wordsCreateDate");
		List<Words> list=wordsMapper.findWordsByKey("%"+key+"%");
		PageInfo<Words> info=new PageInfo<>(list);
		return info;
	}

	@Override
	public PageInfo<Words> searchByUserId(String userId, int index, int length) {
		PageHelper.startPage(index, length, "wordsCreateDate");
		List<Words> list=wordsMapper.findWordsByAuthor(userId);
		PageInfo<Words> info=new PageInfo<>(list);
		return info;
	}

}
