package com.mi.model;

import java.util.Date;
import java.util.List;

public class T_User {
	
	
	private String user_id;
	private int role_id;
	private String user_username;
	private String user_password;
	private String user_nickname;
	private String user_phone;
	private Date user_date;
	private List<T_Address> user_addresslist;
	
	
	public List<T_Address> getUser_addresslist() {
		return user_addresslist;
	}
	public void setUser_addresslist(List<T_Address> user_addresslist) {
		this.user_addresslist = user_addresslist;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public int getRole_id() {
		return role_id;
	}
	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}
	public String getUser_username() {
		return user_username;
	}
	public void setUser_username(String user_username) {
		this.user_username = user_username;
	}
	public String getUser_password() {
		return user_password;
	}
	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}
	public String getUser_nickname() {
		return user_nickname;
	}
	public void setUser_nickname(String user_nickname) {
		this.user_nickname = user_nickname;
	}
	public String getUser_phone() {
		return user_phone;
	}
	public void setUser_phone(String user_phone) {
		this.user_phone = user_phone;
	}
	public Date getUser_date() {
		return user_date;
	}
	public void setUser_date(Date user_date) {
		this.user_date = user_date;
	}
	
	
	
	
	
	
	
	
}
