package com.mi.biz;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mi.dao.T_OrderDao;
import com.mi.model.T_Order;
@Service
public class T_OrderBizImpl implements T_OrderBiz {
	
	@Resource
	private T_OrderDao orderdao;
	
	
	@Override
	public boolean insert_order(T_Order t_order) {
		// TODO Auto-generated method stub
		boolean flag = false;
//		通过UUID生成id号
		String uuid = UUID.randomUUID().toString();
		t_order.setOrder_id(uuid);
		t_order.setOrder_date(new Date());
		if(orderdao.order_insert(t_order)>0) {
			flag = true;
		}
		return flag;
	}

	@Override
	public boolean update_order(T_Order t_order) {
		// TODO Auto-generated method stub
		boolean flag = false;
		if(orderdao.order_update(t_order)>0) {
			flag = true;
		}
		return flag;
	}

	@Override
	public boolean delete_order(T_Order t_order) {
		// TODO Auto-generated method stub
		boolean flag = false;
		if(orderdao.order_delete(t_order)>0) {
			flag=true;
		}
		return flag;
	}

	@Override
	public List<T_Order> select_order() {
		// TODO Auto-generated method stub
		return orderdao.order_select();
	}

	@Override
	public List<T_Order> selectbyuserid_order(T_Order t_order) {
		// TODO Auto-generated method stub
		return orderdao.order_selectbyuserid(t_order);
	}

}
