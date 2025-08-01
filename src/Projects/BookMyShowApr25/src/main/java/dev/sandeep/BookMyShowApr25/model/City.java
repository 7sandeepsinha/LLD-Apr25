package dev.sandeep.BookMyShowApr25.model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class City extends BaseModel{
    private String name;
    @OneToMany
    private List<Theatre> theatres;
}

//Error - Persistent entity 'City' should have primary key