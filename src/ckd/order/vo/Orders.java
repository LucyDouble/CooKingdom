package ckd.order.vo;

import java.sql.Date;

public class Orders {
	private int orderCode;
	private String email;
	private int shipCode;
	private Date orderDate;
	private int totalPrice;
	@Override
	public String toString() {
		return "Orders [orderCode=" + orderCode + ", email=" + email + ", shipCode=" + shipCode + ", orderDate="
				+ orderDate + ", totalPrice=" + totalPrice + "]";
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
	
	
}
