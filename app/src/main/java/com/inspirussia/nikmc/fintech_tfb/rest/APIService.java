package com.inspirussia.nikmc.fintech_tfb.rest;

import android.util.Base64;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by NIKMC on 18-Sep-16.
 */
public class APIService {
    private static APIService instance;

    public static APIService getInstance() {
        if (instance != null) {
            return instance;
        } else {
            instance = new APIService();
            return instance;
        }
    }


    public static final String API_BASE_URL = "http://40.85.141.154:8083/";

    private static OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

    private static Retrofit.Builder builder =
            new Retrofit.Builder()
                    .baseUrl(API_BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create());

    public static <S> S createService(Class<S> serviceClass) {
        return createService(serviceClass, null, null);
    }

    public static <S> S createService(Class<S> serviceClass, String username, String password) {
        if (username != null && password != null) {
            String credentials = username + ":" + password;
            final String basic =
                    "Basic " + Base64.encodeToString(credentials.getBytes(), Base64.NO_WRAP);

            httpClient.addInterceptor(new Interceptor() {
                @Override
                public Response intercept(Interceptor.Chain chain) throws IOException {
                    Request original = chain.request();

                    Request.Builder requestBuilder = original.newBuilder()
                            .header("Authorization", basic)
                            .header("Accept", "application/json")
                            .method(original.method(), original.body());

                    Request request = requestBuilder.build();
                    return chain.proceed(request);
                }
            });
        }

        OkHttpClient client = httpClient.build();
        Retrofit retrofit = builder.client(client).build();
        return retrofit.create(serviceClass);
    }




    public JSONObject getJson(retrofit2.Response<ResponseBody> response) throws JSONException, IOException,NullPointerException {
        JSONObject jsonObject;
        try {
            // JSONObject jsonObject;
            String body;
            if(response.isSuccessful()){
                body = response.body().string();
            }else{
                body = response.errorBody().string();
            }
            jsonObject = new JSONObject(body);
            return jsonObject;
        }catch (NullPointerException e){
            e.printStackTrace();
            jsonObject = new JSONObject();
            return jsonObject;
        }

    }
}
