package com.soecode.lyf.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.soecode.lyf.entity.Cuser;
import com.soecode.lyf.service.CuserService;

@Controller
public class CuserController {

	@Autowired
	private CuserService cuserService;
	
	@RequestMapping(value = "/to_login", method = RequestMethod.POST)
	private String login( Model mav,@RequestParam("uphone") String uphone,@RequestParam("upassword") String upassword) {
		Cuser cuser = cuserService.login(uphone,upassword);
		if(cuser != null) {
			
			//测试接收到的数据
			System.out.println(cuser.toString());
			
			mav.addAttribute("cuser",cuser);
			//参数需要返回对象列表，并且打包为json格式数据response返回到前端。
			return "cuser/loginSuccessJsp";
			
		}
		//这个是跳转的页面，没有路径前缀和文件后缀，是因为在spring-web.xml中做了统一的配置
		return "cuser/loginJsp";
	}
	
	@RequestMapping(value = "/begin", method = RequestMethod.GET)
	private String begin() {
		System.out.println("通过index页面开始进入web-inf目录下的页面");
		return "cuser/loginJsp";
	} 
}
