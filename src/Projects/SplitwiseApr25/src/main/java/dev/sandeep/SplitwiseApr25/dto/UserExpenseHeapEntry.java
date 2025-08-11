package dev.sandeep.SplitwiseApr25.dto;

import dev.sandeep.SplitwiseApr25.model.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserExpenseHeapEntry {
    private User user;
    private Double amount;

    public UserExpenseHeapEntry() {
    }

    public UserExpenseHeapEntry(User user, Double amount) {
        this.user = user;
        this.amount = amount;
    }
}
