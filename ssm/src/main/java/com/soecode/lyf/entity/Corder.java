package com.soecode.lyf.entity;

import java.sql.Time;

public class Corder {

	private int oid;
	private String type;
	private String trade;
	private int uid;
	private Time startTime;
	private Time endTime;
	private String title;
	private Double money;
	private String describe;
	private String ophone;
	private String address;
	private int count;
	private int isValid;
	
	
	
	
	
	/**
	 * @param type
	 * @param trade
	 * @param uid
	 * @param title
	 * @param money
	 * @param ophone
	 * @param isValid
	 */
	public Corder(String type, String trade, int uid, String title, Double money, String ophone, int isValid) {
		super();
		this.type = type;
		this.trade = trade;
		this.uid = uid;
		this.title = title;
		this.money = money;
		this.ophone = ophone;
		this.isValid = isValid;
	}
	/**
	 * 
	 */
	public Corder() {
		//super();
		// TODO 自动生成的构造函数存根
	}
	/* （非 Javadoc）
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Corder [oid=" + oid + ", type=" + type + ", trade=" + trade + ", uid=" + uid + ", startTime="
				+ startTime + ", endTime=" + endTime + ", title=" + title + ", money=" + money + ", describe="
				+ describe + ", ophone=" + ophone + ", address=" + address + ", count=" + count + ", isValid=" + isValid
				+ "]";
	}
	/**
	 * @return oid
	 */
	public int getOid() {
		return oid;
	}
	/**
	 * @param oid 要设置的 oid
	 */
	public void setOid(int oid) {
		this.oid = oid;
	}
	/**
	 * @return type
	 */
	public String getType() {
		return type;
	}
	/**
	 * @param type 要设置的 type
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * @return trade
	 */
	public String getTrade() {
		return trade;
	}
	/**
	 * @param trade 要设置的 trade
	 */
	public void setTrade(String trade) {
		this.trade = trade;
	}
	/**
	 * @return uid
	 */
	public int getUid() {
		return uid;
	}
	/**
	 * @param uid 要设置的 uid
	 */
	public void setUid(int uid) {
		this.uid = uid;
	}
	/**
	 * @return startTime
	 */
	public Time getStartTime() {
		return startTime;
	}
	/**
	 * @param startTime 要设置的 startTime
	 */
	public void setStartTime(Time startTime) {
		this.startTime = startTime;
	}
	/**
	 * @return endTime
	 */
	public Time getEndTime() {
		return endTime;
	}
	/**
	 * @param endTime 要设置的 endTime
	 */
	public void setEndTime(Time endTime) {
		this.endTime = endTime;
	}
	/**
	 * @return title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param title 要设置的 title
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * @return money
	 */
	public Double getMoney() {
		return money;
	}
	/**
	 * @param money 要设置的 money
	 */
	public void setMoney(Double money) {
		this.money = money;
	}
	/**
	 * @return describe
	 */
	public String getDescribe() {
		return describe;
	}
	/**
	 * @param describe 要设置的 describe
	 */
	public void setDescribe(String describe) {
		this.describe = describe;
	}
	/**
	 * @return ophone
	 */
	public String getOphone() {
		return ophone;
	}
	/**
	 * @param ophone 要设置的 ophone
	 */
	public void setOphone(String ophone) {
		this.ophone = ophone;
	}
	/**
	 * @return address
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * @param address 要设置的 address
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * @return count
	 */
	public int getCount() {
		return count;
	}
	/**
	 * @param count 要设置的 count
	 */
	public void setCount(int count) {
		this.count = count;
	}
	/**
	 * @return isValid
	 */
	public int getIsValid() {
		return isValid;
	}
	/**
	 * @param isValid 要设置的 isValid
	 */
	public void setIsValid(int isValid) {
		this.isValid = isValid;
	}
	
	
	
}
