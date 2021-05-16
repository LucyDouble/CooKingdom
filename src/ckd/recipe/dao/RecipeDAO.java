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
	
	// ----------------------------- JSON 입력관련 메소드  ---------------------------------------------
	
	public int deleteRecipeAll(Connection conn) throws SQLException {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String sql = "delete from mealkit";
		
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
		
		String sql = "insert into mealkit values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
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
			pstmt.setInt(15, recipe.getPrice());
			pstmt.setString(16, recipe.getRfilePath());
			
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

//	------------------------ 레시피 조회 관련 메소드 -----------------------------------------
	
	public int getRecipeCount(Connection conn, String search) throws SQLException {
		int cnt = 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select COUNT(*) from mealkit";
		if (search != null) {
			sql += " where recipe_name like '%" + search+ "%'";
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
		
		String sql_1 = "(select * from mealkit ";
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
				vo.setPrice(rs.getInt("price"));
				
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
		
		String sql = "select * from mealkit where recipe_code = ?";
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
			vo.setPrice(rs.getInt("price"));
		}
		
		JDBCConnection.close(rs);
		JDBCConnection.close(pstmt);
		
		return vo;
	}
	
	
//	------------------------ 여기까지 레시피 등록, 수정, 삭제  관련 메소드 -----------------------------------------
	
	public int insertRecipe(Recipe recipe, Connection conn) throws SQLException {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = "insert into mealkit values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, recipe.getRecipeCode());
		pstmt.setString(2, recipe.getRecipeName());
		switch(recipe.getTypeCag()) {
		case "한식" :
			pstmt.setInt(3, 3020001);
			break;
		case "서양" :
			pstmt.setInt(3, 3020002);
			break;
		case "일본" :
			pstmt.setInt(3, 3020003);
			break;
		case "중국" :
			pstmt.setInt(3, 3020004);
			break;
		default :
			System.out.println("DAO 레시피 입력 실패");
			break;
		}
		
		pstmt.setString(4, recipe.getTypeCag());
		pstmt.setString(5, recipe.getRecipeInfo());
		
		switch(recipe.getRecipeCag()) {
		case "밥" :
			pstmt.setInt(6, 3010001);
			break;
		case "밑반찬/김치" :
			pstmt.setInt(6, 3010002);
			break;
		case "찜" :
			pstmt.setInt(6, 3010003);
			break;
		case "부침" :
			pstmt.setInt(6, 3010004);
			break;
		case "조림" :
			pstmt.setInt(6, 3010005);
			break;
		case "구이" :
			pstmt.setInt(6, 3010006);
			break;
		case "튀김/커틀릿" :
			pstmt.setInt(6, 3010007);
			break;
		case "볶음" :
			pstmt.setInt(6, 3010008);
			break;
		case "찌개/전골/스튜" :
			pstmt.setInt(6, 3010009);
			break;
		case "만두/면류" :
			pstmt.setInt(6, 3010010);
			break;
		case "나물/생채/샐러드" :
			pstmt.setInt(6, 3010011);
			break;
		case "그라탕/리조또" :
			pstmt.setInt(6, 3010012);
			break;
		default :
			System.out.println("DAO 레시피 입력 실패");
			break;
		}
		
		pstmt.setString(7, recipe.getRecipeCag());
		pstmt.setString(8, recipe.getCookingTime());
		pstmt.setString(9, recipe.getCalorie());
		pstmt.setString(10, recipe.getRecipeQty());
		pstmt.setString(11, recipe.getRecipeLevel());
		pstmt.setString(12, "x");
		pstmt.setString(13, recipe.getRecipeUrl());
		pstmt.setInt(14, 0);
		pstmt.setInt(15, recipe.getPrice());
		pstmt.setString(16, recipe.getRfilePath());
		
		System.out.println("pstmt 직전 레시피의 레시피 코드 : " + recipe.getRecipeCode());
		
		result = pstmt.executeUpdate();
		
		JDBCConnection.close(pstmt);
		

		
		return result;
		
	}
	
	public int deleteRecipe(Connection conn, int recipeCode) throws SQLException {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = "delete from mealkit where recipe_code = ?";
		
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, recipeCode);
		
		result = pstmt.executeUpdate();
		
		JDBCConnection.close(pstmt);
		
		return result;
	}
}
