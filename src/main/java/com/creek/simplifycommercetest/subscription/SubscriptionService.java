package com.creek.simplifycommercetest.subscription;

import java.util.List;
import java.util.Map;

import com.creek.simplifycommercetest.SimplifyCommerceService;
import com.simplify.payments.PaymentsMap;
import com.simplify.payments.domain.ResourceList;
import com.simplify.payments.domain.Subscription;
import com.simplify.payments.exception.ApiException;

/**
 * 
 * @author andreypereverzin
 */
public class SubscriptionService extends SimplifyCommerceService {

    public SubscriptionService(final String publicKey, final String privateKey) {
        super(publicKey, privateKey);
    }

    public Subscription createCustomSubscription(final String customerId) throws ApiException {
        final PaymentsMap paymentsMap = new PaymentsMap();
        paymentsMap.set("customer", customerId);
        paymentsMap.set("amount", 1234L);
        paymentsMap.set("frequency", "MONTHLY");
        paymentsMap.set("frequencyPeriod", 1L);
        paymentsMap.set("name", "Custom Subscription");
        
        return createWithPaymentsMap(paymentsMap);
    }

    public Subscription createSubscriptionWithPlan(final String customerId, final String planId) throws ApiException {
        final PaymentsMap paymentsMap = new PaymentsMap();
        paymentsMap.set("customer", customerId);
        paymentsMap.set("plan", planId);
        
        return createWithPaymentsMap(paymentsMap);
    }

    public Subscription createSubscriptionWithPlanAndCoupon(final String customerId, final String planId, final String couponId) throws ApiException {
        final PaymentsMap paymentsMap = new PaymentsMap();
        paymentsMap.set("customer", customerId);
        paymentsMap.set("plan", planId);
        paymentsMap.set("coupon", couponId);
        
        return createWithPaymentsMap(paymentsMap);
    }

    private Subscription createWithPaymentsMap(final PaymentsMap paymentsMap) throws ApiException {
        final Subscription subscription = Subscription.create(paymentsMap);
        return subscription;
    }

    public Subscription findSubscription(final String subscriptionId) throws ApiException {
        final Subscription subscription = Subscription.find(subscriptionId);
        return subscription;
    }

    public Subscription updateSubscription(final String subscriptionId, final Map<String, String> props) throws ApiException {
        final Subscription subscriptionFound = Subscription.find(subscriptionId);
        for (final String key : props.keySet()) {
            subscriptionFound.set(key, props.get(key));
        }
        final Subscription subscriptionUpdated = subscriptionFound.update();
        System.out.println(subscriptionUpdated);
        return subscriptionUpdated;
    }

    public Subscription deleteSubscription(final String subscriptionId) throws ApiException {
        final Subscription subscription = Subscription.find(subscriptionId);
        subscription.delete();
        return subscription;
    }
    
    public List<Subscription> listSubscriptions() throws ApiException {
        final ResourceList<Subscription> subscriptions = Subscription.list();
        return subscriptions.getList();
    }
}
