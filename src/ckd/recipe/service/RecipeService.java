package ckd.recipe.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import ckd.common.jdbc.JDBCConnection;
import ckd.recipe.dao.CookingStepDAO;
import ckd.recipe.dao.IngredientDAO;
import ckd.recipe.dao.RecipeDAO;
import ckd.recipe.vo.CookingStep;
import ckd.recipe.vo.Ingredient;
import ckd.recipe.vo.Recipe;

public class RecipeService {
	
//	------------------------ JSON 입력 관련 메소드 -----------------------------------------
	
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
		result = new IngredientDAO().deleteIngredientAll(conn);
		JDBCConnection.close(conn);
		return result;
	}
	public int removeCookingStepAll() throws SQLException {
		int result = 0;
		Connection conn = JDBCConnection.getConnection();
		result = new CookingStepDAO().deleteCookingStepAll(conn);
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
		result = new IngredientDAO().insertIngredientAll(conn, ingredients);
		JDBCConnection.close(conn);
		return result;
	}
	public int regesterCookingStepAll(List<CookingStep> cookingSteps) throws SQLException {
		int result = 0;
		Connection conn = JDBCConnection.getConnection();
		result = new CookingStepDAO().insertCookingStepAll(conn, cookingSteps);
		JDBCConnection.close(conn);
		return result;
	}
	
//	------------------------ 조회 관련 메소드 -----------------------------------------
	
	
//	------------------------ 레시피 ------------------------------------------------
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
	
	public Recipe inqueryRecipe(Recipe recipeInput) throws SQLException {
		Connection conn = JDBCConnection.getConnection();
		Recipe vo = new RecipeDAO().selectRecipe(conn, recipeInput);
		JDBCConnection.close(conn);
		return vo;

		
//	---------------------- 재료 --------------------------------
	}
	public List<Ingredient> inqueryIngredient(Ingredient ingredientInput) throws SQLException {
		Connection conn = JDBCConnection.getConnection();
		List<Ingredient> list = new IngredientDAO().selectIngredient(conn, ingredientInput);
		JDBCConnection.close(conn);
		return list;
//	----------------------- 조리 과정 --------------------------------
	}
	public List<CookingStep> inqueryCookingStep(CookingStep cookingStepInput) throws SQLException {
		Connection conn = JDBCConnection.getConnection();
		List<CookingStep> list = new CookingStepDAO().selectCookingStep(conn, cookingStepInput);
		JDBCConnection.close(conn);
		return list;
	}
	
	
//	------------------------ 레시피 등록, 수정, 삭제  관련 메소드 -----------------------------------------
	
//	-------------------------- 레시피 -----------------------------------------
	
	public int registerRecipe(Recipe recipe) throws SQLException {
		int result = 0;
		Connection conn = JDBCConnection.getConnection();
		result = new RecipeDAO().insertRecipe(recipe, conn);
		JDBCConnection.close(conn);
		return result;
	}
	
	public int removeRecipe(int recipeCode) throws SQLException {
		int result = 0;
		Connection conn = JDBCConnection.getConnection();
		result = new RecipeDAO().deleteRecipe(conn, recipeCode);
		JDBCConnection.close(conn);
		return result;
	}
	
//	-------------------------- 재료 -----------------------------------------
	
	public int registerIngredient(List<Ingredient> ingredients) throws SQLException {
		int result = 0;
		Connection conn = JDBCConnection.getConnection();
		result = new IngredientDAO().insertIngredient(ingredients, conn);
		JDBCConnection.close(conn);
		return result;
	}
	public int removeIngredient(int recipeCode) throws SQLException {
		int result = 0;
		Connection conn = JDBCConnection.getConnection();
		result = new IngredientDAO().deleteIngredient(conn, recipeCode);
		JDBCConnection.close(conn);
		return result;
	}
}
