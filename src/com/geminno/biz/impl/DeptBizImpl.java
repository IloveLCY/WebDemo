package com.geminno.biz.impl;

import java.util.List;

import com.ccy.spring.ClasspathXmlApplicationContext;
import com.geminno.biz.IDeptBiz;
import com.geminno.dao.IDeptDAO;
import com.geminno.dao.impl.DeptDAOImpl;
import com.geminno.pojo.Dept;

public class DeptBizImpl implements IDeptBiz{
	private IDeptDAO deptDAO = (IDeptDAO) ClasspathXmlApplicationContext.newInstance().getBean("deptDAO");
	@Override
	public String findDeptNamebyDeptId(int deptId) {
		// TODO Auto-generated method stub
		return deptDAO.findDeptNamebyDeptId(deptId);
	}

	@Override
	public Dept showDeptByDeptId(int deptId) {
		// TODO Auto-generated method stub
		return deptDAO.showDeptByDeptId(deptId);
	}

	@Override
	public List<Dept> showAllDept() {
		// TODO Auto-generated method stub
		return deptDAO.showAllDept();
	}

	public IDeptDAO getDeptDAO() {
		return deptDAO;
	}

	public void setDeptDAO(IDeptDAO deptDAO) {
		this.deptDAO = deptDAO;
	}

}
