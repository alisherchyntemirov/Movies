package com.example.movies.remole;

import com.example.movies.Models.Film;
import com.example.movies.ui.film_list.FilmsAdapter;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface FilmsApi {

    @GET("/films")
    Call<List<Film>>getFilms();

    @GET("/films/{id}")
    Call<Film> getDetailFilms(
            @Path("id") String id
    );

}
