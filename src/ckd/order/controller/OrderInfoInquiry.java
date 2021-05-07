package ckd.order.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ckd.member.vo.User;
import ckd.order.service.OrderService;

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
		
		User vo = new User();
		String str = request.getParameter("email");
		System.out.println(str);  //email 들어오는 거 체크
		if (str != null) {
			vo.setEmail(str);
			System.out.println("2 : "+vo.getEmail()); //email 들어오는 거 체크
			vo = sv.getUserRead(vo);
			if(vo != null) {
				request.setAttribute("user", vo);
				request.getRequestDispatcher("/WEB-INF/view/order/orderInfoInquiry.jsp").forward(request, response);
			} else {
				System.out.println("VO is null");
			}
		}
	
	}
	

}
