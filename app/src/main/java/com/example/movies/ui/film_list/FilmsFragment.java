package com.example.movies.ui.film_list;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.movies.App;
import com.example.movies.Models.Film;
import com.example.movies.databinding.FragmentFilmsBinding;
import com.example.movies.remole.OnFilmReadyCallBack;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class FilmsFragment extends Fragment {

  FragmentFilmsBinding binding;
  private FilmsAdapter adapter;
  public FilmsFragment(){

  }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentFilmsBinding.inflate(inflater,container,false);
        adapter = new FilmsAdapter();
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.recyclerFilms.setAdapter(adapter);

        App.apiService.getFilms(new OnFilmReadyCallBack() {
            @Override
            public void success(List<Film> films) {
                adapter.setFilms(films);
            }

            @Override
            public void onServerError() {
               Log.e("TAG","onServerError");
            }

            @Override
            public void failure(String msg) {
                Log.e("TAG","failure:"+msg);
            }
        });
  }


}
