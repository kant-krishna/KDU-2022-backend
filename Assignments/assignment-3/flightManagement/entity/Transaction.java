package com.flightManagement.entity;

import lombok.Data;

import javax.persistence.*;
@Data
@Entity
@Table(name = "transaction")
public class Transaction {

    @Id
    @GeneratedValue
    @Column(name = "order_id")
    private String orderId;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    @Column(name = "amount")
    private Double amount;

    @Column(name = "date")
    private String date;

    @Column(name = "respcode")
    private String respCode;

    @Column(name = "respmsg")
    private String respMessage;

    @Column(name = "gateway")
    private String gateway;

    @Column(name = "payment_mode")
    private String paymentMode;

    @Column(name = "status")
    private String status;
}
