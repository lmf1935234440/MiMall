package com.mi.model;

public class T_Picture {
	private String picture_id;
	private String commodity_id;
	private String picture_url;
	public String getPicture_id() {
		return picture_id;
	}
	public void setPicture_id(String picture_id) {
		this.picture_id = picture_id;
	}
	public String getCommodity_id() {
		return commodity_id;
	}
	public void setCommodity_id(String commodity_id) {
		this.commodity_id = commodity_id;
	}
	public String getPicture_url() {
		return picture_url;
	}
	public void setPicture_url(String picture_url) {
		this.picture_url = picture_url;
	}
	@Override
	public String toString() {
		return "T_Picture [picture_id=" + picture_id + ", commodity_id=" + commodity_id + ", picture_url=" + picture_url
				+ "]";
	}
	
}
