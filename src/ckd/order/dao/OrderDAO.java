package ckd.order.dao;

import java.sql.Connection;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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


	public int registerShip(Connection conn, Ship vo) {
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

	public int registerOrders(Connection conn, Orders vo) {
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
				System.out.println("매우 이상한 상황.. 확인바람");
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

}
