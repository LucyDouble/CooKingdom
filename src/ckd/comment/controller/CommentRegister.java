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
 * Servlet implementation class CommentRegister
 */
@WebServlet("/commentRegister")
public class CommentRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommentRegister() {
        super();
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
		
		CommentService csv = new CommentService();
		Comment comment = new Comment();
		
		String email = request.getParameter("email");
		int recipeCode = Integer.parseInt(request.getParameter("recipeCode"));
		String commentContent = request.getParameter("commentContent");
		int commentGroup = Integer.parseInt(request.getParameter("commentGroup"));
		int commentDepth = Integer.parseInt(request.getParameter("commentDepth"));

		comment.setEmail(email);
		comment.setRecipeCode(recipeCode);
		comment.setCommentContent(commentContent);
		comment.setCommentGroup(commentGroup);
		comment.setCommentGroup(commentDepth);
		
		int result = new CommentService().insertComment(comment);
	
	}

}
