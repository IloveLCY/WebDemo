package com.geminno.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class DBHelper {
	public static int executeUpdate(String sql){
		int lines = -1;
		Connection conn = null;
		Statement stmt = null;
		conn = JDBCUtil.getConnection();
		if(conn!=null){
			try {
				stmt = conn.createStatement();
				lines = stmt.executeUpdate(sql);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				JDBCUtil.free(stmt, conn);
			}
			
		}
		return lines;
	}
	public  static List executeQuery(String sql,ICallback callback){
		List list = new ArrayList();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		conn = JDBCUtil.getConnection();
		if(conn!=null){
			try {
				stmt = conn.createStatement();
				rs = stmt.executeQuery(sql);
				list = callback.execute(rs);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				JDBCUtil.free(rs,stmt, conn);
			}
			
		}
		return list;
	}
	public  static List executeQuery(String sql,ICallback callback,Object...psts){
		List list = new ArrayList();
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		conn = JDBCUtil.getConnection();
		if(conn!=null){
			try {
				pst = conn.prepareStatement(sql);
				for (int i = 1; i <= psts.length; i++) {	
					pst.setObject(i, psts[i-1]);
				}
				rs = pst.executeQuery();
				list = callback.execute(rs);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				JDBCUtil.free(rs,pst, conn);
			}
			
		}
		return list;
	}
	
	public static int executeUpdate(String sql,Object...psts){
		Connection conn = null;
		PreparedStatement pst = null;
		int lines = -1;
		conn = JDBCUtil.getConnection();
		if(conn!=null){
			try {
				pst = conn.prepareStatement(sql);
				for (int i = 1; i <= psts.length; i++) {	
					pst.setObject(i, psts[i-1]);
				}
				lines=pst.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				JDBCUtil.free(pst, conn);
			}
		}
		return lines;
	}
	
	public static Integer getEmpsCount(String sql) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		Integer returnNum = 0;

		System.out.println(sql);
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.createStatement();

			rs = stmt.executeQuery(sql);

			if (rs.next()) {
				returnNum = rs.getInt(1);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.free(rs, stmt, conn);
		}
		return returnNum;
	}
	
}
