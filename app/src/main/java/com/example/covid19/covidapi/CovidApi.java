package com.example.covid19.covidapi;

import com.example.covid19.covidapi.bean.Countrie;
import com.example.covid19.covidapi.bean.Global;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface CovidApi {

    @GET("all")
    Call<Global> gatGlobal();

    @GET("countries")
    Call<List<Countrie>> getCountries();

    @GET("countries/{id}")
    Call<Countrie> getCountry(@Path("id") String counrty);

}
