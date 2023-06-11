package com.example.finaltaskandroid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.finaltaskandroid.Models.Favorite;
import com.example.finaltaskandroid.Models.Movie;
import com.example.finaltaskandroid.Models.TvShow;
import com.example.finaltaskandroid.db.FavHelper;
import com.example.finaltaskandroid.db.MapHelper;
import com.google.android.material.card.MaterialCardView;

import org.w3c.dom.Text;

public class MainActivity2 extends AppCompatActivity {

    public static final String EXTRA_DATA = "data";
    public static final String EXTRA_TYPE = "type";
    public static final int DETAIL_RESULT_CODE = 102;


    private ImageView ivBackdrop, ivPoster, ivMovie, ivFavorite;
    private TextView tvTitle, tvYear, tvDate, tvScore, tvHeader, tvSynopsis, tvMore, tvToolbar;
    private MaterialCardView btnFavorite;
    private boolean isFavorite;
    private Toolbar toolbar;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        ivBackdrop = findViewById(R.id.ivBackdrop);
        ivMovie = findViewById(R.id.ivMovie);
        ivPoster = findViewById(R.id.ivPoster);
        tvTitle = findViewById(R.id.tvTitledetail);
        tvDate = findViewById(R.id.tvYear);
        tvHeader = findViewById(R.id.tvHeader);
        tvMore = findViewById(R.id.tvMore);
        tvScore = findViewById(R.id.tvScore);
        tvHeader = findViewById(R.id.tvHeader);
        tvSynopsis = findViewById(R.id.tvSynopsis);
        tvMore = findViewById(R.id.tvMore);
        btnFavorite = findViewById(R.id.btn_favorite);
        tvToolbar = findViewById(R.id.tv_toolbar);
        tvYear = findViewById(R.id.tvYear);
        ivFavorite = findViewById(R.id.iv_favorite);
        toolbar =findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        toolbar.setNavigationOnClickListener(v->onBackPressed());

