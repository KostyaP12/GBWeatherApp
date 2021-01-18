package com.geekbrains.gbweather;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class FragmentWeatherMain extends Fragment {

    public final static String TAG = "com.geekbrains.gbweather.FragmentWeatherMain";
    public final static String KEY = "text";

    public FragmentWeatherMain() {
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_weather_main, container, false);
        TextView textView = view.findViewById(R.id.city_field);

        Button button = view.findViewById(R.id.btnSelectCity);
        button.setOnClickListener(v -> {

        });

        assert getArguments() != null;

        String textFromActivity = getArguments().getString(KEY);
        textView.setText(textFromActivity);

        return view;
    }
}
