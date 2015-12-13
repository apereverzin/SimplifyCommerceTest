package com.creek.simplifycommercetest;

import java.util.ArrayList;
import java.util.List;

import com.creek.simplifycommercetest.data.PaymentsMapTransferrable;
import com.simplify.payments.PaymentsMap;
import com.simplify.payments.domain.ResourceList;
import com.simplify.payments.exception.ApiException;

/**
 * 
 * @author andreypereverzin
 */
public abstract class ListableService <T extends PaymentsMapTransferrable, U extends PaymentsMap> extends SimplifyCommerceService {
    public ListableService(final String publicKey, final String privateKey) {
        super(publicKey, privateKey);
    }

    public List<T> list() throws ApiException {
        final ResourceList<U> resources = getResourceList();
        final List<U> resourcesList = resources.getList();
        final List<T> baseDataList = new ArrayList<>();
        for (final U resource: resourcesList) {
            final T baseData = createBaseData(resource);
            baseDataList.add(baseData);
        }
        return baseDataList;
    }
    
    protected abstract ResourceList<U> getResourceList() throws ApiException;
    
    protected abstract T createBaseData(U u);
}
