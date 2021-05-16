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

public class IngredientDAO {
	
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
	
	
	
	
	public List<Ingredient> selectIngredient(Connection conn, Ingredient ingredientInput) throws SQLException {
		PreparedStatement pstmt = null;
		List<Ingredient> list = null;
		ResultSet rs = null;
		Ingredient vo = null;
		
		String sql = "select r.recipe_code, i.ing_name, i.ing_ty_nm, i.ing_ty_code, i.ing_cpcty"
				+ " from mealkit r join ingredient i"
				+ " on r.recipe_code = i.recipe_code"
				+ " where r.recipe_code = ?"
				+ " order by i.ing_ty_code";
		
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, ingredientInput.getRecipeCode());
		rs = pstmt.executeQuery();
		
		if(rs.next()) {
			list = new ArrayList<Ingredient>();
			do {
				
				vo = new Ingredient();
				vo.setIngName(rs.getString("ing_name"));
				vo.setIngTypeName(rs.getString("ing_ty_nm"));
				vo.setIngTypeCode(rs.getInt("ing_ty_code"));
				vo.setIngQty(rs.getString("ing_cpcty"));
				
				list.add(vo);
				
			} while(rs.next());
		}
		
		JDBCConnection.close(rs);
		JDBCConnection.close(pstmt);
		
		return list;
	}
	
	public int insertIngredient(List<Ingredient> ingredients, Connection conn) throws SQLException  {
		int resultCnt = 0;
		PreparedStatement pstmt = null;
		
		String sql = "insert into ingredient values(?, ?, ?, ?, ?)";
		pstmt = conn.prepareStatement(sql);
		
		
		for(int i = 0; i < ingredients.size(); i++) {
			Ingredient ingredient = ingredients.get(i);
			System.out.println("DAO 재료 vo get(i) : " + ingredients.get(i));
			
			pstmt.setInt(1, ingredient.getRecipeCode());
			pstmt.setString(2, ingredient.getIngName());
			pstmt.setString(3, ingredient.getIngTypeName());
			System.out.println("DAO Insert 재료명 : " + ingredient.getIngTypeName());
			switch(ingredient.getIngTypeName()) {
			case "주재료" :
				pstmt.setInt(4, 3060001);
				System.out.println("주재료 입력 완료 ");
				break;
			case "부재료" :
				pstmt.setInt(4, 3060002);
				System.out.println("부재료 입력 완료 ");
				break;
			case "양념" :
				pstmt.setInt(4, 3060003);
				System.out.println("양념 입력 완료 ");
				break;
			default :
				System.out.println("DAO 재료 입력 실패");
				break;
			}
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
		
		return resultCnt;
		
		
	}
	
	public int deleteIngredient(Connection conn, int recipeCode) throws SQLException {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = "delete from ingredient where recipe_code = ?";
		pstmt = conn.prepareStatement(sql);
		
		pstmt.setInt(1, recipeCode);
		
		result = pstmt.executeUpdate();
		
		JDBCConnection.close(pstmt);
		
		System.out.println("DAO 재료 삭제 결과 : " + result);
		
		return result;
		
	}
}
