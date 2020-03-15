package com.muhib.ninetydegree.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.w3c.dom.Comment;

import java.util.List;

public class CommentResponse {
    @SerializedName("success")
    @Expose
    private Boolean success;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("code")
    @Expose
    private String code;
    @SerializedName("msg")
    @Expose
    private String msg;
//    @SerializedName("data")
//    @Expose
//    private Integer data;
    @SerializedName("error")
    @Expose
    private List<Object> error = null;
    @SerializedName("data")
    @Expose
    private List<Comments> comments = null;

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<Object> getError() {
        return error;
    }

    public void setError(List<Object> error) {
        this.error = error;
    }

    public List<Comments> getComments() {
        return comments;
    }

    public void setComments(List<Comments> comments) {
        this.comments = comments;
    }
}
