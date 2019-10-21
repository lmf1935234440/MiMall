package com.mi.model;

public class T_Car {
	
	private String car_id;
	private String user_id;
	private String commodity_id;
	private String commodity_size;
	
	public String getCommodity_size() {
		return commodity_size;
	}
	public void setCommodity_size(String commodity_size) {
		this.commodity_size = commodity_size;
	}
	private int car_account;
	public String getCar_id() {
		return car_id;
	}
	public void setCar_id(String car_id) {
		this.car_id = car_id;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getCommodity_id() {
		return commodity_id;
	}
	public void setCommodity_id(String commodity_id) {
		this.commodity_id = commodity_id;
	}
	public int getCar_account() {
		return car_account;
	}
	public void setCar_account(int car_account) {
		this.car_account = car_account;
	}
	
	
}
