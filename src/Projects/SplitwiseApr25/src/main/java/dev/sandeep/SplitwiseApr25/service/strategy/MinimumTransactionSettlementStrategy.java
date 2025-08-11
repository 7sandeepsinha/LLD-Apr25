package dev.sandeep.SplitwiseApr25.service.strategy;

import dev.sandeep.SplitwiseApr25.dto.UserExpenseHeapEntry;
import dev.sandeep.SplitwiseApr25.model.*;

import java.util.*;

public class MinimumTransactionSettlementStrategy implements GroupSettlementStrategy{
    private PriorityQueue<UserExpenseHeapEntry> borrowersMinHeap;
    private PriorityQueue<UserExpenseHeapEntry> lendorsMaxHeap;
    private HashMap<User, Double> userAmountMap;

    public MinimumTransactionSettlementStrategy() {
        borrowersMinHeap = new PriorityQueue<>(Comparator.comparingDouble(UserExpenseHeapEntry::getAmount));
        lendorsMaxHeap = new PriorityQueue<>(Comparator.comparingDouble(UserExpenseHeapEntry::getAmount).reversed());
        userAmountMap = new HashMap<>();
    }

    @Override
    public List<Transaction> settleUp(Group group) {
        List<Expense> expenses = group.getExpenses();
        //calculating outstanding balances into userAmountMap
        for (Expense expense : expenses) {
            for (UserExpense userExpense : expense.getExpenseEntries()) {
                User user = userExpense.getUser();
                double amount = userExpense.getAmount();
                if (userExpense.getExpenseType().equals(UserExpenseType.HAD_TO_PAY)) {
                    amount = -1 * amount;
                }
                double mapAmount = userAmountMap.getOrDefault(user, 0.00);
                mapAmount += amount;
                userAmountMap.put(user, mapAmount);
            }
        }
        //inserting user's into heaps
        for (Map.Entry<User, Double> entry : userAmountMap.entrySet()) {
            if (entry.getValue() > 0) {
                // condition - amount is positive -> LENDOR -> MAX HEAP
                UserExpenseHeapEntry heapEntry = new UserExpenseHeapEntry(entry.getKey(), entry.getValue());
                lendorsMaxHeap.add(heapEntry);
            } else if (entry.getValue() < 0) {
                // condition - amount is negative -> BORROWER -> MIN HEAP
                UserExpenseHeapEntry heapEntry = new UserExpenseHeapEntry(entry.getKey(), entry.getValue());
                borrowersMinHeap.add(heapEntry);
            } else {
                // condition - amount is 0
                // no need to do anything
                // empty else is kept for understanding purposes
            }
        }
        return settleHeaps(borrowersMinHeap, lendorsMaxHeap);
    }


    private List<Transaction> settleHeaps(PriorityQueue<UserExpenseHeapEntry> borrowersMinHeap, PriorityQueue<UserExpenseHeapEntry> lendorsMaxHeap) {
        List<Transaction> transactions = new ArrayList<>();
        while (!borrowersMinHeap.isEmpty()) {
            UserExpenseHeapEntry borrower = borrowersMinHeap.poll();
            UserExpenseHeapEntry lendor = lendorsMaxHeap.poll();
            if (Math.abs(borrower.getAmount()) > lendor.getAmount()) {
                Transaction t = new Transaction(borrower.getUser(), lendor.getUser(), lendor.getAmount());
                transactions.add(t);
                borrower.setAmount(borrower.getAmount() + lendor.getAmount());
                borrowersMinHeap.add(borrower);
            } else if (Math.abs(borrower.getAmount()) < lendor.getAmount()) {
                Transaction t = new Transaction(lendor.getUser(), borrower.getUser(), Math.abs(borrower.getAmount()));
                transactions.add(t);
                lendor.setAmount(lendor.getAmount() + borrower.getAmount());
                lendorsMaxHeap.add(lendor);
            } else {
                // borrower and lendor amount is equal
                Transaction t = new Transaction(borrower.getUser(), lendor.getUser(), lendor.getAmount());
                transactions.add(t);
                //no need to add anyone back to heap, both are settled
            }
        }
        return transactions;
    }

}


/*
    Condition -> borrower is bigger
    A -> -800
    B -> 600

    A-B => -800-600 = -1400 XX
    A + (-B) => -800 + 600 => -200

    Condition -> Lendor is bigger
    A -> 1000
    B -> -500


    Condition -> lendor and borrower are equal
    A -> 500
    B -> -500


 */