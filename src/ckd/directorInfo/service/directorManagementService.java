package ckd.directorInfo.service;

import static ckd.common.jdbc.JDBCConnection.close;
import static ckd.common.jdbc.JDBCConnection.getConnection;

import java.sql.Connection;

import ckd.common.jdbc.JDBCConnection;
import ckd.directorInfo.dao.DirectorDao;
import ckd.login.dao.ManagerDao;
import ckd.member.vo.Manager;
import ckd.member.vo.User;
import ckd.userInfo.dao.UserDao;

public class directorManagementService {

	public int inquiryDirectorInfo(Manager manager) {
		int result = 0;
		Connection conn = JDBCConnection.getConnection();
		result = new DirectorDao().inquiryDirectorInfo(conn, manager);
		JDBCConnection.close(conn);
		return result;
	}
	
	public int checkId(Manager manager) {
		int result = 0;
		Connection conn = JDBCConnection.getConnection();
		result = new DirectorDao().checkId(conn, manager);
		JDBCConnection.close(conn);
		return result;
	}
	
	public int modifyDirectorEmail(Manager manager) {
		int result = 0;
		Connection conn = JDBCConnection.getConnection();
		result = new DirectorDao().modifyDirectorEmail(conn, manager);
		JDBCConnection.close(conn);
		return result;
	}
	
	public int modifyDirectorName(Manager manager) {
		int result = 0;
		Connection conn = JDBCConnection.getConnection();
		result = new DirectorDao().modifyDirectorName(conn, manager);
		JDBCConnection.close(conn);
		return result;
	}
	
	public int modifyDirectorPhone(Manager manager) {
		int result = 0;
		Connection conn = JDBCConnection.getConnection();
		result = new DirectorDao().modifyDirectorPhone(conn, manager);
		JDBCConnection.close(conn);
		return result; 
	}
	
	public int modifyDirectorPwd(Manager manager) {
		int result = 0;
		Connection conn = JDBCConnection.getConnection();
		result = new DirectorDao().modifyDirectorPwd(conn, manager);
		JDBCConnection.close(conn);
		return result;
	}
	
	public int deleteDirectorInfo(Manager manager) {
		int result = 0;
		Connection conn = JDBCConnection.getConnection();
		result = new DirectorDao().deleteDirectorInfo(conn, manager);
		JDBCConnection.close(conn);
		return result;
	}
}
