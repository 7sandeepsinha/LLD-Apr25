package dev.sandeep.SplitwiseApr25.controller;

import dev.sandeep.SplitwiseApr25.dto.CreateUserReqDTO;
import dev.sandeep.SplitwiseApr25.dto.CreateUserRespDTO;
import dev.sandeep.SplitwiseApr25.mapper.UserDTOMapper;
import dev.sandeep.SplitwiseApr25.model.User;
import dev.sandeep.SplitwiseApr25.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/user")
    public ResponseEntity<CreateUserRespDTO> createUser(@RequestBody CreateUserReqDTO createUserReqDTO) {
        User newUser = UserDTOMapper.convertDTOToEntity(createUserReqDTO);
        newUser = userService.save(newUser);
        CreateUserRespDTO createdUserResp = UserDTOMapper.convertEntityToDTO(newUser);
        return ResponseEntity.ok(createdUserResp);
    }
}
