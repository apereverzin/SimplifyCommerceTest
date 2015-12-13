package com.creek.simplifycommercetest.payment;

import com.creek.simplifycommercetest.data.BaseData;
import com.creek.simplifycommercetest.data.Currency;
import com.simplify.payments.PaymentsMap;

/**
 * 
 * @author andreypereverzin
 */
public class PaymentData extends BaseData {    
    private static final String PAYMENT_STATUS = "paymentStatus";

    public enum PaymentStatus {
        APPROVED, DECLINED
    }

    private static final String AUTHORIZATION = "authorization";
    private static final String TOKEN = "token";
    private static final String REFERENCE = "reference";
    private static final String DESCRIPTION = "description";
    private static final String CURRENCY = "currency";
    private static final String AMOUNT = "amount";
    private static final String REPLAY_ID = "replayId";
    
    private long amount;
    private Currency currency;
    private String description;
    private String reference;
    private String token;
    private String authorization;
    private String replayId;
    private PaymentStatus paymentStatus;
    
    public PaymentData() {
        //
    }

    public PaymentData(final PaymentsMap paymentsMap) {
        super(paymentsMap);
        this.amount = (long)paymentsMap.get(AMOUNT);
        this.currency = Currency.valueOf((String)paymentsMap.get(CURRENCY));
        this.description = (String)paymentsMap.get(DESCRIPTION);
        this.reference = (String)paymentsMap.get(REFERENCE);
        this.token = (String)paymentsMap.get(TOKEN);
        this.paymentStatus = PaymentStatus.valueOf((String)paymentsMap.get(PAYMENT_STATUS));
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

    public String getAuthorization() {
        return authorization;
    }

    public void setAuthorization(final String authorization) {
        this.authorization = authorization;
    }

    public String getReplayId() {
        return replayId;
    }

    public void setReplayId(final String replayId) {
        this.replayId = replayId;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(final PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    @Override
    public PaymentsMap toPaymentsMap() {
        final PaymentsMap paymentsMap = super.toPaymentsMap();
        
        paymentsMap.set(AMOUNT, getAmount());
        paymentsMap.set(CURRENCY, getCurrency().name());
        paymentsMap.set(DESCRIPTION, getDescription());
        paymentsMap.set(REFERENCE, getReference());
        paymentsMap.set(TOKEN, getToken());
        paymentsMap.set(AUTHORIZATION, getAuthorization());
        paymentsMap.set(REPLAY_ID, getReplayId());
        
        return paymentsMap;
    }
}
