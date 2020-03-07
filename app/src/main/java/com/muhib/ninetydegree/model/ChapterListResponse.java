package com.muhib.ninetydegree.model;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ChapterListResponse extends ViewModel {
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
    @SerializedName("data")
    @Expose
    private List<ChapterData> data = null;
    @SerializedName("error")
    @Expose
    private List<Object> error = null;

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

    public List<ChapterData> getData() {
        return data;
    }

    public void setData(List<ChapterData> data) {
        this.data = data;
    }

    public List<Object> getError() {
        return error;
    }

    public void setError(List<Object> error) {
        this.error = error;
    }

    private final MutableLiveData<ChapterListResponse> mutableLiveChapterData = new MutableLiveData<ChapterListResponse>();

    public MutableLiveData<ChapterListResponse> getMutableLiveData() {
        return mutableLiveChapterData;
    }
    public void setChapterListData(ChapterListResponse chapterListResponse) {
        mutableLiveChapterData.setValue(chapterListResponse);
    }
}
