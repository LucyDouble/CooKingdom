package ckd.userInfo.service;

import static ckd.common.jdbc.JDBCConnection.*;
import ckd.member.vo.*;
import ckd.userInfo.dao.*;

import java.sql.Connection;

public class userManagementService {

	public int inquiryUserInfo(User user) {
		int result = 0;
		Connection conn = getConnection();
		result = new UserDao().inquiryUserInfo(conn, user);
		close(conn);
		return result;
	}
	
	public int checkId(User user) {
		int result = 0;
		Connection conn = getConnection();
		result = new UserDao().checkId(conn, user);
		close(conn);
		return result;
	}
	
	public int checkNickName(User user) {
		int result = 0;
		Connection conn = getConnection();
		result = new UserDao().checkNickName(conn, user);
		close(conn);
		return result;
	}
	

}
