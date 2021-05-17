package ckd.cart.vo;

public class Cart {
	private String cartNo;
	private String email;
	private int mealkitQty;
	private int recipeCode;
	private int totalPrice;
	private String mealkitUrl;
	private String mealkit_name;
	private int mealkit_price;

	public Cart() {
	}

	public Cart(String cartNo, String email, int mealkitQty, int recipeCode, int totalPrice, String mealkitUrl,
			String mealkit_name, int mealkit_price) {
		super();
		this.cartNo = cartNo;
		this.email = email;
		this.mealkitQty = mealkitQty;
		this.recipeCode = recipeCode;
		this.totalPrice = totalPrice;
		this.mealkitUrl = mealkitUrl;
		this.mealkit_name = mealkit_name;
		this.mealkit_price = mealkit_price;
	}

	public String getCartNo() {
		return cartNo;
	}

	public void setCartNo(String cartNo) {
		this.cartNo = cartNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getMealkitQty() {
		return mealkitQty;
	}

	public void setMealkitQty(int mealkitQty) {
		this.mealkitQty = mealkitQty;
	}

	public int getRecipeCode() {
		return recipeCode;
	}

	public void setRecipeCode(int recipeCode) {
		this.recipeCode = recipeCode;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getMealkitUrl() {
		return mealkitUrl;
	}

	public void setMealkitUrl(String mealkitUrl) {
		this.mealkitUrl = mealkitUrl;
	}

	public String getMealkit_name() {
		return mealkit_name;
	}

	public void setMealkit_name(String mealkit_name) {
		this.mealkit_name = mealkit_name;
	}

	public int getMealkit_price() {
		return mealkit_price;
	}

	public void setMealkit_price(int mealkit_price) {
		this.mealkit_price = mealkit_price;
	}

}
