package com.bigbrotherlee.leeblog.service;

import com.bigbrotherlee.leeblog.domain.entity.RealUser;
import com.bigbrotherlee.leeblog.domain.entity.Words;
import com.github.pagehelper.PageInfo;

public interface WordsService {
	public void addWords(Words words);
	public void deleteWords(String wordsId,RealUser user);
	public Words getWordsById(String wordsId);
	public PageInfo<Words> searchByKey(String key,int index,int length);
	public PageInfo<Words> searchByUserId(String userId,int index,int length);
}
