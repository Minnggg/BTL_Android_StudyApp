package com.example.btl_android_studyapp.model;

import java.util.List;

public class DsTuanTkb {
    private Integer tuan_hoc_ky;
    private Integer tuan_tuyet_doi;
    private String thong_tin_tuan;
    private String ngay_bat_dau;
    private String ngay_ket_thuc;

    private List<DsThoiKhoaBieu> ds_thoi_khoa_bieu;
    private List<Object> ds_id_thoi_khoa_bieu_trung;

    public Integer getTuan_hoc_ky() {
        return tuan_hoc_ky;
    }

    public void setTuan_hoc_ky(Integer tuan_hoc_ky) {
        this.tuan_hoc_ky = tuan_hoc_ky;
    }

    public Integer getTuan_tuyet_doi() {
        return tuan_tuyet_doi;
    }

    public void setTuan_tuyet_doi(Integer tuan_tuyet_doi) {
        this.tuan_tuyet_doi = tuan_tuyet_doi;
    }

    public String getThong_tin_tuan() {
        return thong_tin_tuan;
    }

    public void setThong_tin_tuan(String thong_tin_tuan) {
        this.thong_tin_tuan = thong_tin_tuan;
    }

    public String getNgay_bat_dau() {
        return ngay_bat_dau;
    }

    public void setNgay_bat_dau(String ngay_bat_dau) {
        this.ngay_bat_dau = ngay_bat_dau;
    }

    public String getNgay_ket_thuc() {
        return ngay_ket_thuc;
    }

    public void setNgay_ket_thuc(String ngay_ket_thuc) {
        this.ngay_ket_thuc = ngay_ket_thuc;
    }

    public List<DsThoiKhoaBieu> getDs_thoi_khoa_bieu() {
        return ds_thoi_khoa_bieu;
    }

    public void setDs_thoi_khoa_bieu(List<DsThoiKhoaBieu> ds_thoi_khoa_bieu) {
        this.ds_thoi_khoa_bieu = ds_thoi_khoa_bieu;
    }

    public List<Object> getDs_id_thoi_khoa_bieu_trung() {
        return ds_id_thoi_khoa_bieu_trung;
    }

    public void setDs_id_thoi_khoa_bieu_trung(List<Object> ds_id_thoi_khoa_bieu_trung) {
        this.ds_id_thoi_khoa_bieu_trung = ds_id_thoi_khoa_bieu_trung;
    }
}
