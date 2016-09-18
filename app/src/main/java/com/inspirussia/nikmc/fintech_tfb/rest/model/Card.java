package com.inspirussia.nikmc.fintech_tfb.rest.model;

/**
 * Created by TheLetch on 18/09/2016.
 */
public class Card implements SpinnerElement {


    private String balance;
    private String formattedNumber;

    private String currency;

    private String limit;

    public String getNumber() {
        return number;
    }

    private String number;

    private String statusLocale;

    private String info;

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public String getFormattedNumber() {
        return formattedNumber;
    }

    public void setFormattedNumber(String formattedNumber) {
        this.formattedNumber = formattedNumber;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getLimit() {
        return limit;
    }

    public void setLimit(String limit) {
        this.limit = limit;
    }


    public String getStatusLocale() {
        return statusLocale;
    }

    public void setStatusLocale(String statusLocale) {
        this.statusLocale = statusLocale;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
