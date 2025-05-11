package com.lido.user.business;

import com.lido.user.business.converter.PhoneConverter;
import com.lido.user.business.dto.PhoneDTO;
import com.lido.user.infrastructure.entity.Phone;
import com.lido.user.infrastructure.exceptions.ResourceNotFoundException;
import com.lido.user.infrastructure.repository.PhoneRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PhoneService {

    private final PhoneRepository phoneRepository;
    private final PhoneConverter phoneConverter;

    public PhoneDTO updatePhone(Long idPhone, PhoneDTO phoneDTO){
        Phone entity = phoneRepository.findById(idPhone).orElseThrow(
                ()-> new ResourceNotFoundException("Id not found " + idPhone)
        );

        Phone phone = phoneConverter.updatePhone(phoneDTO, entity);

        return phoneConverter.toPhoneDTO(phoneRepository.save(phone));
    }
}
