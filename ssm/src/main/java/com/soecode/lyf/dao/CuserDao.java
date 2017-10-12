package com.soecode.lyf.dao;

import com.soecode.lyf.entity.Cuser;

public interface CuserDao {
	
	
	//登录
	Cuser login(String uphone,String password);
	
	//注册
	void addcuser(Cuser cuser);
	
	//修改
	void updatecuser(Cuser cuser);
	
}
