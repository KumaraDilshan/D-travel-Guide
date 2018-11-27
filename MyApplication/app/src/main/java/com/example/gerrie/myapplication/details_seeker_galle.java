package com.example.gerrie.myapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.maps.model.Marker;

import java.util.Locale;

/**
 * Created by Gerrie on 11/6/2018.
 */

public class details_seeker_galle extends AppCompatActivity {

    private Button unawatuna;
    private Button gungle_beach;
    private Button hikkaduwa;
    private Button kaneliya;
    private Button mirissa;
    private Button galle_lighthouse;
    private Button galle_fort;
    private Button dutch_church;
    private android.support.v7.widget.Toolbar toolbar;

    private Button Nearby_details_close;

    public static boolean general_state_galle=false;

    public static String destination_name_around_galle;
    public static String destination_latitude_around_galle;
    public static String destination_longitude_around_galle;
    public static String destination_url_around_galle;
    public static String destination_description_around_galle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.details_seeker_layout_galle);

        unawatuna=(Button) findViewById (R.id.unawatuna);
        gungle_beach=(Button) findViewById (R.id.gungle_beach);
        hikkaduwa=(Button) findViewById (R.id.hikkaduwa);
        kaneliya=(Button) findViewById (R.id.kaneliya);
        mirissa=(Button) findViewById (R.id.mirissa);
        galle_lighthouse=(Button) findViewById (R.id.galle_lighthouse);
        galle_fort=(Button) findViewById (R.id.galle_fort);
        dutch_church=(Button) findViewById (R.id.dutch_church);

        toolbar = (android.support.v7.widget.Toolbar) findViewById (R.id.toolbar_details_galle);

        Nearby_details_close=(Button) findViewById (R.id.nearby_details_close_galle);

        if (!general_state_galle){
            toolbar.setTitle("Explore nearby travel destinations");
            android.app.AlertDialog.Builder alertDialog_weather = new android.app.AlertDialog.Builder(details_seeker_galle.this);
            alertDialog_weather.setTitle("Notify weather");
            alertDialog_weather.setMessage("Please see about the weather at Galle if you really wish to travel that area.")
                    .setPositiveButton("No",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.cancel();
                                }
                            })

                    .setNegativeButton("Good idea",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    weather_lat_lang_Activity_notify_weather.latitude=6.032861;
                                    weather_lat_lang_Activity_notify_weather.longitude=80.214905;
                                    startActivity(new Intent(details_seeker_galle.this,weather_lat_lang_Activity_notify_weather.class));
                                }
                            });

            alertDialog_weather.show();
        }else{
            toolbar.setTitle("Explore travel destinations");
        }

        final Destination_arguments destination_arguments_facts = new Destination_arguments();

        unawatuna.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] destination_arguments_local;

                destination_arguments_local= destination_arguments_facts.destination_arguments("unawatuna");

                destination_name_around_galle = destination_arguments_local[0];
                destination_latitude_around_galle = destination_arguments_local[1];
                destination_longitude_around_galle = destination_arguments_local[2];
                destination_url_around_galle = destination_arguments_local[3];
                destination_description_around_galle = destination_arguments_local[4];

                startActivity(new Intent(details_seeker_galle.this,Details_of_places_galle.class));
            }
        });

        gungle_beach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] destination_arguments_local;

                destination_arguments_local= destination_arguments_facts.destination_arguments("gungle_beach");

                destination_name_around_galle = destination_arguments_local[0];
                destination_latitude_around_galle = destination_arguments_local[1];
                destination_longitude_around_galle = destination_arguments_local[2];
                destination_url_around_galle = destination_arguments_local[3];
                destination_description_around_galle = destination_arguments_local[4];

                startActivity(new Intent(details_seeker_galle.this,Details_of_places_galle.class));
            }
        });

        hikkaduwa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] destination_arguments_local;

                destination_arguments_local= destination_arguments_facts.destination_arguments("hikkaduwa");

                destination_name_around_galle = destination_arguments_local[0];
                destination_latitude_around_galle = destination_arguments_local[1];
                destination_longitude_around_galle = destination_arguments_local[2];
                destination_url_around_galle = destination_arguments_local[3];
                destination_description_around_galle = destination_arguments_local[4];

                startActivity(new Intent(details_seeker_galle.this,Details_of_places_galle.class));
            }
        });

        kaneliya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] destination_arguments_local;

                destination_arguments_local= destination_arguments_facts.destination_arguments("kaneliya");

                destination_name_around_galle = destination_arguments_local[0];
                destination_latitude_around_galle = destination_arguments_local[1];
                destination_longitude_around_galle = destination_arguments_local[2];
                destination_url_around_galle = destination_arguments_local[3];
                destination_description_around_galle = destination_arguments_local[4];

                startActivity(new Intent(details_seeker_galle.this,Details_of_places_galle.class));
            }
        });

        mirissa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] destination_arguments_local;

                destination_arguments_local= destination_arguments_facts.destination_arguments("mirissa");

                destination_name_around_galle = destination_arguments_local[0];
                destination_latitude_around_galle = destination_arguments_local[1];
                destination_longitude_around_galle = destination_arguments_local[2];
                destination_url_around_galle = destination_arguments_local[3];
                destination_description_around_galle = destination_arguments_local[4];

                startActivity(new Intent(details_seeker_galle.this,Details_of_places_galle.class));
            }
        });

        galle_lighthouse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] destination_arguments_local;

                destination_arguments_local= destination_arguments_facts.destination_arguments("galle_lighthouse");

                destination_name_around_galle = destination_arguments_local[0];
                destination_latitude_around_galle = destination_arguments_local[1];
                destination_longitude_around_galle = destination_arguments_local[2];
                destination_url_around_galle = destination_arguments_local[3];
                destination_description_around_galle = destination_arguments_local[4];

                startActivity(new Intent(details_seeker_galle.this,Details_of_places_galle.class));
            }
        });

        galle_fort.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] destination_arguments_local;

                destination_arguments_local= destination_arguments_facts.destination_arguments("galle_fort");

                destination_name_around_galle = destination_arguments_local[0];
                destination_latitude_around_galle = destination_arguments_local[1];
                destination_longitude_around_galle = destination_arguments_local[2];
                destination_url_around_galle = destination_arguments_local[3];
                destination_description_around_galle = destination_arguments_local[4];

                startActivity(new Intent(details_seeker_galle.this,Details_of_places_galle.class));
            }
        });

        dutch_church.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] destination_arguments_local;

                destination_arguments_local= destination_arguments_facts.destination_arguments("dutch_church");

                destination_name_around_galle = destination_arguments_local[0];
                destination_latitude_around_galle = destination_arguments_local[1];
                destination_longitude_around_galle = destination_arguments_local[2];
                destination_url_around_galle = destination_arguments_local[3];
                destination_description_around_galle = destination_arguments_local[4];

                startActivity(new Intent(details_seeker_galle.this,Details_of_places_galle.class));
            }
        });

        Nearby_details_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
