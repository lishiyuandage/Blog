package com.bigbrotherlee.leeblog.service;

import com.bigbrotherlee.leeblog.domain.entity.Tag;
import com.github.pagehelper.PageInfo;

public interface TagService {
	public void addTag(Tag tag);
	public void deleteTag(String tagId);
	public void updateTag(Tag tag);
	public Tag getTagById(String tagId);
	public Tag getTagByName(String tagName);
	public PageInfo<Tag> findTagByKey(String key,int index ,int length);
}
