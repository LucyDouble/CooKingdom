package ckd.recipe.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ckd.recipe.service.RecipeService;

/**
 * Servlet implementation class RecipeRemove
 */
@WebServlet("/reciperemove")
public class RecipeRemove extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RecipeRemove() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("레시피 삭제 들어왔음!!!!!!!!!!!!!!!!");
		int resultR = 0;
		int resultI = 0;
		RecipeService sv = new RecipeService();
		PrintWriter out = response.getWriter();
		String msg1 = "레시피 삭제 성공";
		String msg2 = "레시피 삭제 실패";
		
		int recipeCode = Integer.parseInt(request.getParameter("recipeCode"));
		System.out.println(recipeCode);
		
		try {
			resultI = sv.removeIngredient(recipeCode);
			resultR = sv.removeRecipe(recipeCode);
			System.out.println("레시피 삭제 결과 : " + resultR);
			System.out.println("재료 삭제 결과 : " + resultI);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NullPointerException e) {
			System.out.println("레시피 정보가 삭제되어 댓글,리뷰 정보가 없습니다.");
		}
		
		if(resultR > 0 && resultI > 0) {
			System.out.println("레시피 삭제 성공");
			out.println("<script>alert('"+msg1+"')</script>");
			out.println("<script>location.href='./recipelistinquery';</script>");
		} else {
			System.out.println("레시피 삭제 실패");
			out.println("<script>alert('"+msg2+"')</script>");
			out.println("<script>history.back()</script>");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
