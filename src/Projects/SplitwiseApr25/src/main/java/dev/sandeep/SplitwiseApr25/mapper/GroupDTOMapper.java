package dev.sandeep.SplitwiseApr25.mapper;

import dev.sandeep.SplitwiseApr25.dto.CreateGroupRespDTO;
import dev.sandeep.SplitwiseApr25.model.Group;
import dev.sandeep.SplitwiseApr25.model.User;

import java.util.ArrayList;
import java.util.List;

public class GroupDTOMapper {

    public static CreateGroupRespDTO convertEntityToDTO(Group group) {
        CreateGroupRespDTO createGroupRespDTO = new CreateGroupRespDTO();
        createGroupRespDTO.setGroupId(group.getId());
        createGroupRespDTO.setGroupName(group.getName());
        createGroupRespDTO.setAdminName(group.getAdmin().getName());
        List<String> members = new ArrayList<>();
        for(User user : group.getMembers()) {
            members.add(user.getName());
        }
        createGroupRespDTO.setMembers(members);
        return createGroupRespDTO;
    }
}
