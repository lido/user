package com.lido.user.business.converter;

import com.lido.user.business.dto.AddressDTO;
import com.lido.user.infrastructure.entity.Address;
import org.springframework.stereotype.Component;

@Component
public class AddressConverter {

    public Address upadateAdress(AddressDTO addressDTO, Address entity){
        return Address.builder()
                .id(addressDTO.getId() != null ? addressDTO.getId() : entity.getId())
                .cep(addressDTO.getCep() != null ? addressDTO.getCep() : entity.getCep())
                .city(addressDTO.getCity() != null ? addressDTO.getCity() : entity.getCity())
                .state(addressDTO.getState() != null ? addressDTO.getState() : entity.getState())
                .number(addressDTO.getNumber() != null ? addressDTO.getNumber() : entity.getNumber())
                .street(addressDTO.getStreet() != null ? addressDTO.getStreet() : entity.getStreet())
                .complement(addressDTO.getComplement() != null ? addressDTO.getComplement() : entity.getComplement())
                .build();
    }

    public AddressDTO toAdressDTO(Address address){
        return AddressDTO.builder()
                .id(address.getId())
                .cep(address.getCep())
                .city(address.getCity())
                .state(address.getState())
                .complement(address.getComplement())
                .number(address.getNumber())
                .street(address.getStreet())
                .build();
    }
}
