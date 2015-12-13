package com.creek.simplifycommercetest.payment;

import com.creek.simplifycommercetest.data.Currency;

/**
 * 
 * @author andreypereverzin
 */
public class PaymentDataBuilder {
    private final long amount = 2000L;
    private final Currency currency = Currency.USD;
    private final String description = "payment description";
    private final String reference = "7a6ef6be31";
    private String token;
    private String authorization;
    private String replayId;
    
    public PaymentDataBuilder withReplayId(final String replayId) {
        this.replayId = replayId;
        return this;
    }
    
    public PaymentDataBuilder withAuthorization(final String authorization) {
        this.authorization = authorization;
        return this;
    }
    
    public PaymentDataBuilder withToken(final String token) {
        this.token = token;
        return this;
    }
    
    public PaymentData create() {
        final PaymentData paymentData = new PaymentData();
        
        paymentData.setAmount(amount);
        paymentData.setCurrency(currency);
        paymentData.setDescription(description);
        paymentData.setReference(reference);
        paymentData.setToken(token);
        paymentData.setAuthorization(authorization);
        
        return paymentData;
    }
}
