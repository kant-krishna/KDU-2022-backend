package com.crypto.transactions;
import com.crypto.entities.Transaction;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.json.simple.JSONObject;

import java.math.BigInteger;


@Setter
@Getter
@ToString
public class AddVolumeTransaction extends Transaction {

    String coin;
    BigInteger volume;

    public AddVolumeTransaction(JSONObject jsonObject) {
        super(jsonObject.get("type").toString());
        JSONObject data = (JSONObject) jsonObject.get("data");
        this.coin = (String) data.get("coin");
        this.volume = BigInteger.valueOf(Long.parseLong(data.get("volume").toString()));
    }

}
