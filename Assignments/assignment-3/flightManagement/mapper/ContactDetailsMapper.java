package com.flightManagement.mapper;

import com.flightManagement.dto.ContactDetailsDto;
import com.flightManagement.entity.ContactDetails;
import org.springframework.stereotype.Component;

@Component

public class ContactDetailsMapper {

    public ContactDetailsDto fromEntity(ContactDetails contactDetails){
        ContactDetailsDto contactDetailsDto= new ContactDetailsDto();
        contactDetailsDto.setContactId(contactDetails.getContactId());
        contactDetailsDto.setCountry(contactDetails.getCountry());
        contactDetailsDto.setCity(contactDetails.getCity());
        contactDetailsDto.setEmail(contactDetails.getEmail());
        contactDetailsDto.setPhone(contactDetails.getPhone());
        contactDetailsDto.setLine1(contactDetails.getLine1());
        contactDetailsDto.setLine2(contactDetails.getLine2());
        contactDetailsDto.setState(contactDetails.getState());
        return  contactDetailsDto;
    }
}
