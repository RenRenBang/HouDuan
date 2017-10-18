package com.soecode.lyf.entity;

import java.util.Date;

public class Transaction {

	private int tid;
	private Corder corder;
	private Cuser cuser;
	private Date tTime;
	
	
	public Transaction(){}


	/**
	 * @return tid
	 */
	public int getTid() {
		return tid;
	}


	/**
	 * @param tid 要设置的 tid
	 */
	public void setTid(int tid) {
		this.tid = tid;
	}


	/**
	 * @return corder
	 */
	public Corder getCorder() {
		return corder;
	}


	/**
	 * @param corder 要设置的 corder
	 */
	public void setCorder(Corder corder) {
		this.corder = corder;
	}


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
	 * @return tTime
	 */
	public Date gettTime() {
		return tTime;
	}


	/**
	 * @param tTime 要设置的 tTime
	 */
	public void settTime(Date tTime) {
		this.tTime = tTime;
	}


	/**
	 * @return releaseCuser
	 */
	


	/**
	 * @param tid
	 * @param corder
	 * @param cuser
	 * @param tTime
	 * @param releaseCuser
	 */
	public Transaction(int tid, Corder corder, Cuser cuser, Date tTime) {
		super();
		this.tid = tid;
		this.corder = corder;
		this.cuser = cuser;
		this.tTime = tTime;
		
	}


	/* （非 Javadoc）
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Transaction [tid=" + tid + ", corder=" + corder + ", cuser=" + cuser + ", tTime=" + tTime
				+ "]";
	}
	
	
	
}
