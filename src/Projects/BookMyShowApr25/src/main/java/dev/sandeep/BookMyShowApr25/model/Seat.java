package dev.sandeep.BookMyShowApr25.model;

import dev.sandeep.BookMyShowApr25.model.constant.SeatStatus;
import dev.sandeep.BookMyShowApr25.model.constant.SeatType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

@Entity
public class Seat extends BaseModel{
    private int row;
    private int col;
    private String seatNumber;
    private SeatType seatType;
    private SeatStatus seatStatus;
}
