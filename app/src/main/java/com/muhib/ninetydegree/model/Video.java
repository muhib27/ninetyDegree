package com.muhib.ninetydegree.model;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Video extends ViewModel {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("video_banner")
    @Expose
    private String videoBanner;
    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("file_url")
    @Expose
    private String fileUrl;
    @SerializedName("file_url_id")
    @Expose
    private String fileUrlId;
    @SerializedName("comments")
    @Expose
    private List<Comments> comments = null;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

//    public List<Object> getComments() {
//        return comments;
//    }
//
//    public void setComments(List<Object> comments) {
//        this.comments = comments;
//    }


    public List<Comments> getComments() {
        return comments;
    }

    public void setComments(List<Comments> comments) {
        this.comments = comments;
    }

    private final MutableLiveData<Video> mutableLiveData = new MutableLiveData<Video>();

    public MutableLiveData<Video> getMutableLiveData() {
        return mutableLiveData;
    }
    public void setData(Video video) {
        mutableLiveData.setValue(video);
    }

    public String getVideoBanner() {
        return videoBanner;
    }

    public void setVideoBanner(String videoBanner) {
        this.videoBanner = videoBanner;
    }

    public String getFileUrlId() {
        return fileUrlId;
    }

    public void setFileUrlId(String fileUrlId) {
        this.fileUrlId = fileUrlId;
    }
}