package com.crypto.transactions;
import com.crypto.entities.Transaction;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.json.simple.JSONObject;


@Getter
@Setter
@ToString
public class UpdatePriceTransaction extends Transaction {

    String coin;
    Double price;

    public UpdatePriceTransaction(JSONObject jsonObject) {
        super(jsonObject.get("type").toString());
        JSONObject data = (JSONObject) jsonObject.get("data");
            this.coin = (String) data.get("coin");
            this.price = Double.valueOf(data.get("price").toString());
    }

}
