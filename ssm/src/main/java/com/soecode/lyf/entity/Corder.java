package com.soecode.lyf.entity;

import java.util.Date;

public class Corder {

	private int oid;
	private String type;
	private String trade;
	private Date startTime;
	private Date endTime;
	private String title;
	private double money;
	private String odescribe;
	private String ophotoPath;
	private String address;
	private int ocount;
	private int isValid;
	private int gmNum;
	private int collNum;
	
//	private int uid;
	
	private Cuser cuser;
	
	public Corder(){}
	
	

	/**
	 * @return cuser
	 */
	public Cuser getCuser() {
		return cuser;
	}



	/**
	 * @param cuser 要设置的 cuser
	 */
	public void setCuser(Cuser cuser) {
		this.cuser = cuser;
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



	/* （非 Javadoc）
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Corder [oid=" + oid + ", type=" + type + ", trade=" + trade + ", startTime=" + startTime + ", endTime="
				+ endTime + ", title=" + title + ", money=" + money + ", odescribe=" + odescribe + ", ophotoPath="
				+ ophotoPath + ", address=" + address + ", ocount=" + ocount + ", isValid=" + isValid + ", gmNum="
				+ gmNum + ", collNum=" + collNum + ", cuser=" + cuser + "]";
	}

	


	
}
