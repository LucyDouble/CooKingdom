package ckd.review.service;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import ckd.common.jdbc.JDBCConnection;
import ckd.review.dao.ReviewDAO;
import ckd.review.vo.Review;

public class ReviewService {

	public int registerReview(Review review) {
		int result = 0;
		Connection conn = JDBCConnection.getConnection();
		result = new ReviewDAO().insertReview(conn, review);
		JDBCConnection.close(conn);
		return result;
	}
}
