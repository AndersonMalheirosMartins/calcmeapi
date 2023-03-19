package com.br.calcme.dtos;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserDto {
    private int id;
    private String name;
    private String email;
    private String phone;
}
