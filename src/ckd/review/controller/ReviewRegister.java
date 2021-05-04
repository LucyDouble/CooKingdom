package ckd.review.controller;

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

import ckd.review.service.ReviewService;
import ckd.review.vo.Review;

/**
 * Servlet implementation class ReviewRegister
 */
@WebServlet("/reviewRegister")
public class ReviewRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewRegister() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("/WEB-INF/main/index.jsp");
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		execute(request, response);
	}

	private void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ReviewService rsv = new ReviewService();
		
		System.out.println("들어옴!");
		String saveDirectory = getServletContext().getRealPath("/files"); // 웹서버상의 절대경로.
		String encType = "UTF-8";
		int maxSize = 5 * 1024 * 1024;

		try {
			// saveDirectory 폴더가 없다면 생성
			File path = new File(saveDirectory);
			System.out.println("path : " + path);
			if (!path.exists()) {
				path.mkdirs(); 
			}

			// saveDirectory위치에 파일을 저장하는 코드
			MultipartRequest mReq = new MultipartRequest(request, saveDirectory, maxSize, encType, new DefaultFileRenamePolicy());

			// *****저장이 잘 되었는지 확인하는 코드*****
			// 저장된 file의 정보(file의 경로 + file name)를 읽어오기 --> DB에 저장할 내용임
			String fileName = "";
			Enumeration<?> files = mReq.getFileNames();
			while (files.hasMoreElements()) {
				String name = (String) files.nextElement(); // input type="file" name="xxxx" //name부분을 String에 넣기. 즉,
															
				fileName = mReq.getFilesystemName(name); // 서버에 저장된 파일이름이 fileName에 들어감 
														 
				File f1 = mReq.getFile(name); // 서버에 file이 정상적으로 저장되어있는지 다시 읽어와서 확인함. //이름만 저장되고 파일이 없는지 확인하는 코드임!!
				if (f1 == null) {
					System.out.println("파일 업로드 실패!");
				} else {
					System.out.println("파일 업로드 성공!" + f1.length()); // 파일 크기 확인
				}
			}
			
			Review vo = new Review();
			vo.setEmail(mReq.getParameter("email"));
			vo.setRecipeCode(Integer.parseInt(mReq.getParameter("recipeCode")));
			vo.setReviewSubject(mReq.getParameter(""));
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
