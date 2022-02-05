package com.crypto.operations;

import com.crypto.entities.Coin;
import com.crypto.entities.Trader;

import java.util.ArrayList;
import java.util.HashMap;

public class Operations {
    public void printCoinsByName(String name, HashMap<String, Coin> mapOfCoinNameToObject) {
        if(mapOfCoinNameToObject.containsKey(name.toUpperCase())) {
            System.out.println(mapOfCoinNameToObject.get(name).getName());
        }else{
            System.out.println("Sorry, no coin of such name.");
        }
    }

    public void searchTradersByName(String name, ArrayList<Trader> traders) {
        for(Trader trader: traders) {
            if((trader.getFirstName() + " " + trader.getLastName()).contains(name)){
                trader.printPortFolio();
            }
        }
    }
}
