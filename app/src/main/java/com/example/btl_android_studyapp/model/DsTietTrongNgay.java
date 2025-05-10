package com.example.btl_android_studyapp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.processing.Generated;

public class DsTietTrongNgay {
    private Integer tiet;
    private String gio_bat_dau;
    private String gio_ket_thuc;
    private Integer so_phut;
    private Integer nhhk;

    public Integer getTiet() {
        return tiet;
    }

    public void setTiet(Integer tiet) {
        this.tiet = tiet;
    }

    public String getGio_bat_dau() {
        return gio_bat_dau;
    }

    public void setGio_bat_dau(String gio_bat_dau) {
        this.gio_bat_dau = gio_bat_dau;
    }

    public String getGio_ket_thuc() {
        return gio_ket_thuc;
    }

    public void setGio_ket_thuc(String gio_ket_thuc) {
        this.gio_ket_thuc = gio_ket_thuc;
    }

    public Integer getSo_phut() {
        return so_phut;
    }

    public void setSo_phut(Integer so_phut) {
        this.so_phut = so_phut;
    }

    public Integer getNhhk() {
        return nhhk;
    }

    public void setNhhk(Integer nhhk) {
        this.nhhk = nhhk;
    }
}
