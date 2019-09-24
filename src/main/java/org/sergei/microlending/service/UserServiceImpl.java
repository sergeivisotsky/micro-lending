package org.sergei.microlending.service;

import org.sergei.microlending.jpa.model.User;
import org.sergei.microlending.jpa.model.mappers.UserModelMapper;
import org.sergei.microlending.jpa.repository.UserRepository;
import org.sergei.microlending.rest.dto.UserDTO;
import org.sergei.microlending.rest.dto.mappers.UserDTOListMapper;
import org.sergei.microlending.rest.dto.mappers.UserDTOMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author Sergei Visotsky
 */
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserDTOMapper userDTOMapper;
    private final UserDTOListMapper userDTOListMapper;
    private final UserModelMapper userModeLMapper;

    @Autowired
    public UserServiceImpl(UserRepository userRepository,
                           UserDTOMapper userDTOMapper,
                           UserDTOListMapper userDTOListMapper,
                           UserModelMapper userModeLMapper) {
        this.userRepository = userRepository;
        this.userDTOMapper = userDTOMapper;
        this.userDTOListMapper = userDTOListMapper;
        this.userModeLMapper = userModeLMapper;
    }

    @Override
    public List<UserDTO> getAllUsers() {
        List<User> userList = userRepository.findAll();
        return userDTOListMapper.apply(userList);
    }

    @Override
    public UserDTO getUserById(Long userId) {
        Optional<User> user = userRepository.findById(userId);
        if (user.isPresent()) {
            return userDTOMapper.apply(user.get());
        } else {
            throw new RuntimeException("User with this ID not found");
        }
    }

    @Override
    public void saveUser(UserDTO request) {

    }
}
