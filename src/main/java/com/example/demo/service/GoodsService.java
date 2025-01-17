package com.example.demo.service;

import com.example.demo.dto.UserDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * packageName    : com.example.demo.service
 * fileName       : UserService
 * author         : doong2s
 * date           : 2025. 1. 12.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025. 1. 12.        doong2s       최초 생성
 */
@Service
public class UserService {

    String appRunType;

    @Value("#{${user-data}}")
    private Map<Integer, Map<String, Object>> userData;

    public UserService(@Value("${app.run.type}") String appRunType) {
        this.appRunType = appRunType;
    }

    public Map<String, Object> getUserByuserNo(int userNo) {
        return userData.get(userNo);
    }
}
