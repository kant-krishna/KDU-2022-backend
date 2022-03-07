package com.flightManagement.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;
@Data
@Entity
@Table(name = "user")
public class User {

    //Table Columns
    @Id
    @GeneratedValue
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "u_name")
    private String userName;

    @Column(name = "email")
    private String email;

    @Column(name = "pass")
    private String password;

    @OneToOne
    @JoinColumn(name = "contact_det",referencedColumnName = "contact_id")
    private ContactDetails contactDetails;

    //Mapping Key
    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private List<Passenger> passengers;

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private List<Transaction> transactions;
}
