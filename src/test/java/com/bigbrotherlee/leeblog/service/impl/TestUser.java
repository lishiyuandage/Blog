package com.bigbrotherlee.leeblog.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import com.bigbrotherlee.leeblog.domain.entity.RealUser;
import com.bigbrotherlee.leeblog.service.UserService;
import com.bigbrotherlee.utils.MD5;

@RunWith(SpringRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TestUser {
	@Autowired
	private UserService userService;
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	@Test
	public void test1() {
		RealUser user=new RealUser();
		user.setUserCode("001");
		user.setUserEmail("1729944291@qq.com");
		user.setUserName("李大哥");
		user.setUserSex(true);
		user.setUserPassword(MD5.getMessageDigest("123456"));
		userService.addUser(user);
	}
	@Test
	public void test2(){
		RealUser user=new RealUser();
		user.setUserId("1");
		user.setUserCode("001");
		user.setUserEmail("1729944291@qq.com");
		user.setUserName("李mumu");
		user.setUserSex(true);
		user.setUserPassword(MD5.getMessageDigest("123456"));
		userService.updateUser(user);
	}
	@Test
	public void test3() {
		userService.deleteUser("2");
	}
	@Test
	public void tset4() {
		RealUser user=new RealUser();
		user.setUserName("李大哥");
		user.setUserPassword(MD5.getMessageDigest("123456"));
		userService.getUserByUser(user);
	}
	@Test
	public void test5() {
		RealUser user=new RealUser();
		user.setUserName("李");
		user.setUserCode("001");
		userService.searchUser(user, 1, 10);
	}
	@Test
	public void test6() {
		System.out.println(userService.searchUser("李", 1, 10).getList().get(0).getArticles().size());
	}
	
}
