package com.soecode.lyf.service.impl;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.soecode.lyf.BaseTest;
import com.soecode.lyf.entity.Cuser;
import com.soecode.lyf.service.CuserService;

public class CuserServiceImplTest extends BaseTest{

	@Autowired
	private CuserService cuserservice;
	
	@Test
	public void login() throws Exception{
		String uphone = "15012341234";
		String password = "123456";
		Cuser user = cuserservice.login(uphone, password);
		System.out.println(user);
	}

}
