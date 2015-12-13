package com.creek.simplifycommercetest.authorization;

import java.util.ArrayList;
import java.util.List;

import com.creek.simplifycommercetest.ListableService;
import com.simplify.payments.PaymentsMap;
import com.simplify.payments.domain.Authorization;
import com.simplify.payments.domain.ResourceList;
import com.simplify.payments.exception.ApiException;

/**
 * 
 * @author andreypereverzin
 */
public class AuthorizationService extends ListableService<AuthorizationData, Authorization> {

    public AuthorizationService(final String publicKey, final String privateKey) {
        super(publicKey, privateKey);
    }

    public AuthorizationData createAuthorization(final AuthorizationData paymentData) throws ApiException {
        final PaymentsMap paymentsMap = paymentData.toPaymentsMap();

        final AuthorizationData authorizationResponse = createAuthorization(paymentsMap);

        return authorizationResponse;
    }

    private AuthorizationData createAuthorization(final PaymentsMap paymentsMap) throws ApiException {
        final Authorization authorization = Authorization.create(paymentsMap);

        System.out.println("Authorization: " + authorization);

        final AuthorizationData authorizationResponse = new AuthorizationData(authorization);
        return authorizationResponse;
    }

    public AuthorizationData findAuthorization(final String authorizationId) throws ApiException {
        final Authorization authorization = Authorization.find(authorizationId);
        final AuthorizationData authorizationData = new AuthorizationData(authorization);
        return authorizationData;
    }

    public AuthorizationData deleteAuthorization(final String authorizationId) throws ApiException {
        final Authorization authorization = Authorization.find(authorizationId);
        final Authorization authorizationDeleted = authorization.delete();
        final AuthorizationData authorizationData = new AuthorizationData(authorizationDeleted);
        return authorizationData;
    }

    public List<AuthorizationData> listAuthorizations() throws ApiException {
        final PaymentsMap paymentsMap = new PaymentsMap();
        paymentsMap.set("max", 30);
        final ResourceList<Authorization> authorizations = Authorization.list();
        final List<Authorization> authorizationsList = authorizations.getList();
        final List<AuthorizationData> authorizationDataList = new ArrayList<>();
        for (final Authorization authorization: authorizationsList) {
            final AuthorizationData authorizationData = new AuthorizationData(authorization);
            authorizationDataList.add(authorizationData);
        }
        return authorizationDataList;
    }
    
    @Override
    protected ResourceList<Authorization> getResourceList() throws ApiException {
        return Authorization.list();
    }
    
    @Override
    protected AuthorizationData createBaseData(final Authorization authorization) {
        return new AuthorizationData(authorization);
    }
}
