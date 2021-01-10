package com.geekbrains.gbweather;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class SelectCity extends AppCompatActivity {
    String[] cities = {"Moscow", "London", "New-York", "Madrid", "Paris", "Tokyo", "Los-Angeles", "Dubai", "Beijing", "Hon-Kong"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_city);

        Spinner spinner = (Spinner) findViewById(R.id.spinnerSelectCity);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, cities);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        CheckBox windSpeed = (CheckBox) findViewById(R.id.cbWindSpeed);
        CheckBox pressure = (CheckBox) findViewById(R.id.cbPressure);
        CheckBox humidity = (CheckBox) findViewById(R.id.cbHumidity);
        windSpeed.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

            }
        });
        pressure.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

            }
        });
        humidity.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            }
        });
    }

    @SuppressLint("NonConstantResourceId")
    public void onCheckboxClicked(View view) {
        CheckBox checkBox = (CheckBox) view;
        boolean checked = checkBox.isChecked();
        switch (view.getId()) {
            case R.id.cbWindSpeed:
                if (checked)
                    Toast.makeText(this, "WindSpeed checked", Toast.LENGTH_LONG).show();
                break;
            case R.id.cbPressure:
                if (checked)
                    Toast.makeText(this, "Pressure checked", Toast.LENGTH_LONG).show();
                break;
            case R.id.cbHumidity:
                if (checked)
                    Toast.makeText(this, "Humidity checked", Toast.LENGTH_LONG).show();
                break;
        }
    }
}