package com.example.movies.remole;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://ghibliapi.herokuapp.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build();


    public FilmsApi filmsApiClient(){
        return retrofit.create(FilmsApi.class);
   }
}
