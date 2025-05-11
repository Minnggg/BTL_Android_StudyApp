package com.example.btl_android_studyapp.ui.schedule;

import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.SnapHelper;

import com.example.btl_android_studyapp.Contanst;
import com.example.btl_android_studyapp.api.ApiClient;
import com.example.btl_android_studyapp.databinding.FragmentDashboardBinding;
import com.example.btl_android_studyapp.model.CalendarDateModel;
import com.example.btl_android_studyapp.model.DsThoiKhoaBieu;
import com.example.btl_android_studyapp.model.ThoiKhoaBieuResponse;
import com.example.btl_android_studyapp.ui.schedule.adapter.CalendarAdapter;
import com.example.btl_android_studyapp.ui.schedule.adapter.RvScheduleAdapter;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ScheduleFragment extends Fragment implements CalendarAdapter.OnItemClickListener {

    private FragmentDashboardBinding binding;

    private SimpleDateFormat sdf = new SimpleDateFormat("MMMM yyyy", Locale.ENGLISH);
    private Calendar cal = Calendar.getInstance(Locale.ENGLISH);;
    private List<Date> dates = new ArrayList<>();
    private CalendarAdapter adapter;
    ArrayList<DsThoiKhoaBieu> subjectList = new ArrayList<>();
    private List<CalendarDateModel> calendarList2 = new ArrayList<>();


    @RequiresApi(api = Build.VERSION_CODES.O)
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentDashboardBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        setUpAdapter();
        setUpClickListener();
        setUpCalendar();

        getSchedule();

    }

    private void getSchedule() {
        ApiClient.getInstance().getService().getSchedule(createdBodyRequest(20242), "Bearer " + Contanst.userCurrent.getAccess_token()).enqueue(new Callback<ThoiKhoaBieuResponse>() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onResponse(Call<ThoiKhoaBieuResponse> call, Response<ThoiKhoaBieuResponse> response) {
                subjectList.clear();
                if (response.body() != null && response.body().getData() != null) {
                    for (var tuan : response.body().getData().getDs_tuan_tkb()) {
                        for (DsThoiKhoaBieu tkb : tuan.getDs_thoi_khoa_bieu()) {
                            String[] parts = tkb.getNgay_hoc().split("-");
                            StringBuilder learnDay = new StringBuilder();
                            for (int i = parts.length - 1; i >= 0; i--) {
                                learnDay.append(parts[i]);
                            }
                            subjectList.add(tkb);
                        }
                    }
                }
                adapter.setDay(LocalDate.now().getDayOfMonth()-1);
                if (binding != null && binding.recyclerViewCalendar != null && adapter != null) {
                    binding.recyclerViewCalendar.scrollToPosition(adapter.getAdapterPosition());
                }
            }

            @Override
            public void onFailure(Call<ThoiKhoaBieuResponse> call, Throwable t) {
                System.out.println(t);
            }
        });
    }

    void displaySchedule(String day) {
        if (binding == null) return;
        ArrayList<DsThoiKhoaBieu> tkbSelected = (ArrayList<DsThoiKhoaBieu>) subjectList.stream().filter(item -> item.getNgay_hoc().equals(day)).collect(Collectors.toList());

        RvScheduleAdapter rvScheduleAdapter = new RvScheduleAdapter(tkbSelected);
        binding.recyclerViewSchedule.setAdapter(rvScheduleAdapter);
        binding.recyclerViewSchedule.setLayoutManager(
                new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
    }

    private Map<String, Object> createdBodyRequest(int hocky) {
        Map<String, Object> requestBody = new HashMap<>();

        Map<String, Object> filter = new HashMap<>();
        filter.put("hoc_ky", hocky);
        filter.put("tuan", "");

        Map<String, Object> paging = new HashMap<>();
        paging.put("limit", 100);
        paging.put("page", 1);

        Map<String, Object> orderItem = new HashMap<>();
        orderItem.put("name", null);
        orderItem.put("order_type", 0);
        List<Map<String, Object>> orderingList = new ArrayList<>();
        orderingList.add(orderItem);

        Map<String, Object> additional = new HashMap<>();
        additional.put("paging", paging);
        additional.put("ordering", orderingList);

        requestBody.put("filter", filter);
        requestBody.put("additional", additional);

        return requestBody;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }


    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onItemClick(String text, String date, String day) {
        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("dd MMMM yyyy", Locale.ENGLISH);
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'00:00:00");

        LocalDate parsedDate = LocalDate.parse(text, inputFormatter);
        String formattedDate = parsedDate.format(outputFormatter);
        displaySchedule(formattedDate);
    }



    private void setUpClickListener() {
        binding.ivCalendarNext.setOnClickListener(v -> {
            cal.add(Calendar.MONTH, 1);
            setUpCalendar();
            adapter.setDay(0);
            binding.recyclerViewCalendar.scrollToPosition(adapter.getAdapterPosition());
        });

        binding.ivCalendarPrevious.setOnClickListener(v -> {
            cal.add(Calendar.MONTH, -1);
            setUpCalendar();
            adapter.setDay(0);
            binding.recyclerViewCalendar.scrollToPosition(adapter.getAdapterPosition());
        });
    }

    private void setUpAdapter() {
        SnapHelper snapHelper = new LinearSnapHelper();
        snapHelper.attachToRecyclerView(binding.recyclerViewCalendar);

        adapter = new CalendarAdapter();
        adapter.setData((ArrayList)calendarList2);
        adapter.setOnItemClickListener(this::onItemClick);
        binding.recyclerViewCalendar.setAdapter(adapter);
    }

    private void setUpCalendar() {
        List<CalendarDateModel> calendarList = new ArrayList<>();
        binding.textDateMonth.setText(sdf.format(cal.getTime()));
        Calendar monthCalendar = (Calendar) cal.clone();
        int maxDaysInMonth = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        dates.clear();
        monthCalendar.set(Calendar.DAY_OF_MONTH, 1);

        while (dates.size() < maxDaysInMonth) {
            Date current = monthCalendar.getTime();
            dates.add(current);
            calendarList.add(new CalendarDateModel(current));
            monthCalendar.add(Calendar.DAY_OF_MONTH, 1);
        }

        calendarList2.clear();
        calendarList2.addAll(calendarList);
        adapter.setOnItemClickListener(this);
        adapter.setData(new ArrayList<>(calendarList));
    }

}