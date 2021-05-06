package ckd.review.controller;

import java.io.IOException;
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
@WebServlet("/reviewListInquiry")
public class ReviewListInquiry extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewListInquiry() {
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
	
		List<Review> list = null;
		list =rsv.selectReviewList();
		System.out.println(list);
		if(list != null) {
			request.setAttribute("reviewList", list);		
		}
		request.getRequestDispatcher("/WEB-INF/view/review/reviewListInquiry.jsp").forward(request, response);
	}
}
