package ckd.json.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ckd.recipe.service.RecipeService;
import ckd.recipe.vo.Ingredient;

/**
 * Servlet implementation class JsonServlet
 */
@WebServlet("/jsonIngredient.do")
public class JsonIngredientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JsonIngredientServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		//	요청 받을 변수 선언
		String command = request.getParameter("command");
//		// 만약 요청이 list라면?
		if(command.equals("list")) {
			response.sendRedirect("./json/jsonIngredient.jsp");
		} else if(command.equals("listdb")) {
			try {
				new RecipeService().removeIngredientAll();
				
				String[] jsonIngredient = request.getParameterValues("jsonIngredient");
				System.out.println("jsonIngredient : " + jsonIngredient);
				
				List<Ingredient> ingredients = new ArrayList<Ingredient>();
				
				for(int i = 0; i < jsonIngredient.length; i++) {
					String[] temp = jsonIngredient[i].split("@");
					System.out.println(jsonIngredient[i]);
					
					Ingredient ingredient = new Ingredient();
					ingredient.setRecipeCode(Integer.parseInt(temp[0]));
					ingredient.setIngName(temp[1]);
					ingredient.setIngTypeName(temp[2]);
					ingredient.setIngTypeCode(Integer.parseInt(temp[3]));
					ingredient.setIngQty(temp[4]);
					
					ingredients.add(ingredient);
				}
				

//					int resultCnt = new RecipeService().regesterRecipeAll(recipes);
					int resultCnt = new RecipeService().regesterIngredientAll(ingredients);
					System.out.println("ingredients : " + ingredients.size());
					System.out.println("resultCntServlet : " + resultCnt);
					
					if(resultCnt == ingredients.size()) {
						jsResponse("db 저장성공", "./jsonIngredient.do?command=list", response);
					} else {						
						jsResponse("db 저장실패", "./jsonIngredient.do?command=list", response);
					}
					
					
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
//		request.getRequestDispatcher("./json/jsonRecipe.jsp").forward(request, response);
//		response.sendRedirect("./json/jsonRecipe.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	private void jsResponse(String msg, String url, HttpServletResponse response) throws IOException {
		String alert = "<script type = 'text/javascript'>" + 
						"alert('" + msg + "');" +
						"location.href='"+ url +"';" +
						"</script>";
		PrintWriter out = response.getWriter();
		out.print(alert);
						
	}

}
