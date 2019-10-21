package com.mi.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mi.biz.T_UserBiz;
import com.mi.model.T_User;
import com.mi.util.pageSize;


@RestController
public class T_UserJSONController {
	
	@Resource
	private T_UserBiz userbiz;
	
	
	
//	添加用户
	@RequestMapping("insert_user")
	public Map insert_user(T_User t_user ,HttpServletRequest request) {
		Map map = new HashMap();
		
		return userbiz.insert_User(t_user);
	}
	
	
//	更新用户
	@RequestMapping("update_user")
	public Map update_user(T_User t_user, HttpServletRequest request) {
		return userbiz.update_User(t_user);
	}
	
	
	
//	删除用户
	@RequestMapping("delete_user")
	public Map delete_user(String user_id, HttpServletRequest request) {
		return userbiz.delete_User(user_id);
	}
	
	
//	查询全部用户
	@RequestMapping("select_user")
	public Map select_user(int pageid,String user_username,String user_phone,int role_id,HttpServletRequest request) {
		Map map = new HashMap();
		if(user_username==""||user_username.equals("")||user_username==null)
			user_username=null;
		else {
			user_username = "%"+user_username+"%";
		}
		if(user_phone==""||user_phone.equals("")||user_phone==null)
			user_phone=null;
		else {
			user_phone = "%"+user_phone+"%";
		}
		
		map.put("user_username", user_username);
		map.put("user_phone", user_phone);
		map.put("pageid", pageid);
		map.put("begin", (pageid-1)*pageSize.pagesize);
		map.put("pagesize", pageSize.pagesize);
		map.put("role_id", role_id);
		
		return userbiz.select_User(map);
	}
	
//	用户名有效性查询
	@RequestMapping("available_user")
	public Map available_user(T_User t_user,HttpServletRequest request, HttpServletResponse Response) {
		return userbiz.available_user(t_user);
	}
	
	
//	用户登录判断
	@RequestMapping("login_user")
	public Map login_user(T_User t_user,HttpServletRequest request, HttpServletResponse Response) {
		Cookie[] cookies = request.getCookies();
//		for (Cookie cookie : cookies) {
//			System.out.println(cookie.getName() + " = " + cookie.getValue());
//		}
		Map map =  userbiz.login_user(t_user);
		if((boolean) map.get("flag")) {
			T_User user = (T_User) map.get("t_user");
			Cookie cookie = new Cookie("user_id",user.getUser_id());
			Response.addCookie(cookie);
			return map;
		}else {
			return map;
		}

	}
	
	
//	查询用户ById
	@RequestMapping("selectone_user")
	public Map selectone_user(T_User t_user,HttpServletRequest request) {
		return userbiz.selectone_User(t_user);
	}
	
	
	
	
	
	
	
}
