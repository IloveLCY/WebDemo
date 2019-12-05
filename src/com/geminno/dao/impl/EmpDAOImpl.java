package com.geminno.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.ccy.spring.ClasspathXmlApplicationContext;
import com.geminno.dao.DBHelper;
import com.geminno.dao.ICallback;
import com.geminno.dao.IDeptDAO;
import com.geminno.dao.IEmpDAO;
import com.geminno.dao.JDBCUtil;
import com.geminno.pojo.Dept;
import com.geminno.pojo.Emp;
import com.geminno.pojo.EmpQuery;
import com.geminno.pojo.PageBean;

public class EmpDAOImpl implements IEmpDAO{
	
	public boolean addEmp(Emp emp) {
		// TODO Auto-generated method stub
		//String sql = "insert into emp values ('"+emp.getEmpId()+"','"+emp.getEmpName()+"', "+(emp.getSex()?1:0)+","+emp.getAge()+", "+emp.getSalary()+", '"+DateUtil.dateToString(emp.getBirthday())+"', "+emp.getDept().getDeptId()+")";
//		int lines = DBHelper.executeUpdate(sql);
//		
//		return lines>0?true:false;
		String sql  = "insert into emp values (UUID(),?,?,?,?,?,?)";
		int lines = DBHelper.executeUpdate(
											sql, 
											emp.getEmpNo(),
											emp.getEmpName(),
											emp.getSex()?1:0,
											emp.getSalary(),
											emp.getBirthday(),
											emp.getDept().getDeptId());
		return lines>0;
	}

