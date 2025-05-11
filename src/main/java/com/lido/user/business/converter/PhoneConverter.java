package com.lido.user.business.converter;

import com.lido.user.business.dto.PhoneDTO;
import com.lido.user.infrastructure.entity.Phone;
import org.springframework.stereotype.Component;

@Component
public class PhoneConverter {

    public Phone updatePhone(PhoneDTO phoneDTO, Phone entity){
        return Phone.builder()
                .id(phoneDTO.getId() != null ? phoneDTO.getId() : entity.getId())
                .number(phoneDTO.getNumber() != null ? phoneDTO.getNumber() : entity.getNumber())
                .ddd(phoneDTO.getDdd() != null ? phoneDTO.getDdd() : entity.getDdd())
                .build();
    }

    public PhoneDTO toPhoneDTO(Phone phone){
        return PhoneDTO.builder()
                .id(phone.getId())
                .ddd(phone.getDdd())
                .number(phone.getNumber())
                .build();
    }
}
