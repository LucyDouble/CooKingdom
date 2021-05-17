package ckd.cart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import ckd.cart.vo.Cart;

public class CartDAO {
	private PreparedStatement pstmt = null;

	private void close() {
		try {
			if (pstmt != null) {
				pstmt.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 장바구니 목록 조회
	public List<Cart> selectCartList() {
		List<Cart> list = null;

		return list;
	}

	// 장바구니 등록 // cart 테이블
	public int insertCart(Connection conn, Cart cart) {
		int result = 0;
		String sql = "INSERT INTO CART";
		sql += " VALUES(SEQ_CART.NEXTVAL, ?, ?)";

		try {
			pstmt = conn.prepareStatement(sql);
			System.out.println("장바구니 이메일 : " + cart.getEmail());
			pstmt.setString(1, cart.getEmail());
			System.out.println("장바구니 총금액 : " + cart.getTotalPrice());
			pstmt.setInt(2, cart.getTotalPrice());
			System.out.println("장바구니 등록 sql문 실행성공");

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
			System.out.println("장바구니 정보 이메일 : " + cart.getEmail());
			pstmt.setString(1, cart.getEmail());
			System.out.println("장바구니 정보 레시피 코드 : " + cart.getRecipeCode());
			pstmt.setInt(2, cart.getRecipeCode());
			System.out.println("장바구니 정보 밀키트 수량 : " + cart.getMealkitQty());
			pstmt.setInt(3, cart.getMealkitQty());
			System.out.println("장바구니 정보 등록 sql문 실행성공");
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
