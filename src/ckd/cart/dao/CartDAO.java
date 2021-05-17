package ckd.cart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ckd.cart.vo.Cart;
import ckd.review.vo.Review;

public class CartDAO {
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
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 장바구니 목록 조회
	public List<Cart> selectCartList(Connection conn, Cart cart) {
		List<Cart> list = null;
		String sql = "SELECT  M.RECIPE_URL, M. RECIPE_NAME, M.PRICE, CI.MEALKIT_QTY, C.TOTAL_PRICE";
			   sql += " FROM MEALKIT M";
			   sql += " INNER JOIN CART_INFO CI";
			   sql += "     ON M.RECIPE_CODE = CI.RECIPE_CODE";
			   sql += " INNER JOIN CART C";
			   sql += "     ON CI.CART_NO = C.CART_NO";
			   sql += " WHERE C.EMAIL = ?";
			   sql += " ORDER BY C.CART_NO DESC";
		
		try {
			pstmt = conn.prepareStatement(sql);
			System.out.println("장바구니 조회 이메일 : " + cart.getEmail());
			pstmt.setString(1,  cart.getEmail());
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				list = new ArrayList<Cart>();
				do {
					Cart cartVo = new Cart();
					cartVo.setMealkitUrl(rs.getString("RECIPE_URL"));
					cartVo.setMealkit_name(rs.getString("RECIPE_NAME"));
					cartVo.setMealkit_price(rs.getInt("PRICE"));
					cartVo.setMealkitQty(rs.getInt("MEALKIT_QTY"));
					cartVo.setTotalPrice(rs.getInt("TOTAL_PRICE"));
					list.add(cartVo);
					
					System.out.println("리스트 조회 list : " + list);
				}while(rs.next());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return list;
	}

	// 장바구니 등록 // cart 테이블
	public int insertCart(Connection conn, Cart cart) {
		int result = 0;
		String sql = "INSERT INTO CART";
		sql += " VALUES(SEQ_CART.NEXTVAL, ?, ?)";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cart.getEmail());
			pstmt.setInt(2, cart.getTotalPrice());

			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return result;
	}

	// 장바구니 정보 등록 // cart_info 테이블
	public int insertCartInfo(Connection conn, Cart cart) {
		int result = 0;
		
		String sql = "INSERT INTO CART_INFO VALUES(";
		sql += " (SELECT CART_NO"; 
		sql += " FROM CART"; 
		sql += " WHERE EMAIL = ? AND CART_NO ="; 
		sql += " (SELECT MAX(CART_NO) FROM CART)";
		sql += " ),";
		sql += " (SELECT RECIPE_CODE";
		sql += " FROM MEALKIT";
		sql += " WHERE RECIPE_CODE = ?";
		sql += " ),";
		sql += " ?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cart.getEmail());
			pstmt.setInt(2, cart.getRecipeCode());
			pstmt.setInt(3, cart.getMealkitQty());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}

		return result;
	}

	// 장바구니 삭제
	public int deleteCartInfo(String cartNo) {
		int result = 0;

		return result;
	}

}
