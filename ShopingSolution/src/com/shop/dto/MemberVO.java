package com.shop.dto;

import java.sql.Timestamp;

public class MemberVO {
	private int mNum;
	private String id;
	private String pwd;
	private String name;
	private String email;
	private String address;
	private String phone;
	private Timestamp indate;
	private Timestamp outdate;
	
	public MemberVO(){}
	public MemberVO(String id, String pwd, String name, String email, String address, String phone){
		this(0, id, pwd, name, email, address, phone, null, null);
	}
	public MemberVO(int mNum, String id, String pwd, String name, String email, String address, String phone,
			Timestamp indate, Timestamp outdate) {
		super();
		this.mNum = mNum;
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.email = email;
		this.address = address;
		this.phone = phone;
		this.indate = indate;
		this.outdate = outdate;
	}
	public int getmNum() {
		return mNum;
	}
	public void setmNum(int mNum) {
		this.mNum = mNum;
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
	public Timestamp getOutdate() {
		return outdate;
	}
	public void setOutdate(Timestamp outdate) {
		this.outdate = outdate;
	}
	
	@Override
	public String toString() {
		return "MemberVO [mNum=" + mNum + ", id=" + id + ", pwd=" + pwd + ", name=" + name + ", email=" + email
				+ ", address=" + address + ", phone=" + phone + ", indate=" + indate + ", outdate=" + outdate + "]";
	}
	
}
