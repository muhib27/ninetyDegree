package com.muhib.ninetydegree.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SubjectModel {
    @SerializedName("subject_id")
    @Expose
    private Integer subjectId;
    @SerializedName("subject_name")
    @Expose
    private String subjectName;
    @SerializedName("subject_status")
    @Expose
    private Integer subjectStatus;
    @SerializedName("subject_created_date")
    @Expose
    private String subjectCreatedDate;

    @SerializedName("subject_banner")
    @Expose
    private String subjectBanner;

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

    public Integer getSubjectStatus() {
        return subjectStatus;
    }

    public void setSubjectStatus(Integer subjectStatus) {
        this.subjectStatus = subjectStatus;
    }

    public String getSubjectCreatedDate() {
        return subjectCreatedDate;
    }

    public void setSubjectCreatedDate(String subjectCreatedDate) {
        this.subjectCreatedDate = subjectCreatedDate;
    }

    public String getSubjectBanner() {
        return subjectBanner;
    }

    public void setSubjectBanner(String subjectBanner) {
        this.subjectBanner = subjectBanner;
    }
}
