package com.inspirussia.nikmc.fintech_tfb.rest.model;

/**
 * Created by NIKMC on 18-Sep-16.
 */
public class accounts {

    private String balance;
    //   private String beginDate;
    //  private String chargesAmountForMonth;
    private String currency;
    //  private String endDate;
    private String formattedNumber;
    //   private String id;
    private String info;
    private String limit;
    private String number;
    //  private String orderNum;
    //   private String status;
    private String statusLocale;

    public accounts() {
    }

    public accounts(String balance, String currency, String formattedNumber, String info, String limit, String number, String statusLocale) {
        this.balance = balance;
        this.currency = currency;
        this.formattedNumber = formattedNumber;
        this.info = info;
        this.limit = limit;
        this.number = number;
        this.statusLocale = statusLocale;
    }

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

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
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
