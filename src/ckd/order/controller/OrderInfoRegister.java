package ckd.order.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ckd.member.vo.User;
import ckd.order.service.OrderService;
import ckd.order.vo.Orders;
import ckd.order.vo.Ship;

/**
 * Servlet implementation class OrderInfoRegister
 */
@WebServlet("/orderInfoRegister")
public class OrderInfoRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public OrderInfoRegister() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		OrderService sv = new OrderService();
		

		try {
			Ship shipVo = new Ship();
			shipVo.setName(request.getParameter("sName"));
			shipVo.setPhone(Integer.parseInt(request.getParameter("sPhone")));
			shipVo.setAddress(request.getParameter("sAddress"));

			int result = sv.registerShip(shipVo);

			PrintWriter out = response.getWriter();
			if (result > 0) { // input success
				System.out.println("배송 정보 정상 입력");
				
			} else {
				System.out.println("배송 정보 입력이 실패하였습니다.");
				request.setAttribute("errorMsg", "배송 정보 입력이 실패하였습니다.");
				request.getRequestDispatcher("/error/nullVoError.jsp").forward(request, response);
			}
			
			Orders ordersVo = new Orders();
			
			// get User VO from Session
			HttpSession session = request.getSession(); 
			User user = (User)session.getAttribute("User");
			
			// X 주문코드(기본키) SEQ / 이메일(참조키) / x 배송코드(참조키) SEQ / x주문일자 / 총금액
			ordersVo.setEmail(user.getEmail());
			System.out.println("email값: "+user.getEmail());
			
			System.out.println("상품총금액:"+request.getParameter("oTotal"));
			ordersVo.setTotalPrice(Integer.parseInt(request.getParameter("oTotal")));
			result = sv.registerOrders(ordersVo);

			if (result > 0) { // input success
				System.out.println("주문 정보 정상 입력");
				
				request.getRequestDispatcher("WEB-INF/view/order/orderListInquiry.jsp").forward(request, response);
			} else {
				System.out.println("주문 정보 입력이 실패하였습니다.");
				request.setAttribute("errorMsg", "주문 정보 입력이 실패하였습니다.");
				request.getRequestDispatcher("/error/nullVoError.jsp").forward(request, response);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
