package dev.sandeep.SplitwiseApr25.service;

import dev.sandeep.SplitwiseApr25.model.Transaction;
import dev.sandeep.SplitwiseApr25.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    public Transaction save(Transaction transaction) {
        return transactionRepository.save(transaction);
    }
}
