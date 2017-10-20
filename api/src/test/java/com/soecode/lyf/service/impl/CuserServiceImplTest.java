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
	
	@Test
	public void addCuserTest() throws Exception{
		Cuser cuser = new Cuser();
		cuser.setPassword("123456");
		cuser.setUphone("15112341234");
		cuserService.addCuser(cuser);
		
	}
	
	
	@Test
	public void findByid()throws Exception{
		int uid = 3;
		Cuser cuser = cuserService.findByid(uid);
		System.out.println(cuser);
	}
	@Test
	public void updateCuserTest()throws Exception{
		int uid = 2;
		Cuser cuser = cuserService.findByid(uid);
		cuser.setPassword("111111");
		String password = "";
		String nickname = "";
		cuserService.updateCuser(uid,nickname,password);
	}

}
