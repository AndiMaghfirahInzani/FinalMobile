package com.example.finaltaskandroid.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.finaltaskandroid.Models.Movie;
import com.example.finaltaskandroid.R;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.GridViewHolder>{

    private final List<Movie> movieList;
    private AdapterView.OnItemClickListener clickListener;

    public MovieAdapter(List<Movie> movieList){
        this.movieList = movieList;
    }
    public void setClickListener(AdapterView.OnItemClickListener clickListener) {
        this.clickListener = clickListener;
    }

    @NonNull
    @Override
    public MovieAdapter.GridViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.carditem, parent, false);
        return new GridViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieAdapter.GridViewHolder holder, int position) {
        holder.onBindItemView(movieList.get(position));

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

    public class GridViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        Movie movie;
        ImageView ivPoster;
        TextView tvTitle;
        TextView tvYear;
        public GridViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            ivPoster = itemView.findViewById(R.id.ivPoster);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvYear = itemView.findViewById(R.id.tvYear);
        }
        void onBindItemView(Movie movie) {
            //set value
            this.movie = movie;
            Glide.with(itemView.getContext()).load("https://image.tmdb.org/t/p/w200/" + movie.getPosterpath()).into(ivPoster);
            tvTitle.setText(movie.getTitle());
            tvYear.setText(movie.getYear());
        }


        @Override
        public void onClick(View view) {

        }
    }
}
