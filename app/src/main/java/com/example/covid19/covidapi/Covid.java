package com.example.covid19.covidapi;

import android.widget.TextView;

import com.example.covid19.covidapi.bean.Countrie;
import com.example.covid19.covidapi.bean.Global;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Covid {
    public String url_api = "https://coronavirus-19-api.herokuapp.com/";

    public  void getGlobalStatus(final TextView t1, final TextView t2, final TextView t3){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url_api)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        CovidApi covidApi = retrofit.create(CovidApi.class);
        Call<Global> call =covidApi.gatGlobal();
        call.enqueue(new Callback<Global>() {
            @Override
            public void onResponse(Call<Global> call, Response<Global> response) {
                Global global = response.body();

                t1.setText(global.getCases());
                t2.setText(global.getDeaths());
                t3.setText(global.getRecovered());
            }

            @Override
            public void onFailure(Call<Global> call, Throwable throwable) {

            }
        });
    }

    public void getCountrie( final TextView t){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url_api)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        CovidApi covidApi = retrofit.create(CovidApi.class);
        Call<List<Countrie>> call =covidApi.getCountries();
        call.enqueue(new Callback<List<Countrie>>() {
            @Override
            public void onResponse(Call<List<Countrie>> call, Response<List<Countrie>> response) {
                List<Countrie> countries = response.body();
                String test= "";
                for(Countrie c : countries){
                    test = test +c.getCountry()+ "\n";
                }
                t.setText(test);
            }

            @Override
            public void onFailure(Call<List<Countrie>> call, Throwable throwable) {

            }
        });
    }
}
