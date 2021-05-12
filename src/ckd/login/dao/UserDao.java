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
	
	public User loginUser(Connection conn, User user) {
		
		User result = null;
		String query = "select * from USERS where email=?";
		
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "chef", "chef11");
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1,  user.getEmail());
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				System.out.println("유저에 조회된 값이 있습니다.");
				
				if (user.getPwd().equals(rs.getString("password"))) {
					System.out.println("유저 비밀번호가 서로 일치");
					result = new User();
					result.setEmail(rs.getNString("email"));
					result.setName(rs.getString("name"));
					result.setNickName(rs.getString("nickname"));
					result.setPwd(rs.getString("password"));
					result.setBirth(rs.getString("birth"));
					result.setPhone(rs.getInt("phone"));
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
	
}
