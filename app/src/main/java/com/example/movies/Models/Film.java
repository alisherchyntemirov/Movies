package com.example.movies.Models;

import com.google.gson.annotations.SerializedName;

public class Film {
    @SerializedName("id")
    String id;
    @SerializedName("title")
    String title;
   @SerializedName("description")
    String description;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
