package com.soecode.lyf.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.soecode.lyf.entity.Cuser;
import com.soecode.lyf.entity.JsonCode;
import com.soecode.lyf.service.CuserService;
import com.soecode.lyf.utils.CheckCode;
import com.soecode.lyf.utils.JsonOperator;
import com.soecode.lyf.utils.RandomNum;

@Controller
public class CuserController {

	@Autowired
	private CuserService cuserService;

	// 用户登录
	
	@ResponseBody
	@RequestMapping(value = "/to_login", method = RequestMethod.POST, produces = "text/json;charset=UTF-8")
	public String login(@RequestParam("uphone") String uphone, @RequestParam("password") String password,
			HttpServletRequest request) {
		Cuser cuser = cuserService.login(uphone, password);
		JsonCode<Cuser> jsonCode = new JsonCode<Cuser>();
		List<Cuser> cuserList = new ArrayList<Cuser>();
		cuserList.add(cuser);
		if (cuser != null) {
			jsonCode.setStatusCode("200");
			jsonCode.setTagCode("登录成功");
			jsonCode.setData(cuserList);
			request.getSession().setAttribute("cuser", cuser);
		} else {
			jsonCode.setStatusCode("400");
			jsonCode.setTagCode("登录失败");
		}
		System.out.println(JsonOperator.toJson(jsonCode));
		return JsonOperator.toJson(jsonCode);
	}

	/*
	 * uphone; name; nickname; idNumber; image; photoPath; password; profile;
	 */

	/*
	 * @RequestMapping(value="addCuser",method = RequestMethod.POST) public
	 * String addCuser(@RequestParam("uphone") String uphone,
	 * 
	 * @RequestParam("name") String name,
	 * 
	 * @RequestParam("nickname") String nickname,
	 * 
	 * @RequestParam("idNumber") String idNumber,
	 * 
	 * @RequestParam("image") String image,
	 * 
	 * @RequestParam("photoPath") String photoPath,
	 * 
	 * @RequestParam("password") String password,
	 * 
	 * @RequestParam("profile") String profile) {
	 * 
	 * Cuser cuser = new Cuser(null, uphone, name, nickname, idNumber, image,
	 * photoPath, password, profile); return null; }
	 */

