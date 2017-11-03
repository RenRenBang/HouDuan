package com.soecode.lyf.web;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.soecode.lyf.entity.Corder;
import com.soecode.lyf.entity.JsonCode;
import com.soecode.lyf.entity.Transaction;
import com.soecode.lyf.service.CorderService;
import com.soecode.lyf.service.CuserService;
import com.soecode.lyf.service.TransactionService;
import com.soecode.lyf.utils.CheckCode;
import com.soecode.lyf.utils.JsonOperator;

@Controller
public class TransactionController {

	@Autowired
	private TransactionService transactionService;
	@Autowired
	private CorderService corderService;
	@Autowired
	private CuserService cuserService;

	@ResponseBody
	@RequestMapping(value = "/addTransaction", method = RequestMethod.GET,produces = "text/json;charset=UTF-8")
	private String addTransaction(@Param("oid") int oid,@Param("uid") int uid) {
		JsonCode jsonCode = new JsonCode<>();
		try {
			Corder tempCorder = corderService.queryCorderById(oid);
			if(tempCorder.getOcount()>0){
				//判断是否在接自己的订单。
				if (tempCorder.getCuser().getUid() == uid){
					jsonCode.setStatusCode("400");
					jsonCode.setTagCode("不能添加自己发布的订单");
					return JsonOperator.toJson(jsonCode);
				}
				
				//判断是否在重复接单
				if(false){
					//有必要添加吗？对于服务订单，可以多吃添加的。例如一个商品可以多次购买的。
					//通过uid和oid在transaction中进行查询，如果能查到数据则说明已经接单，不能重复接单。
				}
				
				transactionService.addTransaction(oid,uid);
				corderService.updateNum("gm_num", oid);
				corderService.cutCount(oid);
				//偷懒了，没有再次查询数据库中更新的记录，而是判断了没有 -1 以前的数据，和1进行了比较
				if(tempCorder.getOcount() == 1){
					tempCorder.setIsValid(0);
					System.out.println("订单count不足，修改订单失效");
					//更新订单的dao没有写？？？
					corderService.updateCorderByIsValid(oid, 0);
					//end_time的时间到期了订单is_valid修改为0;标记为失效
				}
				
				//这些业务上的处理，应该都放在service层，返回jsonCode对象，不应该在这里进行处理，懒的修改了。
				//用户订单被接单以后发短信通知发单用户，功能已通过测试，测试期间暂时关闭发送短信通知。
				/*String corderPhone = corderService.queryCorderById(oid).getCuser().getUphone();
				CheckCode checkCode = new CheckCode();
				checkCode.f1(corderPhone, cuserService.findByid(uid).getUphone());*/
				System.out.println("短信通知成功。");
				jsonCode.setStatusCode("200");
				jsonCode.setTagCode("交易添加OK,短信通知成功");				
			} else {
				jsonCode.setStatusCode("400");
				jsonCode.setTagCode("交易添加失败人数少于1");
			}
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			jsonCode.setStatusCode("400");
			jsonCode.setTagCode("交易添加失败");
		}
		return JsonOperator.toJson(jsonCode);
	}
	
	@ResponseBody
	@RequestMapping(value = "/queryTransactionById", method = RequestMethod.GET,produces = "text/json;charset=UTF-8")
	private String queryTransactionById(@RequestParam("uid") int uid,@RequestParam("type") String type) {
		List<Transaction> transactionList = transactionService.queryTransactionById(uid,type);
		JsonCode<Transaction> jsonCode = new JsonCode<Transaction>();
		if(transactionList.size() == 0){
			jsonCode.setStatusCode("400");
			jsonCode.setTagCode("查询失败");
		} else {
			jsonCode.setStatusCode("200");
			jsonCode.setTagCode("查询成功");
			jsonCode.setData(transactionList);
		}
		System.out.println(JsonOperator.toJson(jsonCode));
		//return "corder/corderListJsp";
		return JsonOperator.toJson(jsonCode);
	}
}
