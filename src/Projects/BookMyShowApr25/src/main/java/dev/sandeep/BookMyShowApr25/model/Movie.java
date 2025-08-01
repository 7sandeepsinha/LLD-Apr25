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
}
