package com.soecode.lyf.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.soecode.lyf.service.CorderService;

@Controller
public class CorderController {

	@Autowired
	CorderService corderService;
	
	@RequestMapping(value = "/corderAdd", method = RequestMethod.GET)
	private String corderAdd() {
		//这里需要传参数进行测试，明天再添加。。。。。
		
		//差一个将返回结果打包为json格式的工具类。。。。。。
		return "";
	} 
}
