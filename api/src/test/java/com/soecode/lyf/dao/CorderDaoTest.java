package com.soecode.lyf.dao;

import java.sql.Timestamp;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import com.soecode.lyf.BaseTest;
import com.soecode.lyf.entity.Corder;
import com.soecode.lyf.entity.Cuser;

public class CorderDaoTest extends BaseTest{

	@Autowired
	CorderDao corderDao;
	
	@Autowired
	CuserDao cuserDao;
	
	@Test
	public void corderAddTest() {
		Cuser cuser = new Cuser();
		cuser = cuserDao.findByid(1);
		Corder corder = new Corder();
		corder.setAddress("内蒙古蒙牛集团三期工厂");
		corder.setEndTime(new Timestamp(0));
		corder.setIsValid(0);
		corder.setMoney(45.12);
		corder.setOcount(1);
		corder.setOdescribe("门前扫雪");
		corder.setOphotoPath("/root/abc.jpg");
		corder.setTitle("爱心活动");
		corder.setTrade("公益");
		corder.setType("n");
		//corder.setUid(1);
		corder.setCuser(cuser);
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

	@Test
	public void queryCorderByIdTest(){
		int oid = 1;
		Corder corder = corderDao.queryCorderById(oid);
		System.out.println(corder.getTitle());
		System.out.println(corder.getCuser().getName());
	}
	
	@Test
	public void deleteCorderByIdTest(){
		int oid = 10;
		corderDao.deleteCorderById(oid);
		
	}
}
