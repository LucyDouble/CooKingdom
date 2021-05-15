package ckd.userInfo.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import ckd.member.vo.User;
import ckd.userInfo.service.userManagementService;

/**
 * Servlet implementation class ModifyUserInfo
 */
@WebServlet("/modifyUserInfo")
public class modifyUserInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public modifyUserInfo() {
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
		String newName = request.getParameter("newName");
		String newNickName = request.getParameter("newNickName");
		String newPhone = request.getParameter("newPhone");
		String newPwd = request.getParameter("newPwd");
		String newAddress = request.getParameter("newAddress");
		
		user.setEmail(email);
		user.setNewEmail(newEmail);
		user.setName(newName);
		user.setNickName(newNickName);
		user.setPhone(newPhone);
		user.setPwd(newPwd);
		user.setAddress(newAddress);
		
		System.out.println("email : " + user.getEmail());
		
		int resultEmail = new userManagementService().modifyUserEmail(user);
		int resultName = new userManagementService().modifyUserName(user);
		int resultNickName = new userManagementService().modifyUserNickName(user);
		int resultPhone = new userManagementService().modifyUserPhone(user);
		int resultPwd = new userManagementService().modifyUserPwd(user);
		
		System.out.println("email : " + resultEmail);
		System.out.println("name : " + resultName);
		System.out.println("nickname : " + resultNickName);
		System.out.println("phone : " + resultPhone);
		System.out.println("pwd : " + resultPwd);
		JSONObject jobj = new JSONObject();
		
		if (resultEmail != 1 && resultName != 1 && resultNickName != 1 && resultPhone != 1 && resultPwd != 1) {
			System.out.println("사용자 정보 수정 실패");
			jobj.put("result", "fail");
		} else if (resultEmail == 1) {
			System.out.println("사용자 이메일 수정 성공");
			jobj.put("result", "email");
		} else if (resultName == 1) {
			System.out.println("사용자 이름 수정 성공");
			jobj.put("result", "name");
		} else if (resultNickName == 1) {
			System.out.println("사용자 닉네임 수정 성공");
			jobj.put("result", "nickName");
		} else if (resultPhone == 1) {
			System.out.println("사용자 핸드폰 번호 수정 성공");
			jobj.put("result", "phone");
		} else if (resultPwd == 1) {
			System.out.println("사용자 비밀번호 수정 성공");
			jobj.put("result", "pwd");
		} 
		response.getWriter().println(jobj);
		response.getWriter().flush();
		response.getWriter().close();
		
	}

}
