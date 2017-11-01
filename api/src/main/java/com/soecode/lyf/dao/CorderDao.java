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
	 *按条件查询订单，有分页功能。。 
	 *type和trade是条件查询，title是模糊查询。如果不为空的时候进行添加的拼接，如果为空跳过该条件。
	 * @param type
	 * @param trade
	 * @param title
	 * @return
	 */
	List<Corder> queryCorderBy(@Param("type") String type,@Param("trade") String trade,@Param("title") String title,@Param("offset") int offset);
	
	//根据订单id查询订单
	Corder queryCorderById(int oid);
	
	//根据oid删除订单
	void deleteCorderById(int oid);
	
	//修改订单是否有效。is_valid属性。0无效，1有效。
	Integer isValidCorderById(@Param("isValid") int isValid ,@Param("oid") int oid);
	
	//修改订单的gm_num 和 coll_num 属性，表示该订单购买次数和收藏的次数。
	void updateNum(@Param("num") String num,@Param("oid") int oid);
	
	//通过用户id查询该用户发布的订单
	List<Corder> queryCorderListById(@Param("uid") int uid,@Param("type") String type);
	
	//需求类订单的需求人数减1
	void cutCount(int oid);
	
	//更新订单的是否有效的状态。和上面的一个方法重复了。
	void updateCorderByIsValid(@Param("oid") int oid,@Param("isvalid") int isvalid);
	
	//修改订单信息。
	void updateCorderByObject(Corder corder);
	
	
	
}