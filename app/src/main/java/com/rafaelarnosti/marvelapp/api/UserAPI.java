package com.rafaelarnosti.marvelapp.api;

import com.rafaelarnosti.marvelapp.Model.ResponseHeroiMarvel;
import com.rafaelarnosti.marvelapp.Model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by rafae on 27/08/2017.
 */

public interface UserAPI {

    @GET("/v2/58b9b1740f0000b614f09d2f")
    Call<User> getUser();
}
