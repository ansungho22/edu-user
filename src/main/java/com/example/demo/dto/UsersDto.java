package com.example.demo.dto;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter

public class UsersDto {
    private String userNo;
    private String userName;
    private String goodsNo;
    private String goodsName;

    public UsersDto(String userNo, String userName,String goodsNo, String goodsName) {
        this.userNo = userNo;
        this.userName = userName;
        this.goodsNo = goodsNo;
        this.goodsName = goodsName;
    }
}

