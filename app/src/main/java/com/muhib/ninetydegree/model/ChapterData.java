package com.muhib.ninetydegree.model;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ChapterData extends ViewModel {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("class_id")
    @Expose
    private Integer classId;
    @SerializedName("class_name")
    @Expose
    private String className;
    @SerializedName("subject_id")
    @Expose
    private Integer subjectId;
    @SerializedName("subject_name")
    @Expose
    private String subjectName;
    @SerializedName("content_desc")
    @Expose
    private String contentDesc;
    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("chapter_banner")
    @Expose
    private String chapterBanner;
    @SerializedName("videos")
    @Expose
    private List<Video> videos = null;

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

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Integer getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Integer subjectId) {
        this.subjectId = subjectId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getContentDesc() {
        return contentDesc;
    }

    public void setContentDesc(String contentDesc) {
        this.contentDesc = contentDesc;
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

    public List<Video> getVideos() {
        return videos;
    }

    public void setVideos(List<Video> videos) {
        this.videos = videos;
    }

    private final MutableLiveData<ChapterData> mutableLiveChrData = new MutableLiveData<ChapterData>();

    public MutableLiveData<ChapterData> getMutableLiveData() {
        return mutableLiveChrData;
    }
    public void setChapterData(ChapterData chapterData) {
        mutableLiveChrData.setValue(chapterData);
    }

    public String getChapterBanner() {
        return chapterBanner;
    }

    public void setChapterBanner(String chapterBanner) {
        this.chapterBanner = chapterBanner;
    }
}
