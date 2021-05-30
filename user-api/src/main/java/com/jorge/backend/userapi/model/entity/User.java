package com.jorge.backend.userapi.model.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Builder
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String cpf;

    private String address;

    private String email;

    private String phone;

    @Column(name = "user_key")
    private String userKey;

    @Column(name = "register_date")
    private LocalDate registerDate;
}
