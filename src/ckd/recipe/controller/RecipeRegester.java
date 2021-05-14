package ckd.recipe.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

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
		
		// ------------------ 파일 -------------------------
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

		//	------------------- 레시피, 재료 등록 ----------------------------
		Recipe Rvo = new Recipe();
		List<Ingredient> IvoList = new ArrayList<Ingredient>();
			
		Rvo.setRecipeCode(Integer.parseInt(mReq.getParameter("recipeCode")));
		Rvo.setRecipeName(mReq.getParameter("recipeName"));
		Rvo.setRecipeInfo(mReq.getParameter("recipeInfo"));
		Rvo.setTypeCag(mReq.getParameter("recipeNation"));
		Rvo.setRecipeCag(mReq.getParameter("recipeType"));
		Rvo.setRecipeQty(mReq.getParameter("recipeQty"));
		Rvo.setCalorie(mReq.getParameter("recipeCalorie"));
		Rvo.setCookingTime(mReq.getParameter("CookingTime"));
		Rvo.setRecipeLevel(mReq.getParameter("recipeLevel"));
		Rvo.setPrice(Integer.parseInt(mReq.getParameter("recipePrice")));

		//	---------------- 재료를 입력한 개수 -------------------
		int cnt = Integer.parseInt(mReq.getParameter("cnt"));
		
		//	---------------- 개수 만큼 for문으로 Ivo에 데이터 입력 --------------
		for(int i = 1; i <= cnt; i++) {
			String ivoP = mReq.getParameter("p_" + i);
			String ivoV = mReq.getParameter("v_" + i);
			System.out.println(ivoP);
			System.out.println(ivoV);
			Ingredient Ivo = new Ingredient();
			
			Ivo.setRecipeCode(Integer.parseInt(mReq.getParameter("recipeCode")));
			Ivo.setIngName(mReq.getParameter("v_" + i));
			Ivo.setIngTypeName(mReq.getParameter("p_" + i));
			Ivo.setIngQty(mReq.getParameter("q_" + i));
			
			IvoList.add(Ivo);	// 리스트에 데이터 추가
			System.out.println("IvoList 확인1: " + IvoList);
		}
		
		System.out.println("IvoList 확인2 : " + IvoList);
		
		//	----------------- DAO로 이동 후 DB에 데이터 입력 ----------------------
		try {
			int resultR = sv.registerRecipe(Rvo);
			int resultI = sv.registerIngredient(IvoList);

			PrintWriter out = response.getWriter();
			System.out.println("resultR : " + resultR);
			System.out.println("resultI : " + resultI);
			
			if (resultR > 0 && resultI == IvoList.size()) {
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
