package com.tvmemp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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

	@Column(name = "laptop")
	private String laptop;

	@Column(name = "headphone")
	private String headphone;

	@Column(name = "charger")
	private String charger;

	public int getId() {
		return assestid;
	}

	public void setId(int id) {
		this.assestid = id;
	}

	public String getLaptop() {
		return laptop;
	}

	public void setLaptop(String laptop) {
		this.laptop = laptop;
	}

	public String getHeadphone() {
		return headphone;
	}

	public void setHeadphone(String headphone) {
		this.headphone = headphone;
	}

	public String getCharger() {
		return charger;
	}

	public void setCharger(String charger) {
		this.charger = charger;
	}

}
