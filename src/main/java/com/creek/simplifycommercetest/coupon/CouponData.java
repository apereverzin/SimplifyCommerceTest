package com.creek.simplifycommercetest.coupon;

import com.creek.simplifycommercetest.data.BaseData;
import com.simplify.payments.PaymentsMap;

/**
 * 
 * @author andreypereverzin
 */
public class CouponData extends BaseData {    
    private static final String COUPON_CODE = "couponCode";
    private static final String DESCRIPTION = "description";
    private static final String END_DATE = "endDate";
    private static final String START_DATE = "startDate";
    private static final String MAX_REDEMPTIONS = "maxRedemptions";
    private static final String PERCENT_OFF = "percentOff";
    
    private String couponCode;
    private String description;
    private long endDate;
    private long startDate;
    private long maxRedemptions;
    private long percentOff;
    
    public CouponData() {
        //
    }

    public CouponData(final PaymentsMap paymentsMap) {
        super(paymentsMap);
        this.couponCode = (String)paymentsMap.get(COUPON_CODE);
        this.description = (String)paymentsMap.get(DESCRIPTION);
        this.endDate = (long)paymentsMap.get(END_DATE);
        this.startDate = (long)paymentsMap.get(START_DATE);
        this.maxRedemptions = (long)paymentsMap.get(MAX_REDEMPTIONS);
        this.percentOff = (long)paymentsMap.get(PERCENT_OFF);
    }

    public String getCouponCode() {
        return couponCode;
    }

    public void setCouponCode(final String couponCode) {
        this.couponCode = couponCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public long getEndDate() {
        return endDate;
    }

    public void setEndDate(final long endDate) {
        this.endDate = endDate;
    }

    public long getStartDate() {
        return startDate;
    }

    public void setStartDate(final long startDate) {
        this.startDate = startDate;
    }

    public long getMaxRedemptions() {
        return maxRedemptions;
    }

    public void setMaxRedemptions(final long maxRedemptions) {
        this.maxRedemptions = maxRedemptions;
    }

    public long getPercentOff() {
        return percentOff;
    }

    public void setPercentOff(final long percentOff) {
        this.percentOff = percentOff;
    }

    @Override
    public PaymentsMap toPaymentsMap() {
        final PaymentsMap paymentsMap = super.toPaymentsMap();
        
        paymentsMap.set(COUPON_CODE, getCouponCode());
        paymentsMap.set(DESCRIPTION, getDescription());
        paymentsMap.set(END_DATE, getEndDate());
        paymentsMap.set(START_DATE, getStartDate());
        paymentsMap.set(PERCENT_OFF, getPercentOff());
        paymentsMap.set(MAX_REDEMPTIONS, getMaxRedemptions());
        
        return paymentsMap;
    }
}
