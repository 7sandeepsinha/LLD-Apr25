package dev.sandeep.SplitwiseApr25.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class UserExpense extends BaseModel {
    @ManyToOne
    private User user;
    private double amount;
    @Enumerated(EnumType.STRING) // creates entry for enum in table, and maps it accordingly
    private UserExpenseType expenseType;
}

/*
    User : UserExpense -> 1 : M
    1      M
    1      1

    UserExpense : User -> M:1
 */