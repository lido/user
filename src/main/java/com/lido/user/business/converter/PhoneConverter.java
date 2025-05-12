package com.lido.user.business.converter;

import com.lido.user.business.dto.PhoneDTO;
import com.lido.user.infrastructure.entity.Phone;
import org.springframework.stereotype.Component;

import java.util.List;

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

    public List<Phone> toPhonesList(List<PhoneDTO> phoneDTOS){
        return phoneDTOS.stream().map(this::toPhone).toList();
    }

    public Phone toPhone(PhoneDTO phoneDTO){
        return Phone.builder()
                .ddd(phoneDTO.getDdd())
                .number(phoneDTO.getNumber())
                .build();
    }

    public List<PhoneDTO> toPhonesListDTO(List<Phone> phones){
        return phones.stream().map(this::toPhoneDTO).toList();
    }

    public Phone toPhoneEntity(Long userId, PhoneDTO phoneDTO){
        return Phone.builder()
                .UserId(userId)
                .ddd(phoneDTO.getDdd())
                .number(phoneDTO.getNumber())
                .build();
    }
}
