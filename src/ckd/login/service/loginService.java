package ckd.login.service;

import static ckd.common.jdbc.JDBCConnection.close;
import static ckd.common.jdbc.JDBCConnection.getConnection;

import java.sql.Connection;

import ckd.login.dao.DirectorDao;
import ckd.login.dao.ManagerDao;
import ckd.login.dao.UserDao;
import ckd.member.vo.Manager;
import ckd.member.vo.User;


public class loginService {

	public User loginUser(User user) {
		User result = null;
		Connection conn = getConnection();
		result = new UserDao().loginUser(conn, user);
		close(conn);
		return result;
	}
	
	public Manager loginManager(Manager manager) {
		Manager result = null;
		Connection conn = getConnection();
		result = new ManagerDao().loginManager(conn, manager);
		close(conn);
		return result;
	}
	
	public Manager loginDirector(Manager manager) {
		Manager result = null;
		Connection conn = getConnection();
		result = new DirectorDao().loginDirector(conn, manager);
		close(conn);
		return result;
	}
	
}
