package com.shop.dto;

public class MemberAddressVO {
	private String id;
	private String zipNum;
	private String address;
	
	public MemberAddressVO(){}
	public MemberAddressVO(String id, String zipNum, String address) {
		super();
		this.id = id;
		this.zipNum = zipNum;
		this.address = address;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getZipNum() {
		return zipNum;
	}
	public void setZipNum(String zipNum) {
		this.zipNum = zipNum;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	@Override
	public String toString() {
		return "MemberAddressVO [id=" + id + ", zipNum=" + zipNum + ", address=" + address + "]";
	}
	
}
