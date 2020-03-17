package com.bigbrotherlee.leeblog.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.bigbrotherlee.leeblog.domain.entity.AdminUser;
import com.bigbrotherlee.leeblog.service.AdminService;

@RestController
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	private AdminService adminService;
	
	@PostMapping("/login")
	public ModelAndView getAdminById(HttpSession session,AdminUser user){
		AdminUser realUser=adminService.findAdminByUser(user);
		session.setAttribute("admin", realUser);
		return realUser!=null? new ModelAndView("/WEB-INF/manage/AdminManage.jsp"): new ModelAndView("/login.jsp");
	}
	
}
