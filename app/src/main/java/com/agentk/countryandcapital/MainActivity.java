package com.agentk.countryandcapital;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.agentk.countryandcapital.Model.Country;

import static com.agentk.countryandcapital.CountryActivity.Countries;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       Country c= Countries.get(0);

    }
}
