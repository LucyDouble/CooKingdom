package ckd.userInfo.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ckd.member.vo.User;
import ckd.userInfo.service.userManagementService;

/**
 * Servlet implementation class removeUserInfo
 */
@WebServlet("/removeUserInfo")
public class removeUserInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public removeUserInfo() {
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
		
		User user = new User();
		
		String email = request.getParameter("email");
		
		user.setEmail(email);
		
		System.out.println(user.getEmail());
		
		int result = new userManagementService().deleteUserInfo(user);
		
		if (result != 1) {
			System.out.println("사용자 회원 탈퇴 실패");
		} else {
			System.out.println("사용자 회원 탈퇴 성공");
			request.getSession().removeAttribute("User");
		}
		response.sendRedirect("cookingDom?command=Main");
	}

}