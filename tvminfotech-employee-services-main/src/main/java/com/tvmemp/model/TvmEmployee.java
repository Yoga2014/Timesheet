package com.tvmemp.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tvmemployee")
public class TvmEmployee {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "employeeid")
	private Integer employeeId;
	@Column(name = "employeefirstname")
	private String employeeFirstname;
	@Column(name = "employeelastname")
	private String employeeLastname;
	@Column(name = "employeeesalary")
	private Long employeeeSalary;
	@Column(name = "employeephone")
	private String employeePhone;
	@Column(name = "employeeemail")
	private String employeeEmail;

	@OneToMany(targetEntity = EmployeeEducation.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "employeeid")
	List<EmployeeEducation> employeeEducation;

	@OneToMany(targetEntity = EmployeeAddress.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "employeeid")
	List<EmployeeAddress> employeeAddress;
	
	@OneToOne(targetEntity = Employee_Assest.class, cascade = CascadeType.ALL)
	@JoinColumn(name="assestid")
	private Employee_Assest assest;
	
	@OneToMany(targetEntity = EmployeeProjectDetails.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "employeeid")
	private List<EmployeeProjectDetails> employeeprojectdetails;

	@OneToMany(targetEntity = EmployeeTechnolgyDetails.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "employeeid")
	private List<EmployeeTechnolgyDetails> employeetechnologydetails;
	
	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeFirstname() {
		return employeeFirstname;
	}

	public void setEmployeeFirstname(String employeeFirstname) {
		this.employeeFirstname = employeeFirstname;
	}

	public String getEmployeeLastname() {
		return employeeLastname;
	}

	public void setEmployeeLastname(String employeeLastname) {
		this.employeeLastname = employeeLastname;
	}

	public Long getEmployeeeSalary() {
		return employeeeSalary;
	}

	public void setEmployeeeSalary(Long employeeeSalary) {
		this.employeeeSalary = employeeeSalary;
	}

	public String getEmployeePhone() {
		return employeePhone;
	}

	public void setEmployeePhone(String employeePhone) {
		this.employeePhone = employeePhone;
	}

	public String getEmployeeEmail() {
		return employeeEmail;
	}

	public void setEmployeeEmail(String employeeEmail) {
		this.employeeEmail = employeeEmail;
	}

	public List<EmployeeEducation> getEmployeeEducation() {
		return employeeEducation;
	}

	public void setEmployeeEducation(List<EmployeeEducation> employeeEducation) {
		this.employeeEducation = employeeEducation;
	}

	public List<EmployeeAddress> getEmployeeAddress() {
		return employeeAddress;
	}

	public void setEmployeeAddress(List<EmployeeAddress> employeeAddress) {
		this.employeeAddress = employeeAddress;
	}

	public Employee_Assest getAssest() {
		return assest;
	}

	public void setAssest(Employee_Assest assest) {
		this.assest = assest;
	}

	public List<EmployeeProjectDetails> getEmployeeprojectdetails() {
		return employeeprojectdetails;
	}

	public void setEmployeeprojectdetails(List<EmployeeProjectDetails> employeeprojectdetails) {
		this.employeeprojectdetails = employeeprojectdetails;
	}

	public List<EmployeeTechnolgyDetails> getEmployeetechnologydetails() {
		return employeetechnologydetails;
	}

	public void setEmployeetechnologydetails(List<EmployeeTechnolgyDetails> employeetechnologydetails) {
		this.employeetechnologydetails = employeetechnologydetails;
	}

	
}
