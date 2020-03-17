package com.bigbrotherlee.leeblog.service;

import com.bigbrotherlee.leeblog.domain.entity.AdminUser;

public interface AdminService {
	public AdminUser findAdminByUser(AdminUser user);
}
