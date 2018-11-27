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

public class plans_jaffna extends AppCompatActivity {

    private Button Close_all_cities;
    private Button day1_jaffna;
    private Button day2_jaffna;
    private Button day3_jaffna;
    private android.support.v7.widget.Toolbar toolbar;

    public static boolean general_plan_jaffna=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.plan_days_jaffna);

        Close_all_cities = (Button) findViewById(R.id.close_all_cities);
        day1_jaffna = (Button) findViewById(R.id.day1_jaffna);
        day2_jaffna = (Button) findViewById(R.id.day2_jaffna);
        day3_jaffna = (Button) findViewById(R.id.day3_jaffna);
        toolbar = (android.support.v7.widget.Toolbar) findViewById (R.id.toolbar_plan_jaffna);

        Close_all_cities.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        day1_jaffna.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(plans_jaffna.this,jaffna_plan_1.class));
            }
        });

        day2_jaffna.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(plans_jaffna.this,jaffna_plan_2.class));
            }
        });

        day3_jaffna.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(plans_jaffna.this,jaffna_plan_3.class));
            }
        });

        if (!general_plan_jaffna){
            toolbar.setTitle("Traveling plans for nearby nodes");
            android.app.AlertDialog.Builder alertDialog_weather = new android.app.AlertDialog.Builder(plans_jaffna.this);
            alertDialog_weather.setTitle("Notify weather");
            alertDialog_weather.setMessage("Please see about the weather at Jaffna if you really wish to travel that area")
                    .setPositiveButton("No",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.cancel();
                                }
                            })

                    .setNegativeButton("Good idea",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    weather_lat_lang_Activity_notify_weather.latitude=9.661302;
                                    weather_lat_lang_Activity_notify_weather.longitude=80.025513;
                                    startActivity(new Intent(plans_jaffna.this,weather_lat_lang_Activity_notify_weather.class));
                                }
                            });

            alertDialog_weather.show();
        }else{
            toolbar.setTitle("Traveling plans");
        }
    }
}
