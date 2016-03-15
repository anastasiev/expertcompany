package com.expert.dto;

/**
 * Created by dmytro on 13.03.16.
 */
public class Company {
    private int id;
    private int personId;
    private String name;
    private String office;
    private String fax;
    private String email;
    private String billingAddress;
    private String city;

    private final int DEFAULT_ID =  0;

    public Company(int personId, String name, String office,
                   String fax, String email, String billingAddress, String city) {
        this.id = DEFAULT_ID;
        this.personId = personId;
        this.name = name;
        this.office = office;
        this.fax = fax;
        this.email = email;
        this.billingAddress = billingAddress;
        this.city = city;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(String billingAddress) {
        this.billingAddress = billingAddress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
