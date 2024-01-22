package com.tvmemp.model;

import java.util.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "empassest")
public class Employee_Assest {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "assestid")
	private int assestid;

	private String assetmodule;
	private Long phonenum;
	private Date issuedate;
	private Date returndate;

	@Enumerated(EnumType.STRING)
	private AssetType assettypes;

	public Employee_Assest() {

	}
	
	@Enumerated(EnumType.STRING)
	private EmployeeDescription employeedescription;

	public int getAssestid() {
		return assestid;
	}

	public void setAssestid(int assestid) {
		this.assestid = assestid;
	}

	public String getAssetmodule() {
		return assetmodule;
	}

	public void setAssetmodule(String assetmodule) {
		this.assetmodule = assetmodule;
	}

	public Long getPhonenum() {
		return phonenum;
	}

	public void setPhonenum(Long phonenum) {
		this.phonenum = phonenum;
	}

	public Date getIssuedate() {
		return issuedate;
	}

	public void setIssuedate(Date issuedate) {
		this.issuedate = issuedate;
	}

	public Date getReturndate() {
		return returndate;
	}

	public void setReturndate(Date returndate) {
		this.returndate = returndate;
	}

	public AssetType getAssettypes() {
		return assettypes;
	}

	public void setAssettypes(AssetType assettypes) {
		this.assettypes = assettypes;
	}

	public EmployeeDescription getEmployeedescription() {
		return employeedescription;
	}

	public void setEmployeedescription(EmployeeDescription employeedescription) {
		this.employeedescription = employeedescription;
	}

}
