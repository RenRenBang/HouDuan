package com.soecode.lyf.service;

import com.soecode.lyf.entity.Cuser;

public interface CuserService {
	
	Cuser login(String uphone,String password);
	
	//注册
	void addCuser(Cuser cuser);
		
	//修改
	void updateCuser(int uid,String nickname,String password,String profile);
	
	//根据id查用户	
	Cuser findByid(int uid);
	
	//根据手机号查用户
	Cuser findCuserByPhone(String uphone);
	
	//修改头像
	void updateImgeById(int uid,String image);
	
	//修改身份证照片
	void updatePhotoPathById(int uid,String photoPath);
	
	//重置用户密码
	void updateCuserPw(String uphone,String password);
}
