package com.inspirussia.nikmc.fintech_tfb.rest.model;

import java.io.Serializable;

/**
 * Created by TheLetch on 18/09/2016.
 */
public interface SpinnerElement extends Serializable{

//    public SpinnerElement(String bal,String typ,String numb){
//        balance=bal;
//        info =typ;
//        number=numb;
//
//    }
    public String getBalance();

    public void setBalance(String balance);

    public String getInfo();

    public void setInfo(String info);

    public String getNumber();

    public void setNumber(String number);



    public String getCurrency();

    public void setCurrency(String currency);


}
