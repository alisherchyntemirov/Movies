package com.example.movies.remole;

import com.example.movies.Models.Film;

import java.util.List;

public interface OnFilmReadyCallBack {
    void success (List<Film> films);
    void onServerError();
    void failure(String msg);

}
