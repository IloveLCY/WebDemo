package com.geminno.dao;

import java.util.List;

import com.geminno.pojo.Emp;
import com.geminno.pojo.EmpQuery;
import com.geminno.pojo.PageBean;

public interface IEmpDAO {
	/**
	 * 添加员工
	 * @author shuo
	 */
	boolean addEmp(Emp emp);
	/**
	 * 获取所有员工信息
	 * @author shuo
	 */
	List<Emp> getAllEmps();
	/**
	 * 获取某个员工信息
	 * @author shuo
	 */
	Emp findEmpByEmpId(String empId);
	/**
	 * 修改员工信息
	 * @author shuo
	 */
	boolean modifyEmp(Emp emp);
	/**
	 * 删除某个员工
	 * @author shuo
	 */
	boolean deleteEmp(String empId);
	/**
	 * 获取分页数据
	 * @author shuo
	 */
	PageBean findData(PageBean pageBean);
	/**
	 * 获取查询分页数据
	 * @author shuo
	 */
	PageBean findOptionData(PageBean pageBean,EmpQuery empQuery);
}
