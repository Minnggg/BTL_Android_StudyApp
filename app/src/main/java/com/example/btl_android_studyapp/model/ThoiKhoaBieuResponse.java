package com.example.btl_android_studyapp.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.processing.Generated;

public class Data {

    @SerializedName("total_items")
    @Expose
    private Integer totalItems;
    @SerializedName("total_pages")
    @Expose
    private Integer totalPages;
    @SerializedName("ds_tiet_trong_ngay")
    @Expose
    private List<DsTietTrongNgay> dsTietTrongNgay;
    @SerializedName("ds_tuan_tkb")
    @Expose
    private List<DsTuanTkb> dsTuanTkb;
    @SerializedName("ds_lich_hoan_thi")
    @Expose
    private List<Object> dsLichHoanThi;
    @SerializedName("title_lich_hoan_thi")
    @Expose
    private String titleLichHoanThi;
    @SerializedName("is_duoc_diem_danh")
    @Expose
    private Boolean isDuocDiemDanh;
    @SerializedName("is_duoc_dk_nghi_day")
    @Expose
    private Boolean isDuocDkNghiDay;
    @SerializedName("is_quan_ly_hoc_lieu")
    @Expose
    private Boolean isQuanLyHocLieu;
    @SerializedName("is_show_tiet")
    @Expose
    private Boolean isShowTiet;
    @SerializedName("is_show_gio_ket_thuc")
    @Expose
    private Boolean isShowGioKetThuc;
    @SerializedName("is_show_link_hoc_online")
    @Expose
    private Boolean isShowLinkHocOnline;
    @SerializedName("thong_bao")
    @Expose
    private String thongBao;

    public Integer getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(Integer totalItems) {
        this.totalItems = totalItems;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public List<DsTietTrongNgay> getDsTietTrongNgay() {
        return dsTietTrongNgay;
    }

    public void setDsTietTrongNgay(List<DsTietTrongNgay> dsTietTrongNgay) {
        this.dsTietTrongNgay = dsTietTrongNgay;
    }

    public List<DsTuanTkb> getDsTuanTkb() {
        return dsTuanTkb;
    }

    public void setDsTuanTkb(List<DsTuanTkb> dsTuanTkb) {
        this.dsTuanTkb = dsTuanTkb;
    }

    public List<Object> getDsLichHoanThi() {
        return dsLichHoanThi;
    }

    public void setDsLichHoanThi(List<Object> dsLichHoanThi) {
        this.dsLichHoanThi = dsLichHoanThi;
    }

    public String getTitleLichHoanThi() {
        return titleLichHoanThi;
    }

    public void setTitleLichHoanThi(String titleLichHoanThi) {
        this.titleLichHoanThi = titleLichHoanThi;
    }

    public Boolean getIsDuocDiemDanh() {
        return isDuocDiemDanh;
    }

    public void setIsDuocDiemDanh(Boolean isDuocDiemDanh) {
        this.isDuocDiemDanh = isDuocDiemDanh;
    }

    public Boolean getIsDuocDkNghiDay() {
        return isDuocDkNghiDay;
    }

    public void setIsDuocDkNghiDay(Boolean isDuocDkNghiDay) {
        this.isDuocDkNghiDay = isDuocDkNghiDay;
    }

    public Boolean getIsQuanLyHocLieu() {
        return isQuanLyHocLieu;
    }

    public void setIsQuanLyHocLieu(Boolean isQuanLyHocLieu) {
        this.isQuanLyHocLieu = isQuanLyHocLieu;
    }

    public Boolean getIsShowTiet() {
        return isShowTiet;
    }

    public void setIsShowTiet(Boolean isShowTiet) {
        this.isShowTiet = isShowTiet;
    }

    public Boolean getIsShowGioKetThuc() {
        return isShowGioKetThuc;
    }

    public void setIsShowGioKetThuc(Boolean isShowGioKetThuc) {
        this.isShowGioKetThuc = isShowGioKetThuc;
    }

    public Boolean getIsShowLinkHocOnline() {
        return isShowLinkHocOnline;
    }

    public void setIsShowLinkHocOnline(Boolean isShowLinkHocOnline) {
        this.isShowLinkHocOnline = isShowLinkHocOnline;
    }

    public String getThongBao() {
        return thongBao;
    }

    public void setThongBao(String thongBao) {
        this.thongBao = thongBao;
    }

}
-----------------------------------com.example.btl_android_studyapp.model.DsThoiKhoaBieu.java-----------------------------------

