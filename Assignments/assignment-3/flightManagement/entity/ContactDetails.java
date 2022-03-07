package com.flightManagement.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "contact_details")
public class ContactDetails {

    @Id
    @GeneratedValue
    @Column(name = "contact_id")
    private Long contactId;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

    @Column(name = "line1")
    private String line1;

    @Column(name = "line2")
    private String line2;

    @Column(name = "city")
    private String city;

    @Column(name = "state")
    private String state;

    @Column(name = "country")
    private String country;

    //Mapping the keys

    @JsonIgnore
    @OneToOne(mappedBy = "contactDetails")
    private User user;

}
