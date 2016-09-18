package com.inspirussia.nikmc.fintech_tfb.rest;

import com.inspirussia.nikmc.fintech_tfb.rest.model.accounts;
import com.inspirussia.nikmc.fintech_tfb.rest.model.cards;

import org.json.JSONObject;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;

/**
 * Created by NIKMC on 17-Sep-16.
 */
public interface GitHubService  {
    @GET("users/{user}/repos")
    Call<cards> listRepos(@Path("user") String user);

/*
    @GET("/")
    Call<> getCards(@Header("Authorization") String authorization);
*/


}
