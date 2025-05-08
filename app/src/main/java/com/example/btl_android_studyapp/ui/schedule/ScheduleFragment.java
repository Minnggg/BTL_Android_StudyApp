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

import com.example.btl_android_studyapp.Contanst;
import com.example.btl_android_studyapp.api.ApiClient;
import com.example.btl_android_studyapp.databinding.FragmentDashboardBinding;
import com.example.btl_android_studyapp.model.ThoiKhoaBieuResponse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ScheduleFragment extends Fragment {

    private FragmentDashboardBinding binding;

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
        ApiClient.getInstance().getService().getSchedule(createdBodyRequest(20241), "Bearer " + Contanst.userCurrent.getAccess_token()).enqueue(new Callback<ThoiKhoaBieuResponse>() {
            @Override
            public void onResponse(Call<ThoiKhoaBieuResponse> call, Response<ThoiKhoaBieuResponse> response) {
                System.out.println(response.body().toString());
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

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }


}