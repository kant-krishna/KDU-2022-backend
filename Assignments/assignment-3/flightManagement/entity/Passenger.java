package com.flightManagement.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "passenger")
public class Passenger {


    @Id
    @GeneratedValue
    @Column(name = "passenger_id")
    private Long passengerID;

    @Column(name = "passenger_name")
    private String passengerName;

    @Column(name = "type")
    private String type;

    @Column(name = "seat_no")
    private String seatNumber;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name="Flight_ID",referencedColumnName = "id")
    private Flight flight;

    @Column(name = "email_id")
    private String email;

    @Column(name = "phone")
    private String phone;

    @Column(name = "age")
    private int age;

    @Column(name = "sex")
    private String sex;

    @Column(name = "confirmed")
    private Long confirmed;

    @Column(name = "cancelled")
    private Long cancelled;

}
