package com.soecode.lyf.service;

import java.util.List;

import com.soecode.lyf.entity.Collections;

public interface CollectionService {

	//添加收藏
			void addCollection(int oid,int uid);
			
			//刪除收藏
			void delCollection(int cid);
			
			//根据用户uid查收藏
			List<Collections> findByUid(int uid);
			
			String findCidByUidOid(int uid,int oid);
}
