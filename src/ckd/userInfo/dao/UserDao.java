package ckd.userInfo.dao;

import java.security.spec.RSAKeyGenParameterSpec;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import ckd.member.vo.User;

public class UserDao {
	
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	private void close() {
		try {
			if (pstmt != null) {
				pstmt.close();
			}
			if (rs != null) {
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public int inquiryUserInfo(Connection conn, User user) {
		int result = 0;
		String query = "insert into USERS values(?,?,?,to_date(?,'yyyy-dd-mm'),?,?,?)";
	
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "chef", "chef11");
			
			pstmt = conn.prepareStatement(query);
			System.out.println(user.getEmail());
			pstmt.setString(1, user.getEmail());
			pstmt.setString(2, user.getName());
			pstmt.setString(3, user.getNickName());
			pstmt.setString(4, user.getBirth());
			pstmt.setString(5, user.getPwd());
			pstmt.setInt(6, user.getPhone());
			pstmt.setString(7, user.getAddress());
			
			System.out.println("email : " + user.getEmail());
			System.out.println("name : " + user.getName());
			System.out.println("nickname : " + user.getNickName());
			System.out.println("birth : " + user.getBirth());
			System.out.println("pwd : " + user.getPwd());
			System.out.println("phone : " + user.getPhone());
			System.out.println("address : " + user.getAddress());
			
			result = pstmt.executeUpdate();
			System.out.println("result : " + result);
			
			if (result > 0) {
				conn.commit();
			} else {
				conn.rollback();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return result;
	}
	
	public int checkId(Connection conn, User user) {
		
		String query = "select * from USERS where email=?";
		
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "chef", "chef11");
			System.out.println("getEmail = " + user.getEmail());
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, user.getEmail());
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				return 1;
			} else {
				return 0;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return -1;
	}
	
	public int checkNickName(Connection conn, User user) {
		
		String query = "select * from USERS where nickname=?";
		
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "chef", "chef11");
			System.out.println("getNickName = " + user.getNickName());
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, user.getNickName());
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				return 1;
			} else {
				return 0;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return -1;
	}
	

}
