package dev.sandeep.BookMyShowApr25.model;

import dev.sandeep.BookMyShowApr25.model.constant.MovieFeature;
import jakarta.persistence.Entity;

import java.util.List;

@Entity
public class Movie extends BaseModel{
    private String name;
    private String language;
    private double lengthInMinutes;
    private List<MovieFeature> movieFeatures;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public double getLengthInMinutes() {
        return lengthInMinutes;
    }

    public void setLengthInMinutes(double lengthInMinutes) {
        this.lengthInMinutes = lengthInMinutes;
    }

    public List<MovieFeature> getMovieFeatures() {
        return movieFeatures;
    }

    public void setMovieFeatures(List<MovieFeature> movieFeatures) {
        this.movieFeatures = movieFeatures;
    }
}
