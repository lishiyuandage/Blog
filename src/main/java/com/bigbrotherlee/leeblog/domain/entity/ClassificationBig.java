package com.bigbrotherlee.leeblog.domain.entity;

import java.util.List;

public class ClassificationBig {
    private Integer bigId;

    private String bigName;

    private String bigDetails;

    private List<ClassificationSmall> smallList;
    
    public List<ClassificationSmall> getSmallList() {
		return smallList;
	}

	public void setSmallList(List<ClassificationSmall> smallList) {
		this.smallList = smallList;
	}

	public Integer getBigId() {
        return bigId;
    }

    public void setBigId(Integer bigId) {
        this.bigId = bigId;
    }

    public String getBigName() {
        return bigName;
    }

    public void setBigName(String bigName) {
        this.bigName = bigName;
    }

    public String getBigDetails() {
        return bigDetails;
    }

    public void setBigDetails(String bigDetails) {
        this.bigDetails = bigDetails;
    }

	@Override
	public String toString() {
		return "ClassificationBig [bigId=" + bigId + ", bigName=" + bigName + ", bigDetails=" + bigDetails
				+ ", smallList=" + smallList + "]";
	}
    
}