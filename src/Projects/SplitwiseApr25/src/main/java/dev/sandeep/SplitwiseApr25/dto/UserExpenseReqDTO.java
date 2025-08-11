package dev.sandeep.SplitwiseApr25.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserExpenseReqDTO {
    private Integer userId;
    private Double amount;
    private Integer expenseType;
}
