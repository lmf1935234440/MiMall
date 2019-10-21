package com.mi.biz;

import java.util.List;
import java.util.Map;

import com.mi.dto.Commodityinformation;
import com.mi.model.T_Commodity;


public interface T_CommodityBiz {
	
//	添加商品
	public boolean insert_commodity(T_Commodity t_commodity);
	
	
//	更新商品
	public boolean update_commodity(T_Commodity t_commodity);
	
	
//	删除商品
	public boolean delete_commodity(T_Commodity t_commodity);
	

	
//	分页多条件查询全部商品
	public List<Commodityinformation> select_commodity(Map map);
	
	
//	查询商品
	public List<Commodityinformation> selectbyname_commodity(Map map);
	
	
//	查询商品ById
	public T_Commodity selectone_commodity(T_Commodity t_commodity);
	
//	分类查询商品
	public List<Commodityinformation> selectBytype_commodity(int type_id);
	
	
	
}
