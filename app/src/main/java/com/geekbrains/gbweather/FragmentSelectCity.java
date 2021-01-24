package com.geekbrains.gbweather;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentSelectCity extends Fragment {
    String[] cities = {"Moscow", "London", "New-York", "Madrid", "Paris", "Tokyo", "Los-Angeles", "Dubai", "Beijing", "Hon-Kong"};
    public final static String TAG = "com.geekbrains.gbweather.FragmentSelectCity";
    private OnFragmentSelectCityDataListener mListener;
    EditText editText;
    Button button;
    CheckBox checkBoxSpeedWing;
    CheckBox checkBoxHumidity;
    CheckBox checkBoxPressure;
    public FragmentSelectCity(){
    }



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_select_city, container, false);
        editText = view.findViewById(R.id.editSelectCity);
        button = view.findViewById(R.id.sendBtn);
        checkBoxSpeedWing = view.findViewById(R.id.cbWindSpeed);

        button.setOnClickListener(v -> {
            String s = editText.getText().toString();
            mListener.onOpenFragmentWeatherMain(s);

        });
        setRetainInstance(true);
        return view;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if(context instanceof OnFragmentSelectCityDataListener){
            mListener = (OnFragmentSelectCityDataListener) context;
        }else {
            throw new RuntimeException(context.toString());
        }
    }
}