package dev.sandeep.BookMyShowApr25.model;

import dev.sandeep.BookMyShowApr25.model.constant.AuditoriumFeature;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Auditorium extends BaseModel{
    private String name;
    private int capacity;
    @OneToMany
    @JoinColumn(name = "auditorium_id")
    private List<Seat> seats;
    @OneToMany
    @JoinColumn(name = "auditorium_id")
    private List<Show> shows;
    private List<AuditoriumFeature> auditoriumFeatures;
}
