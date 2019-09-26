package org.sergei.microlending.service.interfaces;

import org.sergei.microlending.rest.dto.ResponseDTO;
import org.sergei.microlending.rest.dto.UserDTO;
import org.springframework.stereotype.Service;

/**
 * @author Sergei Visotsky
 */
@Service
public interface UserService {

    /**
     * Get all existing users
     *
     * @return collection of users wrapped in response
     */
    ResponseDTO<UserDTO> getAllUsers();

    /**
     * Get specific user
     *
     * @param userId userId
     * @return User
     */
    ResponseDTO<UserDTO> getUserById(Long userId);
}
