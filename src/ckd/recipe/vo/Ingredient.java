package ckd.recipe.vo;

public class Ingredient {
	private int recipeCode;
	private String ingName;
	private String ingTypeName;
	private int ingTypeCode;
	private String ingQty;
	@Override
	public String toString() {
		return "Ingredient [recipeCode=" + recipeCode + ", ingName=" + ingName + ", ingTypeName=" + ingTypeName
				+ ", ingTypeCode=" + ingTypeCode + ", ingQty=" + ingQty + "]";
	}
	public int getRecipeCode() {
		return recipeCode;
	}
	public void setRecipeCode(int recipeCode) {
		this.recipeCode = recipeCode;
	}
	public String getIngName() {
		return ingName;
	}
	public void setIngName(String ingName) {
		this.ingName = ingName;
	}
	public String getIngTypeName() {
		return ingTypeName;
	}
	public void setIngTypeName(String ingTypeName) {
		this.ingTypeName = ingTypeName;
	}
	public int getIngTypeCode() {
		return ingTypeCode;
	}
	public void setIngTypeCode(int ingTypeCode) {
		this.ingTypeCode = ingTypeCode;
	}
	public String getIngQty() {
		return ingQty;
	}
	public void setIngQty(String ingQty) {
		this.ingQty = ingQty;
	}
	

}
