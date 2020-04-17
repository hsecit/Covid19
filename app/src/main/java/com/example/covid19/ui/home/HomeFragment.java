package com.example.covid19.ui.home;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.covid19.R;
import com.example.covid19.covidapi.Covid;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        final TextView textView = root.findViewById(R.id.text_home);
        final TextView cases = root.findViewById(R.id.num_cases);
        final TextView death= root.findViewById(R.id.num_death);
        final TextView recovered = root.findViewById(R.id.num_recovred);
        final ImageView imageView = root.findViewById(R.id.image_src);
        Button go_site = root.findViewById(R.id.go_site);

        imageView.setImageResource(R.drawable.docotor_advice);

        Covid covid = new Covid();
        covid.getGlobalStatus(cases,death,recovered);


        go_site.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url_sante = "https://www.sante.gov.ma/";
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url_sante));
                startActivity(intent);

            }
        });

        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}
