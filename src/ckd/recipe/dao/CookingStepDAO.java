package ckd.recipe.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ckd.common.jdbc.JDBCConnection;
import ckd.recipe.vo.CookingStep;
import ckd.recipe.vo.Ingredient;

public class CookingStepDAO {
	public int deleteCookingStepAll(Connection conn) throws SQLException {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String sql = "delete from cooking_steps";
		
		pstmt = conn.prepareStatement(sql);
		result = pstmt.executeUpdate();
		
		if(result > 0) {
			JDBCConnection.commit(conn);
		}
		JDBCConnection.close(pstmt);
		
		return result;
	}
	
	public int insertCookingStepAll(Connection conn, List<CookingStep> cookingSteps) throws SQLException {
		PreparedStatement pstmt = null;
		int resultCnt = 0;
		
		String sql = "insert into cooking_steps values(?, ?, ?, ?)";
		
		pstmt = conn.prepareStatement(sql);
		
		
		for(int i = 0; i < cookingSteps.size(); i++) {
			CookingStep cookingStep = cookingSteps.get(i);
			
			pstmt.setInt(1, cookingStep.getRecipeCode());
			pstmt.setInt(2, cookingStep.getCookingStep());
			pstmt.setString(3, cookingStep.getCookingDesc());
			pstmt.setString(4, cookingStep.getCookingImage());
			
			pstmt.addBatch();
		}
		
		int[] result = pstmt.executeBatch();
		System.out.println("resultLength : " + result.length);
		
		for(int i = 0; i < result.length; i++) {
			if(result[i] == -2) {
				resultCnt++;
			}
		}
		if(resultCnt == cookingSteps.size()) {
			JDBCConnection.commit(conn);
		}
		
		JDBCConnection.close(pstmt);
		
		System.out.println("resultCntDAO : " + resultCnt);
		return resultCnt;
	}
	
	
	public List<CookingStep> selectCookingStep(Connection conn, CookingStep cookingStepInput) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		CookingStep vo = null;
		List<CookingStep> list = null;
		
		System.out.println("inputVoCookingStepCode : " + cookingStepInput.getRecipeCode());
		String sql = "select c.cooking_step, c.cooking_desc, c.cooking_image"
				+ " from mealkit r join cooking_steps c"
				+ " on r.recipe_code = c.recipe_code"
				+ " where c.recipe_code = ?"
				+ " order by c.cooking_step";
		
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, cookingStepInput.getRecipeCode());
		rs = pstmt.executeQuery();
		
		if(rs.next()) {
			list = new ArrayList<CookingStep>();
			do {
				
				vo = new CookingStep();
				vo.setCookingStep(rs.getInt("cooking_step"));
				vo.setCookingDesc(rs.getString("cooking_desc"));
				vo.setCookingImage(rs.getString("cooking_image"));
				
				list.add(vo);
				
				
			}while(rs.next());
			
		}
		
		JDBCConnection.close(rs);
		JDBCConnection.close(pstmt);
		System.out.println("list : " +  list);
		
		return list;
	}
}
