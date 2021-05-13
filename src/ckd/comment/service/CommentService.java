package ckd.comment.service;

import java.sql.Connection;
import java.util.List;

import ckd.comment.dao.CommentDAO;
import ckd.comment.vo.Comment;
import ckd.common.jdbc.JDBCConnection;

public class CommentService {

	
	public List<Comment> selectCommentList(int recipeCode){
		List<Comment> list = null;
		Connection conn = JDBCConnection.getConnection();
		list = new CommentDAO().selectCommentList(conn, recipeCode);
		JDBCConnection.close(conn);
		return list;
	}
	
	
	public int insertComment(Comment comment) {
		int result = 0;
		Connection conn = JDBCConnection.getConnection();
		result = new CommentDAO().insertComment(conn, comment);
		JDBCConnection.close(conn);
		return result;
	}
	
	public int updateComment( Comment comment ) {
		int result = 0;
		Connection conn = JDBCConnection.getConnection();
		result = new CommentDAO().updateComment(conn, comment);
		JDBCConnection.close(conn);
		return result;
	}
	
	public int deleteComment( Comment comment ) {
		int result = 0;
		Connection conn = JDBCConnection.getConnection();
		result = new CommentDAO().deleteComment(conn, comment);
		JDBCConnection.close(conn);
		return result;
	}
	
	public int getCommentCount(int recipeCode) {
		int result = 0;
		Connection conn = JDBCConnection.getConnection();
		result = new CommentDAO().getCommentCount(conn, recipeCode);
		JDBCConnection.close(conn);
		return result;
	}
	
}
