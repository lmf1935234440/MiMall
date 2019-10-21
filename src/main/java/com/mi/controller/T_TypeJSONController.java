package com.mi.controller;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mi.biz.T_TypeBiz;
import com.mi.model.T_Type;

@RestController
public class T_TypeJSONController {
	
	
	@Resource
	private T_TypeBiz typebiz;
	
	
	
//	添加分类
	@RequestMapping("insert_type")
	public Map insert_type(T_Type t_type,HttpServletRequest request) {
		return typebiz.insert_type(t_type);
	}
	
	
//	修改分类
	@RequestMapping("update_type")
	public Map update_type(T_Type t_type,HttpServletRequest request) {
		return typebiz.update_type(t_type);
	}
	
	
	
//	删除分类
	@RequestMapping("delete_type")
	public Map delete_type(T_Type t_type,HttpServletRequest request) {
		return typebiz.delete_type(t_type);
	}
	
	
	
//	查询全部分类
	@RequestMapping("select_type")
	public Map select_type(T_Type t_type,HttpServletRequest request) {
		return typebiz.select_type();
	}
	
	
	
	
	
}
