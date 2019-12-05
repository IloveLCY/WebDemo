package com.geminno.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.security.auth.callback.Callback;

import com.geminno.dao.DBHelper;
import com.geminno.dao.ICallback;
import com.geminno.dao.IDeptDAO;
import com.geminno.pojo.Dept;
import com.geminno.pojo.Emp;

public class DeptDAOImpl implements IDeptDAO{

	@Override
	public String findDeptNamebyDeptId(int deptId) {
		// TODO Auto-generated method stub
		String sql = "select * from dept where deptId ='"+deptId+"'";
		List<Dept> depts = DBHelper.executeQuery(sql, new ICallback() {
			List<Dept> depts = new ArrayList<Dept>();
			@Override
			public List execute(ResultSet rs) {
				// TODO Auto-generated method stub
				try {
					while(rs.next()){
						Integer deptId = rs.getInt("deptId");
						String deptName = rs.getString("deptName");
						depts.add(new Dept(deptId,deptName));
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return depts;
			}
		});
		
		return (depts.size()>0)?depts.get(0).getDeptName():"";
	}

	@Override
	public Dept showDeptByDeptId(int deptId) {
		// TODO Auto-generated method stub
		String sql = "select * from dept where deptId = ?";
		List<Dept> deptlist = DBHelper.executeQuery(sql, new ICallback() {
			List<Dept> deptlist = new ArrayList<Dept>();
			@Override
			public List execute(ResultSet rs) {
				// TODO Auto-generated method stub
				try {
					Dept dept = new Dept();
					if(rs.next()){
						dept.setDeptId(rs.getInt("deptId"));
						dept.setDeptName(rs.getString("deptName"));
						deptlist.add(dept);
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return deptlist;
			}
		}, deptId);
		
		return deptlist.size()>0?deptlist.get(0):null;
	}

	@Override
	public List<Dept> showAllDept() {
		// TODO Auto-generated method stub
		String sql = "select * from dept";
		ResultSet rs = null;
		List<Dept> deptlist = DBHelper.executeQuery(sql, new ICallback() {
			List<Dept> deptlist = new ArrayList<Dept>();
			@Override
			public List execute(ResultSet rs) {
				// TODO Auto-generated method stub
				try {
					while(rs.next()){
						Dept dept = new Dept();
						dept.setDeptId(rs.getInt("deptId"));
						dept.setDeptName(rs.getString("deptName"));
						deptlist.add(dept);
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return deptlist;
			}
		});
		
		return deptlist;
	}

}
