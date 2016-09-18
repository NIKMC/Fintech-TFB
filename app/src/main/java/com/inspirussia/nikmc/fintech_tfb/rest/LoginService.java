package com.inspirussia.nikmc.fintech_tfb.rest;

import retrofit2.Call;
import retrofit2.http.POST;

/**
 * Created by NIKMC on 18-Sep-16.
 */
public interface LoginService {
    @POST("/login")
    Call<String> basicLogin();
}
