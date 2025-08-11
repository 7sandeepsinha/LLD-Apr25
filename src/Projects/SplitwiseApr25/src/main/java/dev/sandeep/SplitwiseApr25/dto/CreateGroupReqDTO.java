package dev.sandeep.SplitwiseApr25.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CreateGroupReqDTO {
    private String name;
    private Integer adminId; // Admin - user id
    private List<Integer> memberIds; // Members - user ids
}
