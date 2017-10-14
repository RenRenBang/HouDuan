package com.soecode.lyf.service;

import java.util.List;

import com.soecode.lyf.entity.Corder;

public interface CorderService {

	void addCorder(Corder corder);
	
	List<Corder> queryCorderList(String type ,String trade ,String title);
}
