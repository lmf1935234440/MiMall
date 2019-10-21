package com.mi.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.mi.model.T_Car;

@Mapper
public interface T_CarDao {
	
	//添加商品到购物车
	public int car_insert(T_Car t_car);
	
	
	//修改购物车中指定商品信息
	public int car_update(T_Car t_car);
	
	
	//删除购物车中指定商品
	public int car_delete(T_Car t_car);
	
//	删除指定用户的购物车信息
	public int car_deletebyuserid(String user_id);
	
	
	//查询购物车中全部商品ByUser_id
	public List<T_Car> car_select(T_Car t_car);
	
	
}
