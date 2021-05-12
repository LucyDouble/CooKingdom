package ckd.login.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import ckd.login.service.loginService;
import ckd.member.vo.Manager;
import ckd.member.vo.User;

/**
 * Servlet implementation class checkPwd
 */
@WebServlet("/checkPwd")
public class checkPwd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public checkPwd() {
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
		Manager manager = new Manager();
		
		String email = request.getParameter("email");
		String pwd = request.getParameter("pwd");
		System.out.println("email : " + email);
		System.out.println("pwd : " + pwd);
		user.setPwd(pwd);
		user.setEmail(email);
		manager.setPwd(pwd);
		manager.setEmail(email);
		
		int result1 = new loginService().checkUserPwd(user);
		int result2 = new loginService().checkManagerPwd(manager);
		int result3 = new loginService().checkDirectorPwd(manager);
		
		
		System.out.println("userResult = " + result1);
		System.out.println("managerResult = " + result2);
		System.out.println("directorResult = " + result3);
		JSONObject jobj = new JSONObject();
		
		if (result1 != 1 && result2 != 1 && result3 != 1) {
			System.out.println("아이디 없음 or 비밀번호 불일치");
			jobj.put("result", "fail");
		} else if (result1 == 1) {
			System.out.println("사용자 비밀번호 일치");
			jobj.put("result", "ok");
		} else if (result2 == 1) {
			System.out.println("관리자 비밀번호 일치");
			jobj.put("result", "ok");
		} else if (result3 == 1) {
			System.out.println("책임자 비밀번호 일치");
			jobj.put("result", "ok");
		}
		response.getWriter().println(jobj);
		response.getWriter().flush();
		response.getWriter().close();
		
	}

}
