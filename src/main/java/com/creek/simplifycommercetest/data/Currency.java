package com.creek.simplifycommercetest.data;

/**
 * 
 * @author andreypereverzin
 */
public enum Currency {
    EUR, INR, USD, GBP;
    
    public Currency getDefault() {
        return USD;
    }
}