        package com.example.btl_android_studyapp.model;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class DsThoiKhoaBieu {

    @SerializedName("is_hk_lien_truoc")
    @Expose
    private Integer isHkLienTruoc;
    @SerializedName("thu_kieu_so")
    @Expose
    private Integer thuKieuSo;
    @SerializedName("tiet_bat_dau")
    @Expose
    private Integer tietBatDau;
    @SerializedName("so_tiet")
    @Expose
    private Integer soTiet;
    @SerializedName("ma_mon")
    @Expose
    private String maMon;
    @SerializedName("ten_mon")
    @Expose
    private String tenMon;
    @SerializedName("so_tin_chi")
    @Expose
    private String soTinChi;
    @SerializedName("id_to_hoc")
    @Expose
    private String idToHoc;
    @SerializedName("id_tkb")
    @Expose
    private String idTkb;
    @SerializedName("id_to_hop")
    @Expose
    private String idToHop;
    @SerializedName("ma_nhom")
    @Expose
    private String maNhom;
    @SerializedName("ma_to_th")
    @Expose
    private String maToTh;
    @SerializedName("ma_to_hop")
    @Expose
    private String maToHop;
    @SerializedName("ma_giang_vien")
    @Expose
    private String maGiangVien;
    @SerializedName("ten_giang_vien")
    @Expose
    private String tenGiangVien;
    @SerializedName("ma_lop")
    @Expose
    private String maLop;
    @SerializedName("ten_lop")
    @Expose
    private String tenLop;
    @SerializedName("ma_phong")
    @Expose
    private String maPhong;
    @SerializedName("ma_co_so")
    @Expose
    private String maCoSo;
    @SerializedName("is_day_bu")
    @Expose
    private Boolean isDayBu;
    @SerializedName("ngay_hoc")
    @Expose
    private String ngayHoc;
    @SerializedName("tiet_bat_dau_kttc")
    @Expose
    private String tietBatDauKttc;
    @SerializedName("id_tu_tao")
    @Expose
    private String idTuTao;
    @SerializedName("is_file_bai_giang")
    @Expose
    private Boolean isFileBaiGiang;
    @SerializedName("id_sinh_hoat")
    @Expose
    private String idSinhHoat;
    @SerializedName("is_dang_duyet_nghi_day")
    @Expose
    private Boolean isDangDuyetNghiDay;
    @SerializedName("is_nghi_day")
    @Expose
    private Boolean isNghiDay;
    @SerializedName("ten_mon_eg")
    @Expose
    private String tenMonEg;

    public Integer getIsHkLienTruoc() {
        return isHkLienTruoc;
    }

    public void setIsHkLienTruoc(Integer isHkLienTruoc) {
        this.isHkLienTruoc = isHkLienTruoc;
    }

    public Integer getThuKieuSo() {
        return thuKieuSo;
    }

    public void setThuKieuSo(Integer thuKieuSo) {
        this.thuKieuSo = thuKieuSo;
    }

    public Integer getTietBatDau() {
        return tietBatDau;
    }

    public void setTietBatDau(Integer tietBatDau) {
        this.tietBatDau = tietBatDau;
    }

    public Integer getSoTiet() {
        return soTiet;
    }

    public void setSoTiet(Integer soTiet) {
        this.soTiet = soTiet;
    }

    public String getMaMon() {
        return maMon;
    }

    public void setMaMon(String maMon) {
        this.maMon = maMon;
    }

    public String getTenMon() {
        return tenMon;
    }

    public void setTenMon(String tenMon) {
        this.tenMon = tenMon;
    }

    public String getSoTinChi() {
        return soTinChi;
    }

    public void setSoTinChi(String soTinChi) {
        this.soTinChi = soTinChi;
    }

    public String getIdToHoc() {
        return idToHoc;
    }

    public void setIdToHoc(String idToHoc) {
        this.idToHoc = idToHoc;
    }

    public String getIdTkb() {
        return idTkb;
    }

    public void setIdTkb(String idTkb) {
        this.idTkb = idTkb;
    }

    public String getIdToHop() {
        return idToHop;
    }

    public void setIdToHop(String idToHop) {
        this.idToHop = idToHop;
    }

    public String getMaNhom() {
        return maNhom;
    }

    public void setMaNhom(String maNhom) {
        this.maNhom = maNhom;
    }

    public String getMaToTh() {
        return maToTh;
    }

    public void setMaToTh(String maToTh) {
        this.maToTh = maToTh;
    }

    public String getMaToHop() {
        return maToHop;
    }

    public void setMaToHop(String maToHop) {
        this.maToHop = maToHop;
    }

    public String getMaGiangVien() {
        return maGiangVien;
    }

    public void setMaGiangVien(String maGiangVien) {
        this.maGiangVien = maGiangVien;
    }

    public String getTenGiangVien() {
        return tenGiangVien;
    }

    public void setTenGiangVien(String tenGiangVien) {
        this.tenGiangVien = tenGiangVien;
    }

    public String getMaLop() {
        return maLop;
    }

    public void setMaLop(String maLop) {
        this.maLop = maLop;
    }

    public String getTenLop() {
        return tenLop;
    }

    public void setTenLop(String tenLop) {
        this.tenLop = tenLop;
    }

    public String getMaPhong() {
        return maPhong;
    }

    public void setMaPhong(String maPhong) {
        this.maPhong = maPhong;
    }

    public String getMaCoSo() {
        return maCoSo;
    }

    public void setMaCoSo(String maCoSo) {
        this.maCoSo = maCoSo;
    }

    public Boolean getIsDayBu() {
        return isDayBu;
    }

    public void setIsDayBu(Boolean isDayBu) {
        this.isDayBu = isDayBu;
    }

    public String getNgayHoc() {
        return ngayHoc;
    }

    public void setNgayHoc(String ngayHoc) {
        this.ngayHoc = ngayHoc;
    }

    public String getTietBatDauKttc() {
        return tietBatDauKttc;
    }

    public void setTietBatDauKttc(String tietBatDauKttc) {
        this.tietBatDauKttc = tietBatDauKttc;
    }

    public String getIdTuTao() {
        return idTuTao;
    }

    public void setIdTuTao(String idTuTao) {
        this.idTuTao = idTuTao;
    }

    public Boolean getIsFileBaiGiang() {
        return isFileBaiGiang;
    }

    public void setIsFileBaiGiang(Boolean isFileBaiGiang) {
        this.isFileBaiGiang = isFileBaiGiang;
    }

    public String getIdSinhHoat() {
        return idSinhHoat;
    }

    public void setIdSinhHoat(String idSinhHoat) {
        this.idSinhHoat = idSinhHoat;
    }

    public Boolean getIsDangDuyetNghiDay() {
        return isDangDuyetNghiDay;
    }

    public void setIsDangDuyetNghiDay(Boolean isDangDuyetNghiDay) {
        this.isDangDuyetNghiDay = isDangDuyetNghiDay;
    }

    public Boolean getIsNghiDay() {
        return isNghiDay;
    }

    public void setIsNghiDay(Boolean isNghiDay) {
        this.isNghiDay = isNghiDay;
    }

    public String getTenMonEg() {
        return tenMonEg;
    }

    public void setTenMonEg(String tenMonEg) {
        this.tenMonEg = tenMonEg;
    }

}
-----------------------------------com.example.btl_android_studyapp.model.DsTietTrongNgay.java-----------------------------------

