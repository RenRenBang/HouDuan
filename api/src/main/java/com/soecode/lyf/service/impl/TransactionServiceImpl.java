package com.soecode.lyf.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.soecode.lyf.dao.CorderDao;
import com.soecode.lyf.dao.TransactionDao;
import com.soecode.lyf.entity.Transaction;
import com.soecode.lyf.service.TransactionService;

@Service
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	TransactionDao transactionDao;
	@Autowired
	CorderDao corderDao;
	
	@Override
	public void addTransaction(int oid,int uid) {
		
		int releaseUid = corderDao.queryCorderById(oid).getCuser().getUid();
		transactionDao.addTransaction(oid,uid,releaseUid);
	}

	@Override
	public List<Transaction> queryTransactionById(int uid) {
		// TODO 自动生成的方法存根
		return transactionDao.queryTransactionById(uid);
	}

}
