package com.soecode.lyf.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.soecode.lyf.entity.Corder;
import com.soecode.lyf.entity.JsonCode;
import com.soecode.lyf.service.CorderService;
import com.soecode.lyf.utils.JsonOperator;

@Controller
public class CorderController {

	@Autowired
	CorderService corderService;
	
	@RequestMapping(value = "/addCorder", method = RequestMethod.POST)
	private String addCorder() {
		//这里需要传参数进行测试，明天再添加。。。。。
		
		//差一个将返回结果打包为json格式的工具类。。。。。。
		return "";
	} 
	
	@ResponseBody
	@RequestMapping(value = "/queryCorderBy", method = RequestMethod.GET,produces = "text/json;charset=UTF-8")
	private String queryCorderBy(@RequestParam("type") String type, @RequestParam("trade") String trade,@RequestParam("title") String title) {
		List<Corder> corderList = corderService.queryCorderList(type, trade, title);
		String dataString = JsonOperator.toJson(corderList);
		JsonCode<Corder> jsonCode = new JsonCode<Corder>();
		if("".equals(dataString)){
			jsonCode.setStatusCode("400");
		} else {
			jsonCode.setStatusCode("200");
		}
		jsonCode.setData(corderList);
		jsonCode.setTagCode("查询成功");
		System.out.println(JsonOperator.toJson(jsonCode));
		//return "corder/corderListJsp";
		return JsonOperator.toJson(jsonCode);
	} 
}
