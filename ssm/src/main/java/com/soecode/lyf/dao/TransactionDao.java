package com.soecode.lyf.dao;

import org.apache.ibatis.annotations.Param;
import org.junit.runners.Parameterized.Parameter;

public interface TransactionDao {
	
	/**
	 * 添加交易单，time在map文件的sql中添加系统时间。
	 * @param oid
	 * @param uid
	 * @param releaseUid
	 * @return
	 */
	int addTransaction(@Param("oid") int oid,@Param("uid") int uid,@Param("releaseUid") int releaseUid);

}
