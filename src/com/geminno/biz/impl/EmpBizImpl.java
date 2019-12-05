package com.geminno.biz.impl;

import java.util.List;

import com.ccy.spring.ClasspathXmlApplicationContext;
import com.geminno.biz.IEmpBiz;
import com.geminno.dao.IEmpDAO;
import com.geminno.dao.impl.EmpDAOImpl;
import com.geminno.pojo.Emp;
import com.geminno.pojo.EmpQuery;
import com.geminno.pojo.PageBean;

public class EmpBizImpl implements IEmpBiz{
	private IEmpDAO empDAO = (IEmpDAO) ClasspathXmlApplicationContext.newInstance().getBean("empDAO");
	@Override
	public List<Emp> getAllEmps() {
		// TODO Auto-generated method stub
		return empDAO.getAllEmps();
	}
	@Override
	public boolean addEmp(Emp emp) {
		// TODO Auto-generated method stub
		return empDAO.addEmp(emp);
	}
	@Override
	public Emp findEmpByEmpId(String empId) {
		// TODO Auto-generated method stub
		return empDAO.findEmpByEmpId(empId);
	}
	@Override
	public boolean modifyEmp(Emp emp) {
		// TODO Auto-generated method stub
		return empDAO.modifyEmp(emp);
	}
	@Override
	public boolean deleteEmp(String empId) {
		// TODO Auto-generated method stub
		return empDAO.deleteEmp(empId);
	}
	@Override
	public PageBean findData(PageBean pageBean) {
		// TODO Auto-generated method stub
		return empDAO.findData(pageBean);
	}
	@Override
	public PageBean findOptionData(PageBean pageBean, EmpQuery empQuery) {
		// TODO Auto-generated method stub
		return empDAO.findOptionData(pageBean, empQuery);
	}
	public IEmpDAO getEmpDAO() {
		return empDAO;
	}
	public void setEmpDAO(IEmpDAO empDAO) {
		this.empDAO = empDAO;
	}
	
}
