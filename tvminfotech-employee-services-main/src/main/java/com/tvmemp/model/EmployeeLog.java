package com.tvmemp.model;

import java.time.LocalTime;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "empoyeelog")
public class EmployeeLog {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "loginid")
	private Integer id;

	@Temporal(TemporalType.DATE)
	@Column(name = "logindate", nullable = false)
	private Date logindate;

	@Temporal(TemporalType.TIME)
	@Column(name = "logintime", nullable = false)
	private LocalTime logintime;

	@PrePersist
	private void onCreate() {

		logindate = new Date();
		logintime = LocalTime.now();

	}
	@ManyToOne
	@JoinColumn(name = "employeeid")
	private TvmEmployee employee;

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Date getLogindate() {
		return logindate;
	}
	public void setLogindate(Date logindate) {
		this.logindate = logindate;
	}
	public LocalTime getLogintime() {
		return logintime;
	}
	public void setLogintime(LocalTime logintime) {
		this.logintime = logintime;
	}
	public TvmEmployee getEmployee() {
		return employee;
	}
	public void setEmployee(TvmEmployee employee) {
		this.employee = employee;
	}



}