        package com.example.btl_android_studyapp.model;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class DsTietTrongNgay {

    @SerializedName("tiet")
    @Expose
    private Integer tiet;
    @SerializedName("gio_bat_dau")
    @Expose
    private String gioBatDau;
    @SerializedName("gio_ket_thuc")
    @Expose
    private String gioKetThuc;
    @SerializedName("so_phut")
    @Expose
    private Integer soPhut;
    @SerializedName("nhhk")
    @Expose
    private Integer nhhk;

    public Integer getTiet() {
        return tiet;
    }

    public void setTiet(Integer tiet) {
        this.tiet = tiet;
    }

    public String getGioBatDau() {
        return gioBatDau;
    }

    public void setGioBatDau(String gioBatDau) {
        this.gioBatDau = gioBatDau;
    }

    public String getGioKetThuc() {
        return gioKetThuc;
    }

    public void setGioKetThuc(String gioKetThuc) {
        this.gioKetThuc = gioKetThuc;
    }

    public Integer getSoPhut() {
        return soPhut;
    }

    public void setSoPhut(Integer soPhut) {
        this.soPhut = soPhut;
    }

    public Integer getNhhk() {
        return nhhk;
    }

    public void setNhhk(Integer nhhk) {
        this.nhhk = nhhk;
    }

}
-----------------------------------com.example.btl_android_studyapp.model.DsTuanTkb.java-----------------------------------

