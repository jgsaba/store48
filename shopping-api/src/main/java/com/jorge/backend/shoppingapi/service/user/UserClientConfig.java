package com.jorge.backend.shoppingapi.service.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

@Service
@RequiredArgsConstructor
public class UserClientConfig {

    private final UserClientURIs userClientURIs;

    public static final String KEY_PARAM_NAME = "userKey";

    public String getUserByCpfUri(String cpf, String key){
        return UriComponentsBuilder
                .fromHttpUrl(getURI(cpf))
                .queryParam(KEY_PARAM_NAME, key)
                .toUriString();
    }

    private String getURI(String cpf){
        return new StringBuilder(userClientURIs.getBaseUri())
                .append(userClientURIs.getGetByCpf())
                .append(cpf)
                .toString();
    }
}
