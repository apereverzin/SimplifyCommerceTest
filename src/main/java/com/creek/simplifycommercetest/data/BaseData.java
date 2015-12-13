package com.creek.simplifycommercetest.data;

import com.simplify.payments.PaymentsMap;

/**
 * 
 * @author andreypereverzin
 */
public abstract class BaseData implements PaymentsMapTransferrable {
    private static final String ID = "id";
    private static final String DATE_CREATED = "dateCreated";

    private String id;
    private long dateCreated;

    protected BaseData() {
        //
    }
    
    public BaseData(final PaymentsMap paymentsMap) {
        this.id = (String)paymentsMap.get(ID);
        if (paymentsMap.get(DATE_CREATED) != null) {
            this.dateCreated = (long)paymentsMap.get(DATE_CREATED);
        }
    }
    
    public String getId() {
        return id;
    }

    public long getDateCreated() {
        return dateCreated;
    }

    @Override
    public PaymentsMap toPaymentsMap() {
        final PaymentsMap paymentsMap = new PaymentsMap();
        
        paymentsMap.set(ID, getId());
        paymentsMap.set(DATE_CREATED, getDateCreated());
        
        return paymentsMap;
    }
}