        package com.example.btl_android_studyapp.model;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class DsTuanTkb {

    @SerializedName("tuan_hoc_ky")
    @Expose
    private Integer tuanHocKy;
    @SerializedName("tuan_tuyet_doi")
    @Expose
    private Integer tuanTuyetDoi;
    @SerializedName("thong_tin_tuan")
    @Expose
    private String thongTinTuan;
    @SerializedName("ngay_bat_dau")
    @Expose
    private String ngayBatDau;
    @SerializedName("ngay_ket_thuc")
    @Expose
    private String ngayKetThuc;
    @SerializedName("ds_thoi_khoa_bieu")
    @Expose
    private List<DsThoiKhoaBieu> dsThoiKhoaBieu;
    @SerializedName("ds_id_thoi_khoa_bieu_trung")
    @Expose
    private List<Object> dsIdThoiKhoaBieuTrung;

    public Integer getTuanHocKy() {
        return tuanHocKy;
    }

    public void setTuanHocKy(Integer tuanHocKy) {
        this.tuanHocKy = tuanHocKy;
    }

    public Integer getTuanTuyetDoi() {
        return tuanTuyetDoi;
    }

    public void setTuanTuyetDoi(Integer tuanTuyetDoi) {
        this.tuanTuyetDoi = tuanTuyetDoi;
    }

    public String getThongTinTuan() {
        return thongTinTuan;
    }

    public void setThongTinTuan(String thongTinTuan) {
        this.thongTinTuan = thongTinTuan;
    }

    public String getNgayBatDau() {
        return ngayBatDau;
    }

    public void setNgayBatDau(String ngayBatDau) {
        this.ngayBatDau = ngayBatDau;
    }

    public String getNgayKetThuc() {
        return ngayKetThuc;
    }

    public void setNgayKetThuc(String ngayKetThuc) {
        this.ngayKetThuc = ngayKetThuc;
    }

    public List<DsThoiKhoaBieu> getDsThoiKhoaBieu() {
        return dsThoiKhoaBieu;
    }

    public void setDsThoiKhoaBieu(List<DsThoiKhoaBieu> dsThoiKhoaBieu) {
        this.dsThoiKhoaBieu = dsThoiKhoaBieu;
    }

    public List<Object> getDsIdThoiKhoaBieuTrung() {
        return dsIdThoiKhoaBieuTrung;
    }

    public void setDsIdThoiKhoaBieuTrung(List<Object> dsIdThoiKhoaBieuTrung) {
        this.dsIdThoiKhoaBieuTrung = dsIdThoiKhoaBieuTrung;
    }

}
-----------------------------------com.example.btl_android_studyapp.model.ThoiKhoaBieuResponse.java-----------------------------------

        package com.example.btl_android_studyapp.model;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class ThoiKhoaBieuResponse {

    @SerializedName("data")
    @Expose
    private Data data;
    @SerializedName("result")
    @Expose
    private Boolean result;
    @SerializedName("code")
    @Expose
    private Integer code;

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
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