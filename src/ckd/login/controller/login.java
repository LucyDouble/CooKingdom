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
import ckd.userInfo.service.userManagementService;

/**
 * Servlet implementation class loginUser
 */
@WebServlet("/loginUser")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/view/login/login.jsp").forward(request, response); 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		Manager manager = new Manager();
		User user = new User();
		User result1 = new User();
		Manager result2 = new Manager();
		Manager result3 = new Manager();
		
		String email = request.getParameter("email");
		String pwd = request.getParameter("pwd");
		
		user.setEmail(email);
		user.setPwd(pwd);
		manager.setEmail(email);
		manager.setPwd(pwd);
		
		result1 = new loginService().loginUser(user);
		result2 = new loginService().loginManager(manager);
		result3 = new loginService().loginDirector(manager);
		
		JSONObject jobj = new JSONObject();
		if (result1 != null){
			System.out.println("유저 로그인 성공");
			jobj.put("result", "ok");
			jobj.put("email", result1.getEmail());
			request.getSession().setAttribute("User", result1);
			System.out.println("유저에 세션 값 넣기?");
		} else {
			System.out.println("유저 로그인 실패");
			jobj.put("result", "fail");
			if (result2 != null) {
				System.out.println("관리자 로그인 성공");
				jobj.put("result", "ok");
				jobj.put("email", result2.getEmail());
				request.getSession().setAttribute("Manager", result2);
				System.out.println("관리자에 세션 값 넣기?");
			} else {
				System.out.println("관리자 로그인 실패");
				jobj.put("result", "fail");
				if (result3 != null) {
					System.out.println("책임자 로그인 성공");
					jobj.put("result", "ok");
					jobj.put("email", result3.getEmail());
					request.getSession().setAttribute("Director", result3);
					System.out.println("책임자에 세션 값 넣기?");
				} else {
					System.out.println("책임자 로그인 실패");
					jobj.put("result", "fail");
				}
			}
		}
		response.getWriter().println(jobj);
		response.getWriter().flush();
		response.getWriter().close();
		
	}

}
