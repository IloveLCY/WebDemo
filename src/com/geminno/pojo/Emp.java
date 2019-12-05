package com.geminno.pojo;

import java.io.Serializable;
import java.util.Date;

public class Emp implements Serializable{
	/**
	 * @author shuo
	 */
	private static final long serialVersionUID = 1L;
	private String empId;
	private String empNo;
	private String empName;
	private Boolean sex;
	private Double salary;
	private Date birthday;
	private Dept dept;
	public Emp() {
		super();
	}
	
	public Emp(String empNo, String empName, Boolean sex,
			Double salary, Date birthday, Dept dept) {
		super();
		this.empNo = empNo;
		this.empName = empName;
		this.sex = sex;
		this.salary = salary;
		this.birthday = birthday;
		this.dept = dept;
	}

	public Emp(String empId,String empNo, String empName, Boolean sex,
			Double salary, Date birthday) {
		super();
		this.empId = empId;
		this.empNo = empNo;
		this.empName = empName;
		this.sex = sex;
		this.salary = salary;
		this.birthday = birthday;
	}
	public Emp(String empId,String empNo, String empName, Boolean sex,
			Double salary, Date birthday, Dept dept) {
		super();
		this.empId = empId;
		this.empNo = empNo;
		this.empName = empName;
		this.sex = sex;
		this.salary = salary;
		this.birthday = birthday;
		this.dept = dept;
	}
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	
	public String getEmpNo() {
		return empNo;
	}

	public void setEmpNo(String empNo) {
		this.empNo = empNo;
	}

	public Boolean getSex() {
		return sex;
	}
	public void setSex(Boolean sex) {
		this.sex = sex;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public Dept getDept() {
		return dept;
	}
	public void setDept(Dept dept) {
		this.dept = dept;
	}
	
}
