package com.lido.user.business.converter;

import com.lido.user.business.dto.UserDTO;
import com.lido.user.infrastructure.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class UserConverter {

    private final AddressConverter addressConverter;
    public final PhoneConverter phoneConverter;

    public User toUser(UserDTO userDTO){
        return User.builder()
                .name(userDTO.getName())
                .email(userDTO.getEmail())
                .password(userDTO.getPassword())
                .addresses(addressConverter.toAdressList(userDTO.getAddresses()))
                .phones(phoneConverter.toPhonesList(userDTO.getPhones()))
                .build();
    }

    public UserDTO toUserDTO(User user){
        return UserDTO.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .password(user.getPassword())
                .addresses(addressConverter.toAdressListDTO(user.getAddresses()))
                .phones(phoneConverter.toPhonesListDTO(user.getPhones()))
                .build();
    }

    public User upadateUser(UserDTO userDTO, User entity){
        return User.builder()
                .name(userDTO.getName() != null ? userDTO.getName() : entity.getName())
                .id(entity.getId())
                .password(userDTO.getPassword() != null ? userDTO.getPassword() : entity.getPassword())
                .email(userDTO.getEmail() !=null ? userDTO.getEmail() : entity.getEmail())
                .addresses(entity.getAddresses())
                .phones(entity.getPhones())
                .build();

    }
}
