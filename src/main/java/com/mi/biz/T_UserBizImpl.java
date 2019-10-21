package com.mi.biz;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mi.dao.T_AddressDao;
import com.mi.dao.T_CarDao;
import com.mi.dao.T_OrderDao;
import com.mi.dao.T_UserDao;
import com.mi.model.T_User;
import com.mi.util.MD5;
import com.mi.util.pageSize;

@Service
public class T_UserBizImpl implements T_UserBiz {

	@Resource
	private T_UserDao userdao;
	@Resource
	private T_AddressDao addressdao;
	@Resource
	private T_OrderDao orderdao;
	@Resource
	private T_CarDao cardao;

	/*
	 * 
	 * -----------------添加用户
	 * 
	 */
	@Override
	public Map insert_User(T_User t_user) {
		// TODO Auto-generated method stub
		Map map = new HashMap();
		// 通过UUID生成id号
		String uuid = UUID.randomUUID().toString();
		t_user.setUser_id(uuid);
		t_user.setUser_date(new Date());
		map.put("t_user", t_user);
		// MD5加密用户密码
		MD5 md = new MD5();
		t_user.setUser_password(md.md5crypt(t_user.getUser_password()));

		if (userdao.user_insert(t_user) > 0) {
			map.put("flag", true);
			
		} else {
			map.put("flag", false);
			map.put("msg", "添加用户失败!");
		}

		return map;
	}

	/*
	 * 
	 * -----------------更新用户
	 * 
	 */
	@Override
	public Map update_User(T_User t_user) {
		// TODO Auto-generated method stub
		Map map = new HashMap();
		// MD5加密用户密码
		MD5 md = new MD5();
		t_user.setUser_password(md.md5crypt(t_user.getUser_password()));

		if (userdao.user_update(t_user) > 0) {
			map.put("flag", true);
		} else {
			map.put("flag", false);
			map.put("msg", "修改失败!");
		}
		return map;
	}

	/*
	 * 
	 * -----------------删除用户
	 * 
	 */
	@Transactional
	@Override
	public Map delete_User(String user_id) {
		// TODO Auto-generated method stub
		Map map = new HashMap();
		int addressrows = addressdao.address_deleteByUser_id(user_id);
		int userrows = userdao.user_delete(user_id);
		int orderrows = orderdao.order_deletebyuserid(user_id);
		int carrows = cardao.car_deletebyuserid(user_id);
		if (addressrows >= 0 && userrows >= 0 && orderrows >= 0 && carrows >= 0) { 
			map.put("flag", true);
			map.put("msg", "删除用户成功!");
		} else {
			map.put("flag", false);
			map.put("msg", "删除用户失败!");
		}

		return map;
	}

	/*
	 * 
	 * -----------------分页多条件查询用户
	 * 
	 */
	@Override
	public Map select_User(Map map) {
		// TODO Auto-generated method stub

		Map resultmap = new HashMap();
		// 总记录数
		int pagecount = userdao.user_selectcount(map);
		// System.out.println(pagecount);
		resultmap.put("usercount", pagecount);
		if (pagecount % pageSize.pagesize == 0)
			pagecount = pagecount / pageSize.pagesize;
		else
			pagecount = pagecount / pageSize.pagesize + 1;
		resultmap.put("pagecount", pagecount);
		// 用户列表
		List<T_User> userlist = userdao.user_select(map);
		if (userlist != null && userlist.size() > 0) {
			resultmap.put("flag", true);
			resultmap.put("userlist", userlist);
		} else {
			resultmap.put("flag", false);
			resultmap.put("msg", "没有查找到满足此条件的用户!");
		}
		// 当前页码
		resultmap.put("pageid", map.get("pageid"));
		resultmap.put("pagesize", pageSize.pagesize);

		return resultmap;
	}

	/*
	 * 
	 * -----------------用户登录验证
	 * 
	 */
	@Override
	public Map login_user(T_User t_user) {
		// TODO Auto-generated method stub
		Map map = new HashMap();

		List<T_User> userlist = userlist = userdao.user_login(t_user);
		// MD5加密用户密码
		MD5 md = new MD5();
		t_user.setUser_password(md.md5crypt(t_user.getUser_password()));
		userlist = userdao.user_login(t_user);
		if (userlist != null && userlist.size() > 0) {
			map.put("flag", true);
			map.put("t_user", userlist.get(0));
		} else {
			map.put("flag", false);
			map.put("msg", "用户名或密码错误，请重新登录!");
		}
		return map;
	}

	/*
	 * 
	 * -----------------用户名有效性查询
	 * 
	 */
	@Override
	public Map available_user(T_User t_user) {
		// TODO Auto-generated method stub
		Map map = new HashMap();

		List<T_User> userlist = userdao.user_avalibe(t_user);
		if (userlist != null && userlist.size() > 0) {
			map.put("flag", true);
		} else {
			map.put("flag", false);
			map.put("msg", "用户名不存在，请检查后再试!");
		}
		return map;
	}

	@Override
	public Map selectone_User(T_User t_user) {
		// TODO Auto-generated method stub
		Map map = new HashMap();
		List<T_User> userlist = userdao.user_selectone(t_user);
		if (userlist != null && userlist.size() > 0) {
			map.put("flag", true);
			map.put("userlist", userlist.get(0));
		} else {
			map.put("flag", false);
			map.put("msg", "没有查询到此用户!");
		}

		return map;
	}

}
