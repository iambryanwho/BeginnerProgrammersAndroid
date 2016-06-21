package com.codetank.beginnerprogrammers.home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.codetank.beginnerprogrammers.R;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by manny on 6/21/16.
 */
public class HomeActivity extends AppCompatActivity{
    public static final String BASE_API = "https://api.github.com/";

    private Retrofit retrofit;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_fragment);
    }

    @Override
    protected void onResume() {
        super.onResume();
        initRetrofit();
    }

    private void initRetrofit() {
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_API)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
}
