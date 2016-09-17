//package com.inspirussia.nikmc.fintech_tfb.rest;
//
///**
// * Created by NIKMC on 17-Sep-16.
// */
//public class CreateRestAdapter {
//
//    private static final String SERVER = "";
//
//    public static IRetrofitRestAPI getRestAdapterWithoutToken() {
//        RestAdapter restAdapter = new RestAdapter.Builder()
//                .setEndpoint(SERVER)
//                .build();
//        final IRetrofitRestAPI adapter = restAdapter.create(IRetrofitRestAPI.class);
//        return adapter;
//    }
//
//    public static IRetrofitRestAPI getRestAdapterWithToken(final String Token) {
//        RequestInterceptor requestInterceptor = new RequestInterceptor() {
//            @Override
//            public void intercept(RequestFacade request) {
//                request.addHeader("", "");
//            }
//        };
//
//        RestAdapter restAdapter = new RestAdapter.Builder()
//                .setEndpoint(SERVER)
//                .setRequestInterceptor(requestInterceptor)
//
//                .build();
//        final IRetrofitRestAPI adapter = restAdapter.create(IRetrofitRestAPI.class);
//        return adapter;
//    }
//
//
//}
