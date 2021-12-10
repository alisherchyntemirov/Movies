package com.example.movies.remole;

import com.example.movies.App;
import com.example.movies.Models.Film;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FilmsApiService {
    public void getFilms(OnFilmReadyCallBack myCallback){

        App.api.getFilms().enqueue(new Callback<List<Film>>() {
            @Override
            public void onResponse(Call<List<Film>> call, Response<List<Film>> response) {
                if (response.isSuccessful() && response.body() != null){
                        myCallback.success(response.body());
                    }else if (response.code()>500){
                    myCallback.onServerError();
                }
                }
            @Override
            public void onFailure(Call<List<Film>> call, Throwable t) {
                myCallback.failure(t.getLocalizedMessage());
            }
        });
    }
}