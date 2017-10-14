package com.soecode.lyf.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.soecode.lyf.entity.Cuser;
import com.soecode.lyf.service.CuserService;
import com.soecode.lyf.utils.CheckCode;
import com.soecode.lyf.utils.RandomNum;

@Controller
public class CuserController {

	@Autowired
	private CuserService cuserService;
	
	//用户登录
	@RequestMapping(value = "/to_login", method = RequestMethod.POST)
	private String login( Model mav,@RequestParam("uphone") String uphone,@RequestParam("password") String password) {
		Cuser cuser = cuserService.login(uphone,password);
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
		return "cuser/testcode";
	} 
	
	/*uphone;
	name;
	nickname;
	idNumber;
	image;
	photoPath;
	password;
	profile;*/
	
	/*@RequestMapping(value="addCuser",method = RequestMethod.POST)
	public String addCuser(@RequestParam("uphone") String uphone,
			@RequestParam("name") String name,
			@RequestParam("nickname") String nickname,
			@RequestParam("idNumber") String idNumber,
			@RequestParam("image") String image,
			@RequestParam("photoPath") String photoPath,
			@RequestParam("password") String password,
			@RequestParam("profile") String profile) {
		
		Cuser cuser = new Cuser(null, uphone, name, nickname, idNumber, image, photoPath, password, profile);
		return null;
	}*/
	
	//添加用户
	@RequestMapping(value="addCuser",method = RequestMethod.POST)
	public String addCuser(HttpServletRequest request) {
		Cuser cuser = new Cuser();
		cuser.setIdNumber(request.getParameter("idNumber"));
		
		cuser.setName(request.getParameter("name"));
		cuser.setNickname(request.getParameter("nickname"));
		cuser.setPassword(request.getParameter("password"));
		
		cuser.setProfile(request.getParameter("profile"));
		cuser.setUphone(request.getParameter("uphone"));
		String code = request.getParameter("code");
		String code1 = (String) request.getSession().getAttribute("code");
		String uphone = (String) request.getSession().getAttribute("uphone");
		if(code.equals(code1)&&uphone.equals(cuser.getUphone())) {
			cuserService.addCuser(cuser);
			return null;
		}else {
			
			return null;
		}
	}
	
	//获取验证码
	@RequestMapping(value="getCheckCode",method = RequestMethod.POST)
	public String getCheckCode(HttpServletRequest request) {
		String uphone = request.getParameter("uphone");
		RandomNum random = new RandomNum();
		String code = random.getRandomNum();
		CheckCode checkCode = new CheckCode();
		checkCode.f1(uphone, code);
		request.getSession().setAttribute("code", code);
		request.getSession().setAttribute("uphone", uphone);
		return "/cuser/testcode";
	}
	
	//修改密码和昵称
	@RequestMapping(value="updateNameAndNick")
	public String updateNameAndNick(@RequestParam("uid") int uid,@RequestParam("password") String password,@RequestParam("nickname") String nickname) {
		Cuser cuser = cuserService.findByid(uid);
		cuser.setPassword(password);
		cuser.setNickname(nickname);
		cuserService.updateCuser(cuser);
		return null;
	}
	//修改头像
	@RequestMapping(value="updateImage")
	public String updateImage(@RequestParam("uid") int uid,	@RequestParam("image") String image) {
		cuserService.updateImgeById(uid, image);
		return null;
	}
	
	//根据uid查用户信息
	
	@RequestMapping(value="findByUid")
	public String findByUid(@RequestParam("uid") int uid) {
		Cuser cuser = cuserService.findByid(uid);
		return null;
	}
}
