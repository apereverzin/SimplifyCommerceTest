package com.creek.simplifycommercetest.chargeback;

import java.util.List;

import com.creek.simplifycommercetest.SimplifyCommerceService;
import com.simplify.payments.PaymentsMap;
import com.simplify.payments.domain.Chargeback;
import com.simplify.payments.domain.ResourceList;
import com.simplify.payments.exception.ApiException;

/**
 * 
 * @author andreypereverzin
 */
public class ChargeBackService extends SimplifyCommerceService {

    public ChargeBackService(final String publicKey, final String privateKey) {
        super(publicKey, privateKey);
    }

    public List<Chargeback> listChargebacks() throws ApiException {
        final ResourceList<Chargeback> chargebacks = Chargeback.list(new PaymentsMap("max", 30));
        final List<Chargeback> chargebacksList = chargebacks.getList();
        return chargebacksList;
    }
    
    public Chargeback findChargeback(final String chargebackId) {
        return null;
    }
}
