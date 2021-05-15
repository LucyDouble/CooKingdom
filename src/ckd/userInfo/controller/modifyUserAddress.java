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
 * Servlet implementation class ModifyUserAddress
 */
@WebServlet("/modifyUserAddress")
public class modifyUserAddress extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public modifyUserAddress() {
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
		String newAddress = request.getParameter("newAddress");
		
		user.setEmail(email);
		user.setAddress(newAddress);
		
		System.out.println("email : " + user.getEmail());
		System.out.println("address : " + user.getAddress());
		
		int result = new userManagementService().modifyUserAddress(user);
		
		System.out.println("address : " + result);
		JSONObject jobj = new JSONObject();
		
		if (result != 1) {
			System.out.println("사용자 정보 수정 실패");
			jobj.put("result","fail");
		} else {
			System.out.println("사용자 주소 수정 성공");
			jobj.put("reesult","address");
		}
		response.getWriter().println(jobj);
		response.getWriter().flush();
		response.getWriter().close();
	}

}
