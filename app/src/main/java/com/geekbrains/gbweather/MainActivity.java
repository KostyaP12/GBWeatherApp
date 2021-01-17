package com.geekbrains.gbweather;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements OnFragmentSelectCityDataListener {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.fragmentContainer);
        if (fragment == null) {
            fragment = new FragmentSelectCity();
            fm.beginTransaction()
                    .add(R.id.fragmentContainer, fragment, FragmentSelectCity.TAG)
                    .commit();
        }

    }
    @Override
    public void onOpenFragmentWeatherMain(String string) {
        FragmentManager fm = getSupportFragmentManager();

        Fragment fragment = fm.findFragmentById(R.id.fragmentContainer);
        if (fragment instanceof FragmentSelectCity) {
            Fragment fragmentReplace;
            fragmentReplace = new FragmentWeatherMain();

            Bundle bundle = new Bundle();
            bundle.putString(FragmentWeatherMain.KEY, string);
            fragmentReplace.setArguments(bundle);

            fm.beginTransaction()
                    .replace(R.id.fragmentContainer, fragmentReplace, FragmentWeatherMain.TAG)
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .addToBackStack(FragmentWeatherMain.TAG)
                    .commit();
        }
    }
}
