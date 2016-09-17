package com.inspirussia.nikmc.fintech_tfb.rest;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by NIKMC on 17-Sep-16.
 */
public interface GitHubService  {
    @GET("users/{user}/repos")
    Call<List<String>> listRepos(@Path("user") String user);
}
