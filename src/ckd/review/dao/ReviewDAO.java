package ckd.review.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ckd.common.jdbc.JDBCConnection;
import ckd.review.vo.Review;

public class ReviewDAO {
	private Statement stmt = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	private void close() {
		try {
			if (rs != null) {
				rs.close();
			}
			if (pstmt != null) {
				pstmt.close();
			}
			if (stmt != null) {
				stmt.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
	/*selectAll*/
	public List<Review> selectReviewList(Connection conn){
		
//		private int reviewNo;
//		private String email;
//		private String nickname;
//		private int recipeCode;
//		private String recipeName;
//		private String reviewSubject;
//		private Date reviewDate;
//		private String reviewContent;
//		private String reviewPhoto;
//		private int hit;
			
		List<Review> list = null;
		String sql = "SELECT REVIEW_NO, NICKNAME, RECIPE_NAME, REVIEW_SUBJECT, REVIEW_CONTENT, REVIEW_PHOTO, REVIEW_DATE, HIT " + 
				"FROM REVIEW LEFT JOIN USERS " + 
				"ON review.email = users.email " + 
				"LEFT JOIN RECIPE " + 
				"ON review.recipe_code = recipe.recipe_code " +
				"ORDER BY REVIEW_NO DESC";
		pstmt = null; rs = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				list = new ArrayList<Review>();
				do {
					Review vo = new Review();
					vo.setReviewNo(rs.getInt("REVIEW_NO"));
					vo.setNickname(rs.getString("NICKNAME"));
					vo.setRecipeName(rs.getString("RECIPE_NAME"));

					vo.setReviewSubject(rs.getString("REVIEW_SUBJECT"));
					vo.setReviewContent(rs.getString("REVIEW_CONTENT"));
					vo.setReviewPhoto(rs.getString("REVIEW_PHOTO"));
					vo.setReviewDate(rs.getDate("REVIEW_DATE"));
					vo.setHit(rs.getInt("HIT"));
					list.add(vo);
				}while(rs.next());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}	
		return list;
	}

	
	/*insert*/
	public int insertReview(Connection conn, Review review) {
		
//		private int reviewNo;
//		private String email;
//		private int recipeCode;
//		private String reviewSubject;
//		private Date reviewDate;
//		private String reviewContent;
//		private String reviewPhoto;
// 		private int hit;
		
		int result = 0;
		String sql = "INSERT INTO review VALUES((select NVL(max(REVIEW_NO),0)+1 from review),?,?,?,sysdate,?,?,0)";
		
		pstmt = null; 
					
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, review.getEmail());
			pstmt.setInt(2, review.getRecipeCode());
			pstmt.setString(3, review.getReviewSubject());
			pstmt.setString(4, review.getReviewContent());
			pstmt.setString(5, review.getReviewPhoto());

			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		return result;
	}
}
