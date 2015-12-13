package com.creek.simplifycommercetest.refund;

import org.json.simple.JSONObject;

import com.creek.simplifycommercetest.data.BaseData;
import com.simplify.payments.PaymentsMap;

/**
 * 
 * @author andreypereverzin
 */
public class RefundData extends BaseData {    
    private static final String ID = "id";
    private static final String REFERENCE = "reference";
    private static final String REASON = "reason";
    private static final String PAYMENT = "payment";
    private static final String AMOUNT = "amount";
    
    private long amount;
    private String payment;
    private String reason;
    private String reference;
    
    public RefundData() {
        //
    }

    public RefundData(final PaymentsMap paymentsMap) {
        super(paymentsMap);
        this.amount = (long)paymentsMap.get(AMOUNT);
        final JSONObject paymentObject = (JSONObject)paymentsMap.get(PAYMENT);
        this.payment = (String)paymentObject.get(ID);
        this.reason = (String)paymentsMap.get(REASON);
        this.reference = (String)paymentsMap.get(REFERENCE);
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(final long amount) {
        this.amount = amount;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(final String payment) {
        this.payment = payment;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(final String reason) {
        this.reason = reason;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(final String reference) {
        this.reference = reference;
    }

    @Override
    public PaymentsMap toPaymentsMap() {
        final PaymentsMap paymentsMap = super.toPaymentsMap();
        
        paymentsMap.set(AMOUNT, getAmount());
        paymentsMap.set(PAYMENT, getPayment());
        paymentsMap.set(REASON, getReason());
        paymentsMap.set(REFERENCE, getReference());
        
        return paymentsMap;
    }
}
