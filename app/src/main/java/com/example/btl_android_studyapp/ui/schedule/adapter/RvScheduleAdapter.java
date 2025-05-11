package com.example.btl_android_studyapp.ui.schedule.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.btl_android_studyapp.R;
import com.example.btl_android_studyapp.model.DsThoiKhoaBieu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RvScheduleAdapter extends RecyclerView.Adapter<RvScheduleAdapter.ScheduleViewHolder> {

    private final ArrayList<DsThoiKhoaBieu> subjectList;

    private final List<String> tietHoc = Arrays.asList(
            "07:00am", "08:00am", "09:00am", "10:00am", "11:00am",
            "12:00am", "01:00pm", "02:00pm", "03:00pm", "04:00pm",
            "05:00pm", "06:00pm", "07:00pm", "08:00pm", "09:00pm"
    );

    public RvScheduleAdapter(ArrayList<DsThoiKhoaBieu> subjectList) {
        this.subjectList = subjectList;
    }

    @NonNull
    @Override
    public ScheduleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_schedule_layout, parent, false);
        return new ScheduleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ScheduleViewHolder holder, int position) {
        DsThoiKhoaBieu subject = subjectList.get(position);

        TextView gioHoc = holder.itemView.findViewById(R.id.gioHoc);
        TextView ngayHoc = holder.itemView.findViewById(R.id.ngayHoc);
        TextView tenMon = holder.itemView.findViewById(R.id.tenMon);
        TextView phongHoc = holder.itemView.findViewById(R.id.phongHoc);
        TextView tenGiangVien = holder.itemView.findViewById(R.id.tenGiangVien);

        int tietBatDau = subject.getTiet_bat_dau();
        int soTiet = subject.getSo_tiet();

        if (tietBatDau < 4) {
            gioHoc.setBackgroundResource(R.drawable.cv_schedule_time_1);
        } else if (tietBatDau < 10) {
            gioHoc.setBackgroundResource(R.drawable.cv_schedule_time_2);
        } else {
            gioHoc.setBackgroundResource(R.drawable.cv_schedule_time_3);
        }

        String timeRange = tietHoc.get(tietBatDau - 1) + " - " +
                tietHoc.get(Math.min(tietBatDau - 1 + soTiet, tietHoc.size() - 1)); // prevent IndexOutOfBounds
        gioHoc.setText(timeRange);

        ngayHoc.setText(subject.getNgay_hoc().replace("T00:00:00",""));
        tenMon.setText(subject.getTen_mon());

        // Extracting room
        String maPhong = subject.getMa_phong();
        StringBuilder room = new StringBuilder();
        int dashCount = 0;
        for (int i = 0; i < maPhong.length(); i++) {
            char c = maPhong.charAt(i);
            if (c == '-') {
                dashCount++;
                if (dashCount > 1) break;
            }
            room.append(c);
        }
        phongHoc.setText(room.toString());

        tenGiangVien.setText(subject.getTen_giang_vien());
    }

    @Override
    public int getItemCount() {
        return subjectList.size();
    }

    static class ScheduleViewHolder extends RecyclerView.ViewHolder {
        public ScheduleViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
