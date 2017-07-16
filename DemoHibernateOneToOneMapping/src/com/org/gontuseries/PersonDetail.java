package com.org.gontuseries;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class PersonDetail
{
	@Id
	@GeneratedValue
	@Column(name="PDETAIL_PK")
	private int pDetailId;
	
	private String zipCode;
	private String job;
	private String income;
	
	public int getpDetailId() {
		return pDetailId;
	}
	public void setpDetailId(int pDetailId) {
		this.pDetailId = pDetailId;
	}
	public String getIncome() {
		return income;
	}
	public void setIncome(String income) {
		this.income = income;
	}
	
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	
	
	
}
