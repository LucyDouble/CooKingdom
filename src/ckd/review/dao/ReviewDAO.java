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
	
	/*review page split*/
	public List<Review> selectReviewList(Connection conn, int start, int end, int recipeCode){
		List<Review> list = null;
		String sql_1 ="(SELECT REVIEW_NO, review.email, NICKNAME, RECIPE_NAME, REVIEW_SUBJECT, REVIEW_CONTENT, REVIEW_PHOTO, REVIEW_DATE, HIT " + 
				"FROM REVIEW LEFT JOIN USERS " + 
				"ON review.email = users.email " + 
				"LEFT JOIN RECIPE " + 
				"ON review.recipe_code = recipe.recipe_code " + 
				"where review.recipe_code = ? " +   
				"ORDER BY REVIEW_NO DESC) D " ;
		
		String sql_2 = "(SELECT ROWNUM R, D.* FROM " + sql_1 +") " ;
				
		String sql = "SELECT * FROM " + sql_2 +" WHERE R >= ? AND R<= ?";

		pstmt = null; rs = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, recipeCode);
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				list = new ArrayList<Review>();
				do {
					Review vo = new Review();
					vo.setReviewNo(rs.getInt("REVIEW_NO"));
					vo.setEmail(rs.getString("email"));
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
		} catch (Exception e) {
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
	
	/*Update*/
	public int updateReview(Connection conn, Review review) {
		int result = 0;
		String sql = "UPDATE REVIEW SET REVIEW_SUBJECT = ?, REVIEW_CONTENT = ?, REVIEW_PHOTO = ? WHERE REVIEW_NO = ? AND RECIPE_CODE = ? AND EMAIL = ?";
		
		pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, review.getReviewSubject());
			pstmt.setString(2, review.getReviewContent());
			pstmt.setString(3, review.getReviewPhoto());
			pstmt.setInt(4, review.getReviewNo());
			pstmt.setInt(5, review.getRecipeCode());
			pstmt.setString(6, review.getEmail());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		return result;
	}
	
	/*DELETE*/
	public int deleteReview(Connection conn, Review review) {
		int result = 0;
		String sql = "DELETE FROM REVIEW WHERE REVIEW_NO = ? AND RECIPE_CODE= ?";
		
		pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, review.getReviewNo());
			pstmt.setInt(2, review.getRecipeCode());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		return result;
	}
	
	
	/*review total Count*/
	public int getReviewCount(Connection conn, int recipeCode) {
		int cnt = 0;
		String sql = "select COUNT(*) from review where review.recipe_code = ?";
		

		pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, recipeCode);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				cnt = rs.getInt(1);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}		
		return cnt;
	}
	
	/*review Count*/
	public int getReviewHit(Connection conn, int reviewNo) {
		int result = 0;
		String sql = "UPDATE REVIEW SET hit = hit+1 WHERE REVIEW_NO = ?";	
		pstmt = null; rs = null;
		try {
			pstmt= conn.prepareStatement(sql);
			pstmt.setInt(1, reviewNo);
			result = pstmt.executeUpdate();
			if(result>0) {
				close();
				sql = "select hit from REVIEW where REVIEW_NO = ?";
				pstmt= conn.prepareStatement(sql);
				pstmt.setInt(1, reviewNo);
				rs = pstmt.executeQuery();
				if(rs.next()) {
					result = rs.getInt(1);					
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		return result;
	}
	
	
	
}
