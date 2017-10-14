package com.soecode.lyf.dao;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.soecode.lyf.BaseTest;

public class TransactionDaoTest extends BaseTest{

	@Autowired
	TransactionDao transactionDao;
	
	@Test
	public void addTransactionTest() {
		int id = 1;
		int releaseUid = 2;
		transactionDao.addTransaction(id, id, releaseUid);
		System.out.println("transaction的插入执行成功。。。");
	}

}
