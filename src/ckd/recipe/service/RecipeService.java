package ckd.recipe.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import ckd.common.jdbc.JDBCConnection;
import ckd.recipe.dao.IngredientDAO;
import ckd.recipe.dao.RecipeDAO;
import ckd.recipe.vo.Ingredient;
import ckd.recipe.vo.Recipe;

public class RecipeService {
	
	public int removeRecipeAll() throws SQLException {
		int result = 0;
		Connection conn = JDBCConnection.getConnection();
		result = new RecipeDAO().deleteRecipeAll(conn);
		JDBCConnection.close(conn);
		return result;
	}
	public int removeIngredientAll() throws SQLException {
		int result = 0;
		Connection conn = JDBCConnection.getConnection();
		result = new RecipeDAO().deleteIngredientAll(conn);
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
	public int regesterIngredientAll(List<Ingredient> ingredients) throws SQLException {
		int result = 0;
		Connection conn = JDBCConnection.getConnection();
		result = new RecipeDAO().insertIngredientAll(conn, ingredients);
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
	
	public List<Recipe> inqueryRecipeList(int start, int end, String search) throws SQLException {
		Connection conn = JDBCConnection.getConnection();
		List<Recipe> list = new RecipeDAO().selectRecipeList(conn, start, end, search);
		JDBCConnection.close(conn);
		return list;
	}
	
	public Recipe inqueryRecipe(Recipe inputVo) throws SQLException {
		Connection conn = JDBCConnection.getConnection();
		Recipe vo = new RecipeDAO().selectRecipe(conn, inputVo);
		JDBCConnection.close(conn);
		return vo;
	}
	public List<Ingredient> inqueryIngredient(Ingredient inputVo) throws SQLException {
		Connection conn = JDBCConnection.getConnection();
		List<Ingredient> list = new IngredientDAO().selectIngredient(conn, inputVo);
		JDBCConnection.close(conn);
		return list;
	}
}
