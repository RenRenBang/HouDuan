package com.soecode.lyf.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.junit.runners.Parameterized.Parameters;

import com.soecode.lyf.entity.Corder;

public interface CorderDao {

	/**
	 * 插入新的订单
	 * @param corder
	 */
	void addCorder(Corder corder);
	
	/**
	 *按条件查询订单，没有完成分页功能。。 
	 *type和trade是条件查询，title是模糊查询。如果不为空的时候进行添加的拼接，如果为空跳过该条件。
	 * @param type
	 * @param trade
	 * @param title
	 * @return
	 */
	List<Corder> queryCorderBy(@Param("type") String type,@Param("trade") String trade,@Param("title") String title,@Param("offset") int offset);
	
	Corder queryCorderById(int oid);
	
	void deleteCorderById(int oid);
	
	void isValidCorderById(@Param("isValid") int isValid ,@Param("oid") int oid);
	
	void updateNum(@Param("num") String num,@Param("oid") int oid);
	
	List<Corder> queryCorderListById(@Param("uid") int uid,@Param("type") String type);
	
	void cutCount(int oid);
	
	void updateCorderByIsValid(@Param("oid") int oid,@Param("isvalid") int isvalid);
	
	void updateCorderByObject(Corder corder);
	
	
	
}