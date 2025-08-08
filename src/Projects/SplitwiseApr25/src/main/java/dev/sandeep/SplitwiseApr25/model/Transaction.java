package dev.sandeep.SplitwiseApr25.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "SW_TRANSACTION")
public class Transaction extends BaseModel {
    @ManyToOne
    private User sender;
    @ManyToOne
    private User recipient;
    private double amount;
    @ManyToOne
    private Group group;
}

/*
        Transaction Sender
        User Transaction -> 1:M
        1       M
        1       1

        Transaction Receiver
        User Transaction -> 1:M
        1       M
        1       1
 */