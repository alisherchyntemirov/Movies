package com.example.movies.remole;

import com.example.movies.Models.Film;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface FilmsApi {

    @GET("/films")
    Call<List<Film>>getFilms();




}
