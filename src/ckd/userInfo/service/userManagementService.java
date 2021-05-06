package ckd.userInfo.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ckd.member.vo.User;

public class userManagementService {

	public int inquiryUserInfo(User user) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		String query = "insert into USERS values(?,?,?,?,?,?,?)";
		int result = 0;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "chef", "chef11");

			pstmt = conn.prepareStatement(query);

			pstmt.setString(1, user.getEmail());
			pstmt.setString(2, user.getName());
			pstmt.setString(3, user.getNickName());
			pstmt.setString(4, user.getBirth());
			pstmt.setString(5, user.getPwd());
			pstmt.setString(6, user.getPhone());
			pstmt.setString(7, user.getAddress());

			result = pstmt.executeUpdate();

			if (result > 0) {
				conn.commit();
			} else {
				conn.rollback();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;

	}
	
	public int checkId(User user) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		String query = "select * from USERS where email = ?";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "chef", "chef11");
			ResultSet rs = null;
			
			pstmt.setString(1, user.getEmail());
			rs = pstmt.executeQuery();
			
			if (rs.next()) { // 중복 아이디 O
				return 1;
			} else { // 중복 아이디 X
				return 0;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1; // 오류 발생 시
	}

}
