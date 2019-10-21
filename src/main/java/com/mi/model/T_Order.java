package com.mi.model;

import java.util.Date;

public class T_Order {
	private String order_id;
	private String user_id;
	private String user_address;
	private String commodity_size;
	private Date order_date;
	public String getUser_address() {
		return user_address;
	}
	public void setUser_address(String user_address) {
		this.user_address = user_address;
	}
	public String getOrder_id() {
		return order_id;
	}
	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getCommodity_size() {
		return commodity_size;
	}
	public void setCommodity_size(String commodity_size) {
		this.commodity_size = commodity_size;
	}
	public Date getOrder_date() {
		return order_date;
	}
	public void setOrder_date(Date order_date) {
		this.order_date = order_date;
	}
}
