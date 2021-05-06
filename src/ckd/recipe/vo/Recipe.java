package ckd.recipe.vo;

//RECIPE_CODE      NOT NULL NUMBER(7)     
//RECIPE_NAME      NOT NULL VARCHAR2(30)  
//TYPE_CODE        NOT NULL NUMBER(7)     
//TYPE_CAG         NOT NULL VARCHAR2(20)  
//RECIPE_INFO      NOT NULL VARCHAR2(100) 
//RECIPE_TYPE_CODE NOT NULL NUMBER(7)     
//RECIPE_CAG       NOT NULL VARCHAR2(20)  
//COOKING_TIME     NOT NULL VARCHAR2(20)  
//CALORIE          NOT NULL VARCHAR2(20)  
//RECIPE_QTY       NOT NULL VARCHAR2(20)  
//RECIPE_LEVEL     NOT NULL VARCHAR2(20)  
//ING_TYPE         NOT NULL VARCHAR2(30)  
//RECIPE_PRICE     NOT NULL VARCHAR2(20)  
//LIKES                     NUMBER(1)     
//RECIPE_URL                VARCHAR2(200) 


public class Recipe {
	private int recipeCode;
	private String recipeName;
	private int typeCode;
	private String typeCag;
	private String recipeInfo;
	private int recipeTypeCode;
	private String recipeCag;
	private String cookingTime;
	private String calorie;
	private String recipeQty;
	private String recipeLevel;
	private String ingType;
	private String recipePrice;
	private int likes;
	private String recipeUrl;
	
	
	
	@Override
	public String toString() {
		return "Recipe [recipeCode=" + recipeCode + ", recipeName=" + recipeName + ", typeCode=" + typeCode
				+ ", typeCag=" + typeCag + ", recipeInfo=" + recipeInfo + ", recipeTypeCode=" + recipeTypeCode
				+ ", recipeCag=" + recipeCag + ", cookingTime=" + cookingTime + ", calorie=" + calorie + ", recipeQty="
				+ recipeQty + ", recipeLevel=" + recipeLevel + ", ingType=" + ingType + ", recipePrice=" + recipePrice
				+ ", likes=" + likes + ", recipeUrl=" + recipeUrl + "]";
	}

	public int getRecipeCode() {
		return recipeCode;
	}

	public void setRecipeCode(int recipeCode) {
		this.recipeCode = recipeCode;
	}

	public String getRecipeName() {
		return recipeName;
	}

	public void setRecipeName(String recipeName) {
		this.recipeName = recipeName;
	}

	public int getTypeCode() {
		return typeCode;
	}

	public void setTypeCode(int typeCode) {
		this.typeCode = typeCode;
	}

	public String getTypeCag() {
		return typeCag;
	}

	public void setTypeCag(String typeCag) {
		this.typeCag = typeCag;
	}

	public String getRecipeInfo() {
		return recipeInfo;
	}

	public void setRecipeInfo(String recipeInfo) {
		this.recipeInfo = recipeInfo;
	}

	public int getRecipeTypeCode() {
		return recipeTypeCode;
	}

	public void setRecipeTypeCode(int recipeTypeCode) {
		this.recipeTypeCode = recipeTypeCode;
	}

	public String getRecipeCag() {
		return recipeCag;
	}

	public void setRecipeCag(String recipeCag) {
		this.recipeCag = recipeCag;
	}

	public String getCookingTime() {
		return cookingTime;
	}

	public void setCookingTime(String cookingTime) {
		this.cookingTime = cookingTime;
	}

	public String getCalorie() {
		return calorie;
	}

	public void setCalorie(String calorie) {
		this.calorie = calorie;
	}

	public String getRecipeQty() {
		return recipeQty;
	}

	public void setRecipeQty(String recipeQty) {
		this.recipeQty = recipeQty;
	}

	public String getRecipeLevel() {
		return recipeLevel;
	}

	public void setRecipeLevel(String recipeLevel) {
		this.recipeLevel = recipeLevel;
	}

	public String getIngType() {
		return ingType;
	}

	public void setIngType(String ingType) {
		this.ingType = ingType;
	}

	public String getRecipePrice() {
		return recipePrice;
	}

	public void setRecipePrice(String recipePrice) {
		this.recipePrice = recipePrice;
	}

	public int getLikes() {
		return likes;
	}

	public void setLikes(int likes) {
		this.likes = likes;
	}

	public String getRecipeUrl() {
		return recipeUrl;
	}

	public void setRecipeUrl(String recipeUrl) {
		this.recipeUrl = recipeUrl;
	}
	
	
	
}
