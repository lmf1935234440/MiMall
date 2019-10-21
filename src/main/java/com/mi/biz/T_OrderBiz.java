package com.mi.biz;

import java.util.List;

import com.mi.model.T_Order;

public interface T_OrderBiz {
	
	
//	添加订单
	public boolean insert_order(T_Order t_order);
	
//	修改订单
	public boolean update_order(T_Order t_order);
	
//	删除订单
	public boolean delete_order(T_Order t_order);
	
//	查询全部订单
	public List<T_Order> select_order();
	
//	查询订单ByUser_id
	public List<T_Order> selectbyuserid_order(T_Order t_order);
	
	
	
	
}
