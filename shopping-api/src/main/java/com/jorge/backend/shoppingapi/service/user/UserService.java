package com.jorge.backend.shoppingapi.service.user;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import model.user.dto.UserDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import javax.persistence.EntityNotFoundException;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {

    private final UserClientConfig userClientConfig;

    private final RestTemplate restTemplate;

    public UserDTO getUserByCpf(String cpf, String key){
        try {

            UserDTO user = restTemplate.getForEntity(userClientConfig.getUserByCpfUri(cpf, key), UserDTO.class)
                    .getBody();
            log.info(String.format("Found user: %s for CPF: %s", user.getName(), user.getCpf()));
            return user;
        } catch (HttpClientErrorException.NotFound e) {
            throw new EntityNotFoundException(String.format("Was not found a user with cpf=%s", cpf));
        }
    }
}
