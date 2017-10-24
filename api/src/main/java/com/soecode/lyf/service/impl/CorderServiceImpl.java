package com.soecode.lyf.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.soecode.lyf.dao.CorderDao;
import com.soecode.lyf.entity.Corder;
import com.soecode.lyf.service.CorderService;

@Service
public class CorderServiceImpl implements CorderService {

	@Autowired
	CorderDao corderDao;
	
	@Override
	public void addCorder(Corder corder) {
		//如果前端接收到的参数类型不合适，在service层进行调整。不在controller进行处理，cotroller接受最原始的数据就行。
//		Corder corder = new Corder();
//		corder.setType("service");
		
		corderDao.addCorder(corder);
	}

	@Override
	public List<Corder> queryCorderList(String type, String trade, String title,int offet) {
		// TODO 自动生成的方法存根
		return corderDao.queryCorderBy(type, trade, title,offet);
	}

	@Override
	public void deleteCorderById(int oid) {
		// TODO 自动生成的方法存根
		corderDao.deleteCorderById(oid);
	}

	@Override
	public Corder queryCorderById(int oid) {
		
		return corderDao.queryCorderById(oid);
	}

	@Override
	public void updateNum(String num, int oid) {
		// TODO 自动生成的方法存根
		corderDao.updateNum(num, oid);
	}

	@Override
	public List<Corder> queryCorderListById(int uid,String type) {
		// TODO 自动生成的方法存根
		return corderDao.queryCorderListById(uid,type);
	}

	@Override
	public void cutCount(int oid) {
		// TODO 自动生成的方法存根
		corderDao.cutCount(oid);
	}

	@Override
	public void updateCorderByIsValid(int oid, int isvalid) {
		// TODO 自动生成的方法存根
		corderDao.updateCorderByIsValid(oid, isvalid);
	}

	@Override
	public void updateCorderByObject(Corder corder) {
		// TODO 自动生成的方法存根
		corderDao.updateCorderByObject(corder);
	}

	@Override
	public void isValidCorderById(int isValid,int oid) {
		// TODO 自动生成的方法存根
		corderDao.isValidCorderById(isValid,oid);
	}

}
