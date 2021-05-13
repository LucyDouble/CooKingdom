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
 * Servlet implementation class ModifyUserInfo
 */
@WebServlet("/modifyUserInfo")
public class ModifyUserInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifyUserInfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/view/userInfo/userModify.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		User user = new User();
		
		String email = request.getParameter("email");
		String newEmail = request.getParameter("newEmail");
		String name = request.getParameter("name");
		String nickName = request.getParameter("nickName");
		String birth = request.getParameter("birth");
		int phone = Integer.parseInt(request.getParameter("phone"));
		String pwd = request.getParameter("pwd");
		String newPwd = request.getParameter("newPwd");
		String address = request.getParameter("address");
		
		user.setEmail(email);
		user.setNewEmail(newEmail);
		user.setName(name);
		user.setNickName(nickName);
		user.setBirth(birth);
		user.setPhone(phone);
		user.setPwd(pwd);
		user.setNewPwd(newPwd);
		user.setAddress(address);
		
		System.out.println(user.getEmail());
		System.out.println(user.getNewEmail());
		System.out.println(user.getName());
		System.out.println(user.getNickName());
		System.out.println(user.getBirth());
		System.out.println(user.getPhone());
		System.out.println(user.getPwd());
		System.out.println(user.getAddress());
		
		int result = new userManagementService().ModifyUserInfo(user);
		
		if (result == 0) {
			System.out.println("유저 정보수정 실패");
		} else {
			System.out.println("유저 정보수정 성공");
		}
		
		
	}

}
