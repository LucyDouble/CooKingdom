package ckd.managerInfo.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import ckd.member.vo.Manager;

public class managerManagementService {
	
	public int inquiryManagerInfo(Manager manager) {
	
		Connection conn = null;
		PreparedStatement pstmt = null;
		String query = "insert into MANAGER values(?,?,?,?,?)";
		int result = 0;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "chef", "chef11");
			
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, manager.getEmail());
			pstmt.setString(2, manager.getName());
			pstmt.setString(3, manager.getPwd());
			pstmt.setString(4, manager.getPhone());
			pstmt.setString(5, manager.getSerial());
			
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
