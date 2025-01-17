package com.example.demo.service;



import com.example.demo.dto.GoodsResponse;
import com.example.demo.dto.UsersDto;
import com.example.demo.dto.UsersProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UsersService {
    private final UsersProperties usersProperties;
    private final RestTemplate restTemplate;

    public UsersService(UsersProperties usersProperties, RestTemplateBuilder builder) {
        this.usersProperties = usersProperties;
        this.restTemplate = builder.build();
    }

    public UsersDto getUserByNo(String usersNo) {
        String goodsApiUrl = "http://localhost:8080/api/v1/goods/" + usersNo;
        GoodsResponse goodsResponse = restTemplate.getForObject(goodsApiUrl, GoodsResponse.class);
        UsersProperties.Users users = usersProperties.getUsers().get(usersNo);

        if (users != null) {
            return new UsersDto(users.getUserNo(), users.getUserName(),goodsResponse.getGoodsNo(),goodsResponse.getGoodsName());
        }
        return null;
    }
}