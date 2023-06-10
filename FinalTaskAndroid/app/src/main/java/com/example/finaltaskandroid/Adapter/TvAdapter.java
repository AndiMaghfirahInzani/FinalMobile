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
import com.example.finaltaskandroid.Models.TvShow;
import com.example.finaltaskandroid.R;

import java.util.List;

public class TvAdapter extends RecyclerView.Adapter<TvAdapter.GridViewHolder> {

    private final List<TvShow> tvShowList;
    private AdapterView.OnItemClickListener clickListener;

    public TvAdapter(List<TvShow> tvShowList){
        this.tvShowList = tvShowList;
    }
    public void setClickListener(AdapterView.OnItemClickListener clickListener) {
        this.clickListener = clickListener;
    }


    @NonNull
    @Override
    public TvAdapter.GridViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.carditem, parent, false);
        return new GridViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull TvAdapter.GridViewHolder holder, int position) {
        holder.onBindItemView(tvShowList.get(position));

    }
    public void appendList(List<TvShow> listToAppend) {
        tvShowList.addAll(listToAppend);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return tvShowList.size();
    }

    public class GridViewHolder extends RecyclerView.ViewHolder {

        TvShow tvShow;
        ImageView ivPoster;
        TextView tvTitle;
        TextView tvYear;
        public GridViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener((View.OnClickListener) this);

            ivPoster = itemView.findViewById(R.id.ivPoster);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvYear = itemView.findViewById(R.id.tvYear);
        }

        public void onBindItemView(TvShow tvShow) {
            this.tvShow = tvShow;
            Glide.with(itemView.getContext()).load("https://image.tmdb.org/t/p/w200/" + tvShow.getPosterpath()).into(ivPoster);
            tvTitle.setText(tvShow.getTitle());
            tvYear.setText(tvShow.getReleaseYear());
        }
    }
}
