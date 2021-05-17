package ckd.cart.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import ckd.cart.service.CartService;
import ckd.cart.vo.Cart;
import ckd.comment.vo.Comment;

@WebServlet("/cartListInquiry")
public class CartListInquiry extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CartListInquiry() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();

		String email = (String) session.getAttribute("email");
		if (email == "") {
			request.getRequestDispatcher("./loginUser").forward(request, response);
		}
		Cart cart = new Cart();

		cart.setEmail(email);

		CartService cartSV = new CartService();
		List<Cart> list = cartSV.inquiryCartList(cart);
		
		request.setAttribute("list", list);
		request.getRequestDispatcher("/WEB-INF/view/cart/cartListInfo.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
