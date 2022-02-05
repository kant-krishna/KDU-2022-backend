package com.crypto.transactions;

import com.crypto.entities.Transaction;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.json.simple.JSONObject;
import java.math.BigInteger;


@Setter
@ToString
@Getter
public class SellTransaction  extends Transaction{

    String coin;
    BigInteger quantity;
    String walletAddress;
    public SellTransaction(JSONObject jsonObject) {
        super(jsonObject.get("type").toString());
        JSONObject data = (JSONObject) jsonObject.get("data");
        this.coin = (String) data.get("coin");
        this.quantity = BigInteger.valueOf(Long.parseLong(data.get("quantity").toString()));
        this.walletAddress = (String) data.get("wallet_address");
    }

}
