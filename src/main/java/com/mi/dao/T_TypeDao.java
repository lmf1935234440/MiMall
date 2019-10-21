package com.mi.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.mi.model.T_Type;


@Mapper
public interface T_TypeDao {
	

	
//	添加分类
	public int type_insert(T_Type t_type);
	
	
//	更新分类
	public int type_update(T_Type t_type);
	
	
//	删除分类
	public int type_delete(T_Type t_type);
	
	
//	查询全部分类
	public List<T_Type> type_select();
	
	
	
	
}	
