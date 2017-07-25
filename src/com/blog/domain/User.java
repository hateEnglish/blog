package com.blog.domain;

import java.sql.Timestamp;

public class User {
	//用户id
	private int id;
	
	//用户账号
	private String account;
	
	//用户名
	private String name;
	
	//用户密码
	private String passwd;
	
	//用户性别
	private String sex;
	
	//用户签名
	private String sign;
	
	//用户图片
	private String img;
	
	//用户注册时间
	private Timestamp time;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getSign() {
		return sign; 
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public Timestamp getTime() {
		return time;
	}

	public void setTime(Timestamp time) {
		this.time = time;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", account=" + account + ", name=" + name
				+ ", passwd=" + passwd + ", sex=" + sex + ", sign=" + sign
				+ ", img=" + img + ", time=" + time + "]";
	}
	
	
}
