package com.mi.dto;

import java.util.Date;
import java.util.List;

import com.mi.model.T_Picture;

public class Commodityinformation {
	
	private String commodity_id;
	private String commodity_name;
	private String commodity_description;
	private Date commodity_date;
	private int type_id;
	private String type_name;
	private String commodity_size;
	private List<T_Picture> commodity_picturelist;
	
	
	public List<T_Picture> getCommodity_picturelist() {
		return commodity_picturelist;
	}
	public void setCommodity_picturelist(List<T_Picture> commodity_picturelist) {
		this.commodity_picturelist = commodity_picturelist;
	}
	public String getCommodity_id() {
		return commodity_id;
	}
	public void setCommodity_id(String commodity_id) {
		this.commodity_id = commodity_id;
	}
	public String getCommodity_name() {
		return commodity_name;
	}
	public void setCommodity_name(String commodity_name) {
		this.commodity_name = commodity_name;
	}
	public String getCommodity_description() {
		return commodity_description;
	}
	public void setCommodity_description(String commodity_description) {
		this.commodity_description = commodity_description;
	}
	public Date getCommodity_date() {
		return commodity_date;
	}
	public void setCommodity_date(Date commodity_date) {
		this.commodity_date = commodity_date;
	}
	public int getType_id() {
		return type_id;
	}
	public void setType_id(int type_id) {
		this.type_id = type_id;
	}
	public String getType_name() {
		return type_name;
	}
	public void setType_name(String type_name) {
		this.type_name = type_name;
	}
	public String getCommodity_size() {
		return commodity_size;
	}
	public void setCommodity_size(String commodity_size) {
		this.commodity_size = commodity_size;
	}
	
	
}
