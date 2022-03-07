package com.crypto.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public abstract class Transaction {
    public String type;
    public Transaction(String type) {
        this.type = type;
    }
}
