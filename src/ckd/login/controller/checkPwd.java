package ckd.login.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import ckd.login.service.loginService;
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
		
		String email = request.getParameter("email");
		String pwd = request.getParameter("pwd");
		System.out.println("email : " + email);
		System.out.println("pwd : " + pwd);
		user.setPwd(pwd);
		user.setEmail(email);
		
		int result = new loginService().checkPwd(user);
		
		System.out.println("result = " + result);
		JSONObject jobj = new JSONObject();
		if (result == 1) {
			System.out.println("사용자 비밀번호 일치");
			jobj.put("result", "ok");
		} else if (result == 0) {
			System.out.println("사용자 비밀번호 불일치");
			jobj.put("result", "fail");
		}
		response.getWriter().println(jobj);
		response.getWriter().flush();
		response.getWriter().close();
		
	}

}
