package com.inspirussia.nikmc.fintech_tfb.rest;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by NIKMC on 18-Sep-16.
 */
public interface RetrofitClient {
    @GET("rest/personal/product")
    Call<ResponseBody> getAccounts();
}
