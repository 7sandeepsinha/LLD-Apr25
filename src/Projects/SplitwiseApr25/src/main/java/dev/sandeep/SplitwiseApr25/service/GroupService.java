package dev.sandeep.SplitwiseApr25.service;

import dev.sandeep.SplitwiseApr25.dto.CreateExpenseReqDTO;
import dev.sandeep.SplitwiseApr25.dto.CreateGroupReqDTO;
import dev.sandeep.SplitwiseApr25.dto.UserExpenseReqDTO;
import dev.sandeep.SplitwiseApr25.exception.GroupDoesNotExistException;
import dev.sandeep.SplitwiseApr25.model.*;
import dev.sandeep.SplitwiseApr25.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class GroupService {

    @Autowired
    private GroupRepository groupRepository;
    @Autowired
    private UserService userService;
    @Autowired
    private UserExpenseService userExpenseService;
    @Autowired
    private ExpenseService expenseService;

    public Group findGroupById(int id) {
        return groupRepository.findById(id).orElseThrow(
                () -> new GroupDoesNotExistException("Group with id " + id + " does not exist")
        );
    }

    public Group createGroup(CreateGroupReqDTO groupReqDTO) {
        Group group = new Group();
        group.setName(groupReqDTO.getName());

        User admin = userService.findUserById(groupReqDTO.getAdminId());
        List<User> members = new ArrayList<>();
        for(Integer id : groupReqDTO.getMemberIds()) {
            members.add(userService.findUserById(id));
        };
        members.add(admin);
        group.setAdmin(admin);
        group.setMembers(members);
        return groupRepository.save(group);
    }

    public Expense addExpenseToGroup(CreateExpenseReqDTO reqDTO, int groupId) {
        //get group object
        Group group = findGroupById(groupId);
        //create expense object and populate basic fields
        Expense expense = new Expense();
        expense.setAmount(reqDTO.getAmount());
        expense.setDescription(reqDTO.getDescription());
        expense.setEntryTime(LocalDateTime.now());
        User createdByUser = userService.findUserById(reqDTO.getCreatedByUserId());
        expense.setCreatedBy(createdByUser);
        List<UserExpense> userExpenses = new ArrayList<>();

        //loop through all user expense DTOs, and create user expense entities in DB
        for(UserExpenseReqDTO userExpenseReqDTO : reqDTO.getUserExpenseDTOs()){
            UserExpense userExpense = new UserExpense();
            userExpense.setUser(userService.findUserById(userExpenseReqDTO.getUserId()));
            userExpense.setAmount(userExpenseReqDTO.getAmount());
            if(userExpenseReqDTO.getExpenseType() == 1){
                userExpense.setExpenseType(UserExpenseType.PAID);
            } else {
                userExpense.setExpenseType(UserExpenseType.HAD_TO_PAY);
            }
            userExpense = userExpenseService.save(userExpense);
            userExpenses.add(userExpense);
        }
        // set all user expense entries in expense
        expense.setExpenseEntries(userExpenses);
        expense =  expenseService.saveExpense(expense);
        // update group to expense mapping
        group.getExpenses().add(expense);
        groupRepository.save(group);

        return expense;
    }
}
