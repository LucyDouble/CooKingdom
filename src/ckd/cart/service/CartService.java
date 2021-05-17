package ckd.cart.service;

import java.sql.Connection;
import java.util.List;

import ckd.cart.dao.CartDAO;
import ckd.cart.vo.Cart;
import ckd.common.jdbc.JDBCConnection;

public class CartService {
	// 장바구니 목록 조회
	public List<Cart> InquiryCartList() {
		List<Cart> list = null;

		return list;
	}

	// 장바구니 등록
	public int registerCart(Cart cart) {
		int result = 0;
		Connection conn = JDBCConnection.getConnection();
		System.out.println("장바구니 등록  서비스 실행 중......");
		result = new CartDAO().insertCart(conn, cart);
		JDBCConnection.close(conn);
		return result;
	}

	// 장바구니 정보 등록
	public int registerCartInfo(Cart cart) {
		int result = 0;
		Connection conn = JDBCConnection.getConnection();
		System.out.println("장바구니 정보 등록  서비스 실행 중......");
		result = new CartDAO().insertCartInfo(conn, cart);
		JDBCConnection.close(conn);
		return result;
	}

	// 장바구니 삭제
	public int removeCartInfo(String cartNo) {
		int result = 0;

		return result;
	}
}
