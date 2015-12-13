package com.creek.simplifycommercetest.authorization;

import com.creek.simplifycommercetest.data.Currency;

/**
 * 
 * @author andreypereverzin
 */
public class AuthorizationDataBuilder {
    private final long amount = 2000L;
    private final Currency currency = Currency.USD;
    private final String description = "payment description";
    private final String reference = "7a6ef6be31";
    private String token;
    
    public AuthorizationDataBuilder withToken(final String token) {
        this.token = token;
        return this;
    }
    
    public AuthorizationData create() {
        final AuthorizationData authorizationData = new AuthorizationData();
        
        authorizationData.setAmount(amount);
        authorizationData.setCurrency(currency);
        authorizationData.setDescription(description);
        authorizationData.setReference(reference);
        authorizationData.setToken(token);
        
        return authorizationData;
    }
}
