package com.lido.user.infrastructure.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "address")
@Builder
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "street",length = 100)
    private String street;
    @Column(name = "number")
    private Long number;
    @Column(name = "complement",length = 10)
    private String complement;
    @Column(name = "city",length = 100)
    private String city;
    @Column(name = "state",length = 2)
    private String state;
    @Column(name = "cep",length = 9)
    private String cep;
    @Column(name = "user_id")
    private Long userId;

}
