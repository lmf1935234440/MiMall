package com.mi.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.mi.model.T_Order;

@Mapper
public interface T_OrderDao {
	
//	添加订单
	public int order_insert(T_Order t_order);
	
//	修改订单
	public int order_update(T_Order t_order);
	
//	删除订单
	public int order_delete(T_Order t_order);
	
//	查询全部订单
	public List<T_Order> order_select();
	
//	查询订单ByUser_id
	public List<T_Order> order_selectbyuserid(T_Order t_order);
	
//	删除指定用户订单信息
	public int order_deletebyuserid(String user_id);
	
	
}
