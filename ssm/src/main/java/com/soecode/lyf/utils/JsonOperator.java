package com.soecode.lyf.utils;

import java.util.List;

import com.alibaba.fastjson.JSON;

public class JsonOperator {

	public static String toJson(Object obj){
		
		return JSON.toJSONString(obj);
//		return "jsonString";
	}
	
	@SuppressWarnings("unchecked")
	public static <T> T toObject(String json, Class<?> clazz){
		return (T)JSON.parseObject(json, clazz);
	}
	
	public static <T> List<T> toObjects(String json, Class<T> clazz){
		return JSON.parseArray(json, clazz);
	}
}
