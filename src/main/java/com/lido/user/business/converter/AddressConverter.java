package com.lido.user.business.converter;

import com.lido.user.business.dto.AddressDTO;
import com.lido.user.infrastructure.entity.Address;
import org.springframework.stereotype.Component;

import java.util.List;

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

    public List<AddressDTO> toAdressListDTO(List<Address> addresses){
        return addresses.stream().map(this::toAdressDTO).toList();
    }

    public Address toAddressEntity(Long idUser, AddressDTO addressDTO){
        return Address.builder()
                .number(addressDTO.getNumber())
                .city(addressDTO.getCity())
                .cep(addressDTO.getCep())
                .street(addressDTO.getStreet())
                .complement(addressDTO.getComplement())
                .state(addressDTO.getState())
                .userId(idUser)
                .build();
    }
}
