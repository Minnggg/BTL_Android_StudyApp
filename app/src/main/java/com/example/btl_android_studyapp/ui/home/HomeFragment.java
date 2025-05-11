package com.example.btl_android_studyapp.ui.home;

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

import com.example.btl_android_studyapp.Contanst;
import com.example.btl_android_studyapp.api.ApiClient;
import com.example.btl_android_studyapp.databinding.FragmentHomeBinding;
import com.example.btl_android_studyapp.model.DsThoiKhoaBieu;
import com.example.btl_android_studyapp.model.ThoiKhoaBieuResponse;
import com.example.btl_android_studyapp.ui.schedule.adapter.RvScheduleAdapter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment {
    ArrayList<DsThoiKhoaBieu> subjectList = new ArrayList<>();
    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if(subjectList.size()==0){
            getSchedule();
        } else {
            RvScheduleAdapter rvScheduleAdapter = new RvScheduleAdapter(subjectList);
            binding.rvHomeSchedule.setAdapter(rvScheduleAdapter);
            binding.rvHomeSchedule.setLayoutManager(
                    new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        }
        binding.tvNameStudent.setText(Contanst.userCurrent.getName() + "\n" + Contanst.userCurrent.getUserName());
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
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
                            LocalDate today = LocalDate.now();
                            for(int i = 0 ; i <=5 ; i++) {
                                LocalDate resultDate = today.plusDays(i);
                                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'00:00:00");
                                String formattedDate = resultDate.format(formatter);
                                if(formattedDate.equals(tkb.getNgay_hoc())) {
                                    if (subjectList.size() >= 2) break;
                                    subjectList.add(tkb);
                                }
                            }
                        }
                        if (subjectList.size() >= 2) break;
                    }
                }

                RvScheduleAdapter rvScheduleAdapter = new RvScheduleAdapter(subjectList);
                binding.rvHomeSchedule.setAdapter(rvScheduleAdapter);
                binding.rvHomeSchedule.setLayoutManager(
                        new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));

            }

            @Override
            public void onFailure(Call<ThoiKhoaBieuResponse> call, Throwable t) {
                System.out.println(t);
            }
        });
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
}