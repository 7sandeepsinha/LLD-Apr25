package dev.sandeep.SplitwiseApr25.service;

import dev.sandeep.SplitwiseApr25.model.Expense;
import dev.sandeep.SplitwiseApr25.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExpenseService {

    @Autowired
    private ExpenseRepository expenseRepository;

    public Expense saveExpense(Expense expense) {
        return expenseRepository.save(expense);
    }

}
