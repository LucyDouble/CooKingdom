package ckd.recipe.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ckd.recipe.service.RecipeService;
import ckd.recipe.vo.CookingStep;
import ckd.recipe.vo.Ingredient;
import ckd.recipe.vo.Recipe;

/**
 * Servlet implementation class RecipeInquery
 */
@WebServlet("/recipeinquery.do")
public class RecipeInquery extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RecipeInquery() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RecipeService sv = new RecipeService();
		Recipe recipeVo = new Recipe();
		Ingredient ingredientVo = new Ingredient();
		CookingStep cookingStepVo = new CookingStep();
		
		List<Ingredient> ingredientList = new ArrayList<Ingredient>();
		List<CookingStep> cookingStepList = new ArrayList<CookingStep>();
		
		String recipeCode = request.getParameter("recipeCode");
		System.out.println("InqueryRecipeCode : " + recipeCode);
		
			try {
				if(recipeCode != null) {
					recipeVo.setRecipeCode(Integer.parseInt(recipeCode));
					ingredientVo.setRecipeCode(Integer.parseInt(recipeCode));
					cookingStepVo.setRecipeCode(Integer.parseInt(recipeCode));
					
					recipeVo = sv.inqueryRecipe(recipeVo);
					ingredientList = sv.inqueryIngredient(ingredientVo);
					cookingStepList = sv.inqueryCookingStep(cookingStepVo);
					
//					System.out.println("ingName" + ingredientVo.());
					System.out.println("ingredientList : " + ingredientList);
					if(recipeVo != null) {
						request.setAttribute("recipeInquery", recipeVo);
						request.setAttribute("ingredientInquery", ingredientList);
						request.setAttribute("cookingStepInquery", cookingStepList);
						
						request.getRequestDispatcher("/WEB-INF/view/recipe/recipeInquery.jsp").forward(request, response);
					} else {
						System.out.println("데이터가 없어서 레시피 정보 조회가 불가능합니다.");
					}
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
