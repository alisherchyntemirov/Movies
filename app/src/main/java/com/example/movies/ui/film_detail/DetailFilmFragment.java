package com.example.movies.ui.film_detail;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.example.movies.App;
import com.example.movies.Models.Film;
import com.example.movies.remole.OnFilmDetailCallBack;
import com.example.movies.databinding.FragmentFilmDetailBinding;
import com.example.movies.ui.film_list.FilmsAdapter;

public class DetailFilmFragment extends Fragment {

    private FragmentFilmDetailBinding binding;
    private String id;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentFilmDetailBinding.inflate(inflater, container, false);
        id = DetailFilmFragmentArgs.fromBundle(getArguments()).getPosition();
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getData();

    }

    private void getData() {
        App.apiService.getDetailFilms(id, new OnFilmDetailCallBack() {

            @Override
            public void success(Film model) {
                Log.e("tag", "getData");
                Glide.with(binding.imView)
                        .load(model.getImage())
                        .into(binding.imView);
                binding.titleName.setText(model.getTitle());
                binding.director.setText(model.getDirector());
                binding.titleProducer.setText(model.getProducer());
                binding.titleRunningTime.setText(model.getRunning_time());
                binding.titleReleaseDate.setText(model.getRelease_date());
            }

            @Override
            public void error() {
                Log.e("tag", "error");
            }

            @Override
            public void failure(String msg) {
                Log.e("tag", msg);
            }
        });
    }
}
