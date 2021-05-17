package ckd.cart.vo;

public class Cart {
	private String cartNo;
	private String email;
	private int mealkitQty;
	private int recipeCode;
	private int totalPrice;

	public Cart() {
	}

	public Cart(String cartNo, String email, int mealkitQty, int recipeCode, int totalPrice) {
		super();
		this.cartNo = cartNo;
		this.email = email;
		this.mealkitQty = mealkitQty;
		this.recipeCode = recipeCode;
		this.totalPrice = totalPrice;
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

}
