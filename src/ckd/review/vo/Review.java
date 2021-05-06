package ckd.review.vo;

import java.sql.Date;

public class Review {
	
	private int reviewNo;
	private String email;
	private String nickname;
	private int recipeCode;
	private String recipeName;
	private String reviewSubject;
	private Date reviewDate;
	private String reviewContent;
	private String reviewPhoto;
	private int hit;
	
	public Review() {}
	
	public Review(int reviewNo, String email, String nickname, int recipeCode, String recipeName, String reviewSubject,
			Date reviewDate, String reviewContent, String reviewPhoto, int hit) {
		super();
		this.reviewNo = reviewNo;
		this.email = email;
		this.nickname = nickname;
		this.recipeCode = recipeCode;
		this.recipeName = recipeName;
		this.reviewSubject = reviewSubject;
		this.reviewDate = reviewDate;
		this.reviewContent = reviewContent;
		this.reviewPhoto = reviewPhoto;
		this.hit = hit;
	}

	@Override
	public String toString() {
		return "Review [reviewNo=" + reviewNo + ", email=" + email + ", nickname=" + nickname + ", recipeCode="
				+ recipeCode + ", recipeName=" + recipeName + ", reviewSubject=" + reviewSubject + ", reviewDate="
				+ reviewDate + ", reviewContent=" + reviewContent + ", reviewPhoto=" + reviewPhoto + ", hit=" + hit
				+ "]";
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

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
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

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}

}
