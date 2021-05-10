package ckd.order.vo;

import java.sql.Date;

public class OrderMember {
	private String email;
	private String nickname;
	private String name;
	private String password;
	private Date birth;
	private int	phone;
	private String address;
	
	
	@Override
	public String toString() {
		return "OrderMember [email=" + email + ", nickname=" + nickname + ", name=" + name + ", password=" + password
				+ ", birth=" + birth + ", phone=" + phone + ", address=" + address + "]";
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
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
