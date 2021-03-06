package com.soecode.lyf.utils;

import com.montnets.mwgate.common.GlobalParams;
import com.montnets.mwgate.common.Message;
import com.montnets.mwgate.smsutil.ConfigManager;
import com.montnets.mwgate.smsutil.SmsSendConn;

public class CheckCode {
	/**
	 * 发送短信验证码的工具类，使用第三方的服务，<梦网云>
	 * @description 设置用户账号信息
	 */
	// 设置用户账号信息
	public void setAccountInfo() {
		// 设置用户账号信息

		// 用户账号
		String userid = "E10105";
		// 密码
		String password = "xX3IrJ";
		// 发送优先级
		int priority = 1;
		// 主IP信息
		String ipAddress1 = "api01.monyun.cn:7901";

		// 备用IP1信息
		String ipAddress2 = "api02.monyun.cn:7901";
		// 备用IP2信息
		String ipAddress3 = null;
		// 备用IP3信息
		String ipAddress4 = null;
		// 返回值
		int result = -310007;
		try {
			// 设置用户账号信息
			result = ConfigManager.setAccountInfo(userid, password, priority,
					ipAddress1, ipAddress2, ipAddress3, ipAddress4);
			// 判断返回结果，0设置成功，否则失败
			if (result == 0) {
				System.out.println("设置用户账号信息成功！");
			} else {
				System.out.println("设置用户账号信息失败，错误码：" + result);
			}
		} catch (Exception e) {
			// 异常处理
			e.printStackTrace();
		}
	}
	/**
	 * 
	 * @description 单条发送
	 * @param smsSendConn
	 *            短信处理对象,在这个方法中调用发送短信功能
	 * @param userid
	 *            用户账号
	 */
	public static void singleSend(SmsSendConn smsSendConn, String userid,String uphone,String code) {
		try {
			// 参数类
			Message message = new Message();
			// 设置用户账号 指定用户账号发送，需要填写用户账号，不指定用户账号发送，无需填写用户账号
			message.setUserid(userid);
			// 设置手机号码 此处只能设置一个手机号码
			message.setMobile(uphone);
			// 设置内容
//			【人人帮】您的验证码是123456，在5分钟内有效。如非本人操作请忽略本短信。Young科技。
//				尊敬的【人人帮】用户，您的订单已被手机号为{w6-11}的用户接单，请尽快联系该用户！Young科技
			if(code.length() < 7 ){
				message.setContent("【人人帮】您的验证码是"+code+"，在5分钟内有效。如非本人操作请忽略本短信。Young科技。");
			} else {
				message.setContent("尊敬的【人人帮】用户，您的订单已被手机号为"+code+"的用户接单，请尽快联系该用户！Young科技");
			}
			// 设置扩展号
			message.setExno("11");
			// 用户自定义流水编号
			message.setCustid("20160929194950100002");
			// 自定义扩展数据
			message.setExdata("abcdef");
			// 业务类型
			message.setSvrtype("SMS001");
			//短信编号
			//message.setPackid((long)57737);

			// 返回的流水号
			StringBuffer returnValue = new StringBuffer();
			// 返回值
			int result = -310099;
			// 发送短信
			result = smsSendConn.singleSend(message, returnValue);
			// result为0:成功
			if (result == 0) {
				System.out.println("单条发送提交成功！");
				System.out.println(returnValue.toString());
			}
			// result为非0：失败
			else {
				System.out.println("单条发送提交失败,错误码：" + result);
			}
		} catch (Exception e) {
			// 异常处理
			e.printStackTrace();
		}
	}
	public void f1(String uphone,String code) {
				// 用户账号
				String userid = "E10105";
					
				// 创建全局参数
				GlobalParams globalParams = new GlobalParams();
				// 设置请求路径
				globalParams.setRequestPath("/sms/v2/std/");
				// 设置是否需要日志 1:需要日志;0:不需要日志
				globalParams.setNeedLog(1);
				// 设置全局参数
				ConfigManager.setGlobalParams(globalParams);

				// 设置用户账号信息
				this.setAccountInfo();

				// 是否保持长连接
				boolean isKeepAlive = true;
				// 实例化短信处理对象
				SmsSendConn smsSendConn = new SmsSendConn(isKeepAlive);

				// 单条发送
				CheckCode.singleSend(smsSendConn, userid,uphone,code);
	}
}
