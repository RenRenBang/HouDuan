package com.soecode.lyf.web;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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
	@RequestMapping(value = "/addCorder", method = RequestMethod.POST, produces = "text/json;charset=UTF-8")
	private String addCorder(HttpServletRequest request) {
		JsonCode<Corder> jsonCode = new JsonCode<Corder>();
		try {
			Cuser cuser = new Cuser();
			Corder corder = new Corder();
			cuser.setUid(Integer.parseInt(request.getParameter("uid")));
			corder.setCuser(cuser);
			corder.setOdescribe(request.getParameter("odescribe"));
			corder.setTitle(request.getParameter("title"));
			corder.setTrade(request.getParameter("trade"));
			corder.setType(request.getParameter("type"));
			corder.setAddress(request.getParameter("address"));
			corder.setMoney(Double.parseDouble("0"+request.getParameter("money")));
			corder.setOcount(Integer.parseInt("0"+request.getParameter("ocount")));
			// 处理时间戳问题
			//接收和返回的都是时间戳类型的数据
			//注意：java中的date对象的getTime是获取时间戳的。
			String requestTime = request.getParameter("endTime");
			java.util.Date date = null;
			if(requestTime != null && requestTime != ""){
				try {
					SimpleDateFormat format =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
					Long time=new Long(requestTime);  
					String d = format.format(time);  
					date=format.parse(d); 
				} catch (ParseException e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
					System.out.println("时间转换错误");
				}
			}
			corder.setEndTime(date);
			
			System.out.println("准备添加的订单"+corder.toString());
			
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

	//修改订单信息updateCorderByObject
	@ResponseBody
	@RequestMapping(value = "/updateCorderByObject", method = RequestMethod.POST, produces = "text/json;charset=UTF-8")
	private String updateCorderByObject(HttpServletRequest request) {
		JsonCode<Corder> jsonCode = new JsonCode<Corder>();
		try {
			Cuser cuser = new Cuser();
			Corder corder = new Corder();
			//corder对象中的cuser在做插入的时候不需要完整的cuser信息，有id即可。所以这里不需要做cuser的查询。
			//能取到uid的值就说明数据库中肯定有这个用户了
			cuser.setUid(Integer.parseInt(request.getParameter("uid")));
			corder.setCuser(cuser);
			//修改需要获取订单的oid,隐藏字段，必须要有。
			corder.setOid(Integer.parseInt(request.getParameter("oid")));
			corder.setOdescribe(request.getParameter("odescribe"));
			corder.setTitle(request.getParameter("title"));
			corder.setTrade(request.getParameter("trade"));
			corder.setType(request.getParameter("type"));
			corder.setAddress(request.getParameter("address"));
			corder.setMoney(Double.parseDouble("0"+request.getParameter("money")));
			corder.setOcount(Integer.parseInt("0"+request.getParameter("ocount")));
			// 处理时间戳问题
			//接收和返回的都是时间戳类型的数据
			//注意：java中的date对象的getTime是获取时间戳的。
			String requestTime = request.getParameter("endTime");
			java.util.Date date = null;
			if(requestTime != null && requestTime != ""){
				try {
					SimpleDateFormat format =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
					Long time=new Long(requestTime);  
					String d = format.format(time);  
					date=format.parse(d); 
				} catch (ParseException e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
					System.out.println("时间转换错误");
				}
			}
			corder.setEndTime(date);
			
			System.out.println("准备添加的订单"+corder.toString());
			
			corderService.updateCorderByObject(corder);
			corderService.updateCorderByIsValid(corder.getOid(), 1);
			jsonCode.setStatusCode("200");
			jsonCode.setTagCode("修改订单成功");
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			jsonCode.setStatusCode("400");
			jsonCode.setTagCode("修改订单失败");
		}
		return JsonOperator.toJson(jsonCode);
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/queryCorderBy", method = RequestMethod.GET, produces = "text/json;charset=UTF-8")
	private String queryCorderBy(@RequestParam("type") String type, @RequestParam("trade") String trade,
			@RequestParam("title") String title,@RequestParam("offset") int offset) {
		List<Corder> corderList = corderService.queryCorderList(type, trade, title,offset);
		JsonCode<Corder> jsonCode = new JsonCode<Corder>();
		if (corderList.size() == 0) {
			jsonCode.setStatusCode("400");
			jsonCode.setTagCode("查询失败");
		} else {
			jsonCode.setStatusCode("200");
			jsonCode.setTagCode("查询成功");
			jsonCode.setData(corderList);
		}
		System.out.println(JsonOperator.toJson(jsonCode));
		// return "corder/corderListJsp";
		return JsonOperator.toJson(jsonCode);
	}

	@ResponseBody
	@RequestMapping(value = "/queryCorderById", method = RequestMethod.GET, produces = "text/json;charset=UTF-8")
	private String queryCorderById(@RequestParam("oid") int oid) {
		Corder corder = corderService.queryCorderById(oid);
		List<Corder> list = new ArrayList<Corder>();
		list.add(corder);
		String dataString = JsonOperator.toJson(corder);
		JsonCode<Corder> jsonCode = new JsonCode<Corder>();
		if ("".equals(dataString)) {
			jsonCode.setStatusCode("400");
			jsonCode.setTagCode("查询失败");
		} else {
			jsonCode.setStatusCode("200");
			jsonCode.setTagCode("查询成功");
			jsonCode.setData(list);
		}
		System.out.println(JsonOperator.toJson(jsonCode));
		// return "corder/corderListJsp";
		return JsonOperator.toJson(jsonCode);
	}

	@ResponseBody
	@RequestMapping(value = "/deleteCorderById", method = RequestMethod.GET, produces = "text/json;charset=UTF-8")
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
	@RequestMapping(value = "/queryCorderListById", method = RequestMethod.GET, produces = "text/json;charset=UTF-8")
	private String queryCorderListById(@RequestParam("uid") int uid,@RequestParam("type") String type) {
		List<Corder> corderList = corderService.queryCorderListById(uid,type);
		JsonCode<Corder> jsonCode = new JsonCode<Corder>();
		if (corderList.size() != 0) {
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
