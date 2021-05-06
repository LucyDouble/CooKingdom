package ckd.recipe.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import ckd.common.jdbc.JDBCConnection;
import ckd.recipe.dao.RecipeDAO;
import ckd.recipe.vo.Recipe;

public class RecipeService {
	
	public int removeRecipeAll() throws SQLException {
		int result = 0;
		Connection conn = JDBCConnection.getConnection();
		result = new RecipeDAO().deleteRecipeAll(conn);
		JDBCConnection.close(conn);
		return result;
	}
	
	public int regesterRecipeAll(List<Recipe> recipes) throws SQLException {
		int result = 0;
		Connection conn = JDBCConnection.getConnection();
		result = new RecipeDAO().insertRecipeAll(conn, recipes);
		JDBCConnection.close(conn);
		return result;
	}
	
	public int getRecipeCount(String search) throws SQLException {
		int result = 0;
		Connection conn = JDBCConnection.getConnection();
		result = new RecipeDAO().getRecipeCount(conn, search);
		JDBCConnection.close(conn);
		return result;
	}
}
