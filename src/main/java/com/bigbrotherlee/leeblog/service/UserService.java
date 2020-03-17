package com.bigbrotherlee.leeblog.service;

import com.bigbrotherlee.leeblog.domain.entity.RealUser;
import com.github.pagehelper.PageInfo;

public interface UserService {
	public void addUser(RealUser user) ;
	public void updateUser(RealUser user);
	public void deleteUser(String userId);
	public RealUser getUserByUser(RealUser user) ;
	public PageInfo<RealUser> searchUser(RealUser user,int index,int length);
	public PageInfo<RealUser> searchUser(String key,int index,int length);
}
