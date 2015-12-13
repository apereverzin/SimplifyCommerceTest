package com.creek.simplifycommercetest.plan;

import com.creek.simplifycommercetest.data.BaseData;
import com.simplify.payments.PaymentsMap;

/**
 * 
 * @author andreypereverzin
 */
public class PlanData extends BaseData {
    public enum Frequency {
        DAILY, WEEKLY, MONTHLY, YEARLY
    }

    public enum BillingCycle {
        AUTO, FIXED
    }

    private static final String RENEWAL_REMINDER_LEAD_DAYS = "renewalReminderLeadDays";
    private static final String NAME = "name";
    private static final String FREQUENCY_PERIOD = "frequencyPeriod";
    private static final String FREQUENCY = "frequency";
    private static final String BILLING_CYCLE_LIMIT = "billingCycleLimit";
    private static final String BILLING_CYCLE = "billingCycle";
    private static final String AMOUNT = "amount";
    private static final String ID = "id";
    private static final String DATE_CREATED = "dateCreated";

    private long amount;
    private BillingCycle billingCycle;
    private long billingCycleLimit;
    private Frequency frequency;
    private long frequencyPeriod;
    private String name;
    private long renewalReminderLeadDays;
    private String id;
    private long dateCreated;

    public PlanData() {
        //
    }
    
    public PlanData(final PaymentsMap paymentsMap) {
        super(paymentsMap);
        this.amount = (long)paymentsMap.get(AMOUNT);
        this.billingCycle = BillingCycle.valueOf((String)paymentsMap.get(BILLING_CYCLE));
        this.billingCycleLimit = (long)paymentsMap.get(BILLING_CYCLE_LIMIT);
        this.frequency = Frequency.valueOf((String)paymentsMap.get(FREQUENCY));
        this.frequencyPeriod = (long)paymentsMap.get(FREQUENCY_PERIOD);
        this.name = (String)paymentsMap.get(NAME);
        this.renewalReminderLeadDays = (long)paymentsMap.get(RENEWAL_REMINDER_LEAD_DAYS);
        this.id = (String)paymentsMap.get(ID);
        this.dateCreated = (long)paymentsMap.get(DATE_CREATED);
    }
    
    public long getAmount() {
        return amount;
    }

    public void setAmount(final long amount) {
        this.amount = amount;
    }

    public BillingCycle getBillingCycle() {
        return billingCycle;
    }

    public void setBillingCycle(final BillingCycle billingCycle) {
        this.billingCycle = billingCycle;
    }

    public long getBillingCycleLimit() {
        return billingCycleLimit;
    }

    public void setBillingCycleLimit(final long billingCycleLimit) {
        this.billingCycleLimit = billingCycleLimit;
    }

    public Frequency getFrequency() {
        return frequency;
    }

    public void setFrequency(final Frequency frequency) {
        this.frequency = frequency;
    }

    public long getFrequencyPeriod() {
        return frequencyPeriod;
    }

    public void setFrequencyPeriod(final long frequencyPeriod) {
        this.frequencyPeriod = frequencyPeriod;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public long getRenewalReminderLeadDays() {
        return renewalReminderLeadDays;
    }

    public void setRenewalReminderLeadDays(final long renewalReminderLeadDays) {
        this.renewalReminderLeadDays = renewalReminderLeadDays;
    }
    
    @Override
    public String getId() {
        return id;
    }

    public void setId(final String id) {
        this.id = id;
    }

    @Override
    public long getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(final long dateCreated) {
        this.dateCreated = dateCreated;
    }

    @Override
    public PaymentsMap toPaymentsMap() {
        final PaymentsMap paymentsMap = super.toPaymentsMap();
        
        paymentsMap.set(AMOUNT, this.amount);
        paymentsMap.set(BILLING_CYCLE, getBillingCycle().name());
        paymentsMap.set(BILLING_CYCLE_LIMIT, getBillingCycleLimit());
        paymentsMap.set(FREQUENCY, getFrequency().name());
        paymentsMap.set(FREQUENCY_PERIOD, getFrequencyPeriod());
        paymentsMap.set(NAME, getName());
        paymentsMap.set(RENEWAL_REMINDER_LEAD_DAYS, getRenewalReminderLeadDays());
        
        return paymentsMap;
    }
}
