package org.sergei.microlending.jpa.model.mappers;

import org.sergei.microlending.jpa.model.User;
import org.sergei.microlending.rest.dto.UserDTO;
import org.sergei.microlending.utils.IMapper;
import org.springframework.stereotype.Component;

/**
 * @author Sergei Visotsky
 */
@Component
public class UserModelMapper implements IMapper<UserDTO, User> {
    @Override
    public User apply(UserDTO userDTO) {
        return User.builder()
                .firstName(userDTO.getFirstName())
                .lastName(userDTO.getLastName())
                .build();
    }
}
