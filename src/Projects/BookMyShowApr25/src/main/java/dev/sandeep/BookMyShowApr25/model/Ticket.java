package dev.sandeep.BookMyShowApr25.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Ticket extends BaseModel{
    @OneToMany
    private List<ShowSeat> showSeats;
    @ManyToOne
    private Show show;
    private LocalDateTime bookingTime;
    private double totalCost;
    @ManyToOne
    private User user;
}
