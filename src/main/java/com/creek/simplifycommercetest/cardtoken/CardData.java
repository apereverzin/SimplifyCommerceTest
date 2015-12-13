package com.creek.simplifycommercetest.cardtoken;

import org.json.simple.JSONObject;


/**
 * 
 * @author andreypereverzin
 */
public class CardData {
    private static final String ADDRESS_ZIP = "addressZip";
    private static final String ADDRESS_STATE = "addressState";
    private static final String ADDRESS_LINE2 = "addressLine2";
    private static final String ADDRESS_LINE1 = "addressLine1";
    private static final String ADDRESS_COUNTRY = "addressCountry";
    private static final String ADDRESS_CITY = "addressCity";
    private static final String LAST4 = "last4";
    private static final String TYPE = "type";
    private static final String ID = "id";
    private static final String CARD_ENTRY_MODE = "cardEntryMode";
    private static final String DATE_CREATED = "dateCreated";
    private static final String NUMBER = "number";
    private static final String NAME = "name";
    private static final String EXP_YEAR = "expYear";
    private static final String EXP_MONTH = "expMonth";
    private static final String CVC = "cvc";

    public enum CardEntryMode {
        E_COMMERCE, VIRTUAL_TERMINAL
    }
    
    public enum Type {
        MASTERCARD
    }
    
    private String cvc;
    private long expMonth;
    private long expYear;
    private String name;
    private String number;
    private long dateCreated;
    private CardEntryMode cardEntryMode;
    private String id;
    private Type type;
    private String last4;
    private String addressCity;
    private String addressCountry;
    private String addressLine1;
    private String addressLine2;
    private String addressState;
    private String addressZip;
    
    public CardData() {
        //
    }
    
    public CardData(final JSONObject jsonObject) {
        this.number = (String)jsonObject.get(NUMBER);
        this.cvc = (String)jsonObject.get(CVC);
        this.expMonth = (long)jsonObject.get(EXP_MONTH);
        this.expYear = (long)jsonObject.get(EXP_YEAR);
        this.addressState = (String)jsonObject.get(ADDRESS_STATE);
        this.addressCity = (String)jsonObject.get(ADDRESS_CITY);
        this.addressCountry = (String)jsonObject.get(ADDRESS_COUNTRY);
        this.addressLine1 = (String)jsonObject.get(ADDRESS_LINE1);
        this.addressLine2 = (String)jsonObject.get(ADDRESS_LINE2);
        this.addressZip = (String)jsonObject.get(ADDRESS_ZIP);
    }

    public String getCvc() {
        return cvc;
    }

    public void setCvc(final String cvc) {
        this.cvc = cvc;
    }

    public long getExpMonth() {
        return expMonth;
    }

    public void setExpMonth(final long expMonth) {
        this.expMonth = expMonth;
    }

    public long getExpYear() {
        return expYear;
    }

    public void setExpYear(final long expYear) {
        this.expYear = expYear;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(final String number) {
        this.number = number;
    }

    public long getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(final long dateCreated) {
        this.dateCreated = dateCreated;
    }

    public CardEntryMode getCardEntryMode() {
        return cardEntryMode;
    }

    public void setCardEntryMode(final CardEntryMode cardEntryMode) {
        this.cardEntryMode = cardEntryMode;
    }

    public String getId() {
        return id;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public Type getType() {
        return type;
    }

    public void setType(final Type type) {
        this.type = type;
    }

    public String getLast4() {
        return last4;
    }

    public void setLast4(final String last4) {
        this.last4 = last4;
    }

    public String getAddressCity() {
        return addressCity;
    }

    public void setAddressCity(final String addressCity) {
        this.addressCity = addressCity;
    }

    public String getAddressCountry() {
        return addressCountry;
    }

    public void setAddressCountry(final String addressCountry) {
        this.addressCountry = addressCountry;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(final String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(final String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getAddressState() {
        return addressState;
    }

    public void setAddressState(final String addressState) {
        this.addressState = addressState;
    }

    public String getAddressZip() {
        return addressZip;
    }

    public void setAddressZip(final String addressZip) {
        this.addressZip = addressZip;
    }
    
    @SuppressWarnings("unchecked")
    public JSONObject toJSONObject() {
        final JSONObject cardObject = new JSONObject();
        
        cardObject.put(CVC, getCvc());
        cardObject.put(EXP_MONTH, getExpMonth());
        cardObject.put(EXP_YEAR, getExpYear());
        cardObject.put(NAME, getName());
        cardObject.put(NUMBER, getNumber());
        cardObject.put(DATE_CREATED, getDateCreated());
        if (getCardEntryMode() != null) {
            cardObject.put(CARD_ENTRY_MODE, getCardEntryMode().name());
        }
        cardObject.put(ID, getId());
        if (getType() != null) {
            cardObject.put(TYPE, getType().name());
        }
        cardObject.put(LAST4, getLast4());
        cardObject.put(ADDRESS_CITY, getAddressCity());
        cardObject.put(ADDRESS_COUNTRY, getAddressCountry());
        cardObject.put(ADDRESS_LINE1, getAddressLine1());
        cardObject.put(ADDRESS_LINE2, getAddressLine2());
        cardObject.put(ADDRESS_STATE, getAddressState());
        cardObject.put(ADDRESS_ZIP, getAddressZip());
        
        return cardObject;
    }
}
