package dev.sandeep.BookMyShowApr25.model;

import dev.sandeep.BookMyShowApr25.model.constant.AuditoriumFeature;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class Auditorium extends BaseModel{
    private String name;
    private int capacity;
    @OneToMany
    private List<Seat> seats;
    @OneToMany
    private List<Show> shows;
    private List<AuditoriumFeature> auditoriumFeatures;
}
