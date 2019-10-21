package com.mi.biz;

import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mi.dao.T_CarDao;
import com.mi.model.T_Car;
@Service
public class T_CarBizImpl implements T_CarBiz {
	
	@Resource
	private T_CarDao cardao;
	
//	添加商品到购物车
	@Override
	public boolean insert_car(T_Car t_car) {
		// TODO Auto-generated method stub
		boolean flag = false;
//		通过UUID生成id号
		String uuid = UUID.randomUUID().toString();
		t_car.setCar_id(uuid);
		if(cardao.car_insert(t_car)>0) {
			flag = true;
		}
			
		return flag;
	}

	
//	修改购物车中指定商品
	@Override
	public boolean update_car(T_Car t_car) {
		// TODO Auto-generated method stub
		boolean flag = false;
		

		if(cardao.car_update(t_car)>0) {
			flag = true;
		}
			
		return flag;
	}

	
//	删除购物车中指定商品
	@Override
	public boolean delete_car(T_Car t_car) {
		// TODO Auto-generated method stub
		boolean flag = false;
		if(cardao.car_delete(t_car)>0) {
			flag = true;
		}
			
		return flag;
	}

//	查询购物车中商品
	@Override
	public List<T_Car> select_car(T_Car t_car) {
		// TODO Auto-generated method stub
		return cardao.car_select(t_car);
	}

}
