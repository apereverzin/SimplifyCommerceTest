package com.creek.simplifycommercetest.coupon;

/**
 * 
 * @author andreypereverzin
 */
public class CouponDataBuilder {
    String couponCode = "20off";
    String description = "20% off!";
    long endDate = 64063288800000L;
    long startDate = 2394829384000L;
    long maxRedemptions = 100;
    long percentOff = 20L;

    public CouponData create() {
        final CouponData couponData = new CouponData();
        
        couponData.setCouponCode(couponCode);
        couponData.setDescription(description);
        couponData.setEndDate(endDate);
        couponData.setStartDate(startDate);
        couponData.setMaxRedemptions(maxRedemptions);
        couponData.setPercentOff(percentOff);
        
        return couponData;
    }
}
