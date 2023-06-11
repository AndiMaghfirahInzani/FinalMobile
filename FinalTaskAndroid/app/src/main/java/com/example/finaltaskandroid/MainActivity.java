package com.example.finaltaskandroid;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity implements NavigationBarView.OnItemSelectedListener {

    private TextView toolbar;
    private BottomNavigationView bottomNavigationView;
    private MovieFragment movieFragment = new MovieFragment();
    private TvFragment tvFragment = new TvFragment();
    private FavoriteFragment favoriteFragment = new FavoriteFragment();

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.tv_toolbar);
        bottomNavigationView = findViewById(R.id.bottomView);
        bottomNavigationView.setOnItemSelectedListener(this);
        bottomNavigationView.setSelectedItemId(R.id.menutvshow);


    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.menutvshow:
                getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, tvFragment).commit();
                toolbar.setText("Tv Show");
                return true;
            case R.id.menumovie:
                getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, movieFragment).commit();
                toolbar.setText("Movie");
                return true;
            case R.id.menufav:
                getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, favoriteFragment).commit();
                toolbar.setText("Favorite");
                return true;
        }
        return false;
    }
    public void navigateFragment(Fragment fragment, String tag){
        getSupportFragmentManager().beginTransaction().replace(R.id.flFragment,fragment, tag).commit();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == MainActivity2.DETAIL_RESULT_CODE) {
            FavoriteFragment favoriteFragment = (FavoriteFragment) getSupportFragmentManager().findFragmentByTag("fav");
            if (favoriteFragment != null) {
                favoriteFragment.fetchData();
            }
        }
    }

}