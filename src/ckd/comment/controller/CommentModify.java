package ckd.comment.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ckd.comment.service.CommentService;
import ckd.comment.vo.Comment;

/**
 * Servlet implementation class CommentModify
 */
@WebServlet("/commentModify")
public class CommentModify extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommentModify() {
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
		
		CommentService csv = new CommentService();
		Comment comment = new Comment();
		
		String commentContent = request.getParameter("commentContent");
		int commentNo = Integer.parseInt(request.getParameter("commentNo"));
		
		comment.setCommentContent(commentContent);
		comment.setCommentNo(commentNo);
		
		int result = csv.modifyComment(comment);
	}
}
