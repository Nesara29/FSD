package com.cpcjunit.junittest;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name="tab_store")
public class Store {
	@Id
	@GeneratedValue(strategy  = GenerationType.IDENTITY)
	private int sid;
	private String sname;
	private String saddress;
	public Store(String sname, String saddress) {
		this.sname = sname;
		this.saddress = saddress;
	}
	public Store() {
		// TODO Auto-generated constructor stub
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getSaddress() {
		return saddress;
	}
	public void setSaddress(String saddress) {
		this.saddress = saddress;
	}
	
}
