package ckd.cart.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ckd.cart.service.CartService;
import ckd.cart.vo.Cart;

/**
 * Servlet implementation class CartInfoRegister
 */
@WebServlet("/cartRegister")
public class CartRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CartRegister() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();

		String email = (String) session.getAttribute("email");
		int totalPrice = Integer.parseInt(request.getParameter("total_price"));

		System.out.println("장바구니 데이터" + email + " / " + totalPrice);

		// 장바구니 생성
		Cart cart = new Cart();

		// 장바구니 [이메일, 레시피 코드, 수량, 총금액]저장
		cart.setEmail(email);
		cart.setTotalPrice(totalPrice);

		CartService cartSV = new CartService();
		int result = cartSV.registerCart(cart);

		RequestDispatcher dispatcher = request.getRequestDispatcher("./cartInfoRegister");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
