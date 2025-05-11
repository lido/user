package com.lido.user.business;

import com.lido.user.business.converter.AddressConverter;
import com.lido.user.business.dto.AddressDTO;
import com.lido.user.infrastructure.entity.Address;
import com.lido.user.infrastructure.exceptions.ResourceNotFoundException;
import com.lido.user.infrastructure.repository.AddressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AddressService {

    private final AddressRepository addressRepository;
    private final AddressConverter addressConverter;

    public AddressDTO updateAddress(Long idAddress, AddressDTO addressDTO){

        Address entity = addressRepository.findById(idAddress).orElseThrow(
                () -> new ResourceNotFoundException("Id not found" + idAddress)
        );

        Address address =  addressConverter.upadateAdress(addressDTO, entity);

        return addressConverter.toAdressDTO(addressRepository.save(address));
    }

}
