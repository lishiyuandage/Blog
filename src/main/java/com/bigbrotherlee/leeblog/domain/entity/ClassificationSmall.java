package com.bigbrotherlee.leeblog.domain.entity;

import java.util.List;

public class ClassificationSmall {
    private Integer smallId;

    private String smallName;

    private String smallDetails;

    private ClassificationBig big;
    
    private List<Article> articles;
    
    public ClassificationBig getBig() {
		return big;
	}

	public void setBig(ClassificationBig big) {
		this.big = big;
	}

	public Integer getSmallId() {
        return smallId;
    }

    public void setSmallId(Integer smallId) {
        this.smallId = smallId;
    }

    public String getSmallName() {
        return smallName;
    }

    public void setSmallName(String smallName) {
        this.smallName = smallName;
    }

    public String getSmallDetails() {
        return smallDetails;
    }

    public void setSmallDetails(String smallDetails) {
        this.smallDetails = smallDetails;
    }

	public List<Article> getArticles() {
		return articles;
	}

	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}

	@Override
	public String toString() {
		return "ClassificationSmall [smallId=" + smallId + ", smallName=" + smallName + ", smallDetails=" + smallDetails
				+ ", big=" + big + ", articles=" + articles + "]";
	}
    

}