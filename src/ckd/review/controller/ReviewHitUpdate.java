package ckd.review.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ckd.review.service.ReviewService;
import ckd.review.vo.Review;

/**
 * Servlet implementation class ReviewListInquiry
 */
@WebServlet("/reviewHitUpdate")
public class ReviewHitUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewHitUpdate() {
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
		PrintWriter out =response.getWriter();
		ReviewService rsv = new ReviewService();
		
		int reviewNo = Integer.parseInt(request.getParameter("reviewNo"));
		
		int hit = rsv.getReviewHit(reviewNo);
		out.print(hit);
		out.flush();
		out.close();
		
		
		}
}
