package com.bigbrotherlee.leeblog.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bigbrotherlee.leeblog.domain.entity.Tag;
import com.bigbrotherlee.leeblog.mapper.TagMapper;
import com.bigbrotherlee.leeblog.service.TagService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service("tagService")
@Transactional
public class TagServiceImpl implements TagService {
	@Autowired
	private TagMapper tagMapper;
	@Override
	public void addTag(Tag tag) {
		tagMapper.create(tag);
	}

	@Override
	public void deleteTag(String tagId) {
		tagMapper.delete(tagId);
	}

	@Override
	public void updateTag(Tag tag) {
		tagMapper.update(tag);
	}

	@Override
	public Tag getTagById(String tagId) {
		return tagMapper.findTagById(tagId);
	}

	@Override
	public PageInfo<Tag> findTagByKey(String key,int index,int length) {
		PageHelper.startPage(index, length).setOrderBy("tagId desc");
		List<Tag> tags=key==null?tagMapper.findAll():tagMapper.findByKey("%"+key+"%");
		PageInfo<Tag> tagList=new PageInfo<>(tags);
		return tagList;
	}

	@Override
	public Tag getTagByName(String tagName) {
		return tagMapper.findByName(tagName);
	}

}
