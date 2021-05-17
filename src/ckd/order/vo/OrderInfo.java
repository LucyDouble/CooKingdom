package ckd.order.vo;

public class OrderInfo {
	private String orderCode;
	private int recipeCode;
	private int mealkitQty;
	@Override
	public String toString() {
		return "OrderInfo [orderCode=" + orderCode + ", recipeCode=" + recipeCode + ", mealkitQty=" + mealkitQty + "]";
	}
	public String getOrderCode() {
		return orderCode;
	}
	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}
	public int getRecipeCode() {
		return recipeCode;
	}
	public void setRecipeCode(int recipeCode) {
		this.recipeCode = recipeCode;
	}
	public int getMealkitQty() {
		return mealkitQty;
	}
	public void setMealkitQty(int mealkitQty) {
		this.mealkitQty = mealkitQty;
	}
	
}
