package com.creek.simplifycommercetest.authorization;

import com.creek.simplifycommercetest.data.BaseData;
import com.creek.simplifycommercetest.data.Currency;
import com.simplify.payments.PaymentsMap;

/**
 * 
 * @author andreypereverzin
 */
public class AuthorizationData extends BaseData {
    private static final String TOKEN = "token";
    private static final String REFERENCE = "reference";
    private static final String DESCRIPTION = "description";
    private static final String CURRENCY = "currency";
    private static final String AMOUNT = "amount";
    
    private long amount;
    private Currency currency;
    private String description;
    private String reference;
    private String token;
    
    public AuthorizationData() {
        //
    }

    public AuthorizationData(final PaymentsMap paymentsMap) {
        super(paymentsMap);
        this.amount = (long)paymentsMap.get(AMOUNT);
        this.currency = Currency.valueOf((String)paymentsMap.get(CURRENCY));
        this.description = (String)paymentsMap.get(DESCRIPTION);
        this.reference = (String)paymentsMap.get(REFERENCE);
        this.token = (String)paymentsMap.get(TOKEN);
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(final long amount) {
        this.amount = amount;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(final Currency currency) {
        this.currency = currency;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(final String reference) {
        this.reference = reference;
    }

    public String getToken() {
        return token;
    }

    public void setToken(final String token) {
        this.token = token;
    }

    @Override
    public PaymentsMap toPaymentsMap() {
        final PaymentsMap paymentsMap = super.toPaymentsMap();
        
        paymentsMap.set(AMOUNT, getAmount());
        paymentsMap.set(CURRENCY, getCurrency().name());
        paymentsMap.set(DESCRIPTION, getDescription());
        paymentsMap.set(REFERENCE, getReference());
        paymentsMap.set(TOKEN, getToken());
        
        return paymentsMap;
    }
}
