package com.creek.simplifycommercetest.payment;

import com.creek.simplifycommercetest.ListableService;
import com.simplify.payments.PaymentsMap;
import com.simplify.payments.domain.Payment;
import com.simplify.payments.domain.ResourceList;
import com.simplify.payments.exception.ApiException;

/**
 * 
 * @author andreypereverzin
 */
public class PaymentService extends ListableService<PaymentData, Payment> {

    public PaymentService(final String publicKey, final String privateKey) {
        super(publicKey, privateKey);
    }

    public PaymentData createPayment(final PaymentData paymentData) throws ApiException {
        final PaymentsMap paymentsMap = paymentData.toPaymentsMap();
        final Payment payment = Payment.create(paymentsMap);
        
        System.out.println("Payment: " + payment);
        
        return new PaymentData(payment);
    }

    public PaymentData findPayment(final String paymentId) throws ApiException {
        final Payment payment = Payment.find(paymentId);
        return new PaymentData(payment);
    }

    public PaymentData updatePayment(final PaymentData paymentData) throws ApiException {
        final Payment paymentFound = Payment.find(paymentData.getId());
        final Payment paymentUpdated = paymentFound.update();
        System.out.println(paymentUpdated);
        return new PaymentData(paymentUpdated);
    }

    @Override
    protected ResourceList<Payment> getResourceList() throws ApiException {
        return Payment.list();
    }

    @Override
    protected PaymentData createBaseData(final Payment payment) {
        return new PaymentData(payment);
    }
}
