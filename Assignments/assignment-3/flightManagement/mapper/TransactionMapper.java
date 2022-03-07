package com.flightManagement.mapper;

import com.flightManagement.dto.TransactionDto;
import com.flightManagement.entity.Transaction;


public class TransactionMapper {

    public TransactionDto fromEntity(Transaction transaction){
        TransactionDto transactionDto= new TransactionDto();
        transactionDto.setAmount(transaction.getAmount());
        transactionDto.setDate(transaction.getDate());
        transactionDto.setGateway(transaction.getGateway());
        transactionDto.setOrderId(transaction.getOrderId());
        transactionDto.setPaymentMode(transaction.getPaymentMode());
        transactionDto.setRespCode(transaction.getRespCode());
        transactionDto.setRespMessage(transaction.getRespMessage());
        transactionDto.setStatus(transaction.getStatus());
        transactionDto.setUserID(transaction.getUser().getUserId());

        return transactionDto;
    }
}
