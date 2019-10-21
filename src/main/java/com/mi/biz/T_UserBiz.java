package com.mi.biz;

import java.util.List;
import java.util.Map;

import com.mi.model.T_User;



public interface T_UserBiz {

	
//	添加用户
	public Map insert_User(T_User t_user);
	
	
//	修改用户
	public Map update_User(T_User t_user);
	
	
//	删除用户
	public Map delete_User(String user_id);
	
	
//	分页多条件查询用户
	public Map select_User(Map map);
	
	
//	查询用户ById
	public Map selectone_User(T_User t_user);
	
	
//	用户登录判断
	public Map login_user(T_User user);
	

//	用户名有效性查询
	public Map available_user(T_User t_user);
	
	
	
	
	
	
}
