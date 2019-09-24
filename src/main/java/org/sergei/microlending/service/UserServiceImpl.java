package org.sergei.microlending.service;

import org.sergei.microlending.jpa.model.User;
import org.sergei.microlending.jpa.model.mappers.UserModelMapper;
import org.sergei.microlending.jpa.repository.UserRepository;
import org.sergei.microlending.rest.dto.ErrorMessageDTO;
import org.sergei.microlending.rest.dto.ResponseDTO;
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

    @Autowired
    public UserServiceImpl(UserRepository userRepository,
                           UserDTOMapper userDTOMapper,
                           UserDTOListMapper userDTOListMapper,
                           UserModelMapper userModeLMapper) {
        this.userRepository = userRepository;
        this.userDTOMapper = userDTOMapper;
        this.userDTOListMapper = userDTOListMapper;
    }

    @Override
    public ResponseDTO<UserDTO> getAllUsers() {
        List<User> userList = userRepository.findAll();
        return ResponseDTO.<UserDTO>builder()
                .errors(List.of())
                .response(userDTOListMapper.apply(userList))
                .build();
    }

    @Override
    public ResponseDTO<UserDTO> getUserById(Long userId) {
        Optional<User> user = userRepository.findById(userId);
        if (user.isPresent()) {
            return ResponseDTO.<UserDTO>builder()
                    .errors(List.of())
                    .response(List.of(userDTOMapper.apply(user.get())))
                    .build();
        } else {
            return ResponseDTO.<UserDTO>builder()
                    .errors(List.of(
                            ErrorMessageDTO.builder()
                                    .errorCode("USER_NOT_FOUND")
                                    .errorMsg("User with this ID not found")
                                    .stacktrace(null)
                                    .build()))
                    .response(List.of())
                    .build();

        }
    }
}
