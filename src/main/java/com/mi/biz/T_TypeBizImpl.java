package com.mi.biz;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mi.dao.T_CommodityDao;
import com.mi.dao.T_PictureDao;
import com.mi.dao.T_TypeDao;
import com.mi.model.T_Commodity;
import com.mi.model.T_Type;
import com.mi.util.MD5;

@Service
public class T_TypeBizImpl implements T_TypeBiz {
	
	@Resource
	private T_TypeDao typedao;
	@Resource
	private T_CommodityDao commoditydao;
	@Resource
	private T_PictureDao picturedao;
	
//	添加分类
	@Override
	public Map insert_type(T_Type t_type) {
		// TODO Auto-generated method stub
		Map map = new HashMap();
		if(typedao.type_insert(t_type)>0) {
			map.put("flag", true);
		}else {
			map.put("flag", false);
			map.put("msg", "添加分类失败!");
		}
		
		return map;
	}

//	更新分类
	@Override
	public Map update_type(T_Type t_type) {
		// TODO Auto-generated method stub
		Map map = new HashMap();
		if(typedao.type_update(t_type)>0) {
			map.put("flag", true);
		}else {
			map.put("flag", false);
			map.put("msg", "修改分类失败!");
		}
		
		return map;
	}

//	删除分类
	@Transactional
	@Override
	public Map delete_type(T_Type t_type) {
		// TODO Auto-generated method stub
		Map map = new HashMap();
		T_Commodity t_commodity= new T_Commodity();
		t_commodity.setType_id(t_type.getType_id());
		
//		删除商品图片
		int picturerows = picturedao.picture_deletebytypeid(t_commodity);
		
//		删除商品
		int commodityrows = commoditydao.commodity_deletebytypeid(t_commodity);
		
//		删除分类
		int typerows = typedao.type_delete(t_type);
		
		
		if(picturerows>0) {
			if(commodityrows>0) {
				if(typerows>0) {
					map.put("flag", true);
					map.put("msg", "删除分类成功!");
				}else {
					map.put("flag", false);
					map.put("msg", "删除分类失败!");
				}				
			}else {
				map.put("flag", false);
				map.put("msg", "删除此分类中商品失败!");
			}
		}else {
			map.put("flag", false);
			map.put("msg", "删除商品图片失败!");
		}
		
		return map;
	}

//	查询全部分类
	@Override
	public Map select_type() {
		// TODO Auto-generated method stub
		Map map = new HashMap();
		List<T_Type> typelist = typedao.type_select();
		if(typelist!=null&&typelist.size()>0) {
			map.put("flag", true);
			map.put("typelist", typelist);
		}else {
			map.put("flag", false);
			map.put("msg", "没有查找到分类,请添加后再试!");
		}
		return map;
	}

}
