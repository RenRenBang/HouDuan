package com.soecode.lyf.web;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.soecode.lyf.entity.JsonCode;
import com.soecode.lyf.entity.Transaction;
import com.soecode.lyf.service.CorderService;
import com.soecode.lyf.service.TransactionService;
import com.soecode.lyf.utils.JsonOperator;

@Controller
public class TransactionController {

	@Autowired
	private TransactionService transactionService;
	@Autowired
	private CorderService corderService;

	@ResponseBody
	@RequestMapping(value = "/addTransaction", method = RequestMethod.GET,produces = "text/json;charset=UTF-8")
	private String addTransaction(@Param("oid") int oid,@Param("uid") int uid) {
		JsonCode jsonCode = new JsonCode<>();
		try {
			transactionService.addTransaction(oid,uid);
			corderService.updateNum("gm_num", oid);
			jsonCode.setStatusCode("200");
			jsonCode.setTagCode("交易添加成功");
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
	private String queryTransactionById(@RequestParam("uid") int uid) {
		List<Transaction> transactionList = transactionService.queryTransactionById(uid);
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
