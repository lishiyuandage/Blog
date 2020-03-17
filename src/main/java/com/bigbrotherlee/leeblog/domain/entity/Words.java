package com.bigbrotherlee.leeblog.domain.entity;

import java.util.Date;

public class Words {
	private Integer wordsId;
	private String wordsContent;
	private Date wordsCreateDate;
	private RealUser user;
	public Integer getWordsId() {
		return wordsId;
	}
	public void setWordsId(Integer wordsId) {
		this.wordsId = wordsId;
	}
	public String getWordsContent() {
		return wordsContent;
	}
	public void setWordsContent(String wordsContent) {
		this.wordsContent = wordsContent;
	}
	public Date getWordsCreateDate() {
		return wordsCreateDate;
	}
	public void setWordsCreateDate(Date wordsCreateDate) {
		this.wordsCreateDate = wordsCreateDate;
	}
	public RealUser getUser() {
		return user;
	}
	public void setUser(RealUser user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "Words [wordsId=" + wordsId + ", wordsContent=" + wordsContent + ", wordsCreateDate=" + wordsCreateDate
				+ ", user=" + user + "]";
	}
	
}
