package ckd.recipe.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import ckd.common.jdbc.JDBCConnection;
import ckd.recipe.service.RecipeService;
import ckd.recipe.vo.Ingredient;
import ckd.recipe.vo.Recipe;

/**
 * Servlet implementation class RecipeRegester
 */
@WebServlet("/reciperegester")
public class RecipeRegester extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RecipeRegester() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RecipeService sv = new RecipeService();

		String saveDirectory = getServletContext().getRealPath("/files"); // 웹 서버 상의 절대 경로
		String encType = "utf-8"; // 인코딩 타입
		int maxSize = 5 * 1024 * 1024; // 업로드 파일의 최대크기 5Mb

		// saveDirectory 폴더가 없다면 생성
		File path = new File(saveDirectory);
		System.out.println("path : " + path);
		if (!path.exists()) {
			path.mkdirs(); // 폴더 생성
		}
		// saveDirectory에 file 저장됨.
		MultipartRequest mReq = new MultipartRequest(request, saveDirectory, maxSize, encType,
				new DefaultFileRenamePolicy());

		// 저장된 file 의 정보(file 경로 + file name) 를 읽어오기 --> DB에 저장할 내용임
		String fileName = "";
		Enumeration<?> files = mReq.getFileNames();
		while (files.hasMoreElements()) {
			String name = (String) files.nextElement(); // input type="file" name="xxxxxxx", 즉 bfilepath 와 bfilepaths
			fileName = mReq.getFilesystemName(name); // 서버에 저장된 파일이름
			File f1 = mReq.getFile(name); // 서버에 file이 정상적으로 저장되어있는지 다시 읽어와서 확인함.
			if (f1 == null) {
				System.out.println("파일 업로드 실패");
			} else {
				System.out.println("파일 업로드 성공 : " + f1.length()); // 파일 크기 확인
			}
		}

		Recipe voR = new Recipe();
		Ingredient voI = new Ingredient();

		voR.setRecipeCode(Integer.parseInt(mReq.getParameter("recipeCode")));
		voR.setRecipeName(mReq.getParameter("recipeName"));
		voR.setRecipeInfo(mReq.getParameter("recipeInfo"));
		voR.setTypeCag(mReq.getParameter("recipeNation"));
		voR.setRecipeCag(mReq.getParameter("recipeType"));
		voR.setRecipeQty(mReq.getParameter("recipeQty"));
		voR.setCalorie(mReq.getParameter("recipeCalorie"));
		voR.setCookingTime(mReq.getParameter("CookingTime"));
		voR.setRecipeLevel(mReq.getParameter("recipeLevel"));
		voR.setPrice(Integer.parseInt(mReq.getParameter("recipePrice")));

		voI.setRecipeCode(Integer.parseInt(mReq.getParameter("recipeCode")));
		voI.setIngName(mReq.getParameter("ingName"));
		voI.setIngTypeName(mReq.getParameter("ingTypeName"));
		voI.setIngQty(mReq.getParameter("ingQty"));
		
		System.out.println("voR 레시피 코드 : " + voR.getRecipeCode());
		System.out.println("레시피 이름 : " + mReq.getParameter("recipeName"));
		
		
		System.out.println("서블릿 재료 이름 : " + mReq.getParameter("ingName"));
		System.out.println("서블릿 재료 종류 : " + mReq.getParameter("ingTypeName"));
		System.out.println("서블릿 재료 분량 : " + mReq.getParameter("ingQty"));
		
		
		try {
			int resultR = sv.registerRecipe(voR);
			int resultI = sv.registerIngredient(voI);

			PrintWriter out = response.getWriter();
			System.out.println("resultR : " + resultR);
			System.out.println("resultI : " + resultI);
			
			if (resultR > 0 && resultI > 0) {
				System.out.println("정상 입력");
				String msg = "레시피 등록 완료";

				out.println("<script>alert('" + msg + "')</script>");
				out.println("<script>location.href='./recipelistinquery.do'</script>");
			} else {				
				System.out.println("입력 실패");
				
				out.println("<script>alert('입력 실패')</script>");
				out.println("<script>history.back();</script>");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
