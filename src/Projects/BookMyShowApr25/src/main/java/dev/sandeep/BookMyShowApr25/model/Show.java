package dev.sandeep.BookMyShowApr25.model;

import dev.sandeep.BookMyShowApr25.model.constant.ShowStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

import java.time.LocalDate;
import java.util.List;

@Entity
public class Show extends BaseModel{
    private LocalDate startTime;
    private LocalDate endTime;
    private String language;
    @ManyToOne
    private Movie movie;
    @ManyToOne
    private Auditorium auditorium;
    private ShowStatus showStatus;
    @OneToMany
    @JoinColumn(name = "show_id")
    private List<ShowSeat> showSeats;
}
