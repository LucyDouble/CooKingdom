package ckd.order.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import ckd.order.vo.OrderMember;

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

	
	public OrderMember getOrderMemberRead(Connection conn, OrderMember inputVo) {
		OrderMember vo = null;
		String sql = "select * from users where email = ?";
		pstmt = null;
		rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, inputVo.getEmail());
			rs = pstmt.executeQuery();
			if (rs.next()) {
				vo = new OrderMember();
				vo.setEmail(rs.getString("email"));
				vo.setName(rs.getString("name"));
				vo.setPhone(rs.getInt("phone"));
				vo.setAddress(rs.getString("address"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return vo;
	}
}
