package com.soecode.lyf.dao;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;

import com.soecode.lyf.BaseTest;
import com.soecode.lyf.entity.Corder;

public class CorderDaoTest extends BaseTest{

	@Autowired
	CorderDao corderDao;
	
	@Test
	public void corderAddTest() {
		Corder corder = new Corder();
		corder.setAddress("内蒙古呼和浩特市回民区内蒙古财经大学西区");
		corder.setEndTime(new Timestamp(0));
		corder.setIsValid(0);
		corder.setMoney(12.34);
		corder.setOcount(5);
		corder.setOdescribe("星期天对实验室进行大扫除");
		corder.setOphotoPath("/root/aa/abc.jpg");
		corder.setTitle("大扫除");
		corder.setTrade("家政");
		corder.setType("s");
		corder.setUid(1);
		System.out.println(corder.toString());
		corderDao.addCorder(corder);
	}
	
	@Test
	public void queryCorderByTest(){
		String type = "s";
		String trade = "家政";
		String title = "大";
		List<Corder> corderList = corderDao.queryCorderBy(type, trade, title);
		for(Corder corder:corderList){
			System.out.println(corder.toString());
		}
	}

}
