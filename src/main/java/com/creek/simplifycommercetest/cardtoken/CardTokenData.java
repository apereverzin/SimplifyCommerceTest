package com.creek.simplifycommercetest.cardtoken;

import org.json.simple.JSONObject;

import com.creek.simplifycommercetest.data.BaseData;
import com.simplify.payments.PaymentsMap;

/**
 * 
 * @author andreypereverzin
 */
public class CardTokenData extends BaseData {
    private boolean used;
    private CardData cardData;

    public CardTokenData() {
        //
    }

    public CardTokenData(final PaymentsMap paymentsMap) {
        super(paymentsMap);
        this.used = (boolean)paymentsMap.get("used");
        final JSONObject cardObject = (JSONObject)paymentsMap.get("card");
        this.cardData = new CardData(cardObject);
    }

    public boolean isUsed() {
        return used;
    }

    public void setUsed(final boolean used) {
        this.used = used;
    }

    public CardData getCardData() {
        return cardData;
    }

    public void setCardData(final CardData cardData) {
        this.cardData = cardData;
    }

    @Override
    public PaymentsMap toPaymentsMap() {
        final PaymentsMap paymentsMap = super.toPaymentsMap();
        
        paymentsMap.set("card", getCardData().toJSONObject());
        
        return paymentsMap;
    }
}
