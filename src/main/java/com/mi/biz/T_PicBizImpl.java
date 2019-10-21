package com.mi.biz;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mi.dao.T_PicDao;
import com.mi.model.T_Pic;
@Service
public class T_PicBizImpl implements T_PicBiz {
	
	@Resource
	private T_PicDao picdao;
	
	
	@Override
	public boolean insert_pic(T_Pic t_pic) {
		// TODO Auto-generated method stub
		boolean flag = false;
		if(picdao.pic_insert(t_pic)>0) {
			flag = true;
		}
		return flag;
	}

	@Override
	public boolean delete_pic(T_Pic t_pic) {
		// TODO Auto-generated method stub
		boolean flag = false;
		if(picdao.pic_delete(t_pic)>0) {
			flag = true;
		}
		return flag;
	}

	@Override
	public List<T_Pic> select_pic() {
		// TODO Auto-generated method stub
		return picdao.pic_select();
	}

}
