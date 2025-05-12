package com.lido.user.business;

import com.lido.user.business.converter.PhoneConverter;
import com.lido.user.business.dto.PhoneDTO;
import com.lido.user.infrastructure.entity.Phone;
import com.lido.user.infrastructure.entity.User;
import com.lido.user.infrastructure.exceptions.ResourceNotFoundException;
import com.lido.user.infrastructure.repository.PhoneRepository;
import com.lido.user.infrastructure.repository.UserRepository;
import com.lido.user.infrastructure.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PhoneService {

    private final PhoneRepository phoneRepository;
    private final PhoneConverter phoneConverter;
    private final JwtUtil jwtUtil;
    private final UserRepository userRepository;

    public PhoneDTO updatePhone(Long idPhone, PhoneDTO phoneDTO){
        Phone entity = phoneRepository.findById(idPhone).orElseThrow(
                ()-> new ResourceNotFoundException("Id not found " + idPhone)
        );

        Phone phone = phoneConverter.updatePhone(phoneDTO, entity);

        return phoneConverter.toPhoneDTO(phoneRepository.save(phone));
    }

    public PhoneDTO registerPhone(String token, PhoneDTO phoneDTO){
        String email = jwtUtil.extractEmailname(token.substring(7));

        User user = userRepository.findByEmail(email).orElseThrow(
                () -> new ResourceNotFoundException("Email not found" + email )
        );

        Phone phone = phoneConverter.toPhoneEntity(user.getId(), phoneDTO);
        return phoneConverter.toPhoneDTO(
                phoneRepository.save(phone)
        );
    }
}
