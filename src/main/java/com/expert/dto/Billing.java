package com.expert.dto;

import java.util.Date;

/**
 * Created by dmytro on 13.03.16.
 */
public class Billing {
    private int id;
    private int userId;
    private String method;
    private String bankDetails;
    private String creditCard;
    private String cvv;
    private Date expDate;

    private final int DEFAULT_ID =  0;

    public Billing(int userId, String method, String bankDetails,
                   String creditCard, String cvv, Date expDate) {
        this.id = DEFAULT_ID;
        this.userId = userId;
        this.method = method;
        this.bankDetails = bankDetails;
        this.creditCard = creditCard;
        this.cvv = cvv;
        this.expDate = expDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getBankDetails() {
        return bankDetails;
    }

    public void setBankDetails(String bankDetails) {
        this.bankDetails = bankDetails;
    }

    public String getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(String creditCard) {
        this.creditCard = creditCard;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public Date getExpDate() {
        return expDate;
    }

    public void setExpDate(Date expDate) {
        this.expDate = expDate;
    }
}
