package com.tvmemp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class EmployeeTechnolgyDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer techid;
	private String techname;
	public Integer getTechid() {
		return techid;
	}
	public void setTechid(Integer techid) {
		this.techid = techid;
	}
	public String getTechname() {
		return techname;
	}
	public void setTechname(String techname) {
		this.techname = techname;
	}
}
