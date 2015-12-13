package com.creek.simplifycommercetest.refund;

import java.util.ArrayList;
import java.util.List;

import com.creek.simplifycommercetest.ListableService;
import com.simplify.payments.PaymentsMap;
import com.simplify.payments.domain.Refund;
import com.simplify.payments.domain.ResourceList;
import com.simplify.payments.exception.ApiException;

/**
 * 
 * @author andreypereverzin
 */
public class RefundService extends ListableService<RefundData, Refund> {

    public RefundService(final String publicKey, final String privateKey) {
        super(publicKey, privateKey);
    }

    public RefundData createRefund(final RefundData refundData) throws ApiException {
        final PaymentsMap paymentsMap = refundData.toPaymentsMap();
        final Refund refund = Refund.create(paymentsMap);
        
        System.out.println("Refund: " + refund);
        
        return new RefundData(refund);
    }

    public RefundData findRefund(final String refundId) throws ApiException {
        final Refund refund = Refund.find(refundId);
        return new RefundData(refund);
    }
    
    public List<RefundData> listRefunds() throws ApiException {
        final ResourceList<Refund> refunds = Refund.list();
        final List<Refund> refundsList = refunds.getList();
        final List<RefundData> refundDataList = new ArrayList<>();
        for (final Refund refund: refundsList) {
            final RefundData refundData = new RefundData(refund);
            refundDataList.add(refundData);
        }
        return refundDataList;
    }
    
    @Override
    protected ResourceList<Refund> getResourceList() throws ApiException {
        return Refund.list();
    }
    
    @Override
    protected RefundData createBaseData(final Refund refund) {
        return new RefundData(refund);
    }
}
