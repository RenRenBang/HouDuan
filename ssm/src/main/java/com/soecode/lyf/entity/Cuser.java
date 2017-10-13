package com.soecode.lyf.entity;

public class Cuser {
	/*id	uid
	phone	uphone
	真实姓名	name
	昵称	nickname
	身份证号码	id_number
	头像	image
	身份证照片	photo_path
	密码	password
	个人简介	profile*/

	private int uid;
	private String uphone;
	private String name;
	private String nickname;
	private String idNumber;
	private String image;
	private String photoPath;
	private String password;
	private String profile;
	@Override
	public String toString() {
		return "Cuser [uid=" + uid + ", uphone=" + uphone + ", name=" + name + ", nickname=" + nickname + ", id_number="
				+ idNumber + ", image=" + image + ", photo_path=" + photoPath + ", password=" + password
				+ ", profile=" + profile + "]";
	}
	public Cuser(String uphone, String name, String nickname, String idNumber, String image, String photoPath,
			String password, String profile) {
		super();
		this.uphone = uphone;
		this.name = name;
		this.nickname = nickname;
		this.idNumber = idNumber;
		this.image = image;
		this.photoPath = photoPath;
		this.password = password;
		this.profile = profile;
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
	public String getUphone() {
		return uphone;
	}
	public void setUphone(String uphone) {
		this.uphone = uphone;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
	
	/**
	 * @return idNumber
	 */
	public String getIdNumber() {
		return idNumber;
	}
	/**
	 * @param idNumber 要设置的 idNumber
	 */
	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}
	/**
	 * @return photoPath
	 */
	public String getPhotoPath() {
		return photoPath;
	}
	/**
	 * @param photoPath 要设置的 photoPath
	 */
	public void setPhotoPath(String photoPath) {
		this.photoPath = photoPath;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getProfile() {
		return profile;
	}
	public void setProfile(String profile) {
		this.profile = profile;
	}
	
	
}
