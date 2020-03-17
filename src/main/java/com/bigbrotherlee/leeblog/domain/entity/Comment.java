package com.bigbrotherlee.leeblog.domain.entity;

import java.util.Date;

public class Comment {
    private Integer commentId;
    
    private Integer commentArticle;
    
    private Date commentCreateDate;

    private Boolean commentHide;

    private String commentOtherEmail;

    private String commentOtherName;

    private String commentOtherConnect;

    private String commentContent;

	public Integer getCommentId() {
		return commentId;
	}

	public void setCommentId(Integer commentId) {
		this.commentId = commentId;
	}

	public Integer getCommentArticle() {
		return commentArticle;
	}

	public void setCommentArticle(Integer commentArticle) {
		this.commentArticle = commentArticle;
	}

	public Date getCommentCreateDate() {
		return commentCreateDate;
	}

	public void setCommentCreateDate(Date commentCreateDate) {
		this.commentCreateDate = commentCreateDate;
	}

	public Boolean getCommentHide() {
		return commentHide;
	}

	public void setCommentHide(Boolean commentHide) {
		this.commentHide = commentHide;
	}

	public String getCommentOtherEmail() {
		return commentOtherEmail;
	}

	public void setCommentOtherEmail(String commentOtherEmail) {
		this.commentOtherEmail = commentOtherEmail;
	}

	public String getCommentOtherName() {
		return commentOtherName;
	}

	public void setCommentOtherName(String commentOtherName) {
		this.commentOtherName = commentOtherName;
	}

	public String getCommentOtherConnect() {
		return commentOtherConnect;
	}

	public void setCommentOtherConnect(String commentOtherConnect) {
		this.commentOtherConnect = commentOtherConnect;
	}

	public String getCommentContent() {
		return commentContent;
	}

	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}

	@Override
	public String toString() {
		return "Comment [commentId=" + commentId + ", commentArticle=" + commentArticle + ", commentCreateDate="
				+ commentCreateDate + ", commentHide=" + commentHide + ", commentOtherEmail=" + commentOtherEmail
				+ ", commentOtherName=" + commentOtherName + ", commentOtherConnect=" + commentOtherConnect
				+ ", commentContent=" + commentContent + "]";
	}

  
    
}