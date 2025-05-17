package com.example.btl_android_studyapp.adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.btl_android_studyapp.R;
import com.example.btl_android_studyapp.model.DsDiemMonHoc;
import com.example.btl_android_studyapp.model.DsDiemThanhPhan;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RecycleViewPointAdapter extends RecyclerView.Adapter<RecycleViewPointAdapter.PointViewHolder> {

    private ArrayList<DsDiemMonHoc> subjectList;
    private Context context;
    public RecycleViewPointAdapter(ArrayList<DsDiemMonHoc> subjectList, Context context) {
        this.subjectList = subjectList;
        this.context = context;
    }

    public static class PointViewHolder extends RecyclerView.ViewHolder {
        TextView soThuTu, tenMon, tinChi, diemChu;
        CardView item;
        public PointViewHolder(@NonNull View itemView) {
            super(itemView);
            soThuTu = itemView.findViewById(R.id.soThuTu);
            tenMon = itemView.findViewById(R.id.tenMon);
            tinChi = itemView.findViewById(R.id.tinChi);
            diemChu = itemView.findViewById(R.id.diemChu);
            item = itemView.findViewById(R.id.itemView);
        }
    }

    @NonNull
    @Override
    public PointViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_of_score_table, parent, false);
        return new PointViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PointViewHolder holder, int position) {
        DsDiemMonHoc diemMonHoc = subjectList.get(position);
        holder.soThuTu.setText(String.valueOf(position + 1));
        holder.tenMon.setText(diemMonHoc.getTenMon());
        holder.tinChi.setText(String.valueOf(diemMonHoc.getSoTinChi()));
        holder.diemChu.setText(diemMonHoc.getDiemTkChu());

        holder.item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                LayoutInflater inflater = LayoutInflater.from(context);
                View view = inflater.inflate(R.layout.item_detail_score, null);
                builder.setView(view);

                TextView tvTenMon = view.findViewById(R.id.tvTenMon);
                TextView tvMaMon = view.findViewById(R.id.tvMaMon);
                TextView tvSoTinChi = view.findViewById(R.id.tvSoTinChi);
                TextView tvDiemGiuaKy = view.findViewById(R.id.tvDiemGiuaKy);
                TextView tvDiemThi = view.findViewById(R.id.tvDiemThi);
                TextView tvDiemTK = view.findViewById(R.id.tvDiemTK);
                TextView tvDiemChu = view.findViewById(R.id.tvDiemChu);
                TextView tvKetQua = view.findViewById(R.id.tvKetQua);
                TextView tvThanhPhan = view.findViewById(R.id.tvThanhPhan);

                Optional.ofNullable(diemMonHoc.getTenMon()).ifPresent(ten -> tvTenMon.setText("Môn: " + ten));
                Optional.ofNullable(diemMonHoc.getMaMon()).ifPresent(ma -> tvMaMon.setText("Mã môn: " + ma));
                Optional.ofNullable(diemMonHoc.getSoTinChi()).ifPresent(tc -> tvSoTinChi.setText("Số tín chỉ: " + tc));
                Optional.ofNullable(diemMonHoc.getDiemGiuaKy()).ifPresent(d -> tvDiemGiuaKy.setText("Điểm giữa kỳ: " + d));
                Optional.ofNullable(diemMonHoc.getDiemThi()).ifPresent(d -> tvDiemThi.setText("Điểm thi: " + d));
                Optional.ofNullable(diemMonHoc.getDiemTk()).ifPresent(d -> tvDiemTK.setText("Điểm tổng kết: " + d));
                Optional.ofNullable(diemMonHoc.getDiemTkChu()).ifPresent(dc -> tvDiemChu.setText("Điểm chữ: " + dc));
                tvKetQua.setText("Kết quả: " + (diemMonHoc.getKetQua() == 1 ? "Đạt" : "Không đạt"));


                StringBuilder thanhPhanBuilder = new StringBuilder();

                List<DsDiemThanhPhan> dsDiemTP = diemMonHoc.getDsDiemThanhPhan();
                if (dsDiemTP != null && !dsDiemTP.isEmpty()) {
                    for (DsDiemThanhPhan tp : dsDiemTP) {
                        if (tp != null) {
                            String tenTP = tp.getTenThanhPhan() != null ? tp.getTenThanhPhan() : "Không rõ";
                            String trongSo = tp.getTrongSo() != null ? tp.getTrongSo() : "0";
                            String diem = tp.getDiemThanhPhan() != null ? tp.getDiemThanhPhan() : "N/A";

                            thanhPhanBuilder.append(tenTP)
                                    .append(" (").append(trongSo).append("%): ")
                                    .append(diem).append("\n");
                        }
                    }
                    tvThanhPhan.setText("Điểm thành phần:\n" + thanhPhanBuilder.toString());
                } else {
                    tvThanhPhan.setText("Không có điểm thành phần");
                }


                builder.setPositiveButton("Đóng", null);
                builder.create().show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return subjectList.size();
    }
}