package ckd.login.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ckd.member.vo.User;

public class UserDao {
		
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	private Connection conn = null;
	
	private void close() {
		try {
			if (pstmt != null) {
				pstmt.close();
			}
			if (rs != null) {
				rs.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public User loginUser(Connection conn, User user) {
		
		User result = null;
		String query = "select * from USERS where email=?";
		
		try {
			
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1,  user.getEmail());
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				System.out.println("유저에 조회된 값이 있습니다.");
				
				if (user.getPwd().equals(rs.getString("password"))) {
					System.out.println("유저 비밀번호가 서로 일치");
					result = new User();
					result.setEmail(rs.getString("email"));
					result.setName(rs.getString("name"));
					result.setNickName(rs.getString("nickname"));
					result.setPwd(rs.getString("password"));
					result.setBirth(rs.getString("birth"));
					result.setPhone(rs.getString("phone"));
					result.setAddress(rs.getString("address"));
				} else {
					System.out.println("유저 비밀번호가 서로 불일치");
				}
			 } else {
				 System.out.println("유저에서 조회된 값이 없습니다.");
			 }
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return result;	
	}
	
	public int checkPwd(Connection conn, User user) {
		
		String query = "select * from USERS where email=? and password=?";
		
		try {
			
			System.out.println("getEmil = " + user.getEmail());
			System.out.println("getPwd = " + user.getPwd());
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, user.getEmail());
			pstmt.setString(2, user.getPwd());
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				user.setEmail(rs.getString("email"));
				user.setName(rs.getString("name"));
				user.setNickName(rs.getString("nickName"));
				user.setBirth(rs.getString("birth"));
				user.setPwd(rs.getString("password"));
				user.setPhone(rs.getString("phone"));
				user.setAddress(rs.getString("address"));
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
