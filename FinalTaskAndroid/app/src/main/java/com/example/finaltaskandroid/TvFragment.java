package com.example.finaltaskandroid;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

import com.example.finaltaskandroid.Adapter.TvAdapter;
import com.example.finaltaskandroid.Models.TvResponse;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TvFragment extends Fragment {

    private ProgressBar progressBar;
    RecyclerView rv;
    private LinearLayout llConnection;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tv, container, false);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        rv = view.findViewById(R.id.rvTv);
        progressBar = view.findViewById(R.id.pb_tv);
        llConnection = view.findViewById(R.id.llConnection);


        ApiConfig.getApiService().getTvshow(ApiConfig.getApikey()).enqueue(new Callback<TvResponse>(){
            @Override
            public void onResponse(@NonNull Call<TvResponse> call, @NonNull Response<TvResponse> response) {
                if (response.isSuccessful() && response.body() != null){
                    TvAdapter tvAdapter = new TvAdapter(new ArrayList<>());
                    tvAdapter.addUser(response.body().getTvShows());
                    rv.setAdapter(tvAdapter);
                    int numberOfColumns = 2; // Jumlah kolom yang diinginkan
                    GridLayoutManager layoutManager = new GridLayoutManager(getActivity(), numberOfColumns);
                    rv.setLayoutManager(layoutManager  );
                    progressBar.setVisibility(View.GONE);
                    llConnection.setVisibility(View.GONE);
                }
            }
            @Override
            public void onFailure(@NonNull Call<TvResponse> call, @NonNull Throwable t) {
                Log.e("MainActivity", "onFailure: " + t.getMessage());
            }
        });
    }
}