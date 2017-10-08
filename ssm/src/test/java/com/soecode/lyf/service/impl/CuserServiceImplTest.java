package com.soecode.lyf.service.impl;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.soecode.lyf.BaseTest;
import com.soecode.lyf.entity.Cuser;
import com.soecode.lyf.service.CuserService;


public class CuserServiceImplTest extends BaseTest{

	@Autowired
	private CuserService cuserService;
	
	@Test
	public void login() throws Exception{
		Cuser user = cuserService.login("15012341234", "123456");
		System.out.println(user);
	}

}
