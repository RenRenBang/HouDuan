package com.soecode.lyf.service;

import com.soecode.lyf.entity.Cuser;

public interface CuserService {
	
	Cuser login(String uphone,String password);
	
	//注册
	void addCuser(Cuser cuser);
		
	//修改
	void updateCuser(Cuser cuser);
	
	//根据id查用户	
	Cuser findByid(int uid);
	
	//修改头像
	void updateImgeById(int uid,String image);
}
