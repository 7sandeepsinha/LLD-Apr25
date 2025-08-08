package dev.sandeep.SplitwiseApr25.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateUserReqDTO {
    private String name;
    private String email;
    private String password;
}
