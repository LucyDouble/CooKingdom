package ckd.order.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ckd.member.vo.User;
import ckd.order.service.OrderService;
import ckd.order.vo.Orders;
import sun.rmi.server.Dispatcher;

/**
 * Servlet implementation class OrderListInquiry
 */
@WebServlet("/orderListInquiry")
public class OrderListInquiry extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderListInquiry() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		OrderService sv = new OrderService(); 
		
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("User");
		
		Orders ordersVo = new Orders();
		
		List<Orders> ordersList = null;
		
		
		if(user.getEmail()!=null) {
			ordersVo.setEmail(user.getEmail());
			ordersList = sv.selectOrders(ordersVo);
			request.setAttribute("ordersList", ordersList);
			request.getRequestDispatcher("WEB-INF/view/order/orderListInquiry.jsp").forward(request, response);

		}else {
			System.out.println("User의 email이 Null입니다.");
		}

		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
