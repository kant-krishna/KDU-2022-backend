package com.crypto.executors;

import com.crypto.entities.Coin;

public class UpdatePriceExecutor extends Thread{

    final Coin coin;
    Double newPrice;

    public UpdatePriceExecutor(Coin coin, Double newPrice) {
        this.coin = coin;
        this.newPrice = newPrice;
    }

    public void run() {
        synchronized (coin){
            coin.setPrice(newPrice);
        }
    }

}
