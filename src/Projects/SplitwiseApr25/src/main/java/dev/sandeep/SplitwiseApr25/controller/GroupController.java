package dev.sandeep.SplitwiseApr25.controller;

import dev.sandeep.SplitwiseApr25.dto.CreateExpenseReqDTO;
import dev.sandeep.SplitwiseApr25.dto.CreateGroupReqDTO;
import dev.sandeep.SplitwiseApr25.dto.CreateGroupRespDTO;
import dev.sandeep.SplitwiseApr25.mapper.GroupDTOMapper;
import dev.sandeep.SplitwiseApr25.model.Expense;
import dev.sandeep.SplitwiseApr25.model.Group;
import dev.sandeep.SplitwiseApr25.model.Transaction;
import dev.sandeep.SplitwiseApr25.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GroupController {

    @Autowired
    private GroupService groupService;

    @PostMapping("/group")
    public ResponseEntity<CreateGroupRespDTO> createGroup(@RequestBody CreateGroupReqDTO groupReqDTO) {
        //TODO: validation to add limited number of members
        Group createdGroup = groupService.createGroup(groupReqDTO);
        CreateGroupRespDTO responseDTO = GroupDTOMapper.convertEntityToDTO(createdGroup);
        return ResponseEntity.ok(responseDTO);
    }

    @PostMapping("/group/expense/{id}")
    public ResponseEntity<String> addExpenseToGroup(@RequestBody CreateExpenseReqDTO reqDTO, @PathVariable("id") int groupId){
        //TODO : add a response DTO and required mapper methods for expense entry
        Expense savedExpense = groupService.addExpenseToGroup(reqDTO, groupId);
        if(savedExpense != null){
            return ResponseEntity.ok("Expense added successfully");
        } else {
            return ResponseEntity.ok("Expense not added successfully");
        }
    }

    @GetMapping("/group/settle/{id}")
    public ResponseEntity settleUp(@PathVariable("id") int groupId){
        List<Transaction> transactions = groupService.settleUp(groupId);
        return ResponseEntity.ok(transactions);
    }
}
