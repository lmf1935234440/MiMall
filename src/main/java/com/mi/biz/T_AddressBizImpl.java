package com.mi.biz;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.mi.dao.T_AddressDao;
import com.mi.model.T_Address;
import com.mi.util.MD5;

@Service
public class T_AddressBizImpl implements T_AddressBiz{
	
	@Resource
	private T_AddressDao addressdao;

	
	@Override
	public Map insert_address(T_Address t_address) {
		// TODO Auto-generated method stub
		Map map = new HashMap();
//		通过UUID生成id号
		String uuid = UUID.randomUUID().toString();
		t_address.setAddress_id(uuid);

		if(addressdao.address_insert(t_address)>0) {
			map.put("flag", true);
		}else {
			map.put("flag", false);
			map.put("msg", "添加失败!");
		}
		return map;
	}

	@Override
	public Map update_address(T_Address t_address) {
		// TODO Auto-generated method stub
		Map map = new HashMap();
		if(addressdao.address_update(t_address)>0) {
			map.put("flag", true);
		}else {
			map.put("flag", false);
			map.put("msg", "修改地址失败!");
		}
		return map;
	}

	@Override
	public Map delete_address(T_Address t_address) {
		// TODO Auto-generated method stub
		Map map = new HashMap();
		if(addressdao.address_delete(t_address)>0) {
			map.put("flag", true);
		}else {
			map.put("flag", false);
			map.put("msg", "删除地址失败!");
		}
		return map;
	}
	
	
	
	
}
