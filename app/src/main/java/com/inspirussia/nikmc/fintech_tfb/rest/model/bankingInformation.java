package com.inspirussia.nikmc.fintech_tfb.rest.model;

import org.json.JSONObject;

/**
 * Created by NIKMC on 18-Sep-16.
 */
public class bankingInformation {
    String bic;
    String correspondentAccount;
    String name;
    String payee;

    public bankingInformation() {

        JSONObject JSOn = new JSONObject();

    }

    public bankingInformation(String bic, String correspondentAccount, String name, String payee) {
        this.bic = bic;
        this.correspondentAccount = correspondentAccount;
        this.name = name;
        this.payee = payee;
    }

    public String getBic() {
        return bic;
    }

    public void setBic(String bic) {
        this.bic = bic;
    }

    public String getCorrespondentAccount() {
        return correspondentAccount;
    }

    public void setCorrespondentAccount(String correspondentAccount) {
        this.correspondentAccount = correspondentAccount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPayee() {
        return payee;
    }

    public void setPayee(String payee) {
        this.payee = payee;
    }
}
