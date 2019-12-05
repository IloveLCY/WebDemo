package com.geminno.action;


import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.ccy.spring.ClasspathXmlApplicationContext;
import com.geminno.biz.IDeptBiz;
import com.geminno.biz.IEmpBiz;
import com.geminno.pojo.Dept;
import com.geminno.pojo.Emp;
import com.geminno.pojo.EmpQuery;
import com.geminno.pojo.PageBean;
import com.opensymphony.xwork2.ActionContext;

public class EmpAction{
	private IEmpBiz empBiz = (IEmpBiz) ClasspathXmlApplicationContext.newInstance().getBean("empBiz");
	private IDeptBiz deptBiz = (IDeptBiz) ClasspathXmlApplicationContext.newInstance().getBean("deptBiz");
	private String empId;
	private String empNo;
	private String empName;
	private Boolean sex;
	private Double salary;
	private Date birthday;
	private String curPage;
	private String beginDate;
	private String endDate;
	private String addEmpToken;
	public String tomain(){
		PageBean pageBean = new PageBean();
		pageBean.setPageSize(2);
		ActionContext context = ActionContext.getContext();
		
		if(curPage!=null){
			pageBean.setCurPage(Integer.parseInt(curPage));
		}
		EmpQuery empQuery = new EmpQuery(empNo, empName, beginDate, endDate);
		pageBean = empBiz.findOptionData(pageBean, empQuery);
		context.getContextMap().put("pageBean", pageBean);
		context.getContextMap().put("empQuery", empQuery);
		//request.setAttribute("pageBean", pageBean);
		//request.setAttribute("empQuery", empQuery);
		//return "/main.jsp";
		return "tomain";
	}
	public String addemp(){
		HttpServletRequest request = ServletActionContext.getRequest();
		if(addEmpToken.equals(request.getSession().getAttribute("addEmpToken"))){
			Integer deptId = Integer.parseInt(request.getParameter("deptId"));
			Boolean addFlag = empBiz.addEmp(new Emp(UUID.randomUUID().toString(),empNo,empName,sex,salary,birthday,deptBiz.showDeptByDeptId(deptId)));
			request.setAttribute("addFlag", addFlag);
		}
		
		request.getSession().removeAttribute("addEmpToken");
		return "addemp";
	}
	public String modifyemp(){
		HttpServletRequest request = ServletActionContext.getRequest();
		Integer deptId = Integer.parseInt(request.getParameter("deptId"));
		Boolean modifyFlag = empBiz.modifyEmp(new Emp(empId,empNo,empName,sex,salary,birthday,deptBiz.showDeptByDeptId(deptId)));
		request.setAttribute("modifyFlag", modifyFlag);
		return "modifyemp";
	}
	public String toaddemp(){
		HttpServletRequest request = ServletActionContext.getRequest();
		List<Dept> deptList = deptBiz.showAllDept();
		String addEmpToken = UUID.randomUUID()+"";
		request.getSession().setAttribute("addEmpToken", addEmpToken);
		request.setAttribute("addEmpToken", addEmpToken);
		request.setAttribute("deptList", deptList);
		return "toaddemp";
	}
	public String todeleteemp(){
		HttpServletRequest request = ServletActionContext.getRequest();
		Boolean deleteFlag = empBiz.deleteEmp(empId);
		request.setAttribute("deleteFlag", deleteFlag);
		return "todeleteemp";
	}
	public String tomodifyemp(){
		HttpServletRequest request = ServletActionContext.getRequest();
		Emp emp = empBiz.findEmpByEmpId(empId);
		List<Dept> deptList = deptBiz.showAllDept();
		request.setAttribute("deptList", deptList);
		request.setAttribute("emp", emp);
		return "tomodifyemp";
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
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public Boolean getSex() {
		return sex;
	}
	public void setSex(Boolean sex) {
		this.sex = sex;
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
	public String getCurPage() {
		return curPage;
	}
	public void setCurPage(String curPage) {
		this.curPage = curPage;
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
	public String getAddEmpToken() {
		return addEmpToken;
	}
	public void setAddEmpToken(String addEmpToken) {
		this.addEmpToken = addEmpToken;
	}
	
}
