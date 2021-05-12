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
import ckd.recipe.vo.CookingStep;
import ckd.recipe.vo.Ingredient;

/**
 * Servlet implementation class JsonServlet
 */
@WebServlet("/jsonCookingStep.do")
public class JsonCookingStepServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JsonCookingStepServlet() {
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
			response.sendRedirect("./json/jsonCookingStep.jsp");
		} else if(command.equals("listdb")) {
			try {
				new RecipeService().removeCookingStepAll();
				
				String[] jsonCookingStep = request.getParameterValues("jsonCookingStep");
				
				System.out.println(jsonCookingStep.length);
				List<CookingStep> cookingSteps = new ArrayList<CookingStep>();
				
				try {
					
					for(int i = 0; i < jsonCookingStep.length; i++) {
						String[] temp = jsonCookingStep[i].split("@");
						
						CookingStep cookingStep = new CookingStep();
						cookingStep.setRecipeCode(Integer.parseInt(temp[0]));
						cookingStep.setCookingStep(Integer.parseInt(temp[1]));
						cookingStep.setCookingDesc(temp[2]);
						cookingStep.setCookingImage(temp[3]);
						
						cookingSteps.add(cookingStep);
					}
				} catch(ArrayIndexOutOfBoundsException e) {
					e.printStackTrace();
				}
				

//					int resultCnt = new RecipeService().regesterRecipeAll(recipes);
					int resultCnt = new RecipeService().regesterCookingStepAll(cookingSteps);
					System.out.println("cookingSteps : " + cookingSteps.size());
					System.out.println("resultCntServlet : " + resultCnt);
					
					if(resultCnt == cookingSteps.size()) {
						jsResponse("db 저장성공", "./jsonCookingStep.do?command=list", response);
					} else {						
						jsResponse("db 저장실패", "./jsonCookingStep.do?command=list", response);
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
