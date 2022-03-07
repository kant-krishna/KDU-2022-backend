package com.crypto.executors;

import com.crypto.entities.Coin;
import com.crypto.entities.Trader;
import lombok.NonNull;

import java.math.BigInteger;

public class BuyCallExecutor extends Thread {
    @NonNull
    final
    Coin coin;
    BigInteger quantity;
    Trader buyer;


    public BuyCallExecutor(Coin coin, BigInteger quantity, Trader buyer) {
        this.coin = coin;
        this.quantity = quantity;
        this.buyer = buyer;
    }

    public void run() {
        synchronized (coin){
            if(coin.getAvailableAmount().compareTo(quantity) >= 0) {
                coin.setAvailableAmount(coin.getAvailableAmount().subtract(quantity));
                buyer.getMapOfCoinPurchasedToQuantity().merge(coin, quantity, BigInteger::add);
                buyer.setInvestedMoney(buyer.getInvestedMoney() + quantity.doubleValue() * coin.getPrice());
            }
            else {
                try {
                    coin.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
