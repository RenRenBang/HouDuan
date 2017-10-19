package com.soecode.lyf.service;

import java.util.List;

import com.soecode.lyf.entity.Corder;

public interface CorderService {

	void addCorder(Corder corder);
	
	List<Corder> queryCorderList(String type ,String trade ,String title,int offset);
	
	void deleteCorderById(int oid);
	
	Corder queryCorderById(int oid);
	
	void updateNum(String num,int oid);
	
	List<Corder> queryCorderListById(int uid,String type);
	
	void cutCount(int oid);
}
