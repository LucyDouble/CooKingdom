package ckd.comment.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ckd.comment.vo.Comment;

public class CommentDAO {
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
	
	
	public List<Comment> selectCommentList(Connection conn, int recipeCode){
		List<Comment> list = null;
		String sql = "SELECT COMMENT_NO,comments.email, NICKNAME, to_char(COMMENT_DATE, 'YY-MM-DD HH24:MI:SS')as cDate, COMMENT_CONTENT, COMMENT_DEPTH, COMMENT_GROUP, COMMENT_SORTS "
				+ "FROM COMMENTS LEFT JOIN USERS "
				+ "ON comments.email = users.email "
				+ "WHERE RECIPE_CODE = ?"
				+ "ORDER BY COMMENT_NO DESC";
		pstmt = null; rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, recipeCode);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				list = new ArrayList<Comment>();
				do {
					Comment comment = new Comment();
					comment.setCommentNo(rs.getInt("COMMENT_NO"));
					comment.setEmail(rs.getString("email"));
					comment.setNickname(rs.getString("NICKNAME"));
					comment.setCommentDate(rs.getString("cDate"));
					comment.setCommentContent(rs.getString("COMMENT_CONTENT"));
					comment.setCommentDepth(rs.getInt("COMMENT_DEPTH"));
					comment.setCommentGroup(rs.getInt("COMMENT_GROUP"));
					comment.setCommentSorts(rs.getInt("COMMENT_SORTS"));			
					list.add(comment);
				}while(rs.next());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}

		return list;
	}
	
	
	public int insertComment(Connection conn, Comment comment) {

//		private int commentNo;
//		private String email;
//		private int recipeCode;
//		private Date commentDate;
//		private String commentContent;
//		private int commentDepth;
//		private int commentGroup;
//		private int commentSorts;
		
		int result = 0;
		int commentDepth = 0;
		int commentSorts = 0;
		int commentGroup = 0;
		
		//COMMENT_NO
		String sqlMaxBno = "select NVL(max(COMMENT_NO),0)+1 from COMMENTS";
		int max = 1;
		
		//댓글 등록
		String sql = "INSERT INTO COMMENTS VALUES(?,?,?,SYSDATE,?,?,?,?)";
		
		//대댓글 등록
		String sqlUpdate = "UPDATE COMMENTS SET "
				+ "COMMENT_DEPTH = 1 , SORTS = SORTS+1"
				+ "WHERE COMMENT_NO <> COMMENT_GROUP AND COMMENT_GROUP =?";
				
		pstmt = null; rs= null;
		
		try {
			//다음  COMMENT_NO 번호 붙이기
			pstmt = conn.prepareStatement(sqlMaxBno); 
			rs = pstmt.executeQuery(); //sql문 돌려서
			if(rs.next()) {
				max = rs.getInt(1); 
			}else {
				System.out.println("매우 이상한 상황..확인바람");
				return 0;
			}
			close();  // 다음에 나올 글쓰기 쿼리를 위해 기존 것을 삭제함.
					
//			if(comment.getCommentNo() != 0) {
//				pstmt = conn.prepareStatement(sqlUpdate);
//				pstmt.setInt(1, comment.getCommentGroup());
//				result = pstmt.executeUpdate();
//				close();
//				commentGroup = comment.getCommentGroup();
//				commentDepth = comment.getCommentDepth();
//				commentSorts = comment.getCommentSorts();
//			}else {
//				commentGroup = max;
//			}
	
			
			//댓글쓰기
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, max);
			pstmt.setString(2, comment.getEmail());
			pstmt.setInt(3, comment.getRecipeCode());
			pstmt.setString(4, comment.getCommentContent());
			pstmt.setInt(5, commentDepth);
			pstmt.setInt(6, max);
			pstmt.setInt(7, commentSorts);
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		return result;
	} 
	
	/*Update*/
	public int updateComment(Connection conn, Comment comment ) {
		int result = 0;
		String sql = "UPDATE COMMENTS SET COMMENT_CONTENT = ? WHERE COMMENT_NO = ? ";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, comment.getCommentContent());
			pstmt.setInt(2, comment.getCommentNo());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	
	/*DELETE*/
	public int deleteComment(Connection conn, Comment comment ) {
		int result = 0;
		String sql = "DELETE FROM COMMENTS WHERE COMMENT_NO = ? AND RECIPE_CODE=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, comment.getCommentNo());
			pstmt.setInt(2, comment.getRecipeCode());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		
		return result;
	}
	
	
	/*comment total Count*/
	public int getCommentCount(Connection conn, int recipeCode) {
		int cnt = 0;
		String sql = "select COUNT(*) from COMMENTS where comments.recipe_code = ?";
		

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
	
	
	
}
