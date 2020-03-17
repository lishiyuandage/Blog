package com.bigbrotherlee.leeblog.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bigbrotherlee.leeblog.mapper.TagTempMapper;
import com.bigbrotherlee.leeblog.service.TagTempService;

@Service("tagTempService")
@Transactional
public class TagTempServiceImpl implements TagTempService {
	@Autowired
	private TagTempMapper tagTempMapper;
	@Override
	public void addTagToArticle(Integer tagId, Integer articleId) {
		tagTempMapper.insert(tagId, articleId);
	}

	@Override
	public void removeTagToArticle(Integer tagId, Integer articleId) {
		tagTempMapper.delete(tagId, articleId);
	}

}
