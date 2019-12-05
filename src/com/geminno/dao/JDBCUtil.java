package com.geminno.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mchange.v2.c3p0.ComboPooledDataSource;


public class JDBCUtil {
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/geminno?useUnicode=true&characterEncoding=UTF8";
	private static final String USER = "root";
	private static final String PSD = "admin";
	public static Connection getConnection(){
		try {
			Class.forName(DRIVER);
			return DriverManager.getConnection(URL,USER,PSD);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public static Connection getPoolConnection(){
		Connection conn = null;
		try {
			ComboPooledDataSource cpds = new ComboPooledDataSource();
			cpds.setDriverClass(DRIVER);
			cpds.setJdbcUrl(URL);
			cpds.setUser(USER);
			cpds.setPassword(PSD);
			cpds.setInitialPoolSize(5);
			cpds.setMinPoolSize(5);
			cpds.setMaxPoolSize(50);
			cpds.setMaxIdleTime(10);
			cpds.setAcquireIncrement(5);
			conn = cpds.getConnection();
			} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	public static void free(ResultSet rs,Statement stmt,Connection conn){
		if(rs!=null){
			try {
				rs.close();
				rs=null;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				if(stmt!=null){
					try {
						stmt.close();
						stmt=null;
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}finally{
						if(conn!=null){
							try {
								conn.close();
								conn=null;
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					}
				}
			}
		}
	}
	public static void free(Statement stmt,Connection conn){
		if(stmt!=null){
			try {
				stmt.close();
				stmt=null;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				if(conn!=null){
					try {
						conn.close();
						conn=null;
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
	}
	public static void free(ResultSet rs,PreparedStatement pst,Connection conn){
		if(rs!=null){
			try {
				rs.close();
				rs=null;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				if(pst!=null){
					try {
						pst.close();
						pst=null;
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}finally{
						if(conn!=null){
							try {
								conn.close();
								conn=null;
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					}
				}
			}
		}
	}
	public static void free(PreparedStatement pst,Connection conn){
		if(pst!=null){
			try {
				pst.close();
				pst=null;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				if(conn!=null){
					try {
						conn.close();
						conn=null;
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
	}
}
