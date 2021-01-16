package com.geekbrains.gbweather;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class SelectCity extends AppCompatActivity {
    String[] cities = {"Moscow", "London", "New-York", "Madrid", "Paris", "Tokyo", "Los-Angeles", "Dubai", "Beijing", "Hon-Kong"};
    static String selectCityKey = "sckey";
    static String keyToMainActivity = "key";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_city);

        Spinner spinner = (Spinner) findViewById(R.id.spinnerSelectCity);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, cities);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
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

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState, @NonNull PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        EditText selectCity = findViewById(R.id.editSelectCity);
        outState.putString(selectCityKey, selectCity.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        String textView = savedInstanceState.getString(selectCityKey);
        EditText restView = findViewById(R.id.editSelectCity);
        restView.setText(textView);
    }

    public void onSendButtonClicked(View view) {
        EditText selectedCity = findViewById(R.id.editSelectCity);
        String text = selectedCity.getText().toString();
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra(keyToMainActivity, text);
        startActivity(intent);
    }
}