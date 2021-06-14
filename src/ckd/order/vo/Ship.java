package ckd.order.vo;

public class Ship {
	private int shipCode;
	private String name;
	private int phone;
	private String address;
	@Override
	public String toString() {
		return "Ship [shipCode=" + shipCode + ", name=" + name + ", phone=" + phone + ", address=" + address + "]";
	}
	public int getShipCode() {
		return shipCode;
	}
	public void setShipCode(int shipCode) {
		this.shipCode = shipCode;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
	
}
