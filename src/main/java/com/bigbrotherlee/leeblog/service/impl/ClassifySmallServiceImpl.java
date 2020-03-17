package com.bigbrotherlee.leeblog.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bigbrotherlee.leeblog.domain.entity.ClassificationSmall;
import com.bigbrotherlee.leeblog.mapper.ClassifySmallMapper;
import com.bigbrotherlee.leeblog.service.ClassifySmallService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service("classifySmallService")
@Transactional
public class ClassifySmallServiceImpl implements ClassifySmallService {
	@Autowired
	private ClassifySmallMapper classifySmallMapper;
	
	@Override
	public void addSmall(ClassificationSmall small) {
		classifySmallMapper.create(small);
	}

	@Override
	public void deleteSmall(String smallId) {
		classifySmallMapper.delete(smallId);
	}

	@Override
	public void updateSmall(ClassificationSmall small) {
		classifySmallMapper.update(small);
	}

	@Override
	public PageInfo<ClassificationSmall> find(int index, int length) {
		PageHelper.startPage(index, length);
		List<ClassificationSmall> smallList=classifySmallMapper.findAll();
		PageInfo<ClassificationSmall> smalls=new PageInfo<>(smallList);
		return smalls;
	}

	@Override
	public PageInfo<ClassificationSmall> find(int bigId, int index, int length) {
		PageHelper.startPage(index, length);
		List<ClassificationSmall> smallList=classifySmallMapper.findByBigId(bigId);
		PageInfo<ClassificationSmall> smalls=new PageInfo<>(smallList);
		return smalls;
	}

}
