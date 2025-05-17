package com.example.btl_android_studyapp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.processing.Generated;

@Generated("jsonschema2pojo")
public class DsDiemThanhPhan {

    @SerializedName("ky_hieu")
    @Expose
    private String kyHieu;
    @SerializedName("ten_thanh_phan")
    @Expose
    private String tenThanhPhan;
    @SerializedName("trong_so")
    @Expose
    private String trongSo;
    @SerializedName("diem_thanh_phan")
    @Expose
    private String diemThanhPhan;

    public String getKyHieu() {
        return kyHieu;
    }

    public void setKyHieu(String kyHieu) {
        this.kyHieu = kyHieu;
    }

    public String getTenThanhPhan() {
        return tenThanhPhan;
    }

    public void setTenThanhPhan(String tenThanhPhan) {
        this.tenThanhPhan = tenThanhPhan;
    }

    public String getTrongSo() {
        return trongSo;
    }

    public void setTrongSo(String trongSo) {
        this.trongSo = trongSo;
    }

    public String getDiemThanhPhan() {
        return diemThanhPhan;
    }

    public void setDiemThanhPhan(String diemThanhPhan) {
        this.diemThanhPhan = diemThanhPhan;
    }

}
