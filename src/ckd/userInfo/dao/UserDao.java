package ckd.userInfo.dao;

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

	public int inquiryUserInfo(Connection conn, User user) {
		int result = 0;
		String query = "insert into USERS values(?,?,?,to_date(?,'yyyy-mm-dd'),?,?,?)";
	
		try {
			
			
			pstmt = conn.prepareStatement(query);
			System.out.println(user.getEmail());
			pstmt.setString(1, user.getEmail());
			pstmt.setString(2, user.getName());
			pstmt.setString(3, user.getNickName());
			pstmt.setString(4, user.getBirth());
			pstmt.setString(5, user.getPwd());
			pstmt.setString(6, user.getPhone());
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
		} finally {
			close();
		}
		return result;
	}
	
	public int checkId(Connection conn, User user) {
		
		String query = "select * from USERS where email=?";
		
		try {
			
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
	
	public int modifyUserEmail(Connection conn, User user) {
		int result = 0;

		String query = "update USERS set EMAIL=? where EMAIL=?";
		try {
			System.out.println("email : " + user.getEmail());
			System.out.println("new email : " + user.getNewEmail());
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, user.getNewEmail());
			pstmt.setString(2, user.getEmail());
			result = pstmt.executeUpdate();
			if (result > 0) {
				System.out.println("사용자 이메일 수정 성공");
				conn.commit();
			} else {
				System.out.println("사용자 이메일 수정 실패");
				conn.rollback();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return result;
	}
	
	public int modifyUserName(Connection conn, User user) {
		int result = 0;
		
		String query = "update USERS set NAME=? where EMAIL=?";
		try {
			System.out.println("email : " + user.getEmail());
			System.out.println("new Name : " + user.getName());
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, user.getName());
			pstmt.setString(2, user.getEmail());
			result = pstmt.executeUpdate();
			if (result > 0) {
				System.out.println("사용자 이름 수정 성공");
				conn.commit();
			} else {
				System.out.println("사용자 이름 수정 실패");
				conn.rollback();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return result;
	}
	
	public int modifyUserNickName(Connection conn, User user) {
		int result = 0;
		
		String query = "update USERS set NICKNAME=? where EMAIL=?";
		try {
			System.out.println("email : " + user.getEmail());
			System.out.println("new nickName : " + user.getNickName());
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, user.getNickName());
			pstmt.setString(2, user.getEmail());
			result = pstmt.executeUpdate();
			if (result > 0) {
				System.out.println("사용자 닉네임 수정 성공");
				conn.commit();
			} else {
				System.out.println("사용자 닉네임 수정 실패");
				conn.rollback();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return result;
	}
	
	public int modifyUserPhone(Connection conn, User user) {
		int result = 0;
		
		String query = "update USERS set PHONE=? where EMAIL=?";
		try {
			System.out.println("email : " + user.getEmail());
			System.out.println("new phone : " + user.getPhone());
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, user.getPhone());
			pstmt.setString(2, user.getEmail());
			result = pstmt.executeUpdate();
			if (result > 0) {
				System.out.println("사용자 핸드폰 번호 수정 성공");
				conn.commit();
			} else {
				System.out.println("사용자 핸드폰 번호 수정 실패");
				conn.rollback();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return result;
	}
	
	public int modifyUserPwd(Connection conn, User user) {
		int result = 0;
		
		String query = "update USERS set PASSWORD=? where EMAIL=?";
		try {
			System.out.println("email : " + user.getEmail());
			System.out.println("new pwd : " + user.getPwd());
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, user.getPwd());
			pstmt.setString(2, user.getEmail());
			result = pstmt.executeUpdate();
			if (result > 0) {
				System.out.println("사용자 비밀번호 수정 성공");
				conn.commit();
			} else {
				System.out.println("사용자 비밀번호 수정 실패");
				conn.rollback();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return result;
	}
	
	public int modifyUserAddress(Connection conn, User user) {
		int result = 0;
		
		String query = "update USERS set ADDRESS=? where EMAIL=?";
		try {
			System.out.println("email : " + user.getEmail());
			System.out.println("new address : " + user.getAddress());
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, user.getAddress());
			pstmt.setString(2, user.getEmail());
			result = pstmt.executeUpdate();
			if (result > 0) {
				System.out.println("사용자 주소 수정 성공");
				conn.commit();
			} else {
				System.out.println("사용자 주소 수정 실패");
				conn.rollback();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return result;
	}
	
	public int deleteUserInfo(Connection conn, User user) {
		int result = 0;
		
		String query ="delete USERS where email=?";
		try {
			System.out.println("email : " + user.getEmail());
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, user.getEmail());
			result = pstmt.executeUpdate();
			if (result > 0) {
				System.out.println("사용자 회원 탈퇴 성공");
				conn.commit();
			} else {
				System.out.println("사용자 회원 탈퇴 실패");
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
