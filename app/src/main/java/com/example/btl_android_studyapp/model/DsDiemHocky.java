package com.example.btl_android_studyapp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import javax.annotation.processing.Generated;

@Generated("jsonschema2pojo")
public class DsDiemHocky {

    @SerializedName("loai_nganh")
    @Expose
    private Integer loaiNganh;
    @SerializedName("hoc_ky")
    @Expose
    private String hocKy;
    @SerializedName("ten_hoc_ky")
    @Expose
    private String tenHocKy;
    @SerializedName("dtb_hk_he10")
    @Expose
    private String dtbHkHe10;
    @SerializedName("dtb_hk_he4")
    @Expose
    private String dtbHkHe4;
    @SerializedName("dtb_tich_luy_he_10")
    @Expose
    private String dtbTichLuyHe10;
    @SerializedName("dtb_tich_luy_he_4")
    @Expose
    private String dtbTichLuyHe4;
    @SerializedName("so_tin_chi_dat_hk")
    @Expose
    private String soTinChiDatHk;
    @SerializedName("so_tin_chi_dat_tich_luy")
    @Expose
    private String soTinChiDatTichLuy;
    @SerializedName("hien_thi_tk_he_10")
    @Expose
    private Boolean hienThiTkHe10;
    @SerializedName("hien_thi_tk_he_4")
    @Expose
    private Boolean hienThiTkHe4;
    @SerializedName("xep_loai_tkb_hk")
    @Expose
    private String xepLoaiTkbHk;
    @SerializedName("xep_loai_tkb_hk_eg")
    @Expose
    private String xepLoaiTkbHkEg;
    @SerializedName("ds_diem_mon_hoc")
    @Expose
    private List<DsDiemMonHoc> dsDiemMonHoc;

    public Integer getLoaiNganh() {
        return loaiNganh;
    }

    public void setLoaiNganh(Integer loaiNganh) {
        this.loaiNganh = loaiNganh;
    }

    public String getHocKy() {
        return hocKy;
    }

    public void setHocKy(String hocKy) {
        this.hocKy = hocKy;
    }

    public String getTenHocKy() {
        return tenHocKy;
    }

    public void setTenHocKy(String tenHocKy) {
        this.tenHocKy = tenHocKy;
    }

    public String getDtbHkHe10() {
        return dtbHkHe10;
    }

    public void setDtbHkHe10(String dtbHkHe10) {
        this.dtbHkHe10 = dtbHkHe10;
    }

    public String getDtbHkHe4() {
        return dtbHkHe4;
    }

    public void setDtbHkHe4(String dtbHkHe4) {
        this.dtbHkHe4 = dtbHkHe4;
    }

    public String getDtbTichLuyHe10() {
        return dtbTichLuyHe10;
    }

    public void setDtbTichLuyHe10(String dtbTichLuyHe10) {
        this.dtbTichLuyHe10 = dtbTichLuyHe10;
    }

    public String getDtbTichLuyHe4() {
        return dtbTichLuyHe4;
    }

    public void setDtbTichLuyHe4(String dtbTichLuyHe4) {
        this.dtbTichLuyHe4 = dtbTichLuyHe4;
    }

    public String getSoTinChiDatHk() {
        return soTinChiDatHk;
    }

    public void setSoTinChiDatHk(String soTinChiDatHk) {
        this.soTinChiDatHk = soTinChiDatHk;
    }

    public String getSoTinChiDatTichLuy() {
        return soTinChiDatTichLuy;
    }

    public void setSoTinChiDatTichLuy(String soTinChiDatTichLuy) {
        this.soTinChiDatTichLuy = soTinChiDatTichLuy;
    }

    public Boolean getHienThiTkHe10() {
        return hienThiTkHe10;
    }

    public void setHienThiTkHe10(Boolean hienThiTkHe10) {
        this.hienThiTkHe10 = hienThiTkHe10;
    }

    public Boolean getHienThiTkHe4() {
        return hienThiTkHe4;
    }

    public void setHienThiTkHe4(Boolean hienThiTkHe4) {
        this.hienThiTkHe4 = hienThiTkHe4;
    }

    public String getXepLoaiTkbHk() {
        return xepLoaiTkbHk;
    }

    public void setXepLoaiTkbHk(String xepLoaiTkbHk) {
        this.xepLoaiTkbHk = xepLoaiTkbHk;
    }

    public String getXepLoaiTkbHkEg() {
        return xepLoaiTkbHkEg;
    }

    public void setXepLoaiTkbHkEg(String xepLoaiTkbHkEg) {
        this.xepLoaiTkbHkEg = xepLoaiTkbHkEg;
    }

    public List<DsDiemMonHoc> getDsDiemMonHoc() {
        return dsDiemMonHoc;
    }

    public void setDsDiemMonHoc(List<DsDiemMonHoc> dsDiemMonHoc) {
        this.dsDiemMonHoc = dsDiemMonHoc;
    }

}