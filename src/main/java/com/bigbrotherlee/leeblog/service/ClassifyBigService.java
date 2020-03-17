package com.bigbrotherlee.leeblog.service;

import com.bigbrotherlee.leeblog.domain.entity.ClassificationBig;
import com.github.pagehelper.PageInfo;

public interface ClassifyBigService {
	public void addClassify(ClassificationBig big) ;
	public void deleteClassify(Integer classifyId);
	public void updateClassify(ClassificationBig big);
	public PageInfo<ClassificationBig> getByKey(String key,int index ,int length);
	public ClassificationBig get(String classifyId);
}
