package ckd.recipe.controller;

import java.io.File;
import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import ckd.recipe.service.RecipeService;
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RecipeService sv = new RecipeService();
		
		String saveDirectory = getServletContext().getRealPath("/files"); // 웹 서버 상의 절대 경로
		String encType="utf-8";  // 인코딩 타입
		int maxSize = 5*1024*1024; // 업로드 파일의 최대크기 5Mb 
		
		//	saveDirectory 폴더가 없다면 생성
		File path = new File(saveDirectory);
		System.out.println("path : " + path);
		if(!path.exists()) {
			path.mkdirs();
		}
		// saveDirectory에 file 저장됨.
		MultipartRequest mReq = new MultipartRequest(request, saveDirectory, maxSize, encType, new DefaultFileRenamePolicy());
	
		// 저장된 file 의 정보(file 경로 + file name) 를 읽어오기  --> DB에 저장할 내용임
		String fileName = "";
		Enumeration<?> files = mReq.getFileNames();
		while(files.hasMoreElements()) {
			String name = (String) files.nextElement();   // input type="file" name="xxxxxxx", 즉 bfilepath 와 bfilepaths
			fileName = mReq.getFilesystemName(name);    // 서버에 저장된 파일이름
			File f1 = mReq.getFile(name);   // 서버에 file이 정상적으로 저장되어있는지 다시 읽어와서 확인함.
			if(f1 ==null) {
				System.out.println("파일 업로드 실패");
			} else {
				System.out.println("파일 업로드 성공 : "+f1.length());   // 파일 크기 확인
			}
		}
		
		Recipe vo = new Recipe();
		vo.setRecipeCode(Integer.parseInt(request.getParameter("recipeCode")));
//		vo.setRecipeInfo(recipeInfo);
//		vo.setRecipeQty(recipeQty);
//		vo.setCalorie(calorie);
//		vo.set
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
