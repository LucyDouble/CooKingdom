package ckd.cart.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ckd.cart.service.CartService;
import ckd.cart.vo.Cart;

@WebServlet("/cartInfoRegister")
public class CartInfoRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CartInfoRegister() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();

		String email = (String) session.getAttribute("email");
		int rpCode = Integer.parseInt(request.getParameter("recipeCode"));
		int mkQty = Integer.parseInt(request.getParameter("mkNum"));
		System.out.println("장바구니 정보 데이터" + " /이메일: " + email + " /레시피 코드 :  " + rpCode + " /수량 :  " + mkQty);
		// 장바구니 생성
		Cart cart = new Cart();

		// 장바구니 [이메일, 레시피 코드, 수량, 총금액]저장
		cart.setEmail(email);
		cart.setRecipeCode(rpCode);
		cart.setMealkitQty(mkQty);

		CartService cartSV = new CartService();
		int result = cartSV.registerCartInfo(cart);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
