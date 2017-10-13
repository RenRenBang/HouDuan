package com.soecode.lyf.entity;

import java.util.Date;

public class Corder {

	private int oid;
	private String type;
	private String trade;
	private int uid;
	private Date startTime;
	private Date endTime;
	private String title;
	private double money;
	private String odescribe;
	private String ophotoPath;
	private String address;
	private int ocount;
	private int isValid;
	
	public Corder(){}
	
	
	
	/* （非 Javadoc）
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Corder [oid=" + oid + ", type=" + type + ", trade=" + trade + ", uid=" + uid + ", startTime="
				+ startTime + ", endTime=" + endTime + ", title=" + title + ", money=" + money + ", odescribe="
				+ odescribe + ", ophotoPath=" + ophotoPath + ", address=" + address + ", ocount=" + ocount
				+ ", isValid=" + isValid + "]";
	}



	/**
	 * @param oid
	 * @param type
	 * @param trade
	 * @param uid
	 * @param startTime
	 * @param endTime
	 * @param title
	 * @param money
	 * @param odescribe
	 * @param ophotoPath
	 * @param address
	 * @param ocount
	 * @param isValid
	 */
	public Corder(int oid, String type, String trade, int uid, Date startTime, Date endTime, String title, double money,
			String odescribe, String ophotoPath, String address, int ocount, int isValid) {
		super();
		this.oid = oid;
		this.type = type;
		this.trade = trade;
		this.uid = uid;
		this.startTime = startTime;
		this.endTime = endTime;
		this.title = title;
		this.money = money;
		this.odescribe = odescribe;
		this.ophotoPath = ophotoPath;
		this.address = address;
		this.ocount = ocount;
		this.isValid = isValid;
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
	public Date getStartTime() {
		return startTime;
	}
	/**
	 * @param startTime 要设置的 startTime
	 */
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	/**
	 * @return endTime
	 */
	public Date getEndTime() {
		return endTime;
	}
	/**
	 * @param endTime 要设置的 endTime
	 */
	public void setEndTime(Date endTime) {
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
	public double getMoney() {
		return money;
	}
	/**
	 * @param money 要设置的 money
	 */
	public void setMoney(double money) {
		this.money = money;
	}
	/**
	 * @return odescribe
	 */
	public String getOdescribe() {
		return odescribe;
	}
	/**
	 * @param odescribe 要设置的 odescribe
	 */
	public void setOdescribe(String odescribe) {
		this.odescribe = odescribe;
	}
	/**
	 * @return ophotoPath
	 */
	public String getOphotoPath() {
		return ophotoPath;
	}
	/**
	 * @param ophotoPath 要设置的 ophotoPath
	 */
	public void setOphotoPath(String ophotoPath) {
		this.ophotoPath = ophotoPath;
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
	 * @return ocount
	 */
	public int getOcount() {
		return ocount;
	}
	/**
	 * @param ocount 要设置的 ocount
	 */
	public void setOcount(int ocount) {
		this.ocount = ocount;
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
