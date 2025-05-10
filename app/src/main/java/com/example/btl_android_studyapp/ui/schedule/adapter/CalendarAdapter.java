package com.example.btl_android_studyapp.ui.schedule.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.example.btl_android_studyapp.R;
import com.example.btl_android_studyapp.model.CalendarDateModel;
import java.util.ArrayList;

public class CalendarAdapter extends RecyclerView.Adapter<CalendarAdapter.CalendarViewHolder> {
    private ArrayList<CalendarDateModel> list = new ArrayList<>();
    private int adapterPosition = -1;

    private OnItemClickListener mListener;

    public interface OnItemClickListener {
        void onItemClick(String text, String date, String day);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.mListener = listener;
    }

    @NonNull
    @Override
    public CalendarViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.date_layout, parent, false);
        return new CalendarViewHolder(view);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onBindViewHolder(@NonNull CalendarViewHolder holder, @SuppressLint("RecyclerView") int position) {
        CalendarDateModel item = list.get(position);
        Context context = holder.itemView.getContext();

        holder.calendarDay.setText(item.getCalendarDay());
        holder.calendarDate.setText(item.getCalendarDate());

        holder.itemView.setOnClickListener(v -> {
            adapterPosition = position;
            notifyItemRangeChanged(0, list.size());

            String text = String.valueOf(item.getCalendarYear());
            String date = item.getCalendarDate();
            String day = item.getCalendarDay();

            if (mListener != null) {
                mListener.onItemClick(text, date, day);
            }
        });

        if (position == adapterPosition) {
            holder.calendarDay.setTextColor(ContextCompat.getColor(context, R.color.white));
            holder.calendarDate.setTextColor(ContextCompat.getColor(context, R.color.white));
            holder.linear.setBackground(ContextCompat.getDrawable(context, R.drawable.rectangle_fill));
        } else {
            holder.calendarDay.setTextColor(ContextCompat.getColor(context, R.color.black));
            holder.calendarDate.setTextColor(ContextCompat.getColor(context, R.color.black));
            holder.linear.setBackground(ContextCompat.getDrawable(context, R.drawable.rectangle_outline));
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class CalendarViewHolder extends RecyclerView.ViewHolder {
        TextView calendarDay, calendarDate;
        LinearLayout linear;

        public CalendarViewHolder(@NonNull View itemView) {
            super(itemView);
            calendarDay = itemView.findViewById(R.id.tv_calendar_day);
            calendarDate = itemView.findViewById(R.id.tv_calendar_date);
            linear = itemView.findViewById(R.id.linear_calendar);
        }
    }

    public void setData(ArrayList<CalendarDateModel> calendarList) {
        list.clear();
        list.addAll(calendarList);
        notifyDataSetChanged();
    }

    public void setDay(int position) {
        adapterPosition = position;
        notifyItemRangeChanged(0, list.size());

        String text = String.valueOf(list.get(position).getCalendarYear());
        String date = list.get(position).getCalendarDate();
        String day = list.get(position).getCalendarDay();

        if (mListener != null) {
            mListener.onItemClick(text, date, day);
        }
    }

    public int getAdapterPosition() {
        return adapterPosition;
    }
}

