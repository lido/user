package com.lido.user.business.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PhoneDTO {

    private Long id;
    private String ddd;
    private String number;

}
