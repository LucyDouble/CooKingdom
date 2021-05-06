package ckd.userInfo.controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ckd.member.vo.User;
import ckd.userInfo.service.userManagementService;
import oracle.jdbc.dcn.DatabaseChangeEvent;

/**
 * Servlet implementation class inqueryDirectorInfo
 */
@WebServlet("/inquiryUser")
public class inquiryUserInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public inquiryUserInfo() {
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
		
		User user = new User();
		
		String email = request.getParameter("email");
		String name = request.getParameter("name");
		String nickName = request.getParameter("nickName");
		String birth = request.getParameter("birth");
		String pwd = request.getParameter("pwd");
		String rePwd = request.getParameter("rePwd");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		
		user.setEmail(email);
		user.setName(name);
		user.setNickName(nickName);
		user.setBirth(birth);
		user.setPwd(pwd);
		user.setRePwd(rePwd);
		user.setPhone(phone);
		user.setAddress(address);
		
		int result = new userManagementService().inquiryUserInfo(user);
		
		if (result == 0) {
			System.out.println("회원가입 실패");
		} else {
			System.out.println("회원가입 성공");
		}
		request.getRequestDispatcher("/test").forward(request, response);
	}

}
