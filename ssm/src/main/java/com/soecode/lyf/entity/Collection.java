package com.soecode.lyf.entity;

public class Collection {
	
		private int cid;//主键
		private int uid;//用户id
		private int oid;//订单id
		
		
		public int getCid() {
			return cid;
		}
		public void setCid(int cid) {
			this.cid = cid;
		}
		public int getUid() {
			return uid;
		}
		public void setUid(int uid) {
			this.uid = uid;
		}
		public int getOid() {
			return oid;
		}
		public void setOid(int oid) {
			this.oid = oid;
		}
		@Override
		public String toString() {
			return "Collection [cid=" + cid + ", uid=" + uid + ", oid=" + oid + "]";
		}
		public Collection(int cid, int uid, int oid) {
			super();
			this.cid = cid;
			this.uid = uid;
			this.oid = oid;
		}
		public Collection() {
			super();
			// TODO Auto-generated constructor stub
		}

}
