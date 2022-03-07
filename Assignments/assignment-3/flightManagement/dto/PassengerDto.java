package com.flightManagement.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class PassengerDto implements Serializable {
    private  Long passengerID;
    private  String passengerName;
    private  String type;
    private  String seatNumber;
    private  Long userId;
    private  Long flightID;
    private  String email;
    private  String phone;
    private  int age;
    private  String sex;
    private  Long confirmed;
    private  Long cancelled;
}
