package com.creek.simplifycommercetest.tax;

import java.util.List;

import com.creek.simplifycommercetest.SimplifyCommerceService;
import com.simplify.payments.PaymentsMap;
import com.simplify.payments.domain.ResourceList;
import com.simplify.payments.domain.Tax;
import com.simplify.payments.exception.ApiException;

/**
 * 
 * @author andreypereverzin
 */
public class TaxService extends SimplifyCommerceService {

    public TaxService(final String publicKey, final String privateKey) {
        super(publicKey, privateKey);
    }

    public Tax createTax() throws ApiException {
        final PaymentsMap paymentsMap = new PaymentsMap();

        final Tax tax = Tax.create(paymentsMap);
        return tax;
    }

    public Tax findTax(final String taxId) throws ApiException {
        final Tax tax = Tax.find(taxId);
        return tax;
    }

    public Tax deleteTax(final String taxId) throws ApiException {
        final Tax tax = Tax.find(taxId);
        tax.delete();
        return tax;
    }

    public List<Tax> listTaxes() throws ApiException {
        final ResourceList<Tax> taxes = Tax.list();
        return taxes.getList();
    }
}
