package ckd.userInfo.service;

import static ckd.common.jdbc.JDBCConnection.*;

import ckd.common.jdbc.JDBCConnection;
import ckd.member.vo.*;
import ckd.userInfo.dao.*;

import java.sql.Connection;

public class userManagementService {

	public int inquiryUserInfo(User user) {
		int result = 0;
		Connection conn = JDBCConnection.getConnection();
		result = new UserDao().inquiryUserInfo(conn, user);
		JDBCConnection.close(conn);
		return result;
	}
	
	public int checkId(User user) {
		int result = 0;
		Connection conn = JDBCConnection.getConnection();
		result = new UserDao().checkId(conn, user);
		JDBCConnection.close(conn);
		return result;
	}
	
	public int checkNickName(User user) {
		int result = 0;
		Connection conn = JDBCConnection.getConnection();
		result = new UserDao().checkNickName(conn, user);
		JDBCConnection.close(conn);
		return result;
	}
	
	public int modifyUserEmail(User user) {
		int result = 0;
		Connection conn = JDBCConnection.getConnection();
		result = new UserDao().modifyUserEmail(conn, user);
		JDBCConnection.close(conn);
		return result;
	}
	
	public int modifyUserName(User user) {
		int result = 0;
		Connection conn = JDBCConnection.getConnection();
		result = new UserDao().modifyUserName(conn, user);
		JDBCConnection.close(conn);
		return result;
	}
	
	public int modifyUserNickName(User user) {
		int result = 0;
		Connection conn = JDBCConnection.getConnection();
		result = new UserDao().modifyUserNickName(conn, user);
		JDBCConnection.close(conn);
		return result;
	}
	
	public int modifyUserPhone(User user) {
		int result = 0;
		Connection conn = JDBCConnection.getConnection();
		result = new UserDao().modifyUserPhone(conn, user);
		JDBCConnection.close(conn);
		return result;
	}
	
	public int modifyUserPwd(User user) {
		int result = 0;
		Connection conn = JDBCConnection.getConnection();
		result = new UserDao().modifyUserPwd(conn, user);
		JDBCConnection.close(conn);
		return result;
	}
	
	public int modifyUserAddress(User user) {
		int result = 0;
		Connection conn = JDBCConnection.getConnection();
		result = new UserDao().modifyUserAddress(conn, user);
		JDBCConnection.close(conn);
		return result;
	}

	public int deleteUserInfo(User user) {
		int result = 0;
		Connection conn = JDBCConnection.getConnection();
		result = new UserDao().deleteUserInfo(conn, user);
		JDBCConnection.close(conn);
		return result;
	}
}
