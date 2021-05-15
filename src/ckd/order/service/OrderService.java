package ckd.order.service;

import java.sql.Connection;
import java.util.List;

import ckd.common.jdbc.JDBCConnection;
import ckd.order.dao.OrderDAO;
import ckd.order.vo.OrderInfo;
import ckd.order.vo.Orders;
import ckd.order.vo.Ship;

public class OrderService {
	
	public int insertShip(Ship vo) {
		Connection conn = JDBCConnection.getConnection();
		int result = new OrderDAO().insertShip(conn, vo);
		JDBCConnection.close(conn);
		return result;
	}
	
	public int insertOrders(Orders vo) {
		Connection conn = JDBCConnection.getConnection();
		int result = new OrderDAO().insertOrders(conn, vo);
		JDBCConnection.close(conn);
		return result;
	}
	
	public int insertOrderInfo(OrderInfo vo) {
		Connection conn = JDBCConnection.getConnection();
		int result = new OrderDAO().insertOrderInfo(conn, vo);
		JDBCConnection.close(conn);
		return result;
	}

	public List<Orders> selectOrders(Orders ordersVo) {
		Connection conn = JDBCConnection.getConnection();
		List<Orders> list = new OrderDAO().selectOrders(conn, ordersVo);
		JDBCConnection.close(conn);
		return list;
	}
}
