package ckd.userInfo.controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import oracle.jdbc.dcn.DatabaseChangeEvent;

/**
 * Servlet implementation class inqueryDirectorInfo
 */
@WebServlet("/inqueryDirector")
public class inqueryUserInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public inqueryUserInfo() {
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
//		System.out.println("POST 방식으로 접근했습니다~");
		String email = request.getParameter("email");
		String name = request.getParameter("name");
		String nickName = request.getParameter("niceName");
		String birth = request.getParameter("birth");
		String pwd = request.getParameter("pwd");
		String repwd = request.getParameter("rePwd");
		int phone = Integer.parseInt(request.getParameter("phone"));
		String address = request.getParameter("address");
	}

}
