package com.creek.simplifycommercetest.plan;

import java.util.List;
import java.util.Map;

import com.creek.simplifycommercetest.SimplifyCommerceService;
import com.simplify.payments.PaymentsMap;
import com.simplify.payments.domain.Plan;
import com.simplify.payments.domain.ResourceList;
import com.simplify.payments.exception.ApiException;

/**
 * 
 * @author andreypereverzin
 */
public class PlanService extends SimplifyCommerceService {

    public PlanService(final String publicKey, final String privateKey) {
        super(publicKey, privateKey);
    }

    public PlanData createPlan(final PlanData planData) throws ApiException {
        final PaymentsMap paymentsMap = planData.toPaymentsMap();
        final Plan plan = Plan.create(paymentsMap);
        
        System.out.println("Plan: " + plan);
        
        return new PlanData(plan);
    }

    public Plan findPlan(final String planId) throws ApiException {
        final Plan plan = Plan.find(planId);
        return plan;
    }

    public Plan updatePlan(final String planId, final Map<String, String> props) throws ApiException {
        final Plan planFound = Plan.find(planId);
        for (final String key : props.keySet()) {
            planFound.set(key, props.get(key));
        }
        final Plan planUpdated = planFound.update();
        System.out.println(planUpdated);
        return planUpdated;
    }

    public Plan deletePlan(final String planId) throws ApiException {
        final Plan plan = Plan.find(planId);
        plan.delete();
        return plan;
    }
    
    public List<Plan> listPlans() throws ApiException {
        final ResourceList<Plan> plans = Plan.list();
        return plans.getList();
    }
}
