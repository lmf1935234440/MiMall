package com.mi.biz;

import java.util.List;
import java.util.Map;

import com.mi.model.T_Type;



public interface T_TypeBiz {
		
//	添加分类
	public Map insert_type(T_Type t_type);
	
	
//	更新分类
	public Map update_type(T_Type t_type);
	
	
//	删除分类
	public Map delete_type(T_Type t_type);
	
	
//	查询全部分类
	public Map select_type();
	
	
}
