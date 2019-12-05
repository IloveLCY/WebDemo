package com.geminno.biz;

import java.util.List;

import com.geminno.pojo.Dept;

public interface IDeptBiz {
	/**
	 * 根据部门编号显示部门名
	 * @author shuo
	 */
	String findDeptNamebyDeptId(int deptId);
	/**
	 * 根据部门编号查找部门信息
	 * @author shuo
	 */
	Dept showDeptByDeptId(int deptId);
	/**
	 * 显示所有的部门信息
	 * @author shuo
	 */
	List<Dept> showAllDept();
}
