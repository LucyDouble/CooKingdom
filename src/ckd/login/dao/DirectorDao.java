package ckd.login.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ckd.member.vo.Manager;
import ckd.member.vo.User;

public class DirectorDao {
	
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
	
	public Manager loginDirector(Connection conn, Manager manager) {
		
		Manager result = null;
		String query = "select * from DIRECTOR where email=?";
		
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "chef", "chef11");
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1,  manager.getEmail());
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				System.out.println("책임자에 조회된 값이 있습니다.");
				
				if (manager.getPwd().equals(rs.getString("password"))) {
					System.out.println("책임자 비밀번호가 서로 일치");
					result = new Manager();
					result.setEmail(rs.getString("email"));
					result.setName(rs.getString("name"));
					result.setPwd(rs.getString("password"));
					result.setPhone(rs.getInt("phone"));
				} else {
					System.out.println("책임자 비밀번호가 서로 불일치");
				}
 			} else {
 				System.out.println("책임자에서 조회된 값이 없습니다.");
 			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return result;
	}
	
	public int checkPwd(Connection conn, Manager manager) {
		
		String query = "select * from DiRECTOR where email=? and password=?";
		
		try {
			
			System.out.println("getEmail = " + manager.getEmail());
			System.out.println("getPwd = " + manager.getPwd());
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, manager.getEmail());
			pstmt.setString(2, manager.getPwd());
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
