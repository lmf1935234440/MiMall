package com.mi.biz;

import java.util.List;

import com.mi.model.T_Car;

public interface T_CarBiz {
	
	//添加商品到购物车
	public boolean insert_car(T_Car t_car);
			
			
	//修改购物车中指定商品信息
	public boolean update_car(T_Car t_car);
			
			
	//删除购物车中指定商品
	public boolean delete_car(T_Car t_car);
			

	//查询购物车中全部商品ByUser_id
	public List<T_Car> select_car(T_Car t_car);	
		
	
}
