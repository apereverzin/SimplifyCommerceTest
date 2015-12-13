package com.creek.simplifycommercetest.coupon;

import com.creek.simplifycommercetest.ListableService;
import com.simplify.payments.PaymentsMap;
import com.simplify.payments.domain.Coupon;
import com.simplify.payments.domain.ResourceList;
import com.simplify.payments.exception.ApiException;

/**
 * 
 * @author andreypereverzin
 */
public class CouponService extends ListableService<CouponData, Coupon> {

    public CouponService(final String publicKey, final String privateKey) {
        super(publicKey, privateKey);
    }

    public CouponData createCoupon(final CouponData couponData) throws ApiException {
        final PaymentsMap paymentsMap = couponData.toPaymentsMap();
        final Coupon coupon = Coupon.create(paymentsMap);
        
        System.out.println("Coupon: " + coupon);
        
        return new CouponData(coupon);
    }

    public CouponData findCoupon(final String couponId) throws ApiException {
        final Coupon coupon = Coupon.find(couponId);

        return new CouponData(coupon);
    }

    public CouponData updateCoupon(final CouponData couponData) throws ApiException {
        //final Coupon couponFound = Coupon.find(couponData.getId());
        final Coupon coupon = (Coupon)couponData.toPaymentsMap();
        final Coupon couponUpdated = coupon.update();
        
        System.out.println(couponUpdated);

        return new CouponData(couponUpdated);
    }

    public CouponData deleteCoupon(final String couponId) throws ApiException {
        final Coupon couponFound = Coupon.find(couponId);
        final Coupon couponDeleted = couponFound.delete();
        System.out.println(couponDeleted);
        return new CouponData(couponDeleted);
    }

    @Override
    protected ResourceList<Coupon> getResourceList() throws ApiException {
        return Coupon.list();
    }

    @Override
    protected CouponData createBaseData(final Coupon coupon) {
        return new CouponData(coupon);
    }
}
