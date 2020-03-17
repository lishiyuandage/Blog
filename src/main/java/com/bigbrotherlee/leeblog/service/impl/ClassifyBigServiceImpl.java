package com.bigbrotherlee.leeblog.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bigbrotherlee.leeblog.domain.entity.ClassificationBig;
import com.bigbrotherlee.leeblog.mapper.ClassifyBigMapper;
import com.bigbrotherlee.leeblog.service.ClassifyBigService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service("classifyBigService")
@Transactional
public class ClassifyBigServiceImpl implements ClassifyBigService {
	@Autowired
	private ClassifyBigMapper classifyBigMapper;

	@Override
	public void addClassify(ClassificationBig big) {
		classifyBigMapper.createClassify(big);
	}

	@Override
	public void deleteClassify(Integer classifyId) {
		classifyBigMapper.deleteClassify(classifyId);
	}

	@Override
	public void updateClassify(ClassificationBig big) {
		classifyBigMapper.updateClassify(big);
	}

	@Override
	public PageInfo<ClassificationBig> getByKey(String key,int index ,int length) {
		PageHelper.startPage(index,length).setOrderBy("bigId desc");
		List<ClassificationBig> list= classifyBigMapper.find("%"+key+"%");
		PageInfo<ClassificationBig> info=new PageInfo<>(list);
		return info;
	}

	@Override
	public ClassificationBig get(String classifyId) {
		return classifyBigMapper.findClassifyById(classifyId);
	}

}
