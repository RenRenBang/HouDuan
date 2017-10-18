package com.soecode.lyf.dao;

import javax.annotation.Resource;

import org.junit.Test;
import com.soecode.lyf.BaseTest;
import com.soecode.lyf.entity.Cuser;

public class CuserDaoTest extends BaseTest{

	@Resource
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
		cuser.setIdNumber("123456123");
		cuser.setImage("/root/12.jpg");
		cuser.setName("wagnwu");
		cuser.setNickname("wangwuwu");
		cuser.setPassword("123456");
		cuser.setUphone("123456");
		cuserdao.addCuser(cuser);
		
	}
	
	
	@Test
	public void findByid()throws Exception{

		int uid = 1;
		Cuser cuser = cuserdao.findByid(uid);
		System.out.println(cuser);
	}
	@Test
	public void updateCuserTest()throws Exception{
		//int uid = 2;
		Cuser cuser = new Cuser(6, "15112341234", "job", "job", "123456789", null, null, "123456", null);
		cuserdao.updateCuser(cuser);
	}
}
