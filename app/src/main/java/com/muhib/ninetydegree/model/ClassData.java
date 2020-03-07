package com.muhib.ninetydegree.model;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ClassData  extends ViewModel {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("class_banner")
    @Expose
    private String classBanner;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("subjects")
    @Expose
    private List<SubjectModel> subjects = null;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public List<SubjectModel> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<SubjectModel> subjects) {
        this.subjects = subjects;
    }

    private final MutableLiveData<ClassData> mutableLiveClassData = new MutableLiveData<ClassData>();

    public MutableLiveData<ClassData> getMutableLiveData() {
        return mutableLiveClassData;
    }
    public void setClassData(ClassData classData) {
        mutableLiveClassData.setValue(classData);
    }

    public String getClassBanner() {
        return classBanner;
    }

    public void setClassBanner(String classBanner) {
        this.classBanner = classBanner;
    }
}
