package ckd.managerInfo.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import ckd.managerInfo.service.managerManagementService;
import ckd.member.vo.Manager;

/**
 * Servlet implementation class modifyManagerInfo
 */
@WebServlet("/modifyManagerInfo")
public class modifyManagerInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public modifyManagerInfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/view/managerInfo/managerModify.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		Manager manager = new Manager();
		
		String email = request.getParameter("email");
		String newEmail = request.getParameter("newEmail");
		String newName = request.getParameter("newName");
		String newPhone = request.getParameter("newPhone");
		String newPwd = request.getParameter("newPwd");
		
		manager.setEmail(email);
		manager.setNewEmail(newEmail);
		manager.setName(newName);
		manager.setPhone(newPhone);
		manager.setPwd(newPwd);
		
		System.out.println("email : " + manager.getEmail());
		
		int resultEmail = new managerManagementService().modifyManagerEmail(manager);
		int resultName = new managerManagementService().modifyManagerName(manager);
		int resultPhone = new managerManagementService().modifyManagerPhone(manager);
		int resultPwd = new managerManagementService().modifyManagerPwd(manager);
		JSONObject jobj = new JSONObject();
		
		if (resultEmail != 1 && resultName != 1 && resultPhone != 1 && resultPwd != 1) {
			System.out.println("관리자 정보 수정 실패");
			jobj.put("result", "fail");
		} else if (resultEmail == 1) {
			System.out.println("관리자 이메일 수정 성공");
			jobj.put("result", "email");
		} else if (resultName == 1) {
			System.out.println("관리자 이름 수정 성공");
			jobj.put("result", "name");
		} else if (resultPhone == 1) {
			System.out.println("관리자 핸드폰 번호 수정 성공");
			jobj.put("result", "phone");
		} else if (resultPwd == 1) {
			System.out.println("관리자 비밀번호 수정 성공");
			jobj.put("result", "pwd");
		} 
		response.getWriter().println(jobj);
		response.getWriter().flush();
		response.getWriter().close();
	}

}
