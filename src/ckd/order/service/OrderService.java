package ckd.order.service;

import java.sql.Connection;



import ckd.common.jdbc.JDBCConnection;
import ckd.order.dao.OrderDAO;
import ckd.order.vo.Orders;
import ckd.order.vo.Ship;

public class OrderService {
	
	public int registerShip(Ship vo) {
		Connection conn = JDBCConnection.getConnection();
		int result = new OrderDAO().registerShip(conn, vo);
		JDBCConnection.close(conn);
		return result;
	}
	
	public int registerOrders(Orders vo) {
		Connection conn = JDBCConnection.getConnection();
		int result = new OrderDAO().registerOrders(conn, vo);
		JDBCConnection.close(conn);
		return result;
	}
}
