package com.example.covid19.ui.notifications;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.covid19.R;
import com.example.covid19.covidapi.CovidApi;
import com.example.covid19.covidapi.bean.Countrie;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NotificationsFragment extends Fragment {

    private NotificationsViewModel notificationsViewModel;
    public String url_api = "https://coronavirus-19-api.herokuapp.com/";
    public TextView search;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        notificationsViewModel =
                ViewModelProviders.of(this).get(NotificationsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_notifications, container, false);
         search = root.findViewById(R.id.searchView);

        Button sBtn = root.findViewById(R.id.search_btn);

        final TextView country =root.findViewById(R.id.county);
        final TextView cases=root.findViewById(R.id.info_cases1);
        final TextView death = root.findViewById(R.id.info_death1);
        final TextView recover_critical = root.findViewById(R.id.info_critical1);


        sBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(url_api)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                CovidApi covidApi = retrofit.create(CovidApi.class);
                Call<Countrie> call =covidApi.getCountry(search.getText().toString());

                call.enqueue(new Callback<Countrie>() {
                    @Override
                    public void onResponse(Call<Countrie> call, Response<Countrie> response) {

                        Countrie c  = response.body();
                        country.setText(c.getCountry());
                        cases.setText("Cases : "+c.getCases() + " | Today : "+c.getTodayCases());
                        death.setText("Death : "+ c.getDeath() + " | Today "+ c.getTodayDeaths() );
                        recover_critical.setText("Recovered : " +c.getRecovered()+ " | Critical : "+ c.getCritical());

                    }

                    @Override
                    public void onFailure(Call<Countrie> call, Throwable throwable) {

                    }
                });
            }
        });


        notificationsViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
               // textView.setText(s);
            }
        });
        return root;
    }
}
