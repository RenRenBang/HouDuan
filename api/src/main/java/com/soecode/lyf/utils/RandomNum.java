package com.soecode.lyf.utils;

public class RandomNum {
	
	public String getRandomNum() {
		int num = (int)((Math.random()*9+1)*100000);
		String code = String.valueOf(num);
		return code;
	} 
	
	public static void main(String[] args) {
		System.out.println((int)((Math.random()*9+1)*100000));  
	}
}
