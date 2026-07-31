package com.withoutapi.demonstrationofwithoutapi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Cpc {

	@Id
	private int cid;
	private String cname;
	private String clocation;
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getClocation() {
		return clocation;
	}
	public void setClocation(String clocation) {
		this.clocation = clocation;
	}
	@Override
	public String toString() {
		return "Cpc [cid=" + cid + ", cname=" + cname + ", clocation=" + clocation + "]";
	}
	
	
}
