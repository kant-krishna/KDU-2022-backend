import com.crypto.entities.*;
import com.crypto.executors.*;
import com.crypto.operations.Operations;
import com.crypto.tools.LoadResources;
import com.crypto.transactions.*;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;

public class CryptoMarket {
    public static void main(String[] args) {

        // Storing the data from 'coins.csv' to an ArrayList of Coin

        HashMap<String, Coin> mapCoinNameToCoinObject = new HashMap<>();
        Path pathToCoins = Paths.get("src/main/resources/coins.csv");
        LoadResources loader = new LoadResources();
        ArrayList<Coin> coins = loader.loadCoins(pathToCoins);
        for(Coin coin: coins) {
                mapCoinNameToCoinObject.put(coin.getSymbol(), coin);
        }

        // Storing the data from 'traders.csv' to ArrayList of Trader
        HashMap<String, Trader> mapWalletAddressToTraderObject = new HashMap<>();
        Path pathToTraders = Paths.get("src/main/resources/traders.csv");
        ArrayList<Trader> traders = loader.loadTraders(pathToTraders);
        for(Trader trader: traders) {
            mapWalletAddressToTraderObject.put(trader.getWalletAddress(), trader);
        }


        Path pathToTransactions = Paths.get("src/main/resources/test_transaction.json");
        ArrayList<Transaction> transactions = loader.loadTransactions(pathToTransactions);

        for(Transaction transaction: transactions) {
            switch (transaction.type) {
                case "BUY" -> {
                    BuyTransaction buyTransaction = (BuyTransaction) transaction;
                    Coin coinToBuy = mapCoinNameToCoinObject.get(buyTransaction.getCoin());
                    Trader buyer = mapWalletAddressToTraderObject.get(buyTransaction.getWalletAddress());
                    BuyCallExecutor buyCallExecutor = new BuyCallExecutor(coinToBuy, buyTransaction.getQuantity(), buyer);
                    buyCallExecutor.start();
                }
                case "SELL" -> {
                    SellTransaction sellTransaction = (SellTransaction) transaction;
                    Coin coinToSell = mapCoinNameToCoinObject.get(sellTransaction.getCoin());
                    Trader seller = mapWalletAddressToTraderObject.get(sellTransaction.getWalletAddress());
                    SellCallExecutor sellCallExecutor = new SellCallExecutor(coinToSell, sellTransaction.getQuantity(), seller);
                    sellCallExecutor.start();
                }
                case "UPDATE_PRICE" -> {
                    UpdatePriceTransaction updatePriceTransaction = (UpdatePriceTransaction) transaction;
                    Coin coinToUpdatePrice = mapCoinNameToCoinObject.get(updatePriceTransaction.getCoin());
                    UpdatePriceExecutor updatePriceExecutor = new UpdatePriceExecutor(coinToUpdatePrice, updatePriceTransaction.getPrice());
                    updatePriceExecutor.start();
                }
                case "ADD_VOLUME" -> {
                    AddVolumeTransaction addVolumeTransaction = (AddVolumeTransaction) transaction;
                    Coin coinToAddVolume = mapCoinNameToCoinObject.get(addVolumeTransaction.getCoin());
                    AddVolumeExecutor addVolumeExecutor = new AddVolumeExecutor(coinToAddVolume, addVolumeTransaction.getVolume());
                    addVolumeExecutor.start();
                }
            }
        }


        Operations operation = new Operations();

        System.out.println("\nLet the transactions complete, till that you can query things here:\n    1: Search Coin by Name\n    2: Find top N Coins(by price)\n    3: Search Trader by name\n    4: Get top N traders\n    0: Quit");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Choice: ");
        int choice = scanner.nextInt();

        while(choice != 0) {
            switch (choice) {
                case 1 -> {
                    System.out.println("-------------------------------------------------------------------------------------------------------------");
                    System.out.print("Enter the name of coin: ");
                    String coinNameToBeSearched = scanner.next();
                    System.out.println("\n");
                    operation.printCoinsByName("%" + coinNameToBeSearched + "%", mapCoinNameToCoinObject);
                    System.out.println("-------------------------------------------------------------------------------------------------------------");
                }

                case 2 -> {
                    System.out.println("-------------------------------------------------------------------------------------------------------------");
                    System.out.print("\nEnter a number N, to get list of top N coins: ");
                    int N = scanner.nextInt();
                    coins.sort(Comparator.comparing(Coin::getPrice).reversed());
                    coins.stream().limit(N).forEach(System.out::println);
                    System.out.println("-------------------------------------------------------------------------------------------------------------");
                }
                case 3 -> {
                    System.out.println("-------------------------------------------------------------------------------------------------------------");
                    System.out.print("\nEnter the name of Trader to be searched: ");
                    String traderToBeSearched = scanner.next();
                    operation.searchTradersByName(traderToBeSearched, traders);
                    System.out.println("-------------------------------------------------------------------------------------------------------------");
                }
                case 4 -> {
                    System.out.println("-------------------------------------------------------------------------------------------------------------");
                    System.out.print("\nEnter N, and get list of top N Traders: ");
                    int N = scanner.nextInt();
                    traders.sort(Comparator.comparing(Trader::getCurrentPosition).reversed());
                    traders.stream().limit(N).forEach(Trader::printPortFolio);
                    System.out.println("-------------------------------------------------------------------------------------------------------------");
                }

            }
            System.out.print("Enter Choice: ");
            choice = scanner.nextInt();
        }
    }

}
