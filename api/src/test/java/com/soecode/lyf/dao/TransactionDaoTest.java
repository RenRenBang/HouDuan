package com.soecode.lyf.dao;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.soecode.lyf.BaseTest;
import com.soecode.lyf.entity.Transaction;

public class TransactionDaoTest extends BaseTest{

	@Autowired
	TransactionDao transactionDao;
	@Autowired
	CuserDao cuserDao;
	@Autowired
	CorderDao corderDao;
	
	@Test
	public void addTransactionTest() {
		transactionDao.addTransaction(4,5,6);
		System.out.println("transaction的插入执行成功。。。");
	}
	
	@Test
	public void queryTransactionByIdTest(){
		int uid = 1;
		List<Transaction> transactionList = transactionDao.queryTransactionById(uid);
		for(Transaction t:transactionList){
			System.out.println(t.toString());
		}
	}
}
