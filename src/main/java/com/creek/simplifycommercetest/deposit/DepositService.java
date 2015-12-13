package com.creek.simplifycommercetest.deposit;

import java.util.List;

import com.creek.simplifycommercetest.SimplifyCommerceService;
import com.simplify.payments.PaymentsMap;
import com.simplify.payments.domain.Deposit;
import com.simplify.payments.domain.ResourceList;
import com.simplify.payments.exception.ApiException;

/**
 * 
 * @author andreypereverzin
 */
public class DepositService extends SimplifyCommerceService {

    public DepositService(final String publicKey, final String privateKey) {
        super(publicKey, privateKey);
    }

    public List<Deposit> listDeposits() throws ApiException {
        final PaymentsMap query = new PaymentsMap("max", 30);
        final ResourceList<Deposit> deposit = Deposit.list(query);
        return deposit.getList();
    }

    public Deposit findDeposit(final String depositId) throws ApiException {
        final Deposit deposit = Deposit.find(depositId);
        return deposit;
    }
}
