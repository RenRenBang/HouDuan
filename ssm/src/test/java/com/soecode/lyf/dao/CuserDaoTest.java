package com.soecode.lyf.dao;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.soecode.lyf.BaseTest;
import com.soecode.lyf.entity.Cuser;

public class CuserDaoTest extends BaseTest{

	@Autowired
	private CuserDao cuserdao;
	
	
	@Test
	public void loginTest() throws Exception{
		
		String uphone = "15012341234";
		String password = "123456";
		Cuser user = cuserdao.login(uphone, password);
		System.out.println(user);
	}

	@Test
	public void addCuserTest() throws Exception{
		Cuser cuser = new Cuser();
		cuser.setPassword("123456");
		cuser.setUphone("15112341234");
		cuserdao.addCuser(cuser);
		
	}
}
