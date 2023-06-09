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
import com.example.finaltaskandroid.Models.TvShow;
import com.example.finaltaskandroid.R;

import java.util.List;

public class TvAdapter extends RecyclerView.Adapter<TvAdapter.GridViewHolder> {

    private final List<TvShow> tvShowList;

    public TvAdapter(List<TvShow> tvShowList){
        this.tvShowList = tvShowList;
    }


    @NonNull
    @Override
    public TvAdapter.GridViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.carditem, parent, false);
        return new GridViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull TvAdapter.GridViewHolder holder, int position) {
        TvShow tvShow = tvShowList.get(position);
        Context c = holder.itemView.getContext();
        Glide.with(c).load("https://image.tmdb.org/t/p/w200/" + tvShow.getPoster()).into(holder.ivPoster);
        holder.tvTitle.setText(tvShow.getName());
        holder.tvYear.setText(tvShow.getReleaseYear());
        holder.itemView.setOnClickListener(view->{
            Intent toDetail = new Intent(c, MainActivity2.class);
            toDetail.putExtra(MainActivity2.EXTRA_DATA, tvShow);
            toDetail.putExtra(MainActivity2.EXTRA_TYPE, "TV");
            c.startActivity(toDetail);
        });

    }
    public void appendList(List<TvShow> listToAppend) {
        tvShowList.addAll(listToAppend);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return tvShowList.size();
    }

    public void addUser(List<TvShow> tvShows) {
        this.tvShowList.addAll(tvShows);
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
