package com.creek.simplifycommercetest.customer;

import java.util.Map;

import com.creek.simplifycommercetest.ListableService;
import com.simplify.payments.PaymentsMap;
import com.simplify.payments.domain.Customer;
import com.simplify.payments.domain.ResourceList;
import com.simplify.payments.exception.ApiException;

/**
 * 
 * @author andreypereverzin
 */
public class CustomerService extends ListableService<CustomerData, Customer> {

    public CustomerService(final String publicKey, final String privateKey) {
        super(publicKey, privateKey);
    }

    public CustomerData createCustomer(final CustomerData cardTokenData) throws ApiException {
        final PaymentsMap paymentsMap = cardTokenData.toPaymentsMap();
        final Customer customer = Customer.create(paymentsMap);
        
        System.out.println("Customer: " + customer);
        
        return new CustomerData(customer);
    }

    public CustomerData findCustomer(final String customerId) throws ApiException {
        final Customer customer = Customer.find(customerId);
        return new CustomerData(customer);
    }

    public CustomerData updateCustomer(final String customerId, final Map<String, String> props) throws ApiException {
        final Customer customerFound = Customer.find(customerId);
        for (final String key : props.keySet()) {
            customerFound.set(key, props.get(key));
        }
        final Customer customerUpdated = customerFound.update();
        System.out.println(customerUpdated);
        return new CustomerData(customerUpdated);
    }

    public CustomerData deleteCustomer(final String customerId) throws ApiException {
        final Customer customer = Customer.find(customerId);
        customer.delete();
        return new CustomerData(customer);
    }

    @Override
    protected ResourceList<Customer> getResourceList() throws ApiException {
        return Customer.list();
    }

    @Override
    protected CustomerData createBaseData(final Customer customer) {
        return new CustomerData(customer);
    }
}
