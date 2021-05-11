package ckd.comment.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ckd.comment.service.CommentService;
import ckd.comment.vo.Comment;
import ckd.review.vo.Review;

/**
 * Servlet implementation class CommentListInquiry
 */
@WebServlet("/commentListInquiry")
public class CommentListInquiry extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommentListInquiry() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		execute(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		execute(request, response);
	}
	
	
	private void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		CommentService scv = new CommentService();
		
		int recipeCode = Integer.parseInt(request.getParameter("recipeCode"));
		
		List<Comment> list = null;
		//TODO  list조회시 어떤 레시피에 대한 리뷰인지 확인하는 recipeCode 던져줘야함. 
		list =scv.selectCommentList(recipeCode);
		System.out.println("list : "+ list);		
		request.setAttribute("commentList", list);
		
		request.getRequestDispatcher("/WEB-INF/view/review/reviewListInquiry.jsp").forward(request, response);
	}
}
