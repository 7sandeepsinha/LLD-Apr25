package dev.sandeep.SplitwiseApr25.service.strategy;

import dev.sandeep.SplitwiseApr25.model.Group;
import dev.sandeep.SplitwiseApr25.model.Transaction;

import java.util.List;

public interface GroupSettlementStrategy {
    List<Transaction> settleUp(Group group);
}