	@Override
	public List<Emp> getAllEmps() {
		// TODO Auto-generated method stub
		String sql = "select * from emp";
		List<Emp> empList = DBHelper.executeQuery(sql, new ICallback() {
			List<Emp> lists = new ArrayList<Emp>();
			@Override
			public List execute(ResultSet rs) {
				// TODO Auto-generated method stub
				try {
					Dept dept = null;
					while (rs.next()){
						String empId = rs.getString("empId");
						String empNo = rs.getString("empNo");
						String empName = rs.getString("empName");
						Boolean empSex = rs.getBoolean("sex");
						Double salary = rs.getDouble("salary");
						Date birthday = rs.getDate("birthday");
						Integer deptId = rs.getInt("deptId");
						dept = ((IDeptDAO)ClasspathXmlApplicationContext.newInstance().getBean("deptDAO")).showDeptByDeptId(deptId);
						lists.add(new Emp(empId,empNo,empName,empSex,salary,birthday,dept));
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return lists;
			}
		});
		return empList;
	}

	@Override
	public Emp findEmpByEmpId(String empId) {
		// TODO Auto-generated method stub
		String sql = "select * from emp where empId=?";
		List<Emp> empList = DBHelper.executeQuery(sql, new ICallback() {
			List<Emp> lists = new ArrayList<Emp>();
			@Override
			public List execute(ResultSet rs) {
				// TODO Auto-generated method stub
				try {
					Dept dept = null;
					while (rs.next()){
						String empId = rs.getString("empId");
						String empNo = rs.getString("empNo");
						String empName = rs.getString("empName");
						Boolean empSex = rs.getBoolean("sex");
						Double salary = rs.getDouble("salary");
						Date birthday = rs.getDate("birthday");
						Integer deptId = rs.getInt("deptId");
						//dept = new DeptDAOImpl().showDeptByDeptId(deptId);
						dept = ((IDeptDAO)ClasspathXmlApplicationContext.newInstance().getBean("deptDAO")).showDeptByDeptId(deptId);
						lists.add(new Emp(empId,empNo,empName,empSex,salary,birthday,dept));
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return lists;
			}
		},empId);
		return empList.size()>0?empList.get(0):null;
	}

	@Override
	public boolean modifyEmp(Emp emp) {
		// TODO Auto-generated method stub
		String sql = "update emp set empNo=?,empName=?,sex=?,salary=?,birthday=?,deptId=? where empId=?";
		int lines = DBHelper.executeUpdate(
				sql, 
				emp.getEmpNo(),
				emp.getEmpName(),
				emp.getSex()?1:0,
				emp.getSalary(),
				emp.getBirthday(),
				emp.getDept().getDeptId(),
				emp.getEmpId());
		return lines>0;
	}

	@Override
	public boolean deleteEmp(String empId) {
		// TODO Auto-generated method stub
		String sql="delete from emp where empId=?";
		int lines = DBHelper.executeUpdate(
				sql, 
				empId);
		return lines>0;
	}

	@Override
	public PageBean findData(PageBean pageBean) {
		// TODO Auto-generated method stub
		String sql = "select * from emp where 1=1";
		String sqlCount = "select count(empId) from emp where 1 = 1";
		sql +="limit ? , ?";
		List<Emp> empList = DBHelper.executeQuery(sql, new ICallback() {
			List<Emp> lists = new ArrayList<Emp>();
			@Override
			public List execute(ResultSet rs) {
				// TODO Auto-generated method stub
				try {
					Dept dept = null;
					while (rs.next()){
						String empId = rs.getString("empId");
						String empNo = rs.getString("empNo");
						String empName = rs.getString("empName");
						Boolean empSex = rs.getBoolean("sex");
						Double salary = rs.getDouble("salary");
						Date birthday = rs.getDate("birthday");
						Integer deptId = rs.getInt("deptId");
						//dept = new DeptDAOImpl().showDeptByDeptId(deptId);
						dept = ((IDeptDAO)ClasspathXmlApplicationContext.newInstance().getBean("deptDAO")).showDeptByDeptId(deptId);
						lists.add(new Emp(empId,empNo,empName,empSex,salary,birthday,dept));
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return lists;
			}
		},(pageBean.getCurPage()-1)*pageBean.getPageSize(),pageBean.getPageSize());
		pageBean.setData(empList);
		pageBean.setTotalNum(DBHelper.getEmpsCount(sqlCount));
		return pageBean;
	}

	
	@Override
	public PageBean findOptionData(PageBean pageBean, EmpQuery empQuery) {
		// TODO Auto-generated method stub
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		String sql = "select * from emp where 1=1 ";
		String sql_count = "select count(empId) from emp where 1=1 ";

		if (empQuery.getEmpNo() != null
				&& empQuery.getEmpNo().trim().length() != 0) {
			sql += " and empNo = '" + empQuery.getEmpNo().trim() + "'";
			sql_count += " and empNo = '" + empQuery.getEmpNo().trim() + "'";
		}

		if (empQuery.getEmpName() != null
				&& empQuery.getEmpName().trim().length() != 0) {
			sql += " and empName like '%" + empQuery.getEmpName().trim() + "%'";
			sql_count += " and empName like '%" + empQuery.getEmpName().trim()
					+ "%'";
		}
		
		
		if (empQuery.getBeginDate() != null
				&& empQuery.getBeginDate().trim().length() != 0) {
			sql += " and birthday >= '" + empQuery.getBeginDate().trim() + "'";
			sql_count += " and birthday >= '" + empQuery.getBeginDate().trim() + "'";
			
		}
		
		
		if (empQuery.getEndDate() != null
				&& empQuery.getEndDate().trim().length() != 0) {
			sql += " and birthday <= '" + empQuery.getEndDate().trim() + "'";
			sql_count += " and birthday <= '" + empQuery.getEndDate().trim() + "'";
			
		}
		
		
		

		List<Emp> empList = new ArrayList<Emp>();
		sql += " limit " + (pageBean.getCurPage() - 1)
				* pageBean.getPageSize() + "," + pageBean.getPageSize();
		System.out.println(sql);
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.createStatement();

			rs = stmt.executeQuery(sql);
			Emp emp = null;
			while (rs.next()) {
				emp = new Emp();
				emp.setEmpId(rs.getString("empId"));
				emp.setEmpNo(rs.getString("empNo"));
				emp.setEmpName(rs.getString("empName"));
				emp.setSex(rs.getBoolean("sex"));
				emp.setSalary(rs.getDouble("salary"));
				emp.setBirthday(rs.getDate("birthday"));

				// 部门的关联
				Integer deptId = rs.getInt("deptId");
				//Dept dept = new DeptDAOImpl().showDeptByDeptId(deptId);
				Dept dept = ((IDeptDAO)ClasspathXmlApplicationContext.newInstance().getBean("deptDAO")).showDeptByDeptId(deptId);
				emp.setDept(dept);

				empList.add(emp);

			}

			pageBean.setData(empList);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.free(rs, stmt, conn);
		}
		Integer totalNum = DBHelper.getEmpsCount(sql_count);
		pageBean.setTotalNum(totalNum);
		return pageBean;
	}

	
}
