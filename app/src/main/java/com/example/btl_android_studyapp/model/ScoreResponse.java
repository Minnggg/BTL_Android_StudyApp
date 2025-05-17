package com.example.btl_android_studyapp.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.processing.Generated;

@Generated("jsonschema2pojo")
public class ScoreResponse {

    @SerializedName("data")
    @Expose
    private DataScore data;
    @SerializedName("result")
    @Expose
    private Boolean result;
    @SerializedName("code")
    @Expose
    private Integer code;

    public DataScore getData() {
        return data;
    }

    public void setData(DataScore data) {
        this.data = data;
    }

    public Boolean getResult() {
        return result;
    }

    public void setResult(Boolean result) {
        this.result = result;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

}
