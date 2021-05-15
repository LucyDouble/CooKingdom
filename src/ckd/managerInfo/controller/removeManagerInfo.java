package ckd.managerInfo.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ckd.managerInfo.service.managerManagementService;
import ckd.member.vo.Manager;
import ckd.member.vo.User;
import ckd.userInfo.service.userManagementService;

/**
 * Servlet implementation class removeManagerInfo
 */
@WebServlet("/removeManagerInfo")
public class removeManagerInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public removeManagerInfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		Manager manager = new Manager();
		
		String email = request.getParameter("email");
		
		manager.setEmail(email);
		
		System.out.println(manager.getEmail());
		
		int result = new managerManagementService().deleteManagerInfo(manager);
		
		if (result != 1) {
			System.out.println("관리자 회원 탈퇴 실패");
		} else {
			System.out.println("관리자 회원 탈퇴 성공");
			request.getSession().removeAttribute("Manager");
		}
		response.sendRedirect("cookingDom?command=Main");
	}

}
