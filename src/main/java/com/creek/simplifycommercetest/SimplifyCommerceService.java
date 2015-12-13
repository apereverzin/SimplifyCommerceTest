package com.creek.simplifycommercetest;

import com.simplify.payments.PaymentsApi;

/**
 * 
 * @author andreypereverzin
 */
public abstract class SimplifyCommerceService {
    private final String publicKey;
    private final String privateKey;

    public SimplifyCommerceService(final String publicKey, final String privateKey) {
        this.publicKey = publicKey;
        this.privateKey = privateKey;
    }

    public void init() {
        PaymentsApi.PUBLIC_KEY = publicKey;
        PaymentsApi.PRIVATE_KEY = privateKey;
    }
}
