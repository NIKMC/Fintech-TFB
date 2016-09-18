package com.inspirussia.nikmc.fintech_tfb.rest;

import retrofit2.Retrofit;



/**
 * Created by NIKMC on 17-Sep-16.
 */
public class CreateRestAdapter {

    private static final String SERVER = "";

    public static GitHubService getRestAdapterWithoutToken() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://40.85.141.154:8083/rest/personal/product/")
                .build();

        GitHubService service = retrofit.create(GitHubService.class);
        return service;
    }




}
