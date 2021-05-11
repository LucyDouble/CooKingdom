package ckd.recipe.vo;

//RECIPE_ID        NUMBER(7)     
//COOKING_IMAGE    VARCHAR2(200) 
//COOKING_DESC     VARCHAR2(400) 
//COOKING_STEP     NUMBER(2)     

public class CookingStep {
	private int recipeCode;
	private int CookingStep;
	private String CookingDesc;
	private String CookingImage;
	
	
	@Override
	public String toString() {
		return "CookingStep [recipeCode=" + recipeCode + ", CookingImage=" + CookingImage + ", CookingDesc="
				+ CookingDesc + ", CookingStep=" + CookingStep + "]";
	}


	public int getRecipeCode() {
		return recipeCode;
	}


	public void setRecipeCode(int recipeCode) {
		this.recipeCode = recipeCode;
	}


	public String getCookingImage() {
		return CookingImage;
	}


	public void setCookingImage(String cookingImage) {
		CookingImage = cookingImage;
	}


	public String getCookingDesc() {
		return CookingDesc;
	}


	public void setCookingDesc(String cookingDesc) {
		CookingDesc = cookingDesc;
	}


	public int getCookingStep() {
		return CookingStep;
	}


	public void setCookingStep(int cookingStep) {
		CookingStep = cookingStep;
	}
	
	
}
