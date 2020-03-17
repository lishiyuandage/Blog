package com.bigbrotherlee.leeblog.controller;

import javax.servlet.http.HttpSession;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import com.bigbrotherlee.leeblog.domain.entity.RealUser;
import com.bigbrotherlee.leeblog.service.UserService;
import com.bigbrotherlee.utils.MD5;
import com.github.pagehelper.PageInfo;

@RestController
@RequestMapping(value="/user",produces="text/html; charset=UTF-8")
public class UserController {
	@Autowired
	private UserService userService;

	
	@PostMapping("/login")
	public ModelAndView login(HttpSession session,RealUser user) {
		user.setUserPassword(MD5.getMessageDigest(user.getUserPassword()));
		RealUser realUser= userService.getUserByUser(user);
		if(realUser!=null) {
			session.setAttribute("realuser", realUser);
			return new ModelAndView("/WEB-INF/manage/UserManage.jsp");
		}
		return new ModelAndView("/login.jsp");
	}
	
	@GetMapping("/logout")
	public ModelAndView logout(HttpSession session) {
		session.invalidate();
		return new ModelAndView("/login.jsp");
	}
	
	@DeleteMapping("/delete/{id}")
	public void delete(HttpSession session,@PathVariable("id") String userId) {
		if(ObjectUtils.allNotNull(session.getAttribute("admin"))) {
			userService.deleteUser(userId);
		}
	}
	
	@PostMapping("/add")
	public String add(HttpSession session,RealUser user) {
		try {
		if(session.getAttribute("admin")!=null) {
			user.setUserPassword(MD5.getMessageDigest("123456"));
			userService.addUser(user);
			return "添加成功";
		}
		return "权限不足";
		}catch (Exception e) {
			return "添加出错";
		}
	}
	
	@PutMapping("/update")
	public void update(HttpSession session,RealUser user) {
		RealUser realuser=(RealUser)session.getAttribute("realuser");
		BeanUtils.copyProperties(user,realuser , "userId","userCode");
		userService.updateUser(realuser);
	}
	@PutMapping("/updateBySelf")
	public String updateBySelf(HttpSession session,RealUser user) {
		RealUser realuser=(RealUser)session.getAttribute("realuser");
		BeanUtils.copyProperties(user,realuser , "userId","userPassword");
		userService.updateUser(realuser);
		return "修改成功";
	}
	
	@PutMapping("/updatePassword")
	public String updatePassword(HttpSession session,String oldPassword,String newPassword) {
		RealUser realuser=(RealUser)session.getAttribute("realuser");
		String newPwd=MD5.getMessageDigest(newPassword);
		String oldPwd=MD5.getMessageDigest(oldPassword);
		if(oldPwd.equals(realuser.getUserPassword())) {
			realuser.setUserPassword(newPwd);
			userService.updateUser(realuser);
			return "修改成功";
		}else {
			return "密码错误";
		}
	}
	
	@GetMapping(value="/myinfo" ,produces="application/json; charset=UTF-8")
	public RealUser myinfo(HttpSession session) {
		RealUser user=(RealUser)session.getAttribute("realuser");
		return user;
	}
	@GetMapping(value= {"/search/{userCode}/{userName}/{userEmail}/{userSex}/{index}/{length}",
			"/search/{userCode}/{userName}/{userEmail}/{index}/{length}"},
			produces="application/json; charset=UTF-8")
	public PageInfo<RealUser> search(
			HttpSession session,@PathVariable(required=false) String userCode,@PathVariable(required=false) String userName,
			@PathVariable(required=false) String userEmail ,@PathVariable(required=false) Boolean userSex,
			@PathVariable("index") int index,@PathVariable("length") int length){
		RealUser user=new RealUser();
		user.setUserCode(userCode);
		user.setUserEmail(userEmail);
		user.setUserName(userName);
		user.setUserSex(userSex);
		PageInfo<RealUser> users=null;
		if(ObjectUtils.allNotNull(session.getAttribute("admin"))) {
			users=userService.searchUser(user, index, length);
		}
		return users;
	}
	@GetMapping(value="/search/{key}/{index}/{length}",produces="application/json; charset=UTF-8")
	public PageInfo<RealUser> search(
			HttpSession session,@PathVariable("key") String key,@PathVariable("index") int index,@PathVariable("length") int length){
		PageInfo<RealUser> users=null;
		if(ObjectUtils.allNotNull(session.getAttribute("admin"))) 
			users=userService.searchUser(key,index, length);
		return users;	
	}
	
	
}
