package org.sergei.microlending.service.interfaces;

import org.sergei.microlending.rest.dto.ResponseDTO;
import org.sergei.microlending.rest.dto.UserDTO;
import org.springframework.stereotype.Service;

/**
 * @author Sergei Visotsky
 */
@Service
public interface UserService {
    ResponseDTO<UserDTO> getAllUsers();

    ResponseDTO<UserDTO> getUserById(Long userId);
}
