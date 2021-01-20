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
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class FragmentWeatherMain extends Fragment {
    ArrayList<Weather> weathers = new ArrayList<>();
    RecyclerView recyclerView;
    RecyclerDataAdapter adapter;
    public final static String TAG = "com.geekbrains.gbweather.FragmentWeatherMain";
    public final static String KEY = "text";

    public FragmentWeatherMain() {
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        setInitialWeatherList();
        View view = inflater.inflate(R.layout.fragment_weather_main, container, false);
        recyclerView = view.findViewById(R.id.recycler_view_weather);
        adapter = new RecyclerDataAdapter(weathers);
        recyclerView.setAdapter(adapter);

        TextView textView = view.findViewById(R.id.city_field);

        String textFromActivity = getArguments().getString(KEY);
        textView.setText(textFromActivity);
        return view;
    }

    private void setInitialWeatherList() {
        weathers.add(new Weather("MON", "+15", R.drawable.cloudi));
        weathers.add(new Weather("TUES", "+12", R.drawable.cloudi));
        weathers.add(new Weather("WED", "+8", R.drawable.cloudi));
        weathers.add(new Weather("THURS", "+17", R.drawable.cloudi));
    }
}
