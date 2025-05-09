package com.lido.user.business;

import com.lido.user.business.converter.UserConverter;
import com.lido.user.business.dto.UserDTO;
import com.lido.user.infrastructure.entity.User;
import com.lido.user.infrastructure.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserConverter userConverter;

    public UserDTO saveUser(UserDTO userDTO){
        User user = userConverter.toUser(userDTO);
        user = userRepository.save(user);
        return userConverter.toUserDTO(user);
    }

}
