package com.soecode.lyf.dao;

import com.soecode.lyf.entity.Cuser;

public interface CuserDao {
	
	
	//定义每个entity对应的dao接口，但是不实现，spring依赖的方式，在mybatis的每个对象对应的配置文件中实现。
	
	Cuser login(String uphone,String upassword);
}
