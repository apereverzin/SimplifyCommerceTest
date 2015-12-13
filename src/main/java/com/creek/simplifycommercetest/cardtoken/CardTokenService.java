package com.creek.simplifycommercetest.cardtoken;

import java.util.concurrent.ConcurrentHashMap;

import com.creek.simplifycommercetest.SimplifyCommerceService;
import com.simplify.payments.PaymentsMap;
import com.simplify.payments.domain.CardToken;
import com.simplify.payments.exception.ApiException;

/**
 * 
 * @author andreypereverzin
 */
public class CardTokenService extends SimplifyCommerceService {
    private final ConcurrentHashMap<String, String> cardTokens = new ConcurrentHashMap<>();

    public CardTokenService(final String publicKey, final String privateKey) {
        super(publicKey, privateKey);
    }
    
    public String provideCardToken(final CardTokenData cardTokenData) throws ApiException {
        if (cardTokens.containsKey(cardTokenData.getCardData().getNumber())) {
            final String cardTokenId = cardTokens.get(cardTokenData.getCardData().getNumber());
            final CardTokenData cardTokenDataFound = findCardToken(cardTokenId);
            if (!cardTokenDataFound.isUsed()) {
                return cardTokenDataFound.getId();
            }
        }
        
        final CardTokenData cardTokenDataCreated = createCardToken(cardTokenData);
        cardTokens.put(cardTokenData.getCardData().getNumber(), cardTokenDataCreated.getId());
        
        return cardTokenDataCreated.getId();
    }

    private CardTokenData createCardToken(final CardTokenData cardTokenData) throws ApiException {
        final PaymentsMap paymentsMap = cardTokenData.toPaymentsMap();

        final CardToken cardToken = CardToken.create(paymentsMap);
        
        System.out.println("CardToken: " + cardToken);
        
        return new CardTokenData(cardToken);
    }

    private CardTokenData findCardToken(final String cardTokenId) throws ApiException {
        final CardToken cardToken = CardToken.find(cardTokenId);
        
        final CardTokenData cardTokenData = new CardTokenData(cardToken);
        
        return cardTokenData;
    }
}
