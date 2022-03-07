package com.flightManagement.mapper;

import com.flightManagement.dto.UserDto;
import com.flightManagement.entity.User;

public class UserMapper {

    public UserDto fromEntity(User user){
        UserDto userDto= new UserDto();
        userDto.setUserId(user.getUserId());
        userDto.setUserName(user.getUserName());
        userDto.setEmail(user.getEmail());
        userDto.setPassword(user.getPassword());
        userDto.setContactDetailsID(user.getContactDetails().getContactId());
        return userDto;
    }
}
