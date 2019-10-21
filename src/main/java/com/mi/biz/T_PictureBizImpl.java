package com.mi.biz;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mi.dao.T_PictureDao;
import com.mi.model.T_Picture;

@Service
public class T_PictureBizImpl implements T_PictureBiz {
	
	@Resource
	private T_PictureDao picturedao;
	
	@Override
	public boolean insert_picture(T_Picture t_picture) {
		boolean flag=false;
//		通过UUID生成id号
		String uuid = UUID.randomUUID().toString();
		t_picture.setPicture_id(uuid);

		Integer rows = picturedao.picture_insert(t_picture);

		if(rows > 0) {
			flag=true;
		}
		
		
		return flag;
	}

	
	@Override
	public boolean delete_picture(T_Picture t_picture) {
		// TODO Auto-generated method stub
		boolean flag=false;
		if(picturedao.picture_delete(t_picture)>0) {
			flag=true;
		}
		
		return flag;
	}

	

}
