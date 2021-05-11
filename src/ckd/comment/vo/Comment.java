package ckd.comment.vo;

import java.sql.Date;

public class Comment {

	private int commentNo;
	private String email;
	private String nickname;
	private int recipeCode;
	private Date commentDate;
	private String commentContent;
	private int commentDepth;
	private int commentGroup;
	private int commentSorts;
	
	public Comment() {}

	public Comment(int commentNo, String email, String nickname, int recipeCode, Date commentDate,
			String commentContent, int commentDepth, int commentGroup, int commentSorts) {
		super();
		this.commentNo = commentNo;
		this.email = email;
		this.nickname = nickname;
		this.recipeCode = recipeCode;
		this.commentDate = commentDate;
		this.commentContent = commentContent;
		this.commentDepth = commentDepth;
		this.commentGroup = commentGroup;
		this.commentSorts = commentSorts;
	}

	@Override
	public String toString() {
		return "Comment [commentNo=" + commentNo + ", email=" + email + ", nickname=" + nickname + ", recipeCode="
				+ recipeCode + ", commentDate=" + commentDate + ", commentContent=" + commentContent + ", commentDepth="
				+ commentDepth + ", commentGroup=" + commentGroup + ", commentSorts=" + commentSorts + "]";
	}

	public int getCommentNo() {
		return commentNo;
	}

	public void setCommentNo(int commentNo) {
		this.commentNo = commentNo;
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

	public Date getCommentDate() {
		return commentDate;
	}

	public void setCommentDate(Date commentDate) {
		this.commentDate = commentDate;
	}

	public String getCommentContent() {
		return commentContent;
	}

	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}

	public int getCommentDepth() {
		return commentDepth;
	}

	public void setCommentDepth(int commentDepth) {
		this.commentDepth = commentDepth;
	}

	public int getCommentGroup() {
		return commentGroup;
	}

	public void setCommentGroup(int commentGroup) {
		this.commentGroup = commentGroup;
	}

	public int getCommentSorts() {
		return commentSorts;
	}

	public void setCommentSorts(int commentSorts) {
		this.commentSorts = commentSorts;
	}

	
}
