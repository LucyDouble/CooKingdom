package ckd.recipe.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ckd.common.jdbc.JDBCConnection;
import ckd.recipe.vo.Ingredient;
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
		
		return result;
	}
	public int deleteIngredientAll(Connection conn) throws SQLException {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String sql = "delete from ingredient";
		
		pstmt = conn.prepareStatement(sql);
		result = pstmt.executeUpdate();
		
		if(result > 0) {
			JDBCConnection.commit(conn);
		}
		JDBCConnection.close(pstmt);
		
		return result;
	}
	
	public int insertRecipeAll(Connection conn, List<Recipe> recipes) throws SQLException {
		PreparedStatement pstmt = null;
		int resultCnt = 0;
		
		String sql = "insert into recipe values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		pstmt = conn.prepareStatement(sql);
		
		
		for(int i = 0; i < recipes.size(); i++) {
			Recipe recipe = recipes.get(i);
			
			pstmt.setInt(1, recipe.getRecipeCode());
			pstmt.setString(2, recipe.getRecipeName());
			pstmt.setInt(3, recipe.getTypeCode());
			pstmt.setString(4, recipe.getTypeCag());
			pstmt.setString(5, recipe.getRecipeInfo());
			pstmt.setInt(6, recipe.getRecipeTypeCode());
			pstmt.setString(7, recipe.getRecipeCag());
			pstmt.setString(8, recipe.getCookingTime());
			pstmt.setString(9, recipe.getCalorie());
			pstmt.setString(10, recipe.getRecipeQty());
			pstmt.setString(11, recipe.getRecipeLevel());
			pstmt.setString(12, recipe.getIngType());
			pstmt.setString(13, recipe.getRecipeUrl());
			pstmt.setInt(14, recipe.getLikes());
			
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
		
		System.out.println("resultCntDAO : " + resultCnt);
		return resultCnt;
	}
	public int insertIngredientAll(Connection conn, List<Ingredient> ingredients) throws SQLException {
		PreparedStatement pstmt = null;
		int resultCnt = 0;
		
		String sql = "insert into ingredient values(?, ?, ?, ?, ?)";
		
		pstmt = conn.prepareStatement(sql);
		
		
		for(int i = 0; i < ingredients.size(); i++) {
			Ingredient ingredient = ingredients.get(i);
			
			pstmt.setInt(1, ingredient.getRecipeCode());
			pstmt.setString(2, ingredient.getIngName());
			pstmt.setString(3, ingredient.getIngTypeName());
			pstmt.setInt(4, ingredient.getIngTypeCode());
			pstmt.setString(5, ingredient.getIngQty());
			
			pstmt.addBatch();
		}
		
		int[] result = pstmt.executeBatch();
		System.out.println("resultLength : " + result.length);
		
		for(int i = 0; i < result.length; i++) {
			if(result[i] == -2) {
				resultCnt++;
			}
		}
		if(resultCnt == ingredients.size()) {
			JDBCConnection.commit(conn);
		}
		
		JDBCConnection.close(pstmt);
		
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
		
		return cnt;
	}
	
	public List<Recipe> selectRecipeList(Connection conn, int start, int end, String search) throws SQLException {
		List<Recipe> list = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql_1 = "(select * from recipe ";
		if(search == null) {
			sql_1 += " order by recipe_code) d";
		} else {
			sql_1 += " where recipe_name like '%" + search + "%'"
				+ " order by recipe_code) d";
		}
		
		String sql = "select * from "
		+ " (select rownum r, d.* from " + sql_1 + " ) "
		+ " where r >= ? and r <= ?";
					
		pstmt = null; rs = null;
		
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, start);
		pstmt.setInt(2, end);
		rs = pstmt.executeQuery();
		
		if(rs.next()) {
			list = new ArrayList<Recipe>();
			do {			
				Recipe vo = new Recipe();
				
//				RECIPE_CODE      NOT NULL NUMBER(7)     
//				RECIPE_NAME      NOT NULL VARCHAR2(30)  
//				TYPE_CODE        NOT NULL NUMBER(7)     
//				TYPE_CAG         NOT NULL VARCHAR2(20)  
//				RECIPE_INFO      NOT NULL VARCHAR2(400) 
//				RECIPE_TYPE_CODE NOT NULL NUMBER(7)     
//				RECIPE_CAG       NOT NULL VARCHAR2(40)  
//				COOKING_TIME     NOT NULL VARCHAR2(20)  
//				CALORIE          NOT NULL VARCHAR2(20)  
//				RECIPE_QTY       NOT NULL VARCHAR2(20)  
//				RECIPE_LEVEL     NOT NULL VARCHAR2(20)  
//				ING_TYPE         NOT NULL VARCHAR2(30)  
//				RECIPE_PRICE     NOT NULL VARCHAR2(20)  
//				LIKES                     NUMBER(1)     
//				RECIPE_URL                VARCHAR2(200)
				vo.setRecipeCode(rs.getInt("recipe_code"));		
				vo.setRecipeName(rs.getString("recipe_name"));	
				vo.setTypeCode(rs.getInt("type_code"));			
				vo.setTypeCag(rs.getString("type_cag"));		
				vo.setRecipeInfo(rs.getString("recipe_info"));
				vo.setRecipeTypeCode(rs.getInt("recipe_type_code"));
				vo.setRecipeCag(rs.getString("recipe_cag"));	
				vo.setCookingTime(rs.getString("cooking_time"));
				vo.setCalorie(rs.getString("calorie"));
				vo.setRecipeQty(rs.getString("recipe_qty"));
				vo.setRecipeLevel(rs.getString("recipe_level"));
				vo.setIngType(rs.getString("ing_type"));
				vo.setLikes(rs.getInt("likes"));
				vo.setRecipeUrl(rs.getString("recipe_url"));
				
				list.add(vo);
			} while(rs.next());
		}
		
		JDBCConnection.close(rs);
		JDBCConnection.close(pstmt);
		
		return list;
	}
	
	public Recipe selectRecipe(Connection conn, Recipe inputVo) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Recipe vo = null;
		
		String sql = "select * from recipe where recipe_code = ?";
//		System.out.println("inputVoRecipeCode : " + inputVo.getRecipeCode());
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, inputVo.getRecipeCode());
		rs = pstmt.executeQuery();
		
		if(rs.next()) {
			vo = new Recipe();
			vo.setRecipeCode(rs.getInt("recipe_code"));		
			vo.setRecipeName(rs.getString("recipe_name"));	
			vo.setTypeCode(rs.getInt("type_code"));			
			vo.setTypeCag(rs.getString("type_cag"));		
			vo.setRecipeInfo(rs.getString("recipe_info"));
			vo.setRecipeTypeCode(rs.getInt("recipe_type_code"));
			vo.setRecipeCag(rs.getString("recipe_cag"));	
			vo.setCookingTime(rs.getString("cooking_time"));
			vo.setCalorie(rs.getString("calorie"));
			vo.setRecipeQty(rs.getString("recipe_qty"));
			vo.setRecipeLevel(rs.getString("recipe_level"));
			vo.setIngType(rs.getString("ing_type"));
			vo.setLikes(rs.getInt("likes"));
			vo.setRecipeUrl(rs.getString("recipe_url"));
		}
		
		JDBCConnection.close(rs);
		JDBCConnection.close(pstmt);
		
		return vo;
	}
}
