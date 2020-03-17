package com.bigbrotherlee.leeblog.domain.entity;

import java.util.Date;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;

public class Article {
    private Integer articleId;

    private String articleTitle;
    
    private ClassificationSmall small;
    
    @JsonInclude
    private List<Tag> tags;
    
    private RealUser user;
    
    private List<Comment> comments;

    public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	private Date articleCreateDate;

    private Boolean articleHide;

    private Boolean articleClose;

    private Integer articleSee;

    private String articleContent;
    
    private String articleImage;
    
    public ClassificationSmall getSmall() {
		return small;
	}

	public void setSmall(ClassificationSmall small) {
		this.small = small;
	}

	public List<Tag> getTags() {
		return tags;
	}

	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}

	public RealUser getUser() {
		return user;
	}

	public void setUser(RealUser user) {
		this.user = user;
	}

	public String getArticleImage() {
		return articleImage;
	}

	public void setArticleImage(String articleImage) {
		this.articleImage = articleImage;
	}

	public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public String getArticleTitle() {
        return articleTitle;
    }

    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle;
    }


    public Date getArticleCreateDate() {
        return articleCreateDate;
    }

    public void setArticleCreateDate(Date articleCreateDate) {
        this.articleCreateDate = articleCreateDate;
    }

    public Boolean getArticleHide() {
        return articleHide;
    }

    public void setArticleHide(Boolean articleHide) {
        this.articleHide = articleHide;
    }

    public Boolean getArticleClose() {
        return articleClose;
    }

    public void setArticleClose(Boolean articleClose) {
        this.articleClose = articleClose;
    }

    public Integer getArticleSee() {
        return articleSee;
    }

    public void setArticleSee(Integer articleSee) {
        this.articleSee = articleSee;
    }

    public String getArticleContent() {
        return articleContent;
    }

    public void setArticleContent(String articleContent) {
        this.articleContent = articleContent;
    }

	@Override
	public String toString() {
		return "Article [articleId=" + articleId + ", articleTitle=" + articleTitle + ", small=" + small + ", tags="
				+ tags + ", user=" + user + ", articleCreateDate=" + articleCreateDate + ", articleHide=" + articleHide
				+ ", articleClose=" + articleClose + ", articleSee=" + articleSee + ", articleContent=" + articleContent
				+ ", articleImage=" + articleImage + "]";
	}
    
}