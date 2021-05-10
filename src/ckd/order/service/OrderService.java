package ckd.order.service;

import java.sql.Connection;


import ckd.common.jdbc.JDBCConnection;
import ckd.order.dao.OrderDAO;
import ckd.order.vo.OrderMember;

public class OrderService {
	
	public OrderMember getUserRead(OrderMember inputVo) {
		Connection conn = JDBCConnection.getConnection();
		OrderMember result = new OrderDAO().getOrderMemberRead(conn, inputVo);
		JDBCConnection.close(conn);
		return result;
	}
}
