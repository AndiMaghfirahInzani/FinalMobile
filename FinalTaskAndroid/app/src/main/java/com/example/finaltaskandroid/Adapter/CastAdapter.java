package com.example.finaltaskandroid.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.finaltaskandroid.Models.Cast;
import com.example.finaltaskandroid.R;

import org.w3c.dom.Text;

import java.time.temporal.Temporal;
import java.util.List;

public class CastAdapter extends RecyclerView.Adapter<CastAdapter.CastViewHolder> {

    private final List<Cast> casts;

    public CastAdapter(List<Cast> casts) {
        this.casts = casts;
    }

    @NonNull
    @Override
    public CastAdapter.CastViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.castitem, parent, false);
        return new CastAdapter.CastViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CastAdapter.CastViewHolder holder, int position) {
    holder.tvName.setText(casts.get(position).getName());
    holder.tvCharacter.setText(casts.get(position).getCharacter());
        Glide.with(holder.itemView.getContext()).load("https://image.tmdb.org/t/p/w200/"+casts.get(position).getProfile()).into(holder.ivCast);
    }

    @Override
    public int getItemCount() {
        return casts.size();
    }

    public class CastViewHolder extends RecyclerView.ViewHolder {
        ImageView ivCast;
        TextView tvName;
        TextView tvCharacter;
        public CastViewHolder(@NonNull View itemView) {
            super(itemView);
            ivCast = itemView.findViewById(R.id.ivCast);
            tvName = itemView.findViewById(R.id.tvName);
            tvCharacter = itemView.findViewById(R.id.tvCharacter);
        }
    }
}
