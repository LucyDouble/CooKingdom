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
import ckd.recipe.vo.Recipe;

/**
 * Servlet implementation class JsonServlet
 */
@WebServlet("/jsonRecipe.do")
public class JsonRecipeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JsonRecipeServlet() {
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
			response.sendRedirect("./json/jsonRecipe.jsp");
		} else if(command.equals("listdb")) {
			try {
				new RecipeService().removeRecipeAll();
				
				String[] jsonRecipe = request.getParameterValues("jsonRecipe");
				System.out.println("jsonRecipe : " + jsonRecipe);
				
				List<Recipe> recipes = new ArrayList<Recipe>();
				
				for(int i = 0; i < jsonRecipe.length; i++) {
					String[] temp = jsonRecipe[i].split("@");
					
					Recipe recipe = new Recipe();
					recipe.setRecipeCode(Integer.parseInt(temp[0]));
					recipe.setRecipeName(temp[1]);
					recipe.setTypeCode(Integer.parseInt(temp[2]));
					recipe.setTypeCag(temp[3]);
					recipe.setRecipeInfo(temp[4]);
					recipe.setRecipeTypeCode(Integer.parseInt(temp[5]));
					recipe.setRecipeCag(temp[6]);
					recipe.setCookingTime(temp[7]);
					recipe.setCalorie(temp[8]);
					recipe.setRecipeQty(temp[9]);
					recipe.setRecipeLevel(temp[10]);
					recipe.setIngType(temp[11]);
					recipe.setRecipeUrl(temp[12]);
					recipe.setLikes(0);
					recipe.setPrice(Integer.parseInt(temp[13]));
					recipe.setRfilePath("");
					
					recipes.add(recipe);
				}
				
//					int resultCnt = new RecipeService().regesterRecipeAll(recipes);
					int resultCnt = new RecipeService().regesterRecipeAll(recipes);
					System.out.println("recipesSize : " + recipes.size());
					System.out.println("resultCntServlet : " + resultCnt);
					System.out.println("recipes : " + recipes);
					
					if(resultCnt == recipes.size()) {
						jsResponse("db 저장성공", "./jsonRecipe.do?command=list", response);
					} else {						
						jsResponse("db 저장실패", "./jsonRecipe.do?command=list", response);
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
