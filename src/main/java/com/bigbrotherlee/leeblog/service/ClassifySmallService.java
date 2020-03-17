package com.bigbrotherlee.leeblog.service;

import com.bigbrotherlee.leeblog.domain.entity.ClassificationSmall;
import com.github.pagehelper.PageInfo;

public interface ClassifySmallService {
	public void addSmall(ClassificationSmall small);
	public void deleteSmall(String smallId);
	public void updateSmall(ClassificationSmall small);
	public PageInfo<ClassificationSmall> find(int index,int length);
	public PageInfo<ClassificationSmall> find(int bigId,int index,int length);
}
