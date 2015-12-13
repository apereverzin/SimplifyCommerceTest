package com.creek.simplifycommercetest.plan;

import com.creek.simplifycommercetest.plan.PlanData.BillingCycle;
import com.creek.simplifycommercetest.plan.PlanData.Frequency;

/**
 * 
 * @author andreypereverzin
 */
public class PlanDataBuilder {
    private final long amount = 1000L;
    private final BillingCycle billingCycle = BillingCycle.FIXED;
    private final long billingCycleLimit = 8L;
    private final Frequency frequency = Frequency.WEEKLY;
    private final long frequencyPeriod = 4L;
    private final String name = "Plan";
    private final long renewalReminderLeadDays = 7L;
    
    public PlanData create() {
        final PlanData planData = new PlanData();
        
        planData.setAmount(amount);
        planData.setBillingCycle(billingCycle);
        planData.setBillingCycleLimit(billingCycleLimit);
        planData.setFrequency(frequency);
        planData.setFrequencyPeriod(frequencyPeriod);
        planData.setName(name);
        planData.setRenewalReminderLeadDays(renewalReminderLeadDays);

        return planData;
    }
}
