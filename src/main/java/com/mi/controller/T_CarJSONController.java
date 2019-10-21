package com.mi.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mi.biz.T_CarBiz;
import com.mi.model.T_Car;


@RestController
public class T_CarJSONController {
	
	@Resource
	private T_CarBiz carbiz;
	
	
//	添加商品到购物车
	@RequestMapping("insert_car")
	public Map insert_car(T_Car t_car,HttpServletRequest request) {
		
		Map map = new HashMap();
		if(carbiz.insert_car(t_car)) {
			map.put("flag", true);
		}else {
			map.put("flag", false);
			map.put("msg", "添加购物车失败!");
		}
		
		return map;
	}
	
	
//	修改购物车中指定商品
	@RequestMapping("update_car")
	public Map update_car(T_Car t_car,HttpServletRequest request) {
		
		Map map = new HashMap();
		if(carbiz.update_car(t_car)) {
			map.put("flag", true);
		}else {
			map.put("flag", false);
			map.put("msg", "修改购物车中商品失败!");
		}
		
		return map;
	}
	
	
	
//	删除购物车中指定商品
	@RequestMapping("delete_car")
	public Map delete_car(T_Car t_car,HttpServletRequest request) {
		
		Map map = new HashMap();
		if(carbiz.delete_car(t_car)) {
			map.put("flag", true);
		}else {
			map.put("flag", false);
			map.put("msg", "删除购物车中商品失败!");
		}
		
		return map;
	}
	
	
//	删除购物车中指定商品
	@RequestMapping("select_car")
	public Map select_car(T_Car t_car,HttpServletRequest request) {
		
		Map map = new HashMap();
		List<T_Car> carlist = carbiz.select_car(t_car);
		if(carlist.size()>0&&carlist!=null) {
			map.put("flag", true);
			map.put("carlist", carlist);
		}else {
			map.put("flag", false);
			map.put("msg", "购物车中还没有商品，快去选购吧!");
		}
		
		return map;
	}
	
	
	
	
}
