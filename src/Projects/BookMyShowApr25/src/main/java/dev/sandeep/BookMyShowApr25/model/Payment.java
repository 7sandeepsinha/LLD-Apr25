package dev.sandeep.BookMyShowApr25.model;

import dev.sandeep.BookMyShowApr25.model.constant.PaymentStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Payment extends BaseModel{
    private LocalDateTime paymentTime;
    private double totalAmount;
    @OneToOne
    private Ticket ticket;
    @OneToMany
    private List<Transaction> transactions;
    private PaymentStatus paymentStatus;
}
