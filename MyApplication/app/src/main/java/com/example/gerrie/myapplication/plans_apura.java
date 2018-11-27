package com.example.gerrie.myapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by Gerrie on 11/18/2018.
 */

public class plans_apura extends AppCompatActivity {

    private Button Close_all_cities;
    private Button Day1_Anuradhapura;
    private Button Day2_Anuradhapura;
    private android.support.v7.widget.Toolbar toolbar;

    public static boolean general_plan_apura=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.plan_days_apura);

        Close_all_cities = (Button) findViewById(R.id.close_all_cities);
        toolbar = (android.support.v7.widget.Toolbar) findViewById (R.id.toolbar_plan_apura);
        Day1_Anuradhapura=(Button) findViewById(R.id.day1_Anuradhapura);
        Day2_Anuradhapura=(Button) findViewById(R.id.day2_Anuradhapura);

        Close_all_cities.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        Day1_Anuradhapura.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(plans_apura.this,apura_plan_1.class));
            }
        });

        Day2_Anuradhapura.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(plans_apura.this,apura_plan_2.class));
            }
        });

        if (!general_plan_apura){
            toolbar.setTitle("Traveling plans for nearby nodes");
            android.app.AlertDialog.Builder alertDialog_weather = new android.app.AlertDialog.Builder(plans_apura.this);
            alertDialog_weather.setTitle("Notify weather");
            alertDialog_weather.setMessage("Please see about the weather at Anuradhapura if you really wish to travel that area")
                    .setPositiveButton("No",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.cancel();
                                }
                            })

                    .setNegativeButton("Good idea",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    weather_lat_lang_Activity_notify_weather.latitude=8.322950;
                                    weather_lat_lang_Activity_notify_weather.longitude=80.402722;
                                    startActivity(new Intent(plans_apura.this,weather_lat_lang_Activity_notify_weather.class));
                                }
                            });

            alertDialog_weather.show();
        }else{
            toolbar.setTitle("Traveling plans");
        }

    }
}
