package com.soecode.lyf.dao;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.soecode.lyf.BaseTest;

public class CorderDaoTest extends BaseTest{

	@Autowired
	CorderDao corderDao;
	
	@Test
	public void corderAddTest() {
		String type="need";
		corderDao.corderAdd(type);
		System.out.println("插入corder成功！");
	}

}
