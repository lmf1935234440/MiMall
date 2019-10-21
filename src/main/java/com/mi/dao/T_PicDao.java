package com.mi.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.mi.model.T_Pic;

@Mapper
public interface T_PicDao {
	
//	轮播图添加图片
	public int pic_insert(T_Pic t_pic);
	
//	轮播图删除图片
	public int pic_delete(T_Pic t_pic);
	
//	轮播图查询图片
	public List<T_Pic> pic_select();
	
}
