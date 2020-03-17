package com.bigbrotherlee.leeblog.domain.entity;

public class AdminUser {
    private String adminId;

    private String adminCode;

    private String adminPassword;

    private String adminConnect;

    private String adminName;

    public String getAdminId() {
        return adminId;
    }

    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }

    public String getAdminCode() {
        return adminCode;
    }

    public void setAdminCode(String adminCode) {
        this.adminCode = adminCode;
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }

    public String getAdminConnect() {
        return adminConnect;
    }

    public void setAdminConnect(String adminConnect) {
        this.adminConnect = adminConnect;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }
}