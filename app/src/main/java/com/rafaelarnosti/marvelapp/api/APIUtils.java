package com.rafaelarnosti.marvelapp.api;

/**
 * Created by RAFAELLUIZMAZZINIARN on 25/07/2017.
 */

public class APIUtils {
    public static final String BASE_URL = "http://gateway.marvel.com";

    public static SuperAPI getSuper(){
        return RetrofitClient.getClient("http://gateway.marvel.com").create(SuperAPI.class);
    }

    public static UserAPI getUser(){
        return RetrofitClient.getClient("http://www.mocky.io").create(UserAPI.class);
    }

}
