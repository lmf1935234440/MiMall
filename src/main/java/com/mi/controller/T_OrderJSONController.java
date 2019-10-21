package com.mi.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mi.biz.T_OrderBiz;
import com.mi.model.T_Order;
import com.mi.model.T_Type;

@RestController
public class T_OrderJSONController {
	
	
	@Resource
	private T_OrderBiz orderbiz;
	
	
//	添加订单
	@RequestMapping("insert_order")
	public Map insert_order(T_Order t_order,HttpServletRequest request) {
		Map map = new HashMap();
		if(orderbiz.insert_order(t_order)) {
			map.put("flag", true);
		}else {
			map.put("flag", false);
			map.put("msg", "添加订单失败!");
		}
		return map;
	}
	
	
	
	
//	修改订单
	@RequestMapping("update_order")
	public Map update_order(T_Order t_order,HttpServletRequest request) {
		Map map = new HashMap();
		if(orderbiz.update_order(t_order)) {
			map.put("flag", true);
		}else {
			map.put("flag", false);
			map.put("msg", "修改订单失败!");
		}
		return map;
	}
	
	
//	删除订单
	@RequestMapping("delete_order")
	public Map delete_order(T_Order t_order,HttpServletRequest request) {
		Map map = new HashMap();
		if(orderbiz.delete_order(t_order)) {
			map.put("flag", true);
		}else {
			map.put("flag", false);
			map.put("msg", "删除订单失败!");
		}
		return map;
	}
	
	
//	删除订单
	@RequestMapping("select_order")
	public Map select_order(HttpServletRequest request) {
		Map map = new HashMap();
		if(orderbiz.select_order().size()>0&&orderbiz.select_order()!=null) {
			map.put("flag", true);
			map.put("orderlist", orderbiz.select_order());
		}else {
			map.put("flag", false);
			map.put("msg", "没有查询到订单!");
		}
		return map;
	}
	
	
	
//	删除订单
	@RequestMapping("selectbyuserid_order")
	public Map selectbyuserid_order(T_Order t_order,HttpServletRequest request) {
		Map map = new HashMap();
		if(orderbiz.selectbyuserid_order(t_order).size()>0&&orderbiz.selectbyuserid_order(t_order)!=null) {
			map.put("flag", true);
			map.put("orderlist", orderbiz.selectbyuserid_order(t_order));
		}else {
			map.put("flag", false);
			map.put("msg", "没有查询到订单!");
		}
		return map;
	}
	
}
