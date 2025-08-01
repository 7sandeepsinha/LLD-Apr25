package dev.sandeep.BookMyShowApr25.model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class Theatre extends BaseModel{
    private String name;
    private String address;
    @OneToMany
    private List<Auditorium> auditoriums;
}
