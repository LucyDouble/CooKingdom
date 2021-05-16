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
 * Servlet implementation class ReviewRemove
 */
@WebServlet("/reviewRemove")
public class ReviewRemove extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewRemove() {
        super();
        // TODO Auto-generated constructor stub
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
		System.out.println("들어오기 성공!");
		
		ReviewService rsv = new ReviewService();
		
		int result = 0;
		
		Review review = new Review();
		review.setRecipeCode(Integer.parseInt(request.getParameter("recipeCode")));
		review.setReviewNo(Integer.parseInt(request.getParameter("reviewNo")));
		
		result = rsv.removeReview(review);
		
		
	}

}
