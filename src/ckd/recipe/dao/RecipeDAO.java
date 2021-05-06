package ckd.recipe.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import ckd.common.jdbc.JDBCConnection;
import ckd.recipe.vo.Recipe;

public class RecipeDAO {
	
	public int deleteRecipeAll(Connection conn) throws SQLException {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String sql = "delete from recipe";
		
		pstmt = conn.prepareStatement(sql);
		result = pstmt.executeUpdate();
		
		if(result > 0) {
			JDBCConnection.commit(conn);
		}
		JDBCConnection.close(pstmt);
		JDBCConnection.close(conn);
		
		return result;
	}
	
	public int insertRecipeAll(Connection conn, List<Recipe> recipes) throws SQLException {
		PreparedStatement pstmt = null;
		int resultCnt = 0;
		
		String sql = "insert into recipe values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		pstmt = conn.prepareStatement(sql);
		
		
		for(int i = 0; i < recipes.size(); i++) {
			Recipe recipe = recipes.get(i);
			
			pstmt.setInt(1, recipe.getRecipeCode());
			pstmt.setString(2, recipe.getRecipeName());
			pstmt.setInt(3, recipe.getTypeCode());
			pstmt.setString(4, recipe.getTypeCag());
			pstmt.setString(5, recipe.getRecipeInfo());
			pstmt.setInt(6, recipe.getRecipeCode());
			pstmt.setString(7, recipe.getRecipeCag());
			pstmt.setString(8, recipe.getCookingTime());
			pstmt.setString(9, recipe.getCalorie());
			pstmt.setString(10, recipe.getRecipeQty());
			pstmt.setString(11, recipe.getRecipeLevel());
			pstmt.setString(12, recipe.getIngType());
			pstmt.setString(13, recipe.getRecipePrice());
			pstmt.setInt(14, recipe.getLikes());
			pstmt.setString(15, recipe.getRecipeUrl());
			
			pstmt.addBatch();
		}
		
		int[] result = pstmt.executeBatch();
		System.out.println("resultLength : " + result.length);
		
		for(int i = 0; i < result.length; i++) {
			if(result[i] == -2) {
				resultCnt++;
			}
		}
		if(resultCnt == recipes.size()) {
			JDBCConnection.commit(conn);
		}

		JDBCConnection.close(pstmt);
		JDBCConnection.close(conn);
		
		System.out.println("resultCntDAO : " + resultCnt);
		return resultCnt;
	}
	
	public int getRecipeCount(Connection conn, String search) throws SQLException {
		int cnt = 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select COUNT(*) from recipe";
		if (search != null) {
			sql += " where bsubject like '%" + search+ "%' or bcontent like '%"+ search+ "%'";
		}
		
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		if(rs.next()) {
			cnt = rs.getInt(1);
		}
		
		JDBCConnection.close(rs);
		JDBCConnection.close(pstmt);
		JDBCConnection.close(conn);
		
		return cnt;
	}
}
