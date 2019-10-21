package com.mi.controller;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mi.biz.T_AddressBiz;
import com.mi.model.T_Address;

@RestController
public class T_AddressJSONController {
	
	
	@Resource
	private T_AddressBiz addressbiz;
	
	
//	添加地址
	@RequestMapping("insert_address")
	public Map insert_address(T_Address t_address,HttpServletRequest request) {
		return addressbiz.insert_address(t_address);
	}
	
	
	
//	修改地址
	@RequestMapping("update_address")
	public Map update_address(T_Address t_address,HttpServletRequest request) {
		return addressbiz.update_address(t_address);
	}
	
	
	
//	删除地址
	@RequestMapping("delete_address")
	public Map delete_address(T_Address t_address,HttpServletRequest request) {
		return addressbiz.delete_address(t_address);
	}
	
	
	
	
	
}
