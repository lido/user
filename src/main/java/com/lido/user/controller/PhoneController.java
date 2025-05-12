package com.lido.user.controller;

import com.lido.user.business.PhoneService;
import com.lido.user.business.dto.PhoneDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@RequestMapping("/phone")
public class PhoneController {

    private final PhoneService phoneService;

    @PutMapping
    public ResponseEntity<PhoneDTO> updatePhone(@RequestParam("id") Long idPhone,
                                                @RequestBody PhoneDTO phoneDTO){
        return ResponseEntity.ok(phoneService.updatePhone(idPhone, phoneDTO));
    }

    @PostMapping
    public ResponseEntity<PhoneDTO> resgisterPhone(@RequestHeader("Authorization") String token,
                                                   @RequestBody PhoneDTO phoneDTO){
        return ResponseEntity.ok(phoneService.registerPhone(token, phoneDTO));
    }
}

