package com.example.btl_android_studyapp.model;

import java.util.List;

public class Data {
    private Integer total_items;
    private Integer total_pages;
    private List<DsTietTrongNgay> ds_tiet_trong_ngay;
    private List<DsTuanTkb> ds_tuan_tkb;
    private List<Object> ds_lich_hoan_thi;
    private String title_lich_hoan_thi;
    private Boolean is_duoc_diem_danh;
    private Boolean is_duoc_dk_nghi_day;
    private Boolean is_quan_ly_hoc_lieu;
    private Boolean is_show_tiet;
    private Boolean is_show_gio_ket_thuc;
    private Boolean is_show_link_hoc_online;
    private String thong_bao;

    public Integer getTotal_items() {
        return total_items;
    }

    public void setTotal_items(Integer total_items) {
        this.total_items = total_items;
    }

    public Integer getTotal_pages() {
        return total_pages;
    }

    public void setTotal_pages(Integer total_pages) {
        this.total_pages = total_pages;
    }

    public List<DsTietTrongNgay> getDs_tiet_trong_ngay() {
        return ds_tiet_trong_ngay;
    }

    public void setDs_tiet_trong_ngay(List<DsTietTrongNgay> ds_tiet_trong_ngay) {
        this.ds_tiet_trong_ngay = ds_tiet_trong_ngay;
    }

    public List<DsTuanTkb> getDs_tuan_tkb() {
        return ds_tuan_tkb;
    }

    public void setDs_tuan_tkb(List<DsTuanTkb> ds_tuan_tkb) {
        this.ds_tuan_tkb = ds_tuan_tkb;
    }

    public List<Object> getDs_lich_hoan_thi() {
        return ds_lich_hoan_thi;
    }

    public void setDs_lich_hoan_thi(List<Object> ds_lich_hoan_thi) {
        this.ds_lich_hoan_thi = ds_lich_hoan_thi;
    }

    public String getTitle_lich_hoan_thi() {
        return title_lich_hoan_thi;
    }

    public void setTitle_lich_hoan_thi(String title_lich_hoan_thi) {
        this.title_lich_hoan_thi = title_lich_hoan_thi;
    }

    public Boolean getIs_duoc_diem_danh() {
        return is_duoc_diem_danh;
    }

    public void setIs_duoc_diem_danh(Boolean is_duoc_diem_danh) {
        this.is_duoc_diem_danh = is_duoc_diem_danh;
    }

    public Boolean getIs_duoc_dk_nghi_day() {
        return is_duoc_dk_nghi_day;
    }

    public void setIs_duoc_dk_nghi_day(Boolean is_duoc_dk_nghi_day) {
        this.is_duoc_dk_nghi_day = is_duoc_dk_nghi_day;
    }

    public Boolean getIs_quan_ly_hoc_lieu() {
        return is_quan_ly_hoc_lieu;
    }

    public void setIs_quan_ly_hoc_lieu(Boolean is_quan_ly_hoc_lieu) {
        this.is_quan_ly_hoc_lieu = is_quan_ly_hoc_lieu;
    }

    public Boolean getIs_show_tiet() {
        return is_show_tiet;
    }

    public void setIs_show_tiet(Boolean is_show_tiet) {
        this.is_show_tiet = is_show_tiet;
    }

    public Boolean getIs_show_gio_ket_thuc() {
        return is_show_gio_ket_thuc;
    }

    public void setIs_show_gio_ket_thuc(Boolean is_show_gio_ket_thuc) {
        this.is_show_gio_ket_thuc = is_show_gio_ket_thuc;
    }

    public Boolean getIs_show_link_hoc_online() {
        return is_show_link_hoc_online;
    }

    public void setIs_show_link_hoc_online(Boolean is_show_link_hoc_online) {
        this.is_show_link_hoc_online = is_show_link_hoc_online;
    }

    public String getThong_bao() {
        return thong_bao;
    }

    public void setThong_bao(String thong_bao) {
        this.thong_bao = thong_bao;
    }
}
