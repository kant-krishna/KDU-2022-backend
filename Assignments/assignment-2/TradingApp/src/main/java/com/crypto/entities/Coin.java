package com.crypto.entities;
import lombok.Getter;
import lombok.Setter;

import java.math.BigInteger;

@Getter
@Setter
public class Coin {
    Integer rank;
    String name;
    String symbol;
    Double price;
    BigInteger availableAmount;

    public Coin(String rank, String name, String symbol, String price, String availableAmount) {

        this.name = name.toUpperCase();
        this.symbol = symbol;
        this.price = Double.parseDouble(price);
        this.availableAmount = new BigInteger(availableAmount);
    }

    @Override
    public String toString() {
        return
                "           Name: " + name +
                "  Symbol: " + symbol +
                "   Price: " + price +
                "  AvailableAmount: " + availableAmount ;
    }

}


