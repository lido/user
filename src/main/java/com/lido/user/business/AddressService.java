package com.lido.user.business;

import com.lido.user.business.converter.AddressConverter;
import com.lido.user.business.dto.AddressDTO;
import com.lido.user.infrastructure.entity.Address;
import com.lido.user.infrastructure.entity.User;
import com.lido.user.infrastructure.exceptions.ResourceNotFoundException;
import com.lido.user.infrastructure.repository.AddressRepository;
import com.lido.user.infrastructure.repository.UserRepository;
import com.lido.user.infrastructure.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AddressService {

    private final AddressRepository addressRepository;
    private final AddressConverter addressConverter;
    private final JwtUtil jwtUtil;
    private final UserRepository userRepository;

    public AddressDTO updateAddress(Long idAddress, AddressDTO addressDTO){

        Address entity = addressRepository.findById(idAddress).orElseThrow(
                () -> new ResourceNotFoundException("Id not found" + idAddress)
        );

        Address address =  addressConverter.upadateAdress(addressDTO, entity);

        return addressConverter.toAdressDTO(addressRepository.save(address));
    }

    public AddressDTO registerAddress(String token, AddressDTO addressDTO){

        String email = jwtUtil.extractEmailname(token.substring(7));

        User user = userRepository.findByEmail(email).orElseThrow(
                () -> new ResourceNotFoundException("Email not found" + email )
        );

        Address address = addressConverter.toAddressEntity(user.getId(), addressDTO);

        return addressConverter.toAdressDTO(
                addressRepository.save(address)
        );
    }

}
