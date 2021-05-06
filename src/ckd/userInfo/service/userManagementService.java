package ckd.userInfo.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
			
//			System.out.println(user.getEmail());
//			System.out.println(user.getName());
//			System.out.println(user.getNickName());
//			System.out.println(user.getBirth());
//			System.out.println(user.getPwd());
//			System.out.println(user.getPhone());
//			System.out.println(user.getAddress());

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

}
