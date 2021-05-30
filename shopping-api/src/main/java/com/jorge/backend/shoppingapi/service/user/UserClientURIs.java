package com.jorge.backend.shoppingapi.service.user;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserClientURIs {

    @Value("${shoppings.user-api.base-url}")
    public String baseUri;

    @Getter
    @Value("${shoppings.user-api.getByCpf-url}")
    public String getByCpf;

    public String getBaseUri(){
        return baseUri + "/user";
    }
}
