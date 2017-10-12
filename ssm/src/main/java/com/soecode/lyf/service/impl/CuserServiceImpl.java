package com.soecode.lyf.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.soecode.lyf.dao.CuserDao;
import com.soecode.lyf.entity.Cuser;
import com.soecode.lyf.service.CuserService;

@Service
public class CuserServiceImpl implements CuserService{

	@Autowired
	private CuserDao cuserdao;
	
	@Override
	public Cuser login(String uphone, String password) {
		// TODO Auto-generated method stub
		return cuserdao.login(uphone, password);
	}

}
