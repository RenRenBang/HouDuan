package com.soecode.lyf.dao;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.soecode.lyf.BaseTest;
import com.soecode.lyf.entity.Cuser;

public class CuserDaoTest extends BaseTest{

	@Autowired
	private CuserDao cuserdao;
	
	@Test
	public void login() throws Exception{

		String uphone = "15012341234";
		String upassword = "123456";
		Cuser user = cuserdao.login(uphone,upassword);
		System.out.println(user);
	}
	
	
}
