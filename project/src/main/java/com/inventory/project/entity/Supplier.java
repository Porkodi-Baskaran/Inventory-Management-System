package com.inventory.project.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Supplier {
	@Id
	private Integer s_id;
	private String s_name;
	private long phone;
	private String s_address;
	private long bill_no;
	private Date bill_date;
	public Integer getS_id() {
		return s_id;
	}
	public void setS_id(Integer s_id) {
		this.s_id = s_id;
	}
	public String getS_name() {
		return s_name;
	}
	public void setS_name(String s_name) {
		this.s_name = s_name;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public String getS_address() {
		return s_address;
	}
	public void setS_address(String s_address) {
		this.s_address = s_address;
	}
	public long getBill_no() {
		return bill_no;
	}
	public void setBill_no(long bill_no) {
		this.bill_no = bill_no;
	}
	public Date getBill_date() {
		return bill_date;
	}
	public void setBill_date(Date bill_date) {
		this.bill_date = bill_date;
	}
	
	public Supplier() {}
	
	public Supplier(Integer s_id, String s_name, long phone, String s_address, long bill_no, Date bill_date) {
		super();
		this.s_id = s_id;
		this.s_name = s_name;
		this.phone = phone;
		this.s_address = s_address;
		this.bill_no = bill_no;
		this.bill_date = bill_date;
	}
	@Override
	public String toString() {
		return "Supplier [s_id=" + s_id + ", s_name=" + s_name + ", phone=" + phone + ", s_address=" + s_address
				+ ", bill_no=" + bill_no + ", bill_date=" + bill_date + "]";
	}
	
	
}
