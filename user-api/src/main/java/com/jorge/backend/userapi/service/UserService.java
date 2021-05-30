package com.jorge.backend.userapi.service;

import com.jorge.backend.userapi.exceptions.UserNotFoundException;
import com.jorge.backend.userapi.model.entity.User;
import com.jorge.backend.userapi.model.entity.DTOConverter;
import com.jorge.backend.userapi.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import model.user.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Slf4j
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<UserDTO> getAllUsers(){
        return userRepository.findAll().stream()
                .map(DTOConverter::convertFrom)
                .collect(Collectors.toList());
    }

    public UserDTO findById(Long userId) {
        Optional<User> usuario = userRepository.findById(userId);
        return usuario.map(DTOConverter::convertFrom).orElseThrow(UserNotFoundException::new);
    }

    public UserDTO findByCpf(String cpf, String userKey){
        return userRepository.findByCpfAndUserKey(cpf, userKey)
                .map(DTOConverter::convertFrom)
                .orElseThrow(UserNotFoundException::new);
    }

    public List<UserDTO> queryByName(String name){
        return userRepository.queryByNameLike(name).stream()
                .map(DTOConverter::convertFrom)
                .collect(Collectors.toList());
    }

    public UserDTO save(UserDTO userDTO){
        userDTO.setKey(UUID.randomUUID().toString());
        userDTO.setRegisterDate(LocalDate.now());
        return DTOConverter.convertFrom(userRepository.save(DTOConverter.convertFrom(userDTO)));
    }

    public void delete(Long userId) {
        Optional<User> userOptional = userRepository.findById(userId);
        userOptional.ifPresent(userRepository::delete);
    }
}
