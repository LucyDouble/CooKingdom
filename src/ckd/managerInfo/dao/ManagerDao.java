package ckd.managerInfo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ckd.member.vo.Manager;
import ckd.member.vo.User;

public class ManagerDao {

	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	private Connection conn = null;
	
	private void close() {
		try {
			if (rs != null) {
				rs.close();
			}
			if (pstmt != null) {
				pstmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public int inquiryManagerInfo(Connection conn, Manager manager) {
		int result = 0;
		String query = "insert into MANAGER values(?,?,?,?,?)";
	
		try {
			
			
			pstmt = conn.prepareStatement(query);
			
			System.out.println(manager.getEmail());
			pstmt.setString(1, manager.getEmail());
			pstmt.setString(2, manager.getName());
			pstmt.setString(3, manager.getPwd());
			pstmt.setString(4, manager.getPhone());
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
		String query = "select * from MANAGER where email=?";
		
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
	
	public int modifyManagerEmail(Connection conn, Manager manager) {
		int result = 0;

		String query = "update MANAGER set EMAIL=? where EMAIL=?";
		try {
			System.out.println("email : " + manager.getEmail());
			System.out.println("new email : " + manager.getNewEmail());
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, manager.getNewEmail());
			pstmt.setString(2, manager.getEmail());
			result = pstmt.executeUpdate();
			if (result > 0) {
				System.out.println("관리자 이메일 수정 성공");
				conn.commit();
			} else {
				System.out.println("관리자 이메일 수정 실패");
				conn.rollback();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return result;
	}

	public int modifyManagerName(Connection conn, Manager manager) {
		int result = 0;
		
		String query = "update MANAGER set NAME=? where EMAIL=?";
		try {
			System.out.println("email : " + manager.getEmail());
			System.out.println("new Name : " + manager.getName());
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, manager.getName());
			pstmt.setString(2, manager.getEmail());
			result = pstmt.executeUpdate();
			if (result > 0) {
				System.out.println("관리자 이름 수정 성공");
				conn.commit();
			} else {
				System.out.println("관리자 이름 수정 실패");
				conn.rollback();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return result;
	}
	
	public int modifyManagerPhone(Connection conn, Manager manager) {
		int result = 0;
		
		String query = "update MANAGER set PHONE=? where EMAIL=?";
		try {
			System.out.println("email : " + manager.getEmail());
			System.out.println("new phone : " + manager.getPhone());
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, manager.getPhone());
			pstmt.setString(2, manager.getEmail());
			result = pstmt.executeUpdate();
			if (result > 0) {
				System.out.println("관리자 핸드폰 번호 수정 성공");
				conn.commit();
			} else {
				System.out.println("관리자 핸드폰 번호 수정 실패");
				conn.rollback();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return result;
	}

	public int modifyManagerPwd(Connection conn, Manager manager) {
		int result = 0;
		
		String query = "update MANAGER set PASSWORD=? where EMAIL=?";
		try {
			System.out.println("email : " + manager.getEmail());
			System.out.println("new pwd : " + manager.getPwd());
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, manager.getPwd());
			pstmt.setString(2, manager.getEmail());
			result = pstmt.executeUpdate();
			if (result > 0) {
				System.out.println("관리자 비밀번호 수정 성공");
				conn.commit();
			} else {
				System.out.println("관리자 비밀번호 수정 실패");
				conn.rollback();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return result;
	}
}
