package com.mi.biz;

import java.util.Map;

import com.mi.model.T_Address;

public interface T_AddressBiz {
	
	
//	添加地址
	public Map insert_address(T_Address t_address);
	
	
//	修改地址
	public Map update_address(T_Address t_address);
	
	
//	删除地址
	public Map delete_address(T_Address t_address);
	
	
}
