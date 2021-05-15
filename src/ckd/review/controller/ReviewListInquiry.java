package ckd.review.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

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
		final int pageBlock = 3;  // 화면에 나타날 페이지 링크 수   dP) 화면 하단에 1 2 3 
		
		int recipeCode = Integer.parseInt(request.getParameter("recipeCode"));
//		System.out.println("recipeCode : "+ recipeCode);
		
		ReviewService rsv = new ReviewService();
		
//		System.out.println("리뷰리스트서블릿 들어옴!");
		
		int cnt = 0;   // 총 글 개수
		cnt = rsv.getReviewTotalCount(recipeCode);
	
		/*페이지 조회*/
		int pageCnt = (cnt / pageSize) + (cnt % pageSize == 0 ? 0 : 1); // 총 페이지 개수
		
		int currentPage = 1;  // 현재 페이지. 기본 세팅 1. 클릭되면 바뀌게 됨.
		String cPage = request.getParameter("currentPage");
		if(cPage != null && !cPage.equals("")) {
			try {
				currentPage = Integer.parseInt(cPage);			
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

		list =rsv.selectReviewList(startRnum, endRnum, recipeCode);
		System.out.println("pageCnt : " + pageCnt);
		System.out.println("pageSize : " + pageSize);
		System.out.println("pageBlock : " + pageBlock);
		System.out.println("startRnum : " + startRnum);
		System.out.println("startPage : " + startPage);
		System.out.println("endRnum : " + endRnum);
		System.out.println("endPage : " + endPage);
		System.out.println("currentPage : " + currentPage);
		System.out.println("reviewList : " + list);
		System.out.println("cnt : " + cnt);
		

		
		
		// JsonObject 생성
		JsonObject jsonObject = new JsonObject();
		jsonObject.addProperty("pageCnt", pageCnt);
		jsonObject.addProperty("pageSize", pageSize);
		jsonObject.addProperty("startPage", startPage);
		jsonObject.addProperty("endPage", endPage);
		jsonObject.addProperty("currentPage", currentPage);
		jsonObject.addProperty("cnt", cnt);
		try {
			JsonArray jArray = new JsonArray();
			for(int i=0; i<list.size(); i++) {
				JsonObject jobj = new JsonObject();
				jobj.addProperty("reviewNo", list.get(i).getReviewNo());
				jobj.addProperty("email", list.get(i).getEmail());
				jobj.addProperty("recipeName", list.get(i).getRecipeName());
				jobj.addProperty("reviewSubject", list.get(i).getReviewSubject());
				jobj.addProperty("nickname", list.get(i).getNickname());
				DateFormat sdFormat = new SimpleDateFormat("yyyy-MM-dd");
				Date nowDate = list.get(i).getReviewDate();
				String today = sdFormat.format(nowDate);
				jobj.addProperty("reviewDate", today);				
				jobj.addProperty("hit", list.get(i).getHit());
				jobj.addProperty("reviewPhoto", list.get(i).getReviewPhoto());
				jobj.addProperty("reviewContent", list.get(i).getReviewContent());
				jArray.add(jobj);
			}
			jsonObject.add("reviewList", jArray);
		} catch (NullPointerException e) {
			System.out.println("리뷰 작성을 하지 않았거나 레시피 데이터 삭제");
		} catch (Exception e) {
			e.printStackTrace();
		}
		                
//		System.out.println("JsonObject 생성 : " + jsonObject.toString() + "\n");
		        
		// Parse Pretty
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String jsonOutput = gson.toJson(jsonObject);
		
		System.out.println("jsonOutput : "+ jsonOutput);
		
		response.getWriter().write(jsonOutput.toString());
//		PrintWriter out = response.getWriter();
//		
//		out.print(jsonOutput);
//		out.flush();
//		out.close();
		
//		request.setAttribute("Abc", 10);
//		request.setAttribute("pageCnt", pageCnt);
//		request.setAttribute("startPage", startPage);
//		request.setAttribute("endPage", endPage);
//		request.setAttribute("currentPage", currentPage);
//		request.setAttribute("cnt", cnt);
//		request.setAttribute("reviewList", list);
//		request.getRequestDispatcher("/WEB-INF/view/review/a.jsp").forward(request, response);
//		request.getRequestDispatcher("/WEB-INF/view/review/reviewListInquiry.jsp").forward(request, response);
	}
}
