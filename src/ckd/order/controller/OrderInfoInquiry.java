package ckd.order.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ckd.order.service.OrderService;
import ckd.order.vo.OrderMember;

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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		execute(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		execute(request, response);
	}
	protected void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		OrderService sv = new OrderService();
		
		OrderMember vo = new OrderMember();
		String email = request.getParameter("email");
		String url = request.getParameter("imgURL");
		String mkName = request.getParameter("mkName");
		String mkNum = request.getParameter("mkNum");
		String total_price = request.getParameter("total_price");
		
		
		
		if (email != null) {
			vo.setEmail(email);
			vo = sv.getUserRead(vo);
			if(vo != null) {
				request.setAttribute("ordermember", vo);
				request.setAttribute("imgURL", url);
				request.setAttribute("mkName", mkName);
				request.setAttribute("mkNum", mkNum);
				request.setAttribute("total_price", total_price);
				request.getRequestDispatcher("/WEB-INF/view/order/orderInfoInquiry.jsp").forward(request, response);
			} else {
				System.out.println("사용자 VO가 Null입니다.");
				request.setAttribute("errorMsg", "사용자 VO가 Null입니다.");
				request.getRequestDispatcher("/error/nullVoError.jsp").forward(request, response);
			}
		}
	
	}
	

}
