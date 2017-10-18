package com.soecode.lyf.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.soecode.lyf.dao.CuserDao;
import com.soecode.lyf.entity.Cuser;
import com.soecode.lyf.service.CuserService;

@Service
public class CuserServiceImpl implements CuserService{

	//需要dao对象会自动注入
	@Autowired
	private CuserDao cuserdao;
	
	@Override
	public Cuser login(String uphone, String password) {
		// TODO Auto-generated method stub
		return cuserdao.login(uphone, password);
	}

	@Override
	public void addCuser(Cuser cuser) {
		// TODO Auto-generated method stub
		cuserdao.addCuser(cuser);
	}

	@Override
	public void updateCuser(Cuser cuser) {
		// TODO Auto-generated method stub
		cuserdao.updateCuser(cuser);
	}

	@Override
	public Cuser findByid(int uid) {
		// TODO Auto-generated method stub
		return cuserdao.findByid(uid);
	}

	@Override
	public void updateImgeById(int uid,String image) {
		// TODO Auto-generated method stub
		cuserdao.updateImgeById(uid,image);
	}

	@Override
	public Cuser findCuserByPhone(String uphone) {
		// TODO 自动生成的方法存根
		return cuserdao.findCuserByPhone(uphone);
	}

	@Override
	public void updatePhotoPathById(int uid, String photoPath) {
		// TODO Auto-generated method stub
		cuserdao.updatePhotoPathById(uid, photoPath);
	}
	

}
