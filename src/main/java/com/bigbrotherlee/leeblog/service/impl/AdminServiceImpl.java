package com.bigbrotherlee.leeblog.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bigbrotherlee.leeblog.domain.entity.AdminUser;
import com.bigbrotherlee.leeblog.mapper.AdminMapper;
import com.bigbrotherlee.leeblog.service.AdminService;
import com.bigbrotherlee.utils.MD5;

@Service("adminService")
@Transactional
public class AdminServiceImpl implements AdminService {
	@Autowired
	private AdminMapper adminMapper;

	@Override
	public AdminUser findAdminByUser(AdminUser user) {
		String password=MD5.getMessageDigest(user.getAdminPassword());
		user.setAdminPassword(password);
		return adminMapper.findAdminByUser(user);
	}


	
	
}
