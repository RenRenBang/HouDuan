package com.soecode.lyf.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BeginController {

	@RequestMapping(value = "/begin", method = RequestMethod.GET)
	private String begin() {
		System.out.println("通过index页面开始进入web-inf目录下的页面");
		return "cuser/loginJsp";
	} 
}
