package com.bigbrotherlee.leeblog.domain.entity;

import java.util.List;

public class Tag {
    private Integer tagId;

    private String tagName;

    private String tagDetails;
    
    private List<Article> articles;
    
    public List<Article> getArticles() {
		return articles;
	}

	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}

	public Integer getTagId() {
        return tagId;
    }

    public void setTagId(Integer tagId) {
        this.tagId = tagId;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public String getTagDetails() {
        return tagDetails;
    }

    public void setTagDetails(String tagDetails) {
        this.tagDetails = tagDetails;
    }

	@Override
	public String toString() {
		return "Tag [tagId=" + tagId + ", tagName=" + tagName + ", tagDetails=" + tagDetails + ", articles=" + articles
				+ "]";
	}
    
}