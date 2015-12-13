package com.creek.simplifycommercetest.customer;

/**
 * 
 * @author andreypereverzin
 */
public class CustomerDataBuilder {
    private final String name = "Joe Bloggs";
    private final String email = "joe@mastercard.com";
    private final String reference = "Ref1";
    private String token;
    
    public CustomerDataBuilder withToken(final String token) {
        this.token = token;
        return this;
    }
    
    public CustomerData create() {
        final CustomerData customerData = new CustomerData();
        
        customerData.setName(name);
        customerData.setEmail(email);
        customerData.setReference(reference);
        customerData.setToken(token);

        return customerData;
    }
}
