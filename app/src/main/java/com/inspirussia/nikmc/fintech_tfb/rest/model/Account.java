package com.inspirussia.nikmc.fintech_tfb.rest.model;

/**
 * Created by TheLetch on 18/09/2016.
 */
public class Account implements SpinnerElement {
    private String balance;

    private String currency;

    private String formattedNumber;


    private String limit;
    private String number;

    public Account() {
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    private String info;

    private String statusLocale;

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getFormattedNumber() {
        return formattedNumber;
    }

    public void setFormattedNumber(String formattedNumber) {
        this.formattedNumber = formattedNumber;
    }



    public String getLimit() {
        return limit;
    }

    public void setLimit(String limit) {
        this.limit = limit;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getStatusLocale() {
        return statusLocale;
    }

    public void setStatusLocale(String statusLocale) {
        this.statusLocale = statusLocale;
    }
}
