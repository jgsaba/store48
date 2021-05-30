package com.jorge.backend.userapi.model.entity;

import model.user.dto.UserDTO;

public class DTOConverter {

    public static UserDTO convertFrom(User user){
        return UserDTO.builder()
                .address(user.getAddress())
                .cpf(user.getCpf())
                .email(user.getEmail())
                .registerDate(user.getRegisterDate())
                .phone(user.getPhone())
                .name(user.getName())
                .key(user.getUserKey())
                .build();
    }

    public static User convertFrom(UserDTO userDTO){
        return User.builder()
                .name(userDTO.getName())
                .cpf(userDTO.getCpf())
                .address(userDTO.getAddress())
                .email(userDTO.getEmail())
                .phone(userDTO.getPhone())
                .userKey(userDTO.getKey())
                .registerDate(userDTO.getRegisterDate())
                .build();
    }
}
