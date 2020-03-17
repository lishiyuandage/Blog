package com.bigbrotherlee.leeblog.domain.entity;

import java.util.List;

public class RealUser {
    private String userId;

    private String userCode;

    private String userName;

    private String userPassword;

    private Boolean userSex;

    private String userEmail;
    
    private List<Article> articles;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public Boolean getUserSex() {
        return userSex;
    }

    public void setUserSex(Boolean userSex) {
        this.userSex = userSex;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

	public List<Article> getArticles() {
		return articles;
	}

	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}

	@Override
	public String toString() {
		return "RealUser [userId=" + userId + ", userCode=" + userCode + ", userName=" + userName + ", userPassword="
				+ userPassword + ", userSex=" + userSex + ", userEmail=" + userEmail + ", articles=" + articles + "]";
	}
    
}