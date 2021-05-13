package ckd.comment.controller;

import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import ckd.comment.service.CommentService;
import ckd.comment.vo.Comment;
import ckd.review.vo.Review;

/**
 * Servlet implementation class CommentListInquiry
 */
@WebServlet("/commentListInquiry")
public class CommentListInquiry extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommentListInquiry() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		execute(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		execute(request, response);
	}
	
	
	private void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		CommentService scv = new CommentService();
		
		int recipeCode = Integer.parseInt(request.getParameter("recipeCode"));
		int cnt = 0;   // 총 글 개수
		cnt = scv.getCommentCount(recipeCode);
		
		
		
		List<Comment> list = null;
		list =scv.selectCommentList(recipeCode);
		
		// JsonObject 생성
		JsonObject jsonObject = new JsonObject();
		jsonObject.addProperty("cnt", cnt);
		try {
			JsonArray jArray = new JsonArray();
			for(int i=0; i<list.size(); i++) {
				JsonObject jobj = new JsonObject();
				jobj.addProperty("commentNo", list.get(i).getCommentNo());
				jobj.addProperty("email", list.get(i).getEmail());
				jobj.addProperty("nickname", list.get(i).getNickname());
				jobj.addProperty("commentDate", list.get(i).getCommentDate());				
				jobj.addProperty("commentContent", list.get(i).getCommentContent());
				jArray.add(jobj);
			}
			jsonObject.add("commentList", jArray);
		} catch (Exception e) {
			e.printStackTrace();
		}
		                
		        
		// Parse Pretty
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String jsonOutput = gson.toJson(jsonObject);
		
		response.getWriter().write(jsonOutput.toString());
		
		
		
		
	}
}
