package com.mi.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.mi.biz.T_PicBiz;
import com.mi.model.T_Pic;


@RestController
public class T_PicJSONController {

	@Resource
	private T_PicBiz picbiz;
	
	
	
	// 添加图片测试
	@RequestMapping("insert_pic")
	public Map insert_pic(@RequestParam(name="pic") MultipartFile file ,String pic_return ,HttpServletRequest request) {
		
		String path = request.getSession().getServletContext().getRealPath("/") + "Uploads/";

		String realPath = request.getServletContext().getRealPath("/");

		String oname = file.getOriginalFilename();
		int begin = oname.lastIndexOf(".");
		String storename = System.currentTimeMillis() + "." + oname.substring(begin + 1);
		Map map = new HashMap();
		try {
			file.transferTo(new File(path + storename));	
			
			T_Pic t_pic = new T_Pic();
			t_pic.setPic_url("Uploads/"+ storename);
			t_pic.setPic_return(pic_return);
			
			if (picbiz.insert_pic(t_pic)) {
				map.put("flag", true);
			} else {
				map.put("flag", false);
				map.put("msg", "图片保存失败");
			}
		} catch (IllegalStateException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return map;
	}

	// 删除图片测试
	@RequestMapping("delete_pic")
	public Map delete_pic(int pic_id, HttpServletRequest request) {
		Map map = new HashMap();
		T_Pic t_pic = new T_Pic();
		t_pic.setPic_id(pic_id);
		if (picbiz.delete_pic(t_pic)) {
			map.put("flag", true);
		} else {
			map.put("flag", false);
			map.put("msg", "图片删除失败");
		}

		return map;
	}
	
	
	// 删除图片测试
		@RequestMapping("select_pic")
		public Map select_pic(HttpServletRequest request) {
			Map map = new HashMap();
			List<T_Pic> piclist = picbiz.select_pic();
			if (piclist.size()>0&&piclist!=null) {
				map.put("flag", true);
				map.put("piclist", piclist);
			} else {
				map.put("flag", false);
				map.put("msg", "图片查询失败");
			}

			return map;
		}
	
	
	
	
	
	

}
