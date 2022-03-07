package com.flightManagement.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class TransactionDto implements Serializable {
    private  String orderId;
    private  Long userID;
    private  Double amount;
    private  String date;
    private  String respCode;
    private  String respMessage;
    private  String gateway;
    private  String paymentMode;
    private  String status;
}
