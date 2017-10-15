package com.soecode.lyf.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.soecode.lyf.BaseTest;
import com.soecode.lyf.entity.Collections;

public class CollectionDaoTest extends BaseTest {

	@Autowired
	CollectionDao collectionDao;
	
	@Test
	public void findByUidtest() {
		int uid = 1;
		List<Collections> collectionList = collectionDao.findByUid(uid);
		for(Collections c:collectionList) {
			System.out.println(c.toString());
		}
	}

}
