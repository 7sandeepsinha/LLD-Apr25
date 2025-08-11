package dev.sandeep.SplitwiseApr25.service;

import dev.sandeep.SplitwiseApr25.model.UserExpense;
import dev.sandeep.SplitwiseApr25.repository.UserExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserExpenseService {

    @Autowired
    private UserExpenseRepository userExpenseRepository;

    public UserExpense save(UserExpense userExpense) {
        return userExpenseRepository.save(userExpense);
    }
}
