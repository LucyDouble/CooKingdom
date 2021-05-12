package ckd.userInfo.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ckd.member.vo.User;
import ckd.userInfo.dao.UserDao;
import ckd.userInfo.service.userManagementService;

/**
 * Servlet implementation class checkUserInfo
 */
@WebServlet("/checkUserInfo")
public class checkUserEmail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public checkUserEmail() {
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
		System.out.println("checkEmail : " + email);
		user.setEmail(email);
		
		int result = new userManagementService().checkId(user);
		
		System.out.println("result = " + result);
		if (result == 1) {
			System.out.println("중복 이메일 있음");
			response.getWriter().write(result);
		} else if (result == 0){
			System.out.println("중복 이메일 없음");
		}
	}

}
