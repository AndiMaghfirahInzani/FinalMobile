package com.example.finaltaskandroid.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.example.finaltaskandroid.MainActivity2;
import com.example.finaltaskandroid.Models.Movie;
import com.example.finaltaskandroid.R;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.GridViewHolder>{

    private final List<Movie> movieList;

    public MovieAdapter(List<Movie> movieList){
        this.movieList = movieList;
    }

    @NonNull
    @Override
    public MovieAdapter.GridViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.carditem, parent, false);
        return new GridViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull GridViewHolder holder, int position) {
        Movie movie = movieList.get(position);
        Context c = holder.itemView.getContext();
        Glide.with(c).load("https://image.tmdb.org/t/p/w200/" + movie.getPoster()).into(holder.ivPoster);
        holder.tvTitle.setText(movie.getTitle());
        holder.tvYear.setText(movie.getYear());
        holder.itemView.setOnClickListener(view->{
            Intent toDetail = new Intent(c, MainActivity2.class);
            toDetail.putExtra(MainActivity2.EXTRA_DATA, movie);
            toDetail.putExtra(MainActivity2.EXTRA_TYPE, "MOVIE");
            c.startActivity(toDetail);
        });


    }
    public void appendList(List<Movie> listToAppend) {
        movieList.addAll(listToAppend);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }

    public void addUser(List<Movie> movie) {
        this.movieList.addAll(movie);
    }

    public class GridViewHolder extends RecyclerView.ViewHolder {
        ImageView ivPoster;
        TextView tvTitle;
        TextView tvYear;
        public GridViewHolder(@NonNull View itemView) {
            super(itemView);
            ivPoster = itemView.findViewById(R.id.ivPoster);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvYear = itemView.findViewById(R.id.tvYear);
        }

    }
}
