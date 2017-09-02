package com.rafaelarnosti.marvelapp.api;

import com.rafaelarnosti.marvelapp.Model.ResponseHeroiMarvel;
import com.rafaelarnosti.marvelapp.Model.Super;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by RAFAELLUIZMAZZINIARN on 25/07/2017.
 */

public interface SuperAPI {

    @GET("/v1/public/characters?offset=0&ts=1&apikey=5cffe289f71f22833f6cf9dc28140a31&hash=3e7881fec0561fa03447beb41815ae64")
    Call<ResponseHeroiMarvel> getSupers();

}
