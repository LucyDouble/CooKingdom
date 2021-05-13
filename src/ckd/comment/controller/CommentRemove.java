package ckd.comment.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ckd.comment.service.CommentService;
import ckd.comment.vo.Comment;
import ckd.review.service.ReviewService;
import ckd.review.vo.Review;

/**
 * Servlet implementation class CommentRemove
 */
@WebServlet("/commentRemove")
public class CommentRemove extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommentRemove() {
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
		System.out.println("댓글 삭제 서블릿 들어오기 성공!");
		
		CommentService csv = new CommentService();
		
		int result = 0;
		
		Comment comment = new Comment();
		comment.setRecipeCode(Integer.parseInt(request.getParameter("recipeCode")));
		comment.setCommentNo(Integer.parseInt(request.getParameter("commentNo")));
		
		result = csv.deleteComment(comment);
		
		
	}

}
