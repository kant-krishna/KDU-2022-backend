package com.crypto.tools;
import com.crypto.entities.Coin;
import com.crypto.entities.Trader;
import com.crypto.entities.Transaction;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

import com.crypto.transactions.AddVolumeTransaction;
import com.crypto.transactions.BuyTransaction;
import com.crypto.transactions.SellTransaction;
import com.crypto.transactions.UpdatePriceTransaction;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class LoadResources {
    public ArrayList<Coin>  loadCoins(Path pathToFile) {
        ArrayList<Coin> coins = new ArrayList<>();
        try {
            BufferedReader bufferedReader = Files.newBufferedReader(pathToFile, StandardCharsets.US_ASCII);
            String line = bufferedReader.readLine();
            line = bufferedReader.readLine();
            while (line != null) {
                String[] splitLine = line.split(",");
                Coin newCoin = new Coin(splitLine[1], splitLine[2], splitLine[3], splitLine[4], splitLine[5]);
                coins.add(newCoin);
                line = bufferedReader.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return coins;
    }
    public ArrayList<Trader>  loadTraders(Path pathToFile) {
        ArrayList<Trader> traders = new ArrayList<>();
        try {
            BufferedReader bufferedReader = Files.newBufferedReader(pathToFile, StandardCharsets.US_ASCII);
            String line = bufferedReader.readLine();
            line = bufferedReader.readLine();
            while (line != null) {
                String[] splitLine = line.split(",");
                Trader newTrader = new Trader(splitLine[1], splitLine[2], splitLine[3], splitLine[4]);
                traders.add(newTrader);
                line = bufferedReader.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return traders;
    }
    public ArrayList<Transaction> loadTransactions(Path pathToFile) {
        ArrayList<Transaction> transactions = new ArrayList<>();
        JSONArray transactionsList = new JSONArray();
        JSONParser parser = new JSONParser();
        try
        {
            transactionsList = (JSONArray) parser.parse(new FileReader(String.valueOf(pathToFile)));

            for(Object object: transactionsList) {
                JSONObject jsonObject = (JSONObject) object;

                if(jsonObject.get("type").equals("ADD_VOLUME")) {
                    Transaction newTransaction = new AddVolumeTransaction(jsonObject);
                    transactions.add(newTransaction);
                }

                else if(jsonObject.get("type").equals("BUY")) {
                    Transaction newTransaction = new BuyTransaction(jsonObject);
                    transactions.add(newTransaction);

                }
                else if(jsonObject.get("type").equals("SELL")) {
                    Transaction newTransaction = new SellTransaction(jsonObject);
                    transactions.add(newTransaction);

                }
                else if(jsonObject.get("type").equals("UPDATE_PRICE")) {
                    Transaction newTransaction = new UpdatePriceTransaction(jsonObject);
                    transactions.add(newTransaction);
                }
                else {
                    System.out.println(jsonObject.get("Invalid Transaction"));
                }
            }

        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

        return transactions;
    }


}
