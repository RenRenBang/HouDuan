package com.soecode.lyf.entity;

public class Collections {
	
		private int cid;//主键
		private Cuser cuser;//用户id
		private Corder corder;//订单id
		
		
		public int getCid() {
			return cid;
		}
		public void setCid(int cid) {
			this.cid = cid;
		}
		public Cuser getCuser() {
			return cuser;
		}
		public void setCuser(Cuser cuser) {
			this.cuser = cuser;
		}
		public Corder getCorder() {
			return corder;
		}
		public void setCorder(Corder corder) {
			this.corder = corder;
		}
		@Override
		public String toString() {
			return "Collections [cid=" + cid + ", cuser=" + cuser + ", corder=" + corder + "]";
		}
		
		public Collections() {}
		
}
