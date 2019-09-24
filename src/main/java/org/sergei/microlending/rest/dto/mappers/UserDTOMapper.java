package org.sergei.microlending.rest.dto.mappers;

import org.sergei.microlending.jpa.model.User;
import org.sergei.microlending.rest.dto.UserDTO;
import org.sergei.microlending.utils.IMapper;
import org.springframework.stereotype.Component;

/**
 * @author Sergei Visotsky
 */
@Component
public class UserDTOMapper implements IMapper<User, UserDTO> {

    @Override
    public UserDTO apply(User user) {
        return UserDTO.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .build();
    }
}
