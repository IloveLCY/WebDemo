package com.geminno.pojo;

public class EmpQuery {
	private String empNo;
	private String empName;
	private String beginDate;
	private String endDate;
	
	public EmpQuery() {
		super();
	}
	public EmpQuery(String empNo, String empName, String beginDate,
			String endDate) {
		super();
		this.empNo = empNo;
		this.empName = empName;
		this.beginDate = beginDate;
		this.endDate = endDate;
	}
	public String getEmpNo() {
		return empNo;
	}
	public void setEmpNo(String empNo) {
		this.empNo = empNo;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getBeginDate() {
		return beginDate;
	}
	public void setBeginDate(String beginDate) {
		this.beginDate = beginDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	
}
