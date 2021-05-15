package ckd.recipe.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import ckd.recipe.service.RecipeService;
import ckd.recipe.vo.Recipe;

/**
 * Servlet implementation class RecipeListInquery
 */
@WebServlet("/recipelistinquery.do")
public class RecipeListInquery extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RecipeListInquery() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		final int pageSize = 9;  // 한페이지당 글 수
		final int pageBlock = 5;  // 화면에 나타날 페이지 링크 수   dP) 화면 하단에 1 2 3 

		RecipeService sv = new RecipeService();
		
		int cnt = 0;   // 총 글 개수
		
		/********** 검색 *************/
		String search = request.getParameter("search");
		System.out.println("search: " + search);
		
		if(search != null && !search.equals("")) {
		} else {
			search = null;
		}
		try {
			cnt= sv.getRecipeCount(search);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		int pageCnt = (cnt / pageSize) + (cnt % pageSize == 0 ? 0 : 1); // 총 페이지 개수
		
		int currentPage = 1;	//	현재 페이지. 기본세팅1. 클릭되면 바뀌게 됨.
		String pageNum = request.getParameter("pageNum");
		if(pageNum != null && !pageNum.equals("")) { //	클린된 숫자를 가지고 온다면
			currentPage = Integer.parseInt(pageNum);
		}
		
		int startPage = 1;	//	화면에 나타날 시작 페이지
		int endPage = 1;	//	화면에 나타날 마지막 페이지
		
		//	문제 구간 생김. currentPage가 pageBlock 배수인 경우 오류 발생 즉, 5,10,15..
		if(currentPage % pageBlock == 0) {	// currentPage가 pageBlock 배수인 경우
			startPage = ((currentPage/pageBlock)-1) * pageBlock + 1;
		} else {
			startPage = (currentPage/pageBlock) * pageBlock + 1;
		}
		
		endPage = startPage + pageBlock -1;
		//	총 페이지 개수보다 endPage가 더 클 수 없음
		if(endPage > pageCnt) {
			endPage = pageCnt;
		}
		
		int startRnum = (currentPage-1)*pageSize+1;
		int endRnum = startRnum + pageSize - 1;
		if(endRnum > cnt)
			endRnum = cnt;
		
		List<Recipe> list = null;
		/********** 검색 *************/
		if(search != null && !search.equals("")) {
			//	검색은 ajax를 통한 경우...
		} else {
			search =  null;
		}
		try {
			list = sv.inqueryRecipeList(startRnum, endRnum, search);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		/********** 검색 *************/
			request.setAttribute("pageCnt", pageCnt);
			request.setAttribute("startPage", startPage);
			request.setAttribute("endPage", endPage);
			request.setAttribute("currentPage", currentPage);
			request.setAttribute("recipeList", list);
			request.setAttribute("search", search);
			System.out.println(pageCnt);
			System.out.println(startPage);
			System.out.println(endPage);
			System.out.println(currentPage);
			System.out.println(list);
			System.out.println(search);
			
			request.getRequestDispatcher("/WEB-INF/view/recipe/recipeListInquery.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
