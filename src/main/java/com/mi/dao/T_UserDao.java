package com.mi.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import com.mi.model.T_User;


@Mapper
public interface T_UserDao {
	
//	添加用户
	public int user_insert(T_User user);
	
	
//	更新用户
	public int user_update(T_User user);
	
	
//	删除用户
	public int user_delete(String user_id);
	
	
//	分页多条件查询用户
	public List<T_User> user_select(Map map);
	
	
//	多条件查询用户数量
	public int user_selectcount(Map map);	
	
	
//	查询用户ById
	public List<T_User> user_selectone(T_User t_user);
	
	
//	用户登录判断
	public List<T_User> user_login(T_User user);
	
	
//	用户名有效性查询
	public List<T_User> user_avalibe(T_User user);
	
	
	
	
}
