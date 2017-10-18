package com.soecode.lyf.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.junit.runners.Parameterized.Parameters;

import com.soecode.lyf.entity.Collections;

public interface CollectionDao {

		//添加收藏
		void addCollection(@Param("oid") int oid ,@Param("uid") int uid);
		
		//刪除收藏
		void delCollection(int cid);
		
		//根据用户uid查收藏
		List<Collections> findByUid(int uid);
}
