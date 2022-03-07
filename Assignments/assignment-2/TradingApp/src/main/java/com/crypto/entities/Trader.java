package com.crypto.entities;

import lombok.Getter;
import lombok.Setter;

import java.math.BigInteger;
import java.util.HashMap;

@Getter
@Setter
public class Trader {
    String firstName;
    String lastName;
    String phone;
    String walletAddress;
    Double netWorth = (double) 0;
    Double investedMoney = (double) 0;
    Double currentPosition = (double) 0;

    HashMap<Coin, BigInteger> mapOfCoinPurchasedToQuantity = new HashMap<>();

    public Trader(String firstName, String lastName, String phone, String walletAddress) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.walletAddress = walletAddress;
    }


    public Double getCurrentPosition() {
        this.currentPosition = ((this.getNetWorth() - investedMoney)/investedMoney) * 100.0;
        return this.currentPosition;
    }

    public Double getNetWorth() {
        Double net = 0.0;
        for(Coin coin: mapOfCoinPurchasedToQuantity.keySet()) {
            net += coin.getPrice()*(mapOfCoinPurchasedToQuantity.get(coin).floatValue()) ;
        }
        return net;
    }

    @Override
    public String toString() {
        return
                "Name=" + firstName +
                " " + lastName + "      Phone= " + phone  + "     WalletAddress="  + walletAddress ;
    }

    public void printPortFolio() {
        System.out.println("\n..........................................." + "Portfolio of " + this.firstName.toUpperCase() + " " + this.lastName.toUpperCase() + "..........................................");
        System.out.println("Net Worth: " + this.getNetWorth());
        System.out.println("Total Investment: " + this.investedMoney);
        System.out.println("Current Position: " + this.getCurrentPosition() +"%");
        System.out.println("\n                COINS BOUGHT:          ");
        for(Coin coin: mapOfCoinPurchasedToQuantity.keySet()) {
            System.out.println("Coin: " + coin.getName().toUpperCase() + "  Quantity: "+ mapOfCoinPurchasedToQuantity.get(coin) + "   Current Price: " + coin.getPrice());
        }
        System.out.println("................................................................................................................");
    }
}
