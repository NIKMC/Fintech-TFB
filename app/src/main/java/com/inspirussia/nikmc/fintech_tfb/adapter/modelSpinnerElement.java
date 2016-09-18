package com.inspirussia.nikmc.fintech_tfb.adapter;

import java.io.Serializable;

/**
 * Created by TheLetch on 18/09/2016.
 */
public class modelSpinnerElement {

    String balance;
    String number;
    String info;

    public modelSpinnerElement(String bal,String typ,String numb){
        balance=bal;
        info =typ;
        number=numb;
    }


    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
