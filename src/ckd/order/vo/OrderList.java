package ckd.order.vo;

import java.sql.Date;

public class OrderList {
	private int orderCode;
	private String email;
	private int shipCode;
	private Date orderDate;
	private int totalPrice;
	private int recipeCode;
	private int mealkitQty;
	private String recipeName;
	private String recipeUrl;
	private int price;
	@Override
	public String toString() {
		return "OrderList [orderCode=" + orderCode + ", email=" + email + ", shipCode=" + shipCode + ", orderDate="
				+ orderDate + ", totalPrice=" + totalPrice + ", recipeCode=" + recipeCode + ", mealkitQty=" + mealkitQty
				+ ", recipeName=" + recipeName + ", recipeUrl=" + recipeUrl + ", price=" + price + "]";
	}
	public int getOrderCode() {
		return orderCode;
	}
	public void setOrderCode(int orderCode) {
		this.orderCode = orderCode;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getShipCode() {
		return shipCode;
	}
	public void setShipCode(int shipCode) {
		this.shipCode = shipCode;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public int getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
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
	public String getRecipeName() {
		return recipeName;
	}
	public void setRecipeName(String recipeName) {
		this.recipeName = recipeName;
	}
	public String getRecipeUrl() {
		return recipeUrl;
	}
	public void setRecipeUrl(String recipeUrl) {
		this.recipeUrl = recipeUrl;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
}
