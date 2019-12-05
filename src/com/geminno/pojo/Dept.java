package com.geminno.pojo;

public class Dept {
	private Integer deptId;
	private String  deptName;
	
	public Dept() {
		super();
	}
	
	public Dept(Integer deptId) {
		super();
		this.deptId = deptId;
	}

	public Dept(Integer deptId, String deptName) {
		super();
		this.deptId = deptId;
		this.deptName = deptName;
	}
	public Integer getDeptId() {
		return deptId;
	}
	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String toString() {
		return "Dept [deptId=" + deptId + ", deptName=" + deptName + "]";
	}
	
}
