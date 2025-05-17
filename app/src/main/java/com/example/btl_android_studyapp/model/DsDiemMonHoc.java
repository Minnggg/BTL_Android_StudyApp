package com.example.btl_android_studyapp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import javax.annotation.processing.Generated;

@Generated("jsonschema2pojo")
public class DsDiemMonHoc {

    @SerializedName("chuyen_diem_ve_hoc_ky")
    @Expose
    private String chuyenDiemVeHocKy;
    @SerializedName("ma_mon")
    @Expose
    private String maMon;
    @SerializedName("ma_mon_tt")
    @Expose
    private String maMonTt;
    @SerializedName("nhom_to")
    @Expose
    private String nhomTo;
    @SerializedName("ten_mon")
    @Expose
    private String tenMon;
    @SerializedName("ten_mon_eg")
    @Expose
    private String tenMonEg;
    @SerializedName("mon_hoc_nganh")
    @Expose
    private Boolean monHocNganh;
    @SerializedName("so_tin_chi")
    @Expose
    private String soTinChi;
    @SerializedName("diem_thi")
    @Expose
    private String diemThi;
    @SerializedName("diem_giua_ky")
    @Expose
    private String diemGiuaKy;
    @SerializedName("diem_tk")
    @Expose
    private String diemTk;
    @SerializedName("diem_tk_so")
    @Expose
    private String diemTkSo;
    @SerializedName("diem_tk_chu")
    @Expose
    private String diemTkChu;
    @SerializedName("ket_qua")
    @Expose
    private Integer ketQua;
    @SerializedName("hien_thi_ket_qua")
    @Expose
    private Boolean hienThiKetQua;
    @SerializedName("loai_nganh")
    @Expose
    private Integer loaiNganh;
    @SerializedName("KhoaThi")
    @Expose
    private Integer khoaThi;
    @SerializedName("khong_tinh_diem_tbtl")
    @Expose
    private Integer khongTinhDiemTbtl;
    @SerializedName("ly_do_khong_tinh_diem_tbtl")
    @Expose
    private String lyDoKhongTinhDiemTbtl;
    @SerializedName("ds_diem_thanh_phan")
    @Expose
    private List<DsDiemThanhPhan> dsDiemThanhPhan;

    public String getChuyenDiemVeHocKy() {
        return chuyenDiemVeHocKy;
    }

    public void setChuyenDiemVeHocKy(String chuyenDiemVeHocKy) {
        this.chuyenDiemVeHocKy = chuyenDiemVeHocKy;
    }

    public String getMaMon() {
        return maMon;
    }

    public void setMaMon(String maMon) {
        this.maMon = maMon;
    }

    public String getMaMonTt() {
        return maMonTt;
    }

    public void setMaMonTt(String maMonTt) {
        this.maMonTt = maMonTt;
    }

    public String getNhomTo() {
        return nhomTo;
    }

    public void setNhomTo(String nhomTo) {
        this.nhomTo = nhomTo;
    }

    public String getTenMon() {
        return tenMon;
    }

    public void setTenMon(String tenMon) {
        this.tenMon = tenMon;
    }

    public String getTenMonEg() {
        return tenMonEg;
    }

    public void setTenMonEg(String tenMonEg) {
        this.tenMonEg = tenMonEg;
    }

    public Boolean getMonHocNganh() {
        return monHocNganh;
    }

    public void setMonHocNganh(Boolean monHocNganh) {
        this.monHocNganh = monHocNganh;
    }

    public String getSoTinChi() {
        return soTinChi;
    }

    public void setSoTinChi(String soTinChi) {
        this.soTinChi = soTinChi;
    }

    public String getDiemThi() {
        return diemThi;
    }

    public void setDiemThi(String diemThi) {
        this.diemThi = diemThi;
    }

    public String getDiemGiuaKy() {
        return diemGiuaKy;
    }

    public void setDiemGiuaKy(String diemGiuaKy) {
        this.diemGiuaKy = diemGiuaKy;
    }

    public String getDiemTk() {
        return diemTk;
    }

    public void setDiemTk(String diemTk) {
        this.diemTk = diemTk;
    }

    public String getDiemTkSo() {
        return diemTkSo;
    }

    public void setDiemTkSo(String diemTkSo) {
        this.diemTkSo = diemTkSo;
    }

    public String getDiemTkChu() {
        return diemTkChu;
    }

    public void setDiemTkChu(String diemTkChu) {
        this.diemTkChu = diemTkChu;
    }

    public Integer getKetQua() {
        return ketQua;
    }

    public void setKetQua(Integer ketQua) {
        this.ketQua = ketQua;
    }

    public Boolean getHienThiKetQua() {
        return hienThiKetQua;
    }

    public void setHienThiKetQua(Boolean hienThiKetQua) {
        this.hienThiKetQua = hienThiKetQua;
    }

    public Integer getLoaiNganh() {
        return loaiNganh;
    }

    public void setLoaiNganh(Integer loaiNganh) {
        this.loaiNganh = loaiNganh;
    }

    public Integer getKhoaThi() {
        return khoaThi;
    }

    public void setKhoaThi(Integer khoaThi) {
        this.khoaThi = khoaThi;
    }

    public Integer getKhongTinhDiemTbtl() {
        return khongTinhDiemTbtl;
    }

    public void setKhongTinhDiemTbtl(Integer khongTinhDiemTbtl) {
        this.khongTinhDiemTbtl = khongTinhDiemTbtl;
    }

    public String getLyDoKhongTinhDiemTbtl() {
        return lyDoKhongTinhDiemTbtl;
    }

    public void setLyDoKhongTinhDiemTbtl(String lyDoKhongTinhDiemTbtl) {
        this.lyDoKhongTinhDiemTbtl = lyDoKhongTinhDiemTbtl;
    }

    public List<DsDiemThanhPhan> getDsDiemThanhPhan() {
        return dsDiemThanhPhan;
    }

    public void setDsDiemThanhPhan(List<DsDiemThanhPhan> dsDiemThanhPhan) {
        this.dsDiemThanhPhan = dsDiemThanhPhan;
    }

}
