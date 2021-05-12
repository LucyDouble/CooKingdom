package ckd.directorInfo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ckd.member.vo.Manager;
import ckd.member.vo.User;

public class DirectorDao {

	private PreparedStatement pstmt = null;

	private void close() {
		try {
			if (pstmt != null) {
				pstmt.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public int inquiryDirectorInfo(Connection conn, Manager manager) {
		int result = 0;
		String query = "insert into DIRECTOR values(?,?,?,?,?)";

		try {

			pstmt = conn.prepareStatement(query);

			System.out.println(manager.getEmail());
			pstmt.setString(1, manager.getEmail());
			pstmt.setString(2, manager.getName());
			pstmt.setString(3, manager.getPwd());
			pstmt.setInt(4, manager.getPhone());
			pstmt.setString(5, manager.getSerial());

			System.out.println("email : " + manager.getEmail());
			System.out.println("name : " + manager.getName());
			System.out.println("pwd : " + manager.getPwd());
			System.out.println("phone : " + manager.getPhone());
			System.out.println("serial : " + manager.getSerial());

			result = pstmt.executeUpdate();
			System.out.println("result : " + result);

			if (result > 0) {
				conn.commit();
			} else {
				conn.rollback();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return result;
	}
	
	public int checkId(Connection conn, Manager manager) {
		ResultSet rs = null;
		String query = "select * from USERS where email=?";
		
		try {
			
			System.out.println("getEmail = " + manager.getEmail());
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, manager.getEmail());
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
