package dev.sandeep.SplitwiseApr25.repository;

import dev.sandeep.SplitwiseApr25.model.Expense;
import dev.sandeep.SplitwiseApr25.model.UserExpense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserExpenseRepository extends JpaRepository<UserExpense, Integer> {
}
