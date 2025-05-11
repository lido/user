package com.lido.user.business;

import com.lido.user.business.converter.UserConverter;
import com.lido.user.business.dto.UserDTO;
import com.lido.user.infrastructure.entity.User;
import com.lido.user.infrastructure.exceptions.ConflictException;
import com.lido.user.infrastructure.exceptions.ResourceNotFoundException;
import com.lido.user.infrastructure.repository.UserRepository;
import com.lido.user.infrastructure.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserConverter userConverter;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    public UserDTO saveUser(UserDTO userDTO){
        checkExistsEmail(userDTO.getEmail());
        userDTO.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        User user = userConverter.toUser(userDTO);
        user = userRepository.save(user);
        return userConverter.toUserDTO(user);
    }

    public void checkExistsEmail(String email){
        try {
            boolean exists = existsEmail(email);
            if(exists)
                throw new ConflictException("Email already "+email);
        } catch (Exception e) {
            throw new ConflictException("Email already", e.getCause());
        }
    }

    public boolean existsEmail(String email){
        return userRepository.existsByEmail(email);
    }

    public User findUserByEmail(String email){
        return userRepository.findByEmail(email).orElseThrow(
                () -> new ResourceNotFoundException("Email not found " + email)
        );
    }

    public void deleteUserByEmail(String email){
        userRepository.deleteByEmail(email);
    }

    public UserDTO updateUserData(String token, UserDTO userDTO){
        String email = jwtUtil.extractEmailname(token.substring(7));

        userDTO.setPassword(userDTO.getPassword() !=null ? passwordEncoder.encode(userDTO.getPassword()) : null);

        User userEntity = userRepository.findByEmail(email).orElseThrow(
                () -> new ResourceNotFoundException("Email not found")
        );

        User user = userConverter.upadateUser(userDTO, userEntity);
        user.setPassword(passwordEncoder.encode(userEntity.getPassword()));

        return userConverter.toUserDTO(user);
    }
}
