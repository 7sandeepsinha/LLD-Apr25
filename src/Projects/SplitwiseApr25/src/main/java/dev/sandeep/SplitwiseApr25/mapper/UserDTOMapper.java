package dev.sandeep.SplitwiseApr25.mapper;

import dev.sandeep.SplitwiseApr25.dto.CreateUserReqDTO;
import dev.sandeep.SplitwiseApr25.dto.CreateUserRespDTO;
import dev.sandeep.SplitwiseApr25.model.User;

public class UserDTOMapper {

    public static User convertDTOToEntity(CreateUserReqDTO createUserReqDTO) {
        User user = new User();
        user.setName(createUserReqDTO.getName());
        user.setEmail(createUserReqDTO.getEmail());
        user.setPassword(createUserReqDTO.getPassword());
        return user;
    }

    public static CreateUserRespDTO convertEntityToDTO(User user) {
        CreateUserRespDTO createUserRespDTO = new CreateUserRespDTO();
        createUserRespDTO.setUserId(user.getId());
        createUserRespDTO.setName(user.getName());
        createUserRespDTO.setEmail(user.getEmail());
        return createUserRespDTO;
    }
}
