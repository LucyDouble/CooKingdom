package ckd.login.service;

import static ckd.common.jdbc.JDBCConnection.close;
import static ckd.common.jdbc.JDBCConnection.getConnection;

import java.sql.Connection;

import ckd.common.jdbc.JDBCConnection;
import ckd.login.dao.DirectorDao;
import ckd.login.dao.ManagerDao;
import ckd.login.dao.UserDao;
import ckd.member.vo.Manager;
import ckd.member.vo.User;


public class loginService {

	public User loginUser(User user) {
		User result = null;
		Connection conn = JDBCConnection.getConnection();
		result = new UserDao().loginUser(conn, user);
		JDBCConnection.close(conn);
		return result;
	}
	
	public Manager loginManager(Manager manager) {
		Manager result = null;
		Connection conn = JDBCConnection.getConnection();
		result = new ManagerDao().loginManager(conn, manager);
		JDBCConnection.close(conn);
		return result;
	}
	
	public Manager loginDirector(Manager manager) {
		Manager result = null;
		Connection conn = JDBCConnection.getConnection();
		result = new DirectorDao().loginDirector(conn, manager);
		JDBCConnection.close(conn);
		return result;
	}
	
	public int checkPwd(User user) {
		int result = 0;
		Connection conn = JDBCConnection.getConnection();
		result = new UserDao().checkPwd(conn, user);
		JDBCConnection.close(conn);
		return result;
	}
	
}
