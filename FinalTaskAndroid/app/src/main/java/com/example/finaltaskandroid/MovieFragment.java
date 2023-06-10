package com.example.finaltaskandroid;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.finaltaskandroid.Adapter.MovieAdapter;
import com.example.finaltaskandroid.Models.MovieResponse;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieFragment extends Fragment {
    MovieAdapter movieAdapter;
    RecyclerView rv;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movie, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        rv = view.findViewById(R.id.rvMovie);


        ApiConfig.getApiService().getMovie(ApiConfig.getApikey()).enqueue(new Callback<MovieResponse>(){
            @Override
            public void onResponse(@NonNull Call<MovieResponse> call, @NonNull Response<MovieResponse> response) {
                if (response.isSuccessful() && response.body() != null){
                    MovieAdapter movieAdapter = new MovieAdapter(new ArrayList<>());
                    movieAdapter.addUser(response.body().getMovie());
                    rv.setAdapter(movieAdapter);
                    int numberOfColumns = 2; // Jumlah kolom yang diinginkan
                    GridLayoutManager layoutManager = new GridLayoutManager(getActivity(), numberOfColumns);
                    rv.setLayoutManager(layoutManager  );
                }
            }
            @Override
            public void onFailure(@NonNull Call<MovieResponse> call, @NonNull Throwable t) {
                Log.e("MainActivity", "onFailure: " + t.getMessage());
            }
        });
    }
}