package org.sergei.microlending.service;

import org.sergei.microlending.rest.dto.UserDTO;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Sergei Visotsky
 */
@Service
public interface UserService {
    List<UserDTO> getAllUsers();

    UserDTO getUserById(Long userId);

    void saveUser(UserDTO request);
}
