package ckd.review.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import ckd.review.vo.Review;

public class ReviewDAO {
	
	public int insertReview(Connection conn, Review review) {
		
//		private int reviewNo;
//		private String email;
//		private int recipeCode;
//		private String reviewSubject;
//		private Date reviewDate;
//		private String reviewContent;
//		private String reviewPhoto;
		
		int result = 0;
		String sql = "INSERT INTO review VALUES(SEQ_REVIEW.NEXTVAL,?,?,?,sysdate,?,?)";
		
		PreparedStatement pstmt = null;
		Review vo = new Review();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getEmail());
			pstmt.setInt(2, vo.getRecipeCode());
			pstmt.setString(3, vo.getReviewSubject());
			pstmt.setString(4, vo.getReviewContent());
			pstmt.setString(5, vo.getReviewPhoto());
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
}
