package ckd.review.vo;

import java.sql.Date;

public class Review {
	
	private int reviewNo;
	private String email;
	private int recipeCode;
	private String reviewSubject;
	private Date reviewDate;
	private String reviewContent;
	private String reviewPhoto;
	
	public Review() {}
	
	public Review(int reviewNo, String email, int recipeCode, String reviewSubject, Date reviewDate,
			String reviewContent, String reviewPhoto) {
		super();
		this.reviewNo = reviewNo;
		this.email = email;
		this.recipeCode = recipeCode;
		this.reviewSubject = reviewSubject;
		this.reviewDate = reviewDate;
		this.reviewContent = reviewContent;
		this.reviewPhoto = reviewPhoto;
	}
	
	@Override
	public String toString() {
		return "Review [reviewNo=" + reviewNo + ", email=" + email + ", recipeCode=" + recipeCode + ", reviewSubject="
				+ reviewSubject + ", reviewDate=" + reviewDate + ", reviewContent=" + reviewContent + ", reviewPhoto="
				+ reviewPhoto + "]";
	}

	public int getReviewNo() {
		return reviewNo;
	}
	public void setReviewNo(int reviewNo) {
		this.reviewNo = reviewNo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getRecipeCode() {
		return recipeCode;
	}
	public void setRecipeCode(int recipeCode) {
		this.recipeCode = recipeCode;
	}
	public String getReviewSubject() {
		return reviewSubject;
	}
	public void setReviewSubject(String reviewSubject) {
		this.reviewSubject = reviewSubject;
	}
	public Date getReviewDate() {
		return reviewDate;
	}
	public void setReviewDate(Date reviewDate) {
		this.reviewDate = reviewDate;
	}
	public String getReviewContent() {
		return reviewContent;
	}
	public void setReviewContent(String reviewContent) {
		this.reviewContent = reviewContent;
	}
	public String getReviewPhoto() {
		return reviewPhoto;
	}
	public void setReviewPhoto(String reviewPhoto) {
		this.reviewPhoto = reviewPhoto;
	}
	
	
}
