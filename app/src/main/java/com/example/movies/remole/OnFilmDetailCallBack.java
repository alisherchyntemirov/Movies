package com.example.movies.remole;

import com.example.movies.Models.Film;

public interface OnFilmDetailCallBack {
    void success(Film model);
    void error();
    void failure(String msg);

}
