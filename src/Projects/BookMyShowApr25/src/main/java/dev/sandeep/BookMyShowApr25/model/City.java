package dev.sandeep.BookMyShowApr25.model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class City extends BaseModel{
    private String name;
    @OneToMany
    @JoinColumn(name = "city_id")
    private List<Theatre> theatres;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Theatre> getTheatres() {
        return theatres;
    }

    public void setTheatres(List<Theatre> theatres) {
        this.theatres = theatres;
    }
}

//Error - Persistent entity 'City' should have primary key