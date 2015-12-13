package com.creek.simplifycommercetest.invoiceitem;

import java.util.Map;

import com.creek.simplifycommercetest.SimplifyCommerceService;
import com.simplify.payments.PaymentsMap;
import com.simplify.payments.domain.InvoiceItem;
import com.simplify.payments.exception.ApiException;

/**
 * 
 * @author andreypereverzin
 */
public class InvoiceItemService extends SimplifyCommerceService {

    public InvoiceItemService(final String publicKey, final String privateKey) {
        super(publicKey, privateKey);
    }

    public InvoiceItem createInvoiceItem(final String invoiceId) throws ApiException {
        final PaymentsMap paymentsMap = new PaymentsMap();
        paymentsMap.set("amount", 1000L);
        paymentsMap.set("description", "Invoice Item1");
        paymentsMap.set("invoice", invoiceId);
        paymentsMap.set("reference", "ref111");       

        final InvoiceItem invoiceItem = InvoiceItem.create(paymentsMap);
        return invoiceItem;
    }

    public InvoiceItem findInvoiceItem(final String invoiceItemId) throws ApiException {
        final InvoiceItem invoiceItem = InvoiceItem.find(invoiceItemId);
        return invoiceItem;
    }

    public InvoiceItem updateInvoiceItem(final String invoiceItemId, final Map<String, String> props) throws ApiException {
        final InvoiceItem invoiceItemFound = InvoiceItem.find(invoiceItemId);
        for (final String key : props.keySet()) {
            invoiceItemFound.set(key, props.get(key));
        }
        final InvoiceItem invoiceItemUpdated = invoiceItemFound.update();
        System.out.println(invoiceItemUpdated);
        return invoiceItemUpdated;
    }

    public InvoiceItem deleteInvoiceItem(final String invoiceItemId) throws ApiException {
        final InvoiceItem invoiceItem = InvoiceItem.find(invoiceItemId);
        invoiceItem.delete();
        return invoiceItem;
    }
}