        String type = getIntent().getStringExtra(EXTRA_TYPE);
        if(type.equals("MOVIE")){
            Movie movie = getIntent().getParcelableExtra(EXTRA_DATA);
            handlingMovieDetailView(movie);
            checkFavoriteStatus(movie.getId());
            btnFavorite.setOnClickListener(v->onFavClick(movie));
        }else if(type.equals("TV")){
            TvShow tv = getIntent().getParcelableExtra(EXTRA_DATA);
            handlingTvDetailView(tv);
            checkFavoriteStatus(tv.getId());
            btnFavorite.setOnClickListener(v->onFavClick(tv));
        }else if(type.equals("FAVORITE")){
            Favorite fav = getIntent().getParcelableExtra(EXTRA_DATA);
            handlingFavoriteDetailView(fav);
            checkFavoriteStatus(fav.getTmdbId());
            btnFavorite.setOnClickListener(v->onFavClick(fav));
        }

    }
    private void checkFavoriteStatus(int tmdbId){
        FavHelper favHelper = FavHelper.getInstance(this);
        favHelper.open();
        isFavorite = favHelper.isFavorite(tmdbId);
        if(isFavorite){
            ivFavorite.setImageResource(R.drawable.baseline_favorite_border_24);
        }else{
            ivFavorite.setImageResource(R.drawable.baseline_favorite_border_24);
        }
        favHelper.close();
    }
    private void onFavClick(Movie movie){
        FavHelper favHelper = FavHelper.getInstance(this);
        favHelper.open();
        Favorite favorite = new Favorite(movie.getId(), movie.getTitle(), movie.getOverview(), movie.getVoteAverage(),movie.getVoteAverage(), true, movie.getDate(), movie.getPoster());
        if(isFavorite){
            favHelper.delete(movie.getId());
            FavoriteFragment.favAdapter.removeItem(favorite);
            Toast.makeText(this, movie.getTitle() + " Dihapus dari Favorite", Toast.LENGTH_SHORT).show();
        }else{
            favHelper.create(MapHelper.favToContentValues(favorite));
            FavoriteFragment.favAdapter.addItem(favorite);
            Toast.makeText(this, movie.getTitle() + " Ditambahkan ke Favorite", Toast.LENGTH_SHORT).show();
        }
        checkFavoriteStatus(favorite.getTmdbId());
        favHelper.close();
    }
    private void onFavClick(Favorite fav){
        FavHelper favHelper = FavHelper.getInstance(this);
        favHelper.open();
        if(isFavorite){
            favHelper.delete(fav.getTmdbId());
            FavoriteFragment.favAdapter.removeItem(fav);
            Toast.makeText(this, fav.getTitle() + " Dihapus dari Favorite", Toast.LENGTH_SHORT).show();

        }else{
            favHelper.create(MapHelper.favToContentValues(fav));
            FavoriteFragment.favAdapter.addItem(fav);
            Toast.makeText(this, fav.getTitle() + " Ditambahkan ke Favorite", Toast.LENGTH_SHORT).show();

        }
        checkFavoriteStatus(fav.getTmdbId());
        favHelper.close();
    }

    private void onFavClick(TvShow tv){
        FavHelper favHelper = FavHelper.getInstance(this);
        favHelper.open();
        Favorite favorite = new Favorite(tv.getId(), tv.getName(), tv.getOverview(), tv.getVoteAverage(),tv.getBackdrop(), false, tv.getAirdate(), tv.getPoster());
        if(isFavorite){
            favHelper.delete(tv.getId());
            FavoriteFragment.favAdapter.removeItem(favorite);
            Toast.makeText(this, tv.getName() + " Dihapus dari Favorite", Toast.LENGTH_SHORT).show();

        }else{
            favHelper.create(MapHelper.favToContentValues(favorite));
            FavoriteFragment.favAdapter.addItem(favorite);
            Toast.makeText(this, tv.getName() + " Ditambahkan ke Favorite", Toast.LENGTH_SHORT).show();

        }
        checkFavoriteStatus(favorite.getTmdbId());
        favHelper.close();
    }
    private void handlingMovieDetailView(Movie movie){
        tvToolbar.setText("Detail Movie");
        tvTitle.setText(movie.getTitle());
        tvYear.setText(movie.getYear());
        tvSynopsis.setText(movie.getOverview().isEmpty() ? "-" : movie.getOverview());
        tvScore.setText(movie.getVoteAverage());
        Glide.with(this).load("https://image.tmdb.org/t/p/w200/" + movie.getPoster()).into(ivPoster);
        Glide.with(this).load("https://image.tmdb.org/t/p/w200/" + movie.getBackdrop()).into(ivBackdrop);
    }

    private void handlingTvDetailView(TvShow tvShow){
        tvToolbar.setText("Detail Tv Show");
        tvTitle.setText(tvShow.getName());
        tvYear.setText(tvShow.getReleaseYear());
        tvSynopsis.setText(tvShow.getOverview().isEmpty() ? "-" : tvShow.getOverview());
        tvScore.setText(tvShow.getVoteAverage());
        Glide.with(this).load("https://image.tmdb.org/t/p/w200/" + tvShow.getPoster()).into(ivPoster);
        Glide.with(this).load("https://image.tmdb.org/t/p/w200/" + tvShow.getBackdrop()).into(ivBackdrop);
    }

    private void handlingFavoriteDetailView(Favorite fav){
        tvToolbar.setText(fav.isMovie() ? "Detail Movie" : "Detail Tv Show");
        tvTitle.setText(fav.getTitle());
        tvYear.setText(fav.getYear());
        tvSynopsis.setText(fav.getOverview().isEmpty() ? "-" : fav.getOverview());
        tvScore.setText(fav.getVoteAverage());
        Glide.with(this).load("https://image.tmdb.org/t/p/w200/" + fav.getPosterpath()).into(ivPoster);
        Glide.with(this).load("https://image.tmdb.org/t/p/w200/" + fav.getBannerUrl()).into(ivBackdrop);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if(getIntent().getStringExtra(EXTRA_TYPE).equals("FAVORITE")){
            Intent intent = new Intent();
            setResult(RESULT_OK, intent);
            finish();
        }
    }

}