package com.soecode.lyf.dao;

import org.apache.ibatis.annotations.Param;
import org.junit.runners.Parameterized.Parameters;

import com.soecode.lyf.entity.Cuser;

public interface CuserDao {
	
	
	//登录
	Cuser login(@Param("uphone") String uphone,@Param("password") String password);
	
	//注册
	void addCuser(Cuser cuser);
	
	//修改
	void updateCuser(@Param("uid") int uid,@Param("nickname") String nickname,@Param("password") String password,@Param("profile") String profile);
	
	//根据id查用户
	Cuser findByid(int uid);
	
	//通过手机号查询用户信息
	Cuser findCuserByPhone(String uphone);
	
	//修改头像
	void updateImgeById(int uid,String image);
	
	//修改身份证照片
	void updatePhotoPathById(int uid,String photoPath);

	//修改用户登录密码
	void updateCuserPw(String uphone,String password);
	
}
