package dev.sandeep.BookMyShowApr25.model;

import dev.sandeep.BookMyShowApr25.model.constant.ShowSeatStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class ShowSeat extends BaseModel{
    private int price;
    @ManyToOne
    private Seat seat;
    @ManyToOne
    private Show show;
    private ShowSeatStatus showSeatStatus;
}
