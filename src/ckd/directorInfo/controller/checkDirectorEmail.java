package ckd.directorInfo.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ckd.directorInfo.service.directorManagementService;
import ckd.member.vo.Manager;
import ckd.member.vo.User;
import ckd.userInfo.service.userManagementService;

/**
 * Servlet implementation class checkUserInfo
 */
@WebServlet(name = "checkDirectorInfo", urlPatterns = { "/checkDirectorInfo" })
public class checkDirectorEmail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public checkDirectorEmail() {
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
		System.out.println("checkEmail : " + email);
		manager.setEmail(email);
		
		int result = new directorManagementService().checkId(manager);
		
		System.out.println("result = " + result);
		if (result == 1) {
			System.out.println("중복 이메일 있음");
			response.getWriter().write(result);
		} else if (result == 0){
			System.out.println("중복 이메일 없음");
		}
	}

}
