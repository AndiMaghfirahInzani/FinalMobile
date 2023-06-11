package com.example.finaltaskandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.finaltaskandroid.Models.Movie;
import com.example.finaltaskandroid.Models.TvShow;

import org.w3c.dom.Text;

public class MainActivity2 extends AppCompatActivity {

    private ImageView ivBackdrop, ivPoster, ivMovie;
    private TextView tvTitle, tvYear, tvBullet, tvDate, tvScore, tvHeader, tvSynopsis, tvMore, tvCast;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        ivBackdrop = findViewById(R.id.ivBackdrop);
        ivMovie = findViewById(R.id.ivMovie);
        ivPoster = findViewById(R.id.ivPoster);
        tvTitle = findViewById(R.id.tvTitledetail);
        tvYear = findViewById(R.id.tvYear);
        tvBullet = findViewById(R.id.tvBullet);
        tvDate = findViewById(R.id.tvYear);
        tvHeader = findViewById(R.id.tvHeader);
        tvMore = findViewById(R.id.tvMore);
        tvScore = findViewById(R.id.tvScore);
        tvHeader = findViewById(R.id.tvHeader);
        tvSynopsis = findViewById(R.id.tvSynopsis);
        tvMore = findViewById(R.id.tvMore);

        Intent intent = getIntent();
        if (intent.getParcelableExtra("movie")!= null){
            Movie movie = intent.getParcelableExtra("movie");
            tvTitle.setText(movie.getTitle());
            tvSynopsis.setText(movie.getOverview());
            tvScore.setText(movie.getVoteAverage());
            tvDate.setText(movie.getDate());

            Glide.with(this).load("https://image.tmdb.org/t/p/w200/"+ movie.getPoster()).into(ivPoster);
            Glide.with(this).load("https://image.tmdb.org/t/p/w200/"+ movie.getBackdrop()).into(ivBackdrop);

        } else if (intent.getParcelableExtra("tvShow") != null) {
            TvShow tvShow = intent.getParcelableExtra("tvShow");
            tvTitle.setText(tvShow.getName());
            tvSynopsis.setText(tvShow.getOverview());
            tvScore.setText(tvShow.getVoteAverage());
            tvDate.setText(tvShow.getAirdate());

            Glide.with(this).load("https://image.tmdb.org/t/p/w200/"+ tvShow.getPoster()).into(ivPoster);
            Glide.with(this).load("https://image.tmdb.org/t/p/w200/"+ tvShow.getBackdrop()).into(ivBackdrop);


        }

    }

}