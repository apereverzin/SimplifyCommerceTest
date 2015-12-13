package com.creek.simplifycommercetest.cardtoken;

import java.util.Properties;

/**
 * 
 * @author andreypereverzin
 */
public class CardTokenDataFactory {
    public CardTokenData crateFromProperties(final Properties props, final String cardNumberProperty) {
        final CardTokenData cardTokenRequest = new CardTokenData();
        
        final CardData cardData = new CardData();
        cardData.setAddressCity(props.getProperty("card.addressCity"));
        cardData.setAddressState(props.getProperty("card.addressCity"));
        cardData.setNumber(props.getProperty(cardNumberProperty));
        cardData.setCvc(props.getProperty("card.cvc"));
        cardData.setExpMonth(Integer.valueOf(props.getProperty("card.expMonth")));
        cardData.setExpYear(Integer.valueOf(props.getProperty("card.expYear")));
        
        cardTokenRequest.setCardData(cardData);
        
        return cardTokenRequest;
    }
}
