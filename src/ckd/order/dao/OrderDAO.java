package ckd.order.dao;

import java.sql.Connection;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ckd.order.vo.OrderInfo;
import ckd.order.vo.OrderList;
import ckd.order.vo.Orders;
import ckd.order.vo.Ship;

public class OrderDAO {

	private Statement stmt = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	private void close() {
		try {
			if (rs != null) {
				rs.close();
			}
			if (pstmt != null) {
				pstmt.close();
			}
			if (stmt != null) {
				stmt.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


	public int insertShip(Connection conn, Ship vo) {
		int result = 0;

		String sql = "insert into ship values(concat(to_char(sysdate,'yyyymmdd'), seq_ship.nextval), ?, ?, ?)";
		
		pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getName());
			pstmt.setInt(2, vo.getPhone()); 
			pstmt.setString(3, vo.getAddress());

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}

		return result;
	}

	public int insertOrders(Connection conn, Orders vo) {
		int result = 0;
		
		int last = 1;

		String sqlLastShipCode = "select ship_code from( select * from ship order by rownum desc )where rownum = 1";
		String sql = "insert into orders values(concat(to_char(sysdate,'yyyymmdd'), seq_orders.nextval), ?, ? , sysdate, ?)";

		pstmt = null; rs=null;
		try {
			pstmt = conn.prepareStatement(sqlLastShipCode);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				last = rs.getInt(1);
			} else {
				System.out.println("sqlLastShipCode Error");
				return 0;
			}
			close(); 
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getEmail());
			pstmt.setInt(2, last); // ship vo를 먼저 생성하고 참조해야함
			pstmt.setInt(3, vo.getTotalPrice());

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}

		return result;
	}


	public int insertOrderInfo(Connection conn, OrderInfo vo) {
		int result = 0;
		int lastOrderCode = 1;
		
		String sqlLastOrderCode = "select order_code from( select * from orders order by rownum desc )where rownum = 1";
		// 주문코드 / 레시피코드 / 밀키트 수량
		String sql = "insert into order_info values(?, ?, ?)";
		
		pstmt = null; rs = null;
		try {
			pstmt = conn.prepareStatement(sqlLastOrderCode);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				lastOrderCode = rs.getInt(1);
			} else {
				System.out.println("sqlLastOrderCode Error");
				return 0;
			}
			close(); 
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, lastOrderCode);
			pstmt.setInt(2, vo.getRecipeCode());
			pstmt.setInt(3, vo.getMealkitQty());

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}

		return result;
	}

// 주문코드(기본)/이메일(참조)/배송코드/주문일자/총금액
	public List<OrderList> selectOrderList(Connection conn, Orders ordersVo, int period) {
		List<OrderList> list = null;
		String sql = "select * from (select * from orders where email = ?) natural join order_info natural join mealkit where order_date between to_date(sysdate-"
				+ period + ") and to_date(sysdate+1) order by order_date desc";

		if(period == 365) {
			sql = "select * from orders natural join order_info natural join mealkit where email = ? order by order_date desc";
		}
		
		pstmt = null; rs = null;
		try {
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ordersVo.getEmail());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				list = new ArrayList<OrderList>();
				do {
					OrderList vo = new OrderList();
					vo.setOrderCode(rs.getInt("order_code"));
					vo.setEmail(rs.getString("email"));
					vo.setShipCode(rs.getInt("ship_code"));
					vo.setOrderDate(rs.getDate("order_date"));
					vo.setTotalPrice(rs.getInt("total_price"));
					vo.setRecipeCode(rs.getInt("recipe_code"));
					vo.setMealkitQty(rs.getInt("mealkit_qty"));
					vo.setRecipeName(rs.getString("recipe_name"));
					vo.setRecipeUrl(rs.getString("recipe_url"));
					vo.setPrice(rs.getInt("price"));
					list.add(vo);
				}while(rs.next());
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		
		return list;
	}

}
