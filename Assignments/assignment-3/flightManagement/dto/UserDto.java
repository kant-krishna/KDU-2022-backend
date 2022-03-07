package com.flightManagement.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserDto implements Serializable {
    private  Long userId;
    private  String userName;
    private  String email;
    private  String password;
    private  Long contactDetailsID;
}
