package ckd.managerInfo.service;

import static ckd.common.jdbc.JDBCConnection.close;
import static ckd.common.jdbc.JDBCConnection.getConnection;

import java.sql.Connection;

import ckd.common.jdbc.JDBCConnection;
import ckd.managerInfo.dao.ManagerDao;
import ckd.member.vo.Manager;
import ckd.member.vo.User;
import ckd.userInfo.dao.UserDao;

public class managerManagementService {
	
	public int inquiryManagerInfo(Manager manager) {
		int result = 0;
		Connection conn = JDBCConnection.getConnection();
		result = new ManagerDao().inquiryManagerInfo(conn, manager);
		JDBCConnection.close(conn);
		return result;
	}
	
	public int checkId(Manager manager) {
		int result = 0;
		Connection conn = getConnection();
		result = new ManagerDao().checkId(conn, manager);
		close(conn);
		return result;
	}
	
}
