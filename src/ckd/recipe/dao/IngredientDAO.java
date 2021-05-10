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
	public List<Ingredient> selectIngredient(Connection conn, Ingredient inputVo) throws SQLException {
		PreparedStatement pstmt = null;
		List<Ingredient> list = null;
		ResultSet rs = null;
		Ingredient vo = null;
		
		System.out.println("inputVoIngredientCode : " + inputVo.getRecipeCode());
		String sql = "select r.recipe_code, i.ing_name, i.ing_ty_nm, i.ing_cpcty"
				+ " from recipe r join ingredient i"
				+ " on r.recipe_code = i.recipe_code"
				+ " where r.recipe_code = ?";
		
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, inputVo.getRecipeCode());
		rs = pstmt.executeQuery();
		
		if(rs.next()) {
			list = new ArrayList<Ingredient>();
			do {
				
				vo = new Ingredient();
				vo.setRecipeCode(rs.getInt("recipe_code"));
				vo.setIngName(rs.getString("ing_name"));
				vo.setIngTypeName(rs.getString("ing_ty_nm"));
				vo.setIngQty("ing_cpcty");
				
				list.add(vo);
				
			} while(rs.next());
		}
		
		JDBCConnection.close(rs);
		JDBCConnection.close(pstmt);
		
		return list;
	}
}