	/**
	 * 添加用户,注册的时候不需要上传头像，请在api文档中进行说明。
	 * 身份证照片的路径，在上传附件的时候修改用户信息中的idPhotoPath字段的数据。
	 * 
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "addCuser", method = RequestMethod.POST, produces = "text/json;charset=UTF-8")
	public String addCuser(HttpServletRequest request) {
		Cuser cuser = new Cuser();
		cuser.setIdNumber(request.getParameter("idNumber"));
		cuser.setName(request.getParameter("name"));
		cuser.setNickname(request.getParameter("nickname"));
		cuser.setPassword(request.getParameter("password"));
		cuser.setProfile(request.getParameter("profile"));
		cuser.setUphone(request.getParameter("uphone"));
		System.out.println("表单提交的用户信息：" + cuser.toString());
		String code = request.getParameter("code");
		String uphone = null;
		String code1 = null;
		JsonCode<Cuser> jsonCode = new JsonCode<Cuser>();
		List<Cuser> cuserList = new ArrayList<Cuser>();
		
		if (cuser.getUphone() != null && cuser.getUphone() != "") {
			if (code != null && code != "") {
				Cuser cuserFind = cuserService.findCuserByPhone(cuser.getUphone());
				if (cuserFind != null) {
					jsonCode.setStatusCode("400");
					jsonCode.setTagCode("该手机号已注册");
					return JsonOperator.toJson(jsonCode);
				}
				try {
					@SuppressWarnings("unchecked")
					Map<String, String> mapCheckCode = (Map<String, String>) request.getServletContext()
							.getAttribute("CheckCode");
					//问题：获取验证码的请求和注册信息的请求不能获取到同一个session的信息。保存在application中，临时解决办法。。
					
					if (mapCheckCode != null) {
						//uphone = mapCheckCode.get("uphone");
						code1 = mapCheckCode.get(cuser.getUphone());
						System.out.println("session获取的CheckCode"+code1+"#接收到的code"+code);
						if (code1 != null &&  !"".equals(code1)) {
							if (code.equals(code1)) {
								System.out.println("验证码通过，开始注册用户。。。。。。");
								// 不能重复注册，在注册以前需要对用户进行查找，通过手机号进行查找。
								cuserService.addCuser(cuser);
								Cuser cuserSuccessFind = cuserService.findCuserByPhone(cuser.getUphone());
								cuserList.add(cuserSuccessFind);
								
								//插入对象成功的时候返回对象的uid用于上传身份证照片，分步上传的。
								//并且在data中返回注册成功用户的信息。
								jsonCode.setStatusCode("200");
								jsonCode.setTagCode(cuserSuccessFind.getUid()+"");
								jsonCode.setData(cuserList);
							} else {
								cuserList.add(cuser);
								jsonCode.setStatusCode("300");
								jsonCode.setTagCode("验证码错误n");
								jsonCode.setData(cuserList);
							}
						} else {
							cuserList.add(cuser);
							jsonCode.setStatusCode("400");
							jsonCode.setTagCode("手机号码错误,无法获取session的code");
							jsonCode.setData(cuserList);
						}
						System.out.println(JsonOperator.toJson(jsonCode));
						return JsonOperator.toJson(jsonCode);
					} else {
						cuserList.add(cuser);
						jsonCode.setStatusCode("300");
						jsonCode.setTagCode("手机号码未发送验证码");
						jsonCode.setData(cuserList);
						return JsonOperator.toJson(jsonCode);
					}
				} catch (Exception e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
					System.out.println("获取session中 的数据异常了。。。。。");
					cuserList.add(cuser);
					jsonCode.setStatusCode("300");
					jsonCode.setTagCode("session异常，服务器验证码丢失");
					jsonCode.setData(cuserList);
					return JsonOperator.toJson(jsonCode);
				}
			} else {
				cuserList.add(cuser);
				jsonCode.setStatusCode("300");
				jsonCode.setTagCode("验证码错误w");
				jsonCode.setData(cuserList);
				return JsonOperator.toJson(jsonCode);
			}
		}
		cuserList.add(cuser);
		jsonCode.setStatusCode("400");
		jsonCode.setTagCode("手机号码错误");
		jsonCode.setData(cuserList);
		return JsonOperator.toJson(jsonCode);
	}

	// 获取验证码
	@ResponseBody
	@RequestMapping(value = "getCheckCode", method = RequestMethod.POST, produces = "text/json;charset=UTF-8")
	public String getCheckCode(HttpServletRequest request) {
		JsonCode<Cuser> jsonCode = new JsonCode<Cuser>();
		try {
			String uphone = request.getParameter("uphone");
			Cuser cuserFind = cuserService.findCuserByPhone(uphone);
			if (cuserFind != null) {
				jsonCode.setStatusCode("400");
				jsonCode.setTagCode("该手机号已注册y");
				return JsonOperator.toJson(jsonCode);
			}
			RandomNum random = new RandomNum();
			String code = random.getRandomNum();
			CheckCode checkCode = new CheckCode();
			checkCode.f1(uphone, code);
			System.out.println("验证码为" + code + "请保密！");
			// 这样在session中多个人同时注册可能产生混淆，可以将手机号和验证码临时保存在一个新建的session中，到时间了自动销毁，
			// 或者将手机号和验证码打包在一个map中保存，不能像这样单独存储，多个人同时注册一定混淆。
			Map<String, String> mapTempCode = (Map<String, String>) request.getServletContext().getAttribute(uphone);
			//mapTempCode = (Map<String, String>) request.getSession().getAttribute(uphone);
			//mapTempCode.clear();
			if(mapTempCode == null){
				mapTempCode = new HashMap<String,String>();
			}
			mapTempCode.put(uphone,code);
			request.getServletContext().setAttribute("CheckCode", mapTempCode);
			jsonCode.setStatusCode("200");
			jsonCode.setTagCode("发送成功");
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			jsonCode.setStatusCode("300");
			jsonCode.setTagCode("服务器错误，验证码发送失败");
		}
		return JsonOperator.toJson(jsonCode);
	}
	
	// 获取验证码，不验证该手机用户是否已经注册，用于重置密码发送验证码。
	@ResponseBody
	@RequestMapping(value = "getCheckCode2", method = RequestMethod.POST, produces = "text/json;charset=UTF-8")
	public String getCheckCode2(HttpServletRequest request) {
		JsonCode<Cuser> jsonCode = new JsonCode<Cuser>();
		String uphone = request.getParameter("uphone");
		RandomNum random = new RandomNum();
		String code = random.getRandomNum();
		CheckCode checkCode = new CheckCode();
		checkCode.f1(uphone, code);
		System.out.println("验证码为" + code + "请保密！");
		// 这样在session中多个人同时注册可能产生混淆，可以将手机号和验证码临时保存在一个新建的session中，到时间了自动销毁，
		// 或者将手机号和验证码打包在一个map中保存，不能像这样单独存储，多个人同时注册一定混淆。
		Map<String, String> mapTempCode = (Map<String, String>) request.getServletContext().getAttribute(uphone);
		// mapTempCode = (Map<String, String>)
		// request.getSession().getAttribute(uphone);
		// mapTempCode.clear();
		if (mapTempCode == null) {
			mapTempCode = new HashMap<String, String>();
		}
		mapTempCode.put(uphone, code);
		request.getServletContext().setAttribute("CheckCode", mapTempCode);
		jsonCode.setStatusCode("200");
		jsonCode.setTagCode("发送成功");
		return JsonOperator.toJson(jsonCode);
	}

	// 修改密码和昵称
	@ResponseBody
	@RequestMapping(value = "updateNameAndNick", method = RequestMethod.POST, produces = "text/json;charset=UTF-8")
	public String updateNameAndNick(@RequestParam("uid") int uid, @RequestParam("password") String password,
			@RequestParam("nickname") String nickname,@RequestParam("profile") String profile) {
		cuserService.updateCuser(uid, nickname, password,profile);
		JsonCode<Cuser> jsonCode = new JsonCode<Cuser>();
		jsonCode.setStatusCode("200");
		jsonCode.setTagCode("修改成功");
		return JsonOperator.toJson(jsonCode);
	}

	//找回密码，通过发短信验证。
	@ResponseBody
	@RequestMapping(value = "updatePassword", method = RequestMethod.POST, produces = "text/json;charset=UTF-8")
	public String updatePassword(@RequestParam("uphone") String uphone, @RequestParam("password") String password,
			@RequestParam("checkCode") String checkCode,HttpServletRequest request) {
		JsonCode<Cuser> jsonCode = new JsonCode<Cuser>();
		Cuser cuserTemp = cuserService.findCuserByPhone(uphone);
		//判断该用户是否已经注册
		String code1 = null;
		if(cuserTemp != null){
			try {
				@SuppressWarnings("unchecked")
				Map<String, String> mapCheckCode = (Map<String, String>) request.getServletContext()
						.getAttribute("CheckCode");
				//问题：获取验证码的请求和注册信息的请求不能获取到同一个session的信息。保存在application中，临时解决办法。。
				
				if (mapCheckCode != null) {
					//uphone = mapCheckCode.get("uphone");
					code1 = mapCheckCode.get(uphone);
					System.out.println("session获取的CheckCode"+code1+"#接收到的code"+checkCode);
					if (code1 != null &&  !"".equals(code1)) {
						if (checkCode.equals(code1)) {
							System.out.println("验证码通过，开始重置用户密码。。。。。。");
							
							//重置用户密码，使用uid？还是使用uphone？
							cuserService.updateCuserPw(uphone,password);
							jsonCode.setStatusCode("200");
							jsonCode.setTagCode("密码重置成功");
						} else {
							jsonCode.setStatusCode("300");
							jsonCode.setTagCode("验证码错误n");
						}
					} else {
						jsonCode.setStatusCode("400");
						jsonCode.setTagCode("手机号码错误,无法获取session的code,也可能该手机号没有发送验证码");
					}
					System.out.println(JsonOperator.toJson(jsonCode));
					return JsonOperator.toJson(jsonCode);
				} else {
					jsonCode.setStatusCode("300");
					jsonCode.setTagCode("手机号码未发送验证码");
					return JsonOperator.toJson(jsonCode);
				}
			} catch (Exception e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
				System.out.println("获取session中 的数据异常了。。。。。");
				jsonCode.setStatusCode("300");
				jsonCode.setTagCode("session异常，服务器验证码丢失");
				return JsonOperator.toJson(jsonCode);
			}
		} else {
			jsonCode.setStatusCode("400");
			jsonCode.setTagCode("该手机号用户未注册");
		}
		return JsonOperator.toJson(jsonCode);
	}
	
	// 修改头像
	@ResponseBody
	@RequestMapping(value = "updateImage", method = RequestMethod.POST, produces = "text/json;charset=UTF-8")
	public String updateImage(@RequestParam("uid") int uid, @RequestParam("image") String image) {
		cuserService.updateImgeById(uid, image);
		JsonCode<Cuser> jsonCode = new JsonCode<Cuser>();
		jsonCode.setStatusCode("200");
		jsonCode.setTagCode("修改成功");
		return JsonOperator.toJson(jsonCode);
	}

	// 根据uid查用户信息
	@ResponseBody
	@RequestMapping(value = "findByUid", method = RequestMethod.GET, produces = "text/json;charset=UTF-8")
	public String findByUid(@RequestParam("uid") int uid) {
		Cuser cuser = cuserService.findByid(uid);
		List<Cuser> cuserList = new ArrayList<Cuser>();
		cuserList.add(cuser);
		JsonCode<Cuser> jsonCode = new JsonCode<Cuser>();
		if (cuserList.size() != 0) {
			jsonCode.setStatusCode("200");
			jsonCode.setTagCode("修改成功");
			jsonCode.setData(cuserList);
		} else {
			jsonCode.setStatusCode("400");
			jsonCode.setTagCode("修改失败");
		}
		return JsonOperator.toJson(jsonCode);
	}

	@ResponseBody
	@RequestMapping(value = "to_logout", method = RequestMethod.POST, produces = "text/json;charset=UTF-8")
	public void logout(HttpServletRequest request) {
		request.getSession().invalidate();
	}
}
