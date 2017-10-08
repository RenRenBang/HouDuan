package com.soecode.lyf.entity;

import com.mysql.jdbc.Blob;

public class Cuser {
	
	private int uid;
	private String uname;
	private String upassword;
	private String uphone;
	private String unickname;
	private String uidnumber;
	private Blob uimage;
	private Blob uphotopath;
	public Cuser(int uid, String uname, String upassword, String uphone, String unickname, String uidnumber,
			Blob uimage, Blob uphotopath) {
		super();
		this.uid = uid;
		this.uname = uname;
		this.upassword = upassword;
		this.uphone = uphone;
		this.unickname = unickname;
		this.uidnumber = uidnumber;
		this.uimage = uimage;
		this.uphotopath = uphotopath;
	}
	public Cuser() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUpassword() {
		return upassword;
	}
	public void setUpassword(String upassword) {
		this.upassword = upassword;
	}
	public String getUphone() {
		return uphone;
	}
	public void setUphone(String uphone) {
		this.uphone = uphone;
	}
	public String getUnickname() {
		return unickname;
	}
	public void setUnickname(String unickname) {
		this.unickname = unickname;
	}
	public String getUidnumber() {
		return uidnumber;
	}
	public void setUidnumber(String uidnumber) {
		this.uidnumber = uidnumber;
	}
	public Blob getUimage() {
		return uimage;
	}
	public void setUimage(Blob uimage) {
		this.uimage = uimage;
	}
	public Blob getUphotopath() {
		return uphotopath;
	}
	public void setUphotopath(Blob uphotopath) {
		this.uphotopath = uphotopath;
	}
	@Override
	public String toString() {
		return "Cuser [uid=" + uid + ", uname=" + uname + ", upassword=" + upassword + ", uphone=" + uphone
				+ ", unickname=" + unickname + ", uidnumber=" + uidnumber + ", uimage=" + uimage + ", uphotopath="
				+ uphotopath + "]";
	}
	
	
}
