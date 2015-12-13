package com.creek.simplifycommercetest.refund;

/**
 * 
 * @author andreypereverzin
 */
public class RefundDataBuilder {
    private final long amount = 2000L;
    private String payment;
    private final String reason = "Refund Description";
    private final String reference = "76398734634";
    
    public RefundDataBuilder withPaymentn(final String payment) {
        this.payment = payment;
        return this;
    }
    
    public RefundData create() {
        final RefundData refundData = new RefundData();
        
        refundData.setAmount(amount);
        refundData.setPayment(payment);
        refundData.setReason(reason);
        refundData.setReference(reference);
        
        return refundData;
    }
}
