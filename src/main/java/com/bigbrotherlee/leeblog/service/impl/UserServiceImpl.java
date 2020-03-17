package com.bigbrotherlee.leeblog.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bigbrotherlee.leeblog.domain.entity.RealUser;
import com.bigbrotherlee.leeblog.mapper.UserMapper;
import com.bigbrotherlee.leeblog.service.UserService;
import com.bigbrotherlee.utils.MD5;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {
	@Autowired
	private UserMapper userMapper;
	
	@Override
	public void addUser(RealUser user) {
		String password=MD5.getMessageDigest("123456");
		user.setUserPassword(password);
		userMapper.createUser(user);
	}

	@Override
	public void updateUser(RealUser user) {
		userMapper.updateUser(user);
	}

	@Override
	public void deleteUser(String userId) {
		userMapper.deleteUser(userId);
	}

	@Override
	public RealUser getUserByUser(RealUser user) {
		RealUser realuser =userMapper.findUserByUser(user);
		return realuser;
	}

	@Override
	public PageInfo<RealUser> searchUser(RealUser user,int index,int length) {
		PageHelper.startPage(index, length);
		List<RealUser> userlist=userMapper.searchUserByUser(user);
		PageInfo<RealUser> users=new PageInfo<>(userlist);
		return users;
	}

	@Override
	public PageInfo<RealUser> searchUser(String key,int index,int length) {
		PageHelper.startPage(index, length);
		List<RealUser> userlist=userMapper.searchUserByKey("%"+key+"%");
		PageInfo<RealUser> users=new PageInfo<>(userlist);
		return users;
	}

}
