package ckd.review.service;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import ckd.common.jdbc.JDBCConnection;
import ckd.review.dao.ReviewDAO;
import ckd.review.vo.Review;

public class ReviewService {

	public List<Review> inquiryReviewList(int start, int end, int recipeCode){
		List<Review> list = null;
		Connection conn = JDBCConnection.getConnection();
		list = new ReviewDAO().selectReviewList(conn, start, end, recipeCode);
		JDBCConnection.close(conn);
		return list;
	}
	
	public int registerReview(Review review) {
		int result = 0;
		Connection conn = JDBCConnection.getConnection();
		result = new ReviewDAO().insertReview(conn, review);
		JDBCConnection.close(conn);
		return result;
	}
	
	public int modifyReview(Review review) {
		int result = 0;
		Connection conn = JDBCConnection.getConnection();
		result = new ReviewDAO().updateReview(conn, review);
		JDBCConnection.close(conn);
		return result;
	}
	
	public int removeReview(Review review) {
		int result = 0;
		Connection conn = JDBCConnection.getConnection();
		result = new ReviewDAO().deleteReview(conn, review);
		JDBCConnection.close(conn);
		return result;
	}
	
	public int getReviewCount(int recipeCode) {
		int cnt = 0;
		Connection conn = JDBCConnection.getConnection();
		cnt = new ReviewDAO().getReviewCount(conn, recipeCode);
		JDBCConnection.close(conn);
		return cnt;
	}
	
	public int getReviewHit(int reviewNo) {
		int result = 0;
		Connection conn = JDBCConnection.getConnection();
		result = new ReviewDAO().getReviewHit(conn, reviewNo);
		JDBCConnection.close(conn);
		return result;
	}
}
