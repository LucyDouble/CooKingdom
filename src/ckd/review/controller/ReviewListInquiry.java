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
		
		final int pageSize = 3;  // 한페이지당 글 수
		final int pageBlock = 5;  // 화면에 나타날 페이지 링크 수   dP) 화면 하단에 1 2 3 
		
		ReviewService rsv = new ReviewService();
			
		
		int cnt = 0;   // 총 글 개수
		cnt = rsv.getReviewTotalCount();
	
		/*페이지 조회*/
		int pageCnt = (cnt / pageSize) + (cnt % pageSize == 0 ? 0 : 1); // 총 페이지 개수
		
		int currentPage = 1;  // 현재 페이지. 기본 세팅 1. 클릭되면 바뀌게 됨.
		String pageNum = request.getParameter("pageNum");
		if(pageNum != null) {  // 클린 된 숫자를 가지고 온다면
			try {
				currentPage = Integer.parseInt(pageNum);
			}catch (Exception e){
				e.printStackTrace();
			}
		}
		
		
		int startPage = 1; // 화면에 나타날 시작 페이지
		int endPage = 1; // 화면에 나타날 마지막 페이지
		
		// 문제 구간 생김. currentPage가 pageBlock 배수인 경우 오류 발생 즉, 3,6,9..
		if(currentPage % pageBlock == 0)   { //  currentPage가 pageBlock 배수인 경우 
			startPage = ((currentPage/pageBlock)-1) * pageBlock + 1;	
		}else {
			startPage = (currentPage/pageBlock) * pageBlock + 1;  
		}		
		endPage = startPage + pageBlock - 1;
		// 총 페이지 개수보다 endPage가 더 클 수 없음.
		if(endPage > pageCnt)
			endPage = pageCnt;
		
		int startRnum = (currentPage-1)*pageSize +1;
		int endRnum = startRnum + pageSize - 1;
		if(endRnum > cnt) 
			endRnum = cnt;
		
		List<Review> list = null;
		//TODO  list조회시 어떤 레시피에 대한 리뷰인지 확인하는 recipeCode 던져줘야함. 
		list =rsv.selectReviewList(startRnum, endRnum);
		
		System.out.println("pageCnt : " + pageCnt);
		System.out.println("pageSize : " + pageSize);
		System.out.println("startRnum : " + startRnum);
		System.out.println("endRnum : " + endRnum);
		System.out.println("currentPage : " + currentPage);
		
		request.setAttribute("pageCnt", pageCnt);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("cnt", cnt);
		request.setAttribute("reviewList", list);
		request.getRequestDispatcher("/WEB-INF/view/review/reviewListInquiry.jsp").forward(request, response);
	}
}
