package com.crypto.executors;

import com.crypto.entities.Coin;
import java.math.BigInteger;

public class AddVolumeExecutor extends Thread{
    Coin coin;
    BigInteger newVolume;

    public AddVolumeExecutor(Coin coin, BigInteger newVolume) {
        this.coin = coin;
        this.newVolume = newVolume;
    }

    public void run() {
        synchronized (coin.getAvailableAmount()){
            coin.setAvailableAmount(coin.getAvailableAmount().add(newVolume));
        }
    }
}
