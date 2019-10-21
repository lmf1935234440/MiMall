package com.mi.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.mi.model.T_Commodity;
import com.mi.model.T_Picture;

@Mapper
public interface T_PictureDao {
	
	
//	添加图片
	public int picture_insert(T_Picture t_picture);

	
	
//	删除图片
	public int picture_delete(T_Picture t_picture);
	
	
//	删除图片bycommodity_id
	public int picture_deletebytypeid(T_Commodity t_commodity);
	
	
//	查询图片
	public List<T_Picture> picture_select(String commodity_id);
	
}
