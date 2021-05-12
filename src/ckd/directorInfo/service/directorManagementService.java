package ckd.directorInfo.service;

import static ckd.common.jdbc.JDBCConnection.close;
import static ckd.common.jdbc.JDBCConnection.getConnection;

import java.sql.Connection;

import ckd.directorInfo.dao.DirectorDao;
import ckd.login.dao.ManagerDao;
import ckd.member.vo.Manager;
import ckd.member.vo.User;
import ckd.userInfo.dao.UserDao;

public class directorManagementService {

	public int inquiryDirectorInfo(Manager manager) {
		int result = 0;
		Connection conn = getConnection();
		result = new DirectorDao().inquiryDirectorInfo(conn, manager);
		close(conn);
		return result;
	}
	
	public int checkId(Manager manager) {
		int result = 0;
		Connection conn = getConnection();
		result = new DirectorDao().checkId(conn, manager);
		close(conn);
		return result;
	}
}
