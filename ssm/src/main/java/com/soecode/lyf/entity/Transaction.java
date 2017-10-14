package com.soecode.lyf.entity;

import java.util.Date;

public class Transaction {

	private int tid;
	private int oid;
	private int uid;
	private Date tTime;
	private int releaseUid;
	
	
	public Transaction(){}
	
	
	
	/* （非 Javadoc）
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Transaction [tid=" + tid + ", oid=" + oid + ", uid=" + uid + ", tTime=" + tTime + ", releaseUid="
				+ releaseUid + "]";
	}



	/**
	 * @param tid
	 * @param oid
	 * @param uid
	 * @param tTime
	 * @param releaseUid
	 */
	public Transaction(int tid, int oid, int uid, Date tTime, int releaseUid) {
		super();
		this.tid = tid;
		this.oid = oid;
		this.uid = uid;
		this.tTime = tTime;
		this.releaseUid = releaseUid;
	}



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
	 * @return releaseUid
	 */
	public int getReleaseUid() {
		return releaseUid;
	}
	/**
	 * @param releaseUid 要设置的 releaseUid
	 */
	public void setReleaseUid(int releaseUid) {
		this.releaseUid = releaseUid;
	}
	
	
}
