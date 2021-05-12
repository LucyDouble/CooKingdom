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
 * Servlet implementation class checkUserNickName
 */
@WebServlet("/checkUserInfo.re")
public class checkUserNickName extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public checkUserNickName() {
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
		
		String nickName = request.getParameter("nickName");
		System.out.println("checkNickName : " + nickName);
		user.setNickName(nickName);
		
		int result = new userManagementService().checkNickName(user);
		
		System.out.println("result = " + result);
		if (result == 1) {
			System.out.println("중복 닉네임 있음");
			response.getWriter().write(result);
		} else if (result == 0) {
			System.out.println("중복 닉네임 없음");
		}
	}

}
