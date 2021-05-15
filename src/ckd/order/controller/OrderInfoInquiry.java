package ckd.order.controller;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class OrderInfoInquiry
 */
@WebServlet("/orderInfoInquiry")
public class OrderInfoInquiry extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public OrderInfoInquiry() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String recipeCode = request.getParameter("recipeCode");
		String url = request.getParameter("imgURL");
		String mkName = request.getParameter("mkName");
		String mkNum = request.getParameter("mkNum");
		String total_price = request.getParameter("total_price");

		request.setAttribute("recipeCode", recipeCode);
		request.setAttribute("imgURL", url);
		request.setAttribute("mkName", mkName);
		request.setAttribute("mkNum", mkNum);
		request.setAttribute("total_price", total_price);
		request.getRequestDispatcher("/WEB-INF/view/order/orderInfoInquiry.jsp").forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
