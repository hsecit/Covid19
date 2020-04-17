package com.example.covid19.ui.dashboard;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.covid19.R;
import com.example.covid19.covidapi.bean.Countrie;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    Context context;
    List<Countrie> countries;
    int list_size =8;
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_country, parent, false);
        return new MyViewHolder(v);

    }

    public MyAdapter(Context ct, List<Countrie> countries){
        this.context = ct;
        this.countries = countries;
        //this.list_size =new Covid().getList_size();
    }
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
            holder.afficher(countries.get(position));
            Log.d("hamza",countries.get(position).toString());
    }

    @Override
    public int getItemCount() {
        return countries.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView country, cases , death, recover_critical ;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            country = itemView.findViewById(R.id.county1);
           cases=itemView.findViewById(R.id.info_cases1);
           death = itemView.findViewById(R.id.info_death1);
           recover_critical = itemView.findViewById(R.id.info_critical1);


        }

        void afficher(Countrie c){

            country.setText(c.getCountry());
            cases.setText("Cases : "+c.getCases() + " | Today : "+c.getTodayCases());
            death.setText("Death : "+ c.getDeath() + " | Today "+ c.getTodayDeaths() );
            recover_critical.setText("Recovered : " +c.getRecovered()+ " | Critical : "+ c.getCritical());
        }
    }
}
