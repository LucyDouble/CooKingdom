package ckd.common.jdbc;


import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class JDBCConnection {

	public static Connection getConnection() {
		Connection conn = null;
		try {
			Context i1 = new InitialContext();
			Context i2 = (Context) i1.lookup("java:/comp/env"); 
			DataSource ds = (DataSource)i2.lookup("jdbc/chef");
			conn = ds.getConnection();
			if(conn == null) {
				System.out.println("***************연결실패***************");
			}else {
				System.out.println("!!!!!!!!!!!!!연결성공!!!!!!!!!!!!!!!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public static void close(Connection conn) {
		try {
			if(conn != null && !conn.isClosed())
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void close(Statement stmt) {
		try {
			if(stmt != null && !stmt.isClosed())
				stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void close(ResultSet rs) {
		try {
			if(rs != null && !rs.isClosed())
				rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void commit(Connection conn) {
		try {  
			if(conn != null && !conn.isClosed())
				conn.commit();    //트랜젝션 커밋
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void rollback(Connection conn) {
		try {
			if(conn != null && !conn.isClosed())
				conn.rollback();   //트랜젝션 롤백
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
