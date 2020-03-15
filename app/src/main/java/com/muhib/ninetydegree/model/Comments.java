package com.muhib.ninetydegree.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Comments {
    @SerializedName("user_name")
    @Expose
    private String userName;
    @SerializedName("comments")
    @Expose
    private String comments;
    @SerializedName("commented_date")
    @Expose
    private String commentedDate;
    @SerializedName("status")
    @Expose
    private Integer status;


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getCommentedDate() {
        return commentedDate;
    }

    public void setCommentedDate(String commentedDate) {
        this.commentedDate = commentedDate;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
