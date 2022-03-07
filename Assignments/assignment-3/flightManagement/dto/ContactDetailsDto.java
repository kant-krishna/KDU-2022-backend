package com.flightManagement.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class ContactDetailsDto implements Serializable {
    private  Long contactId;
    private  String email;
    private  String phone;
    private  String line1;
    private  String line2;
    private  String city;
    private  String state;
    private  String country;
}
