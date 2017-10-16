package com.soecode.lyf.web;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.soecode.lyf.entity.Corder;
import com.soecode.lyf.entity.Cuser;
import com.soecode.lyf.entity.JsonCode;
import com.soecode.lyf.service.CorderService;
import com.soecode.lyf.utils.JsonOperator;

@Controller
public class CorderController {

	@Autowired
	CorderService corderService;
	
	@ResponseBody
	@RequestMapping(value = "/addCorder", method = RequestMethod.POST,produces = "text/json;charset=UTF-8")
	private String addCorder(HttpServletRequest request) {
		Cuser cuser = new Cuser();
		Corder corder = new Corder();
		cuser.setUid(Integer.parseInt(request.getParameter("uid")));
		corder.setCuser(cuser);
		corder.setAddress(request.getParameter("address"));
		corder.setEndTime(new Date(request.getParameter("endTime")));
		corder.setMoney(Double.parseDouble(request.getParameter("money")));
		corder.setOcount(Integer.parseInt(request.getParameter("ocount")));
		corder.setOdescribe(request.getParameter("odescribe"));
		corder.setTitle(request.getParameter("title"));
		corder.setTrade(request.getParameter("trade"));
		corder.setType(request.getParameter("type"));
		JsonCode<Corder> jsonCode = new JsonCode<Corder>();
		try {
			corderService.addCorder(corder);
			jsonCode.setStatusCode("200");
			jsonCode.setTagCode("增加成功");
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			jsonCode.setStatusCode("400");
			jsonCode.setTagCode("增加失败");
		}
		return JsonOperator.toJson(jsonCode);
	} 
	
	@ResponseBody
	@RequestMapping(value = "/queryCorderBy", method = RequestMethod.GET,produces = "text/json;charset=UTF-8")
	private String queryCorderBy(@RequestParam("type") String type, @RequestParam("trade") String trade,@RequestParam("title") String title) {
		List<Corder> corderList = corderService.queryCorderList(type, trade, title);
		JsonCode<Corder> jsonCode = new JsonCode<Corder>();
		if(corderList.size() == 0){
			jsonCode.setStatusCode("400");
			jsonCode.setTagCode("查询失败");
		} else {
			jsonCode.setStatusCode("200");
			jsonCode.setTagCode("查询成功");
			jsonCode.setData(corderList);
		}
		System.out.println(JsonOperator.toJson(jsonCode));
		//return "corder/corderListJsp";
		return JsonOperator.toJson(jsonCode);
	} 
	
	@ResponseBody
	@RequestMapping(value = "/queryCorderById", method = RequestMethod.GET,produces = "text/json;charset=UTF-8")
	private String queryCorderById(@RequestParam("oid") int oid) {
		Corder corder = corderService.queryCorderById(oid);
		List<Corder> list = new ArrayList<Corder>();
		list.add(corder);
		String dataString = JsonOperator.toJson(corder);
		JsonCode<Corder> jsonCode = new JsonCode<Corder>();
		if("".equals(dataString)){
			jsonCode.setStatusCode("400");
			jsonCode.setTagCode("查询失败");
		} else {
			jsonCode.setStatusCode("200");
			jsonCode.setTagCode("查询成功");
			jsonCode.setData(list);
		}
		System.out.println(JsonOperator.toJson(jsonCode));
		//return "corder/corderListJsp";
		return JsonOperator.toJson(jsonCode);
	} 
	
	@ResponseBody
	@RequestMapping(value = "/deleteCorderById", method = RequestMethod.GET,produces = "text/json;charset=UTF-8")
	private String deleteCorderById(@RequestParam("oid") int oid) {
		JsonCode<Corder> jsonCode = new JsonCode<Corder>();
		try {
			corderService.deleteCorderById(oid);
			jsonCode.setStatusCode("200");
			jsonCode.setTagCode("删除成功");
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			jsonCode.setStatusCode("400");
			jsonCode.setTagCode("删除失败");
		}		
		return JsonOperator.toJson(jsonCode);
	}
	
	@ResponseBody
	@RequestMapping(value = "/queryCorderListById", method = RequestMethod.GET,produces = "text/json;charset=UTF-8")
	private String queryCorderListById(@RequestParam("uid") int uid) {
		List<Corder> corderList = corderService.queryCorderListById(uid);
		JsonCode<Corder> jsonCode = new JsonCode<Corder>();
		if(corderList.size() != 0){
			jsonCode.setStatusCode("200");
			jsonCode.setTagCode("查询成功");
			jsonCode.setData(corderList);
		} else {
			jsonCode.setStatusCode("400");
			jsonCode.setTagCode("查询失败");
		}		
		return JsonOperator.toJson(jsonCode);
	}
}
