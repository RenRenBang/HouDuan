package com.soecode.lyf.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.soecode.lyf.entity.Transaction;

public interface TransactionDao {
	
	/**
	 * 添加加交易订单
	 * @param transaction
	 * @return
	 */
	int addTransaction(@Param("oid") int oid,@Param("uid") int uid,@Param("releaseUid") int releaseUid);
	
	List<Transaction> queryTransactionById(@Param("uid") int uid,@Param("type") String type);
}
