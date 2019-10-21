package com.mi.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.mi.dto.Commodityinformation;
import com.mi.model.T_Commodity;



@Mapper
public interface T_CommodityDao {
	
	
	
//	添加商品
	public int commodity_insert(T_Commodity t_commodity);
	
	
//	更新商品
	public int commodity_update(T_Commodity t_commodity);
	
	
//	删除商品
	public int commodity_delete(T_Commodity t_commodity);
	
//	删除商品Bytype_id
	public int commodity_deletebytypeid(T_Commodity t_commodity);
	
//	分页多条件查询全部商品
	public List<Commodityinformation> commodity_select(Map map);
	
//	查询商品Bynameortype
	public List<Commodityinformation> commodity_selectbyname(Map map);
	
	
//	统计页数
	public int commodity_selectcount(Map map);	
	
	
	
//	统计页数
	public int commodity_selectbynamecount(Map map);	
	
	
//	查询商品ById
	public T_Commodity commodity_selectById(T_Commodity t_commodity);
	
	
//	分类查询商品
	public List<Commodityinformation> commodity_selectBytype(int type_id);
	
	
	
	
}	
