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
@Table(name = "emplogout")
public class EmployeeLogout {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "logid")
	private Integer id;

	@Temporal(TemporalType.TIME)
	@Column(name = "logouttime", nullable = false)
	private LocalTime logouttime;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "logoutdate", nullable = false)
	private Date logoutdate;

	@PrePersist
	private void onCreate() {

		logoutdate = new Date();
		logouttime=LocalTime.now();
		
		
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



	public LocalTime getLogouttime() {
		return logouttime;
	}

	public void setLogouttime(LocalTime logouttime) {
		this.logouttime = logouttime;
	}

	public Date getLogoutdate() {
		return logoutdate;
	}

	public void setLogoutdate(Date logoutdate) {
		this.logoutdate = logoutdate;
	}

	public TvmEmployee getEmployee() {
		return employee;
	}

	public void setEmployee(TvmEmployee employee) {
		this.employee = employee;
	}

}
