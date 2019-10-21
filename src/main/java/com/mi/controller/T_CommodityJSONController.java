package com.mi.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.mi.biz.T_CommodityBiz;
import com.mi.biz.T_PictureBiz;
import com.mi.dao.T_CommodityDao;
import com.mi.dao.T_TypeDao;
import com.mi.dto.Commodityinformation;
import com.mi.model.T_Commodity;
import com.mi.model.T_Picture;
import com.mi.model.T_Type;
import com.mi.util.pageSize;

@RestController
public class T_CommodityJSONController {

	@Resource
	private T_CommodityBiz commoditybiz;
	@Resource
	private T_CommodityDao commoditydao;

	@Resource
	private T_PictureBiz picturebiz;
	@Resource
	private T_TypeDao typedao;

	// 添加图片测试
	@RequestMapping("insert_picture")
	public boolean insert_picture(@RequestParam(name="file") MultipartFile[] files, HttpServletRequest request) {
		System.out.println("insert_picture=====");
		boolean picflag = true;
		
		for(int i =0;i<files.length;i++) {
			
		
			String path = request.getSession().getServletContext().getRealPath("/") + "Uploads/";

			String realPath = request.getServletContext().getRealPath("/");

			String oname = files[i].getOriginalFilename();
			int begin = oname.lastIndexOf(".");
			String storename = System.currentTimeMillis() + "." + oname.substring(begin + 1);
			try {
				files[i].transferTo(new File(path + storename));
	
				System.out.println(path + storename);
	
				// 图片存入数据库
				T_Picture t_picture = new T_Picture();
				t_picture.setCommodity_id("d9cace95-5b1f-465e-a1df-a86cd897dc2b");
	
				t_picture.setPicture_url("Uploads/"+ storename);
	
				if (!picturebiz.insert_picture(t_picture)) {
					picflag = false;
				} else {
					
					System.out.println("OK");
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				picflag = false;
				e.printStackTrace();
			}
		}
		// }
		
		return picflag;
	}

	// 添加商品
	@RequestMapping("insert_commodity")
	public Map insert_commodity(T_Commodity t_commodity,@RequestParam(name="commodity_pic") MultipartFile[] files, HttpServletRequest request) {

		Map resultmap = new HashMap();

		// 商品基本信息添加

		if (commoditybiz.insert_commodity(t_commodity)) {
			// 商品基本信息添加成功

			// //保存图片信息到数据库标志位
			System.out.println("上传图片至服务器，写入数据库=====");
			boolean picflag = true;
			
			for(int i =0;i<files.length;i++) {
				
			
				String path = request.getSession().getServletContext().getRealPath("/") + "Uploads/";
				String oname = files[i].getOriginalFilename();
				int begin = oname.lastIndexOf(".");
				String storename = System.currentTimeMillis() + "." + oname.substring(begin + 1);
				try {
					files[i].transferTo(new File(path + storename));
		
					System.out.println(path + storename);
		
					// 图片存入数据库
					T_Picture t_picture = new T_Picture();
					t_picture.setCommodity_id(t_commodity.getCommodity_id());
		
					t_picture.setPicture_url("Uploads/"+ storename);
		
					if (!picturebiz.insert_picture(t_picture)) {
						picflag = false;
					} else {
						
						System.out.println("OK");
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					picflag = false;
					e.printStackTrace();
				}
			}
			if(picflag) {
				// //商品图片上传成功
				// //图片添加成功
				resultmap.put("flag", true);
			}else {
				resultmap.put("flag", false);
				resultmap.put("msg", "商品添加失败！因为图片添加失败");
			}
			
		} else {
			// 商品基本信息添加失败
			resultmap.put("flag", false);
			resultmap.put("msg", "商品添加失败！因为商品基本信息添加失败");
		}


		return resultmap;
	}
	
	
	
	// 修改商品
		@RequestMapping("update_commodity")
		public Map update_commodity(T_Commodity t_commodity,@RequestParam(name="commodity_pic") MultipartFile[] files, HttpServletRequest request) {

			Map resultmap = new HashMap();

			// 商品基本信息添加

			if (commoditybiz.update_commodity(t_commodity)) {
				// 商品基本信息修改成功
				
				// //保存图片信息到数据库标志位
				System.out.println("上传图片至服务器，写入数据库=====");
				boolean picflag = true;
				
				for(int i =0;i<files.length;i++) {
					
				
					String path = request.getSession().getServletContext().getRealPath("/") + "Uploads/";
					String oname = files[i].getOriginalFilename();
					int begin = oname.lastIndexOf(".");
					String storename = System.currentTimeMillis() + "." + oname.substring(begin + 1);
					try {
						files[i].transferTo(new File(path + storename));
			
						System.out.println(path + storename);
			
						// 图片存入数据库
						T_Picture t_picture = new T_Picture();
						t_picture.setCommodity_id(t_commodity.getCommodity_id());
			
						t_picture.setPicture_url("Uploads/"+ storename);
			
						if (!picturebiz.insert_picture(t_picture)) {
							picflag = false;
						} else {
							
							System.out.println("OK");
						}
					} catch (Exception e) {
						// TODO Auto-generated catch block
						picflag = false;
						e.printStackTrace();
					}
				}
				if(picflag) {
					// //商品图片上传成功
					// //图片添加成功
					resultmap.put("flag", true);
				}else {
					resultmap.put("flag", false);
					resultmap.put("msg", "商品添加失败！因为图片添加失败");
				}
				
			} else {
				// 商品基本信息添加失败
				resultmap.put("flag", false);
				resultmap.put("msg", "商品添加失败！因为商品基本信息添加失败");
			}


			return resultmap;
		}
	
	
	
	
	
	
	
	
//	删除商品
	@RequestMapping("delete_commodity")
	public Map delete_commodity(T_Commodity t_commodity, HttpServletRequest request) {
		Map map = new HashMap();
		map.put("flag", commoditybiz.delete_commodity(t_commodity));
		return map;
	}
//	查询商品
	@RequestMapping("select_commodity")
	public Map select_commodity(String commodity_name, int type_id, int pageid, HttpServletRequest request) {
		Map map = new HashMap();
		if (commodity_name == "" || commodity_name.equals("") || commodity_name == null)
			commodity_name = null;
		else {
			commodity_name = "%" + commodity_name + "%";
		}

		map.put("commodity_name", commodity_name);
		map.put("type_id", type_id);
		map.put("pageid", pageid);
		map.put("begin", (pageid - 1) * pageSize.pagesize);
		map.put("pagesize", pageSize.pagesize);
		
		List<Commodityinformation> list = commoditybiz.select_commodity(map);
		
		for (Commodityinformation commodityinformation : list) {
			commodityinformation.setCommodity_picturelist(commodityinformation.getCommodity_picturelist());
		}
		Map resultmap = new HashMap();
		resultmap.put("commoditylist", list) ;
		resultmap.put("pageid", pageid);
		resultmap.put("commodity_name", commodity_name);
		resultmap.put("type_id", type_id);
		resultmap.put("commodity_counts", commoditydao.commodity_selectcount(map));
		resultmap.put("pagesize", pageSize.pagesize);
		resultmap.put("typelist", typedao.type_select());
		return resultmap;
	}
	
	
	
	
//	查询商品
	@RequestMapping("selectbyname_commodity")
	public Map selectbyname_commodity(String commodity_name, HttpServletRequest request) {
		Map map = new HashMap();
		if (commodity_name == "" || commodity_name.equals("") || commodity_name == null)
			commodity_name = null;
		else {
			commodity_name = "%" + commodity_name + "%";
		}

		map.put("commodity_name", commodity_name);
//		map.put("pageid", pageid);
//		map.put("begin", (pageid - 1) * pageSize.pagesize);
//		map.put("pagesize", pageSize.frontpagesize);
		
		List<Commodityinformation> list = commoditybiz.selectbyname_commodity(map);
		
		for (Commodityinformation commodityinformation : list) {
			commodityinformation.setCommodity_picturelist(commodityinformation.getCommodity_picturelist());
		}
		Map resultmap = new HashMap();
		resultmap.put("commoditylist", list) ;
//		resultmap.put("pageid", pageid);
		resultmap.put("commodity_name", commodity_name);
		resultmap.put("commodity_counts", commoditydao.commodity_selectbynamecount(map));
//		resultmap.put("pagesize", pageSize.frontpagesize);
		resultmap.put("typelist", typedao.type_select());
		return resultmap;
	}
	
	
	
	
	
	
	
	//查询商品ById
	@RequestMapping("selectone_commodity")
	public Map selectone_commodity(T_Commodity t_commodity, HttpServletRequest request) {
		
		Map resultmap = new HashMap();
		resultmap.put("commodity", commoditybiz.selectone_commodity(t_commodity)) ;

		return resultmap;
	}
	
	
	//查询商品ById
	@RequestMapping("selectBytype_commodity")
	public Map selectBytype_commodity(T_Commodity t_commodity, HttpServletRequest request) {
			
		Map resultmap = new HashMap();

		List<T_Type> typelist = typedao.type_select();
		List<Map> commoditylist = new ArrayList<Map>();
		for(int i=0;i<typelist.size();i++) {
			Map map = new HashMap();
			map.put("name", typelist.get(i).getType_name());
			map.put("list", commoditybiz.selectBytype_commodity(typelist.get(i).getType_id()));
			commoditylist.add(map);
		}
		resultmap.put("flag", true);
		resultmap.put("commoditylist", commoditylist);
		
		
		return resultmap;
	}
	
	
	
	
	
	

}
