package com.shop.dto;

import java.sql.Timestamp;

public class MemberVO {
	private String id;
	private String pwd;
	private String name;
	private String email;
	private String address;
	private String zipNum;
	private String phone;
	private Timestamp indate;
	private String emailyn;
	
	public MemberVO(){}
	public MemberVO(String id, String pwd, String name, String email, String address, String zipNum, String phone,
			String emailyn){
		this(id, pwd, name, email, address, zipNum, phone, null, emailyn);
		
	}
	public MemberVO(String id, String pwd, String name, String email, String address, String zipNum, String phone,
			Timestamp indate, String emailyn) {
		super();
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.email = email;
		this.address = address;
		this.zipNum = zipNum;
		this.phone = phone;
		this.indate = indate;
		this.emailyn = emailyn;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getZipNum() {
		return zipNum;
	}
	public void setZipNum(String zipNum) {
		this.zipNum = zipNum;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Timestamp getIndate() {
		return indate;
	}
	public void setIndate(Timestamp indate) {
		this.indate = indate;
	}
	public String getEmailyn() {
		return emailyn;
	}
	public void setEmailyn(String emailyn) {
		this.emailyn = emailyn;
	}
	
	@Override
	public String toString() {
		return "MemberVO [id=" + id + ", pwd=" + pwd + ", name=" + name + ", email=" + email + ", address=" + address
				+ ", zipNum=" + zipNum + ", phone=" + phone + ", indate=" + indate + ", emailyn=" + emailyn + "]";
	}
	
}
