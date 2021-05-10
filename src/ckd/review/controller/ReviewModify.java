package ckd.review.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ckd.review.service.ReviewService;
import ckd.review.vo.Review;

/**
 * Servlet implementation class ReviewModify
 */
@WebServlet("/reviewModify")
public class ReviewModify extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewModify() {
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
		
		ReviewService rsv = new ReviewService();
		Review review = new Review();
		
		request.setCharacterEncoding("utf-8");
		
		int reviewNo = Integer.parseInt(request.getParameter("reviewNo"));
		int recipeCode = Integer.parseInt(request.getParameter("recipeCode"));
		String email = request.getParameter("email");
		String reviewSubject = request.getParameter("reviewSubject");
		String reviewContent = request.getParameter("reviewContent");

		
		
		
		request.setAttribute("reviewNo", reviewNo);
		request.setAttribute("recipeCode", recipeCode);
		request.setAttribute("email", email);
		request.setAttribute("reviewSubject", reviewSubject);
		request.setAttribute("reviewContent", reviewContent);

		request.getRequestDispatcher("/WEB-INF/view/review/reviewModify.jsp").forward(request, response);
	}
}
