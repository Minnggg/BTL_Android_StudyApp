package com.example.btl_android_studyapp.model;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class CalendarDateModel {

    private Date data;
    private boolean isSelected;

    public CalendarDateModel(Date data, boolean isSelected) {
        this.data = data;
        this.isSelected = isSelected;
    }

    public CalendarDateModel(Date data) {
        this(data, true); // Mặc định isSelected = true
    }

    public String getCalendarDay() {
        return new SimpleDateFormat("EE", Locale.getDefault()).format(data);
    }

    public String getCalendarYear() {
        return new SimpleDateFormat("dd MMMM yyyy", Locale.getDefault()).format(data);
    }

    public String getCalendarDate() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(data);
        return String.valueOf(cal.get(Calendar.DAY_OF_MONTH));
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }
}
