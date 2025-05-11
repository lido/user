package com.lido.user.business.converter;

import com.lido.user.business.dto.AddressDTO;
import com.lido.user.business.dto.PhoneDTO;
import com.lido.user.business.dto.UserDTO;
import com.lido.user.infrastructure.entity.Address;
import com.lido.user.infrastructure.entity.Phone;
import com.lido.user.infrastructure.entity.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserConverter {

    public User toUser(UserDTO userDTO){
        return User.builder()
                .name(userDTO.getName())
                .email(userDTO.getEmail())
                .password(userDTO.getPassword())
                .addresses(toAdressList(userDTO.getAddresses()))
                .phones(toPhonesList(userDTO.getPhones()))
                .build();
    }

    public List<Address> toAdressList(List<AddressDTO> addressDTOS){
        return addressDTOS.stream().map(this::toAdress).toList();
    }

    public Address toAdress(AddressDTO addressDTO){
        return Address.builder()
                .cep(addressDTO.getCep())
                .city(addressDTO.getCity())
                .state(addressDTO.getState())
                .complement(addressDTO.getComplement())
                .number(addressDTO.getNumber())
                .street(addressDTO.getStreet())
                .build();
    }

    public List<Phone> toPhonesList(List<PhoneDTO> phoneDTOS){
        return phoneDTOS.stream().map(this::toPhone).toList();
    }

    public Phone toPhone(PhoneDTO phoneDTO){
        return Phone.builder()
                .ddd(phoneDTO.getDdd())
                .number(phoneDTO.getNumber())
                .build();
    }


    public UserDTO toUserDTO(User user){
        return UserDTO.builder()
                .name(user.getName())
                .email(user.getEmail())
                .password(user.getPassword())
                .addresses(toAdressListDTO(user.getAddresses()))
                .phones(toPhonesListDTO(user.getPhones()))
                .build();
    }

    public List<AddressDTO> toAdressListDTO(List<Address> addresses){
        return addresses.stream().map(this::toAdressDTO).toList();
    }

    public AddressDTO toAdressDTO(Address address){
        return AddressDTO.builder()
                .cep(address.getCep())
                .city(address.getCity())
                .state(address.getState())
                .complement(address.getComplement())
                .number(address.getNumber())
                .street(address.getStreet())
                .build();
    }

    public List<PhoneDTO> toPhonesListDTO(List<Phone> phones){
        return phones.stream().map(this::toPhoneDTO).toList();
    }

    public PhoneDTO toPhoneDTO(Phone phone){
        return PhoneDTO.builder()
                .ddd(phone.getDdd())
                .number(phone.getNumber())
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
