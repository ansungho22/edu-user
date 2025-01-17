package com.example.demo.controller;


import com.example.demo.dto.UsersDto;
import com.example.demo.service.UsersService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
public class UsersController {
    private final UsersService usersService;

    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }

    @GetMapping("/{usersNo}")
    public UsersDto getUsers(@PathVariable String usersNo) {
        return usersService.getUserByNo(usersNo);
    }
    @GetMapping("/")
    public String healthCheck() {
        return "ok";
    }
}