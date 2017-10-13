package com.soecode.lyf.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.soecode.lyf.dao.CorderDao;
import com.soecode.lyf.service.CorderService;

@Service
public class CorderServiceImpl implements CorderService {

	@Autowired
	CorderDao corderdao;
	
	@Override
	public void corderAdd(String type) {
		//如果前端接收到的参数类型不合适，在service层进行调整。不在controller进行处理，cotroller接受最原始的数据就行。
		corderdao.corderAdd(type);
	}

}
