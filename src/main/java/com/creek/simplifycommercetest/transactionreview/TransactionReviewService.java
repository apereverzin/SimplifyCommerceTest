package com.creek.simplifycommercetest.transactionreview;

import java.util.List;
import java.util.Map;

import com.creek.simplifycommercetest.SimplifyCommerceService;
import com.simplify.payments.PaymentsMap;
import com.simplify.payments.domain.Invoice;
import com.simplify.payments.domain.ResourceList;
import com.simplify.payments.exception.ApiException;

/**
 * 
 * @author andreypereverzin
 */
public class TransactionReviewService extends SimplifyCommerceService {

    public TransactionReviewService(final String publicKey, final String privateKey) {
        super(publicKey, privateKey);
    }

    public Invoice createInvoice() throws ApiException {
        final PaymentsMap paymentsMap = new PaymentsMap();
        paymentsMap.set("currency", "USD");
        paymentsMap.set("email", "customer@mastercard.com");
        // paymentsMap.set("items[0].amount", 5504L);
        // paymentsMap.set("items[0].quantity", 1L);
        // paymentsMap.set("items[0].tax", "[TAX ID]");
        paymentsMap.set("memo", "This is a memo");
        paymentsMap.set("name", "Customer Customer");
        paymentsMap.set("note", "This is a note");
        paymentsMap.set("reference", "Ref2");
        paymentsMap.set("suppliedDate", 2394839384000L);

        final Invoice invoice = Invoice.create(paymentsMap);
        return invoice;
    }

    public Invoice findInvoice(final String invoiceId) throws ApiException {
        final Invoice invoice = Invoice.find(invoiceId);
        return invoice;
    }

    public Invoice updateInvoice(final String invoiceId, final Map<String, String> props) throws ApiException {
        final Invoice invoiceFound = Invoice.find(invoiceId);
        for (final String key : props.keySet()) {
            invoiceFound.set(key, props.get(key));
        }
        final Invoice invoiceUpdated = invoiceFound.update();
        System.out.println(invoiceUpdated);
        return invoiceUpdated;
    }

    public Invoice deleteInvoice(final String invoiceId) throws ApiException {
        final Invoice invoice = Invoice.find(invoiceId);
        invoice.delete();
        return invoice;
    }

    public List<Invoice> listInvoices() throws ApiException {
        final ResourceList<Invoice> invoices = Invoice.list();
        return invoices.getList();
    }
}
