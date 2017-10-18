package com.soecode.lyf.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.soecode.lyf.dao.CollectionDao;
import com.soecode.lyf.dao.CorderDao;
import com.soecode.lyf.entity.Collections;
import com.soecode.lyf.service.CollectionService;

@Service
public class CollectionServiceImpl implements CollectionService {

	
	@Autowired
	CollectionDao collectionDao;
	@Autowired
	CorderDao corderDao;
	
	@Override
	public void addCollection(int oid,int uid) {
		// TODO Auto-generated method stub
		collectionDao.addCollection(oid,uid);
	}

	@Override
	public void delCollection(int cid) {
		// TODO Auto-generated method stub
		collectionDao.delCollection(cid);
	}

	@Override
	public List<Collections> findByUid(int uid) {
		// TODO Auto-generated method stub
		return collectionDao.findByUid(uid);
	}

}
