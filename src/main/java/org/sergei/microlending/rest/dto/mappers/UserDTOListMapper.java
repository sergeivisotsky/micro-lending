package org.sergei.microlending.rest.dto.mappers;

import org.sergei.microlending.jpa.model.User;
import org.sergei.microlending.rest.dto.UserDTO;
import org.sergei.microlending.utils.IMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Sergei Visotsky
 */
@Component
public class UserDTOListMapper implements IMapper<List<User>, List<UserDTO>> {

    private final UserDTOMapper userDTOMapper;

    @Autowired
    public UserDTOListMapper(UserDTOMapper userDTOMapper) {
        this.userDTOMapper = userDTOMapper;
    }

    @Override
    public List<UserDTO> apply(List<User> users) {
        return userDTOMapper.applyList(users);
    }
}
