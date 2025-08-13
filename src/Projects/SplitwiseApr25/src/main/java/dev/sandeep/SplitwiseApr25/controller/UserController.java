package dev.sandeep.SplitwiseApr25.controller;

import dev.sandeep.SplitwiseApr25.configuration.BCryptEncoder;
import dev.sandeep.SplitwiseApr25.dto.CreateUserReqDTO;
import dev.sandeep.SplitwiseApr25.dto.CreateUserRespDTO;
import dev.sandeep.SplitwiseApr25.dto.LoginReqDTO;
import dev.sandeep.SplitwiseApr25.mapper.UserDTOMapper;
import dev.sandeep.SplitwiseApr25.model.User;
import dev.sandeep.SplitwiseApr25.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private BCryptEncoder bCryptEncoder;

    @PostMapping("/user")
    public ResponseEntity<CreateUserRespDTO> createUser(@RequestBody CreateUserReqDTO createUserReqDTO) {
        createUserReqDTO.setPassword(bCryptEncoder.encode(createUserReqDTO.getPassword()));
        User newUser = UserDTOMapper.convertDTOToEntity(createUserReqDTO);
        newUser = userService.save(newUser);
        CreateUserRespDTO createdUserResp = UserDTOMapper.convertEntityToDTO(newUser);
        return ResponseEntity.ok(createdUserResp);
    }

    @GetMapping("/login")
    public User login(@RequestBody LoginReqDTO loginReqDTO) {
        return userService.login(loginReqDTO.getEmail(), loginReqDTO.getPassword());
    }
}
