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

public class plans_kandy extends AppCompatActivity {

    private Button Close_all_cities;
    private Button day1_kandy;
    private Button day2_kandy;
    private Button day3_kandy;
    private Button day4_kandy;
    private android.support.v7.widget.Toolbar toolbar;

    public static boolean general_plan_kandy=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.plan_days_kandy);

        Close_all_cities = (Button) findViewById(R.id.close_all_cities);
        day1_kandy = (Button) findViewById(R.id.day1_Kandy);
        day2_kandy = (Button) findViewById(R.id.day2_Kandy);
        day3_kandy = (Button) findViewById(R.id.day3_Kandy);
        day4_kandy = (Button) findViewById(R.id.day4_Kandy);
        toolbar = (android.support.v7.widget.Toolbar) findViewById (R.id.toolbar_plan_kandy);

        Close_all_cities.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        day1_kandy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(plans_kandy.this,kandy_plan_1.class));
            }
        });

        day2_kandy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(plans_kandy.this,kandy_plan_2.class));
            }
        });

        day3_kandy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(plans_kandy.this,kandy_plan_3.class));
            }
        });

        day4_kandy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(plans_kandy.this,kandy_plan_4.class));
            }
        });

        if (!general_plan_kandy){
            toolbar.setTitle("Traveling plans for nearby nodes");
            android.app.AlertDialog.Builder alertDialog_weather = new android.app.AlertDialog.Builder(plans_kandy.this);
            alertDialog_weather.setTitle("Notify weather");
            alertDialog_weather.setMessage("Please see about the weather at Kandy if you really wish to travel that area")
                    .setPositiveButton("No",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.cancel();
                                }
                            })

                    .setNegativeButton("Good idea",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    weather_lat_lang_Activity_notify_weather.latitude=7.293146;
                                    weather_lat_lang_Activity_notify_weather.longitude=80.635009;
                                    startActivity(new Intent(plans_kandy.this,weather_lat_lang_Activity_notify_weather.class));
                                }
                            });

            alertDialog_weather.show();
        }else{
            toolbar.setTitle("Traveling plans");
        }

    }
}
