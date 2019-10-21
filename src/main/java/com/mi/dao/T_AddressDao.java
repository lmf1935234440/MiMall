package com.mi.dao;

import org.apache.ibatis.annotations.Mapper;

import com.mi.model.T_Address;

@Mapper
public interface T_AddressDao {
	
//	添加地址
	public int address_insert(T_Address t_address);
	
	
//	修改地址
	public int address_update(T_Address t_address);
	
	
//	删除地址
	public int address_delete(T_Address t_address);
	
	
//	删除地址ByUser_Id
	public int address_deleteByUser_id(String user_id);
	
	
	
}
