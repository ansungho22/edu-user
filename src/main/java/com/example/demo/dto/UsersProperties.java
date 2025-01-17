package com.example.demo.dto;

import lombok.Getter;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import java.util.Map;

@Component
@ConfigurationProperties(prefix = "test")
@Validated
public class UsersProperties {
    @Setter
    @Getter
    @NotNull
    private Map<String, Users> users;

    @Getter
    @Setter
    public static class Users {
        private String userNo;
        private String userName;

    }
}