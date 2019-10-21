package com.mi.biz;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mi.dao.T_CommodityDao;
import com.mi.dao.T_PictureDao;
import com.mi.dto.Commodityinformation;
import com.mi.model.T_Commodity;
import com.mi.model.T_Picture;
import com.mi.util.MD5;

@Service
public class T_CommodityBizImpl implements T_CommodityBiz {
	
	@Resource
	private T_CommodityDao commoditydao;
	@Resource
	private T_PictureDao picturedao;
	
	//添加商品
	@Override
	public boolean insert_commodity(T_Commodity t_commodity) {
		// TODO Auto-generated method stub
		boolean flag = false;
//		通过UUID生成id号
		String uuid = UUID.randomUUID().toString();
		t_commodity.setCommodity_id(uuid);
		t_commodity.setCommodity_date(new Date());
		
		if(commoditydao.commodity_insert(t_commodity)>0) {
			flag = true;
		}
		
		return flag;
	}

	
	
	
	
	//修改商品
	@Override
	public boolean update_commodity(T_Commodity t_commodity) {
		// TODO Auto-generated method stub
		boolean flag= false;
		
		if(commoditydao.commodity_update(t_commodity)>0) {
			T_Picture picture = new T_Picture();
			picture.setCommodity_id(t_commodity.getCommodity_id());
			if(picturedao.picture_delete(picture)>0) {
				flag=true;
			}
		}
		
		return flag;
	}

	
	
	
	
	//删除商品
	@Override
	public boolean delete_commodity(T_Commodity t_commodity) {
		// TODO Auto-generated method stub
		boolean flag=false;
		T_Picture picture = new T_Picture();
		picture.setCommodity_id(t_commodity.getCommodity_id());
		if(picturedao.picture_delete(picture)>0) {
			if(commoditydao.commodity_delete(t_commodity)>0) {
				flag=true;
			}
		}
		
		return flag;
	}


	//分页多条件查询商品
	@Override
	public List<Commodityinformation> select_commodity(Map map) {
		// TODO Auto-generated method stub
		List<Commodityinformation> resultmap = commoditydao.commodity_select(map);
		for (Commodityinformation commodityinformation : resultmap) {
			commodityinformation.setCommodity_picturelist(picturedao.picture_select(commodityinformation.getCommodity_id()));
		}
		return resultmap;
	}





	@Override
	public T_Commodity selectone_commodity(T_Commodity t_commodity) {
		// TODO Auto-generated method stub
		return commoditydao.commodity_selectById(t_commodity);
	}





	@Override
	public List<Commodityinformation> selectBytype_commodity(int type_id) {
		// TODO Auto-generated method stub
		return commoditydao.commodity_selectBytype(type_id);
	}





	@Override
	public List<Commodityinformation> selectbyname_commodity(Map map) {
		// TODO Auto-generated method stub
		List<Commodityinformation> resultmap = commoditydao.commodity_selectbyname(map);
		for (Commodityinformation commodityinformation : resultmap) {
			commodityinformation.setCommodity_picturelist(picturedao.picture_select(commodityinformation.getCommodity_id()));
		}
		return resultmap;
	}




}
