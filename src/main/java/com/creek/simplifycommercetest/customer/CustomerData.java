package com.creek.simplifycommercetest.customer;

import java.util.List;

import org.json.simple.JSONArray;

import com.creek.simplifycommercetest.data.PaymentsMapTransferrable;
import com.creek.simplifycommercetest.subscription.SubscriptionData;
import com.simplify.payments.PaymentsMap;

/**
 * 
 * @author andreypereverzin
 */
public class CustomerData implements PaymentsMapTransferrable {
    private static final String SUBSCRIPTIONS = "subscriptions";
    private static final String TOKEN = "token";
    private static final String REFERENCE = "reference";
    private static final String EMAIL = "email";
    private static final String NAME = "name";
    
    private String name;
    private String email;
    private String reference;
    private String token;
    private List<SubscriptionData> subscriptions;

    public CustomerData() {
        //
    }

    public CustomerData(final PaymentsMap paymentsMap) {
        name = (String)paymentsMap.get(NAME);
        email = (String)paymentsMap.get(EMAIL);
        reference = (String)paymentsMap.get(REFERENCE);
        token = (String)paymentsMap.get(TOKEN);
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(final String email) {
        this.email = email;
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

    public List<SubscriptionData> getSubscriptions() {
        return subscriptions;
    }

    public void setSubscriptions(final List<SubscriptionData> subscriptions) {
        this.subscriptions = subscriptions;
    }

    @SuppressWarnings("unchecked")
    @Override
    public PaymentsMap toPaymentsMap() {
        final PaymentsMap paymentsMap = new PaymentsMap();
        
        paymentsMap.set(NAME, getEmail());
        paymentsMap.set(EMAIL, getEmail());
        paymentsMap.set(REFERENCE, getReference());
        paymentsMap.set(TOKEN, getToken());
        final JSONArray subscriptionsArray = new JSONArray();
        for(final SubscriptionData subscription: subscriptions) {
            subscriptionsArray.add(subscription.toJSON());
        }
        paymentsMap.put(SUBSCRIPTIONS, subscriptionsArray);
        
        return paymentsMap;
    }
}
