package com.example.movies;

import android.app.Application;

import com.example.movies.remole.FilmsApi;
import com.example.movies.remole.FilmsApiService;
import com.example.movies.remole.RetrofitClient;

public class App extends Application {

    private RetrofitClient retrofitClient;
    public static FilmsApi api;
    public static FilmsApiService apiService;

    @Override
    public void onCreate() {
        super.onCreate();
        retrofitClient = new RetrofitClient();
        api= retrofitClient.filmsApiClient();
        apiService = new FilmsApiService();
    }
}
