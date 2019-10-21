package com.mi.biz;

import java.util.List;

import com.mi.model.T_Pic;

public interface T_PicBiz {
	
//	轮播图添加图片
	public boolean insert_pic(T_Pic t_pic);
	
//	轮播图删除图片
	public boolean delete_pic(T_Pic t_pic);
	
//	轮播图查询图片
	public List<T_Pic> select_pic();
	
	
	
	
	
}
