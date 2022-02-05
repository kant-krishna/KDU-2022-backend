package com.crypto.executors;

import com.crypto.entities.Coin;
import com.crypto.entities.Trader;

import java.math.BigInteger;

public class SellCallExecutor extends Thread{
    final Coin coin;
    BigInteger quantity;
    Trader seller;

    public void run() {
        synchronized (coin){
            if(seller.getMapOfCoinPurchasedToQuantity().get(coin) == null) {

            }
            else if(seller.getMapOfCoinPurchasedToQuantity().get(coin).compareTo(quantity) >= 0 ) {
                coin.setAvailableAmount(coin.getAvailableAmount().add(quantity));
                seller.getMapOfCoinPurchasedToQuantity().merge(coin, quantity, BigInteger::subtract);
                seller.setInvestedMoney(seller.getInvestedMoney() - quantity.doubleValue() * (coin.getPrice()));
                coin.notifyAll();
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

    public SellCallExecutor(Coin coin, BigInteger quantity, Trader buyer) {
        this.coin = coin;
        this.quantity = quantity;
        this.seller = buyer;
    }
}
