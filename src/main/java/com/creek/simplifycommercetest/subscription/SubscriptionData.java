package com.creek.simplifycommercetest.subscription;

import org.json.simple.JSONObject;

import com.creek.simplifycommercetest.data.JSONTransformable;

/**
 * 
 * @author andreypereverzin
 */
public class SubscriptionData implements JSONTransformable {
    private static final String PLAN = "plan";
    private String plan;

    public String getPlan() {
        return plan;
    }

    public void setPlan(final String plan) {
        this.plan = plan;
    }

    @SuppressWarnings("unchecked")
    @Override
    public JSONObject toJSON() {
        final JSONObject jsonObject = new JSONObject();
        
        jsonObject.put(PLAN, this.getPlan());
        
        return jsonObject;
    }

}
