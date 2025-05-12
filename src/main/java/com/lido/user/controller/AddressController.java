package com.lido.user.controller;

import com.lido.user.business.AddressService;
import com.lido.user.business.dto.AddressDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/address")
public class AddressController {

    private final AddressService addressService;

    @PutMapping
    public ResponseEntity<AddressDTO> updateAddress(@RequestParam("id") Long idAddress,
                                                    @RequestBody AddressDTO addressDTO){
        return ResponseEntity.ok(addressService.updateAddress(idAddress, addressDTO));
    }

    @PostMapping
    public ResponseEntity<AddressDTO> registerAddress(@RequestHeader("Authorization") String token,
                                                    @RequestBody AddressDTO addressDTO){
        return ResponseEntity.ok(addressService.registerAddress(token, addressDTO));
    }
}
