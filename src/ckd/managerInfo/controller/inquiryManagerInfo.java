package ckd.managerInfo.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ckd.managerInfo.service.managerManagementService;
import ckd.member.vo.Manager;

/**
 * Servlet implementation class inqueryManagerInfo
 */
@WebServlet("/inquiryManager")
public class inquiryManagerInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public inquiryManagerInfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/view/managerInfo/managerSignup.jsp").forward(request, response); 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Manager manager = new Manager();
		int result = 0;
		
		String email = request.getParameter("email");
		String name = request.getParameter("name");
		String pwd = request.getParameter("pwd");
		String rePwd = request.getParameter("rePwd");
		int phone = Integer.parseInt(request.getParameter("phone"));
		String serial = request.getParameter("serial");
		
		manager.setEmail(email);
		manager.setName(name);
		manager.setPwd(pwd);
		manager.setRePwd(rePwd);
		manager.setPhone(phone);
		manager.setSerial(serial);
		
		result = new managerManagementService().inquiryManagerInfo(manager);
		
		if (result == 0) {
			System.out.println("회원가입 실패");
		} else {
			System.out.println("회원가입 성공");
		}
		request.getRequestDispatcher("/cookingDom?command=Main").forward(request, response);
	}

}
