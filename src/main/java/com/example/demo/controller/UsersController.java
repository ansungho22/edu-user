package com.example.demo.controller;


import com.example.demo.dto.DataSourceConfig;
import com.example.demo.dto.UsersDto;
import com.example.demo.service.UsersService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
//@RequestMapping("/api/v1/users")
public class UsersController {
    private final UsersService usersService;
    private final DataSourceConfig dataSourceConfig;

    public UsersController(UsersService usersService, DataSourceConfig dataSourceConfig) {
        this.usersService = usersService;
        this.dataSourceConfig = dataSourceConfig;
    }

    @GetMapping("/api/v1/users/{usersNo}")
    public UsersDto getUsers(@PathVariable String usersNo) {
        return usersService.getUserByNo(usersNo);
    }
    @GetMapping("/")
    public String healthCheck() {
        return "ok";
    }
    @GetMapping("/configmap")
    public Map<String, String> getConfigMap() {
        Map<String, String> configMap = new HashMap<>();
        configMap.put("hostip", dataSourceConfig.getHostip());
        configMap.put("username", dataSourceConfig.getUsername());
        configMap.put("password", dataSourceConfig.getPassword());
        return configMap;
    }
}