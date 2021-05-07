package ckd.order.service;

import java.sql.Connection;

import ckd.common.jdbc.JDBCConnection;
import ckd.member.vo.User;
import ckd.order.dao.OrderDAO;

public class OrderService {
	
	public User getUserRead(User inputVo) {
		Connection conn = JDBCConnection.getConnection();
		User result = new OrderDAO().getUserRead(conn, inputVo);
		JDBCConnection.close(conn);
		return result;
	}
}
