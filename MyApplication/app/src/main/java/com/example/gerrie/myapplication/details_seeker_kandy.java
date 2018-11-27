package com.example.gerrie.myapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by Gerrie on 11/6/2018.
 */

public class details_seeker_kandy extends AppCompatActivity {

    private Button temple_of_tooth;
    private Button pinnawala;
    private Button kandy_lake;
    private Button hulu;
    private Button knuckles;
    private Button bahirawakanda;
    private Button pera_garden;
    private Button hanthana;
    private Button udawatta_lake;
    private Button ambakke;
    private Button lankathilaka;
    private android.support.v7.widget.Toolbar toolbar;

    private Button Nearby_details_close;

    public static boolean general_state_kandy=false;

    public static String destination_name_around_kandy;
    public static String destination_latitude_around_kandy;
    public static String destination_longitude_around_kandy;
    public static String destination_url_around_kandy;
    public static String destination_description_around_kandy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.details_seeker_layout_kandy);

        temple_of_tooth=(Button) findViewById (R.id.temple_of_tooth);
        pinnawala=(Button) findViewById (R.id.pinnawala);
        kandy_lake=(Button) findViewById (R.id.kandy_lake);
        hulu=(Button) findViewById (R.id.hulu);
        knuckles=(Button) findViewById (R.id.knuckles);
        bahirawakanda=(Button) findViewById (R.id.bahirawakanda);
        pera_garden=(Button) findViewById (R.id.pera_garden);
        hanthana=(Button) findViewById (R.id.hanthana);
        udawatta_lake=(Button) findViewById (R.id.udawatta_lake);
        ambakke=(Button) findViewById (R.id.ambakke);
        lankathilaka=(Button) findViewById (R.id.lankathilaka);

        toolbar = (android.support.v7.widget.Toolbar) findViewById (R.id.toolbar_details_kandy);

        Nearby_details_close=(Button) findViewById (R.id.nearby_details_close_kandy);

        if (!general_state_kandy){
            toolbar.setTitle("Explore nearby travel destinations");
            android.app.AlertDialog.Builder alertDialog_weather = new android.app.AlertDialog.Builder(details_seeker_kandy.this);
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
                                    startActivity(new Intent(details_seeker_kandy.this,weather_lat_lang_Activity_notify_weather.class));
                                }
                            });

            alertDialog_weather.show();
        }else{
            toolbar.setTitle("Explore travel destinations");
        }

        final Destination_arguments destination_arguments_facts = new Destination_arguments();

        pinnawala.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] destination_arguments_local;

                destination_arguments_local= destination_arguments_facts.destination_arguments("pinnawala");
                destination_name_around_kandy = destination_arguments_local[0];
                destination_latitude_around_kandy = destination_arguments_local[1];
                destination_longitude_around_kandy = destination_arguments_local[2];
                destination_url_around_kandy = destination_arguments_local[3];
                destination_description_around_kandy = destination_arguments_local[4];

                startActivity(new Intent(details_seeker_kandy.this,Details_of_places_kandy.class));
            }
        });

        temple_of_tooth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] destination_arguments_local;

                destination_arguments_local= destination_arguments_facts.destination_arguments("temple_of_tooth");
                destination_name_around_kandy = destination_arguments_local[0];
                destination_latitude_around_kandy = destination_arguments_local[1];
                destination_longitude_around_kandy = destination_arguments_local[2];
                destination_url_around_kandy = destination_arguments_local[3];
                destination_description_around_kandy = destination_arguments_local[4];

                startActivity(new Intent(details_seeker_kandy.this,Details_of_places_kandy.class));
            }
        });

        kandy_lake.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] destination_arguments_local;

                destination_arguments_local= destination_arguments_facts.destination_arguments("kandy_lake");
                destination_name_around_kandy = destination_arguments_local[0];
                destination_latitude_around_kandy = destination_arguments_local[1];
                destination_longitude_around_kandy = destination_arguments_local[2];
                destination_url_around_kandy = destination_arguments_local[3];
                destination_description_around_kandy = destination_arguments_local[4];

                startActivity(new Intent(details_seeker_kandy.this,Details_of_places_kandy.class));
            }
        });

        hulu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] destination_arguments_local;

                destination_arguments_local= destination_arguments_facts.destination_arguments("hulu");
                destination_name_around_kandy = destination_arguments_local[0];
                destination_latitude_around_kandy = destination_arguments_local[1];
                destination_longitude_around_kandy = destination_arguments_local[2];
                destination_url_around_kandy = destination_arguments_local[3];
                destination_description_around_kandy = destination_arguments_local[4];

                startActivity(new Intent(details_seeker_kandy.this,Details_of_places_kandy.class));
            }
        });

        knuckles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] destination_arguments_local;

                destination_arguments_local= destination_arguments_facts.destination_arguments("knuckles");
                destination_name_around_kandy = destination_arguments_local[0];
                destination_latitude_around_kandy = destination_arguments_local[1];
                destination_longitude_around_kandy = destination_arguments_local[2];
                destination_url_around_kandy = destination_arguments_local[3];
                destination_description_around_kandy = destination_arguments_local[4];

                startActivity(new Intent(details_seeker_kandy.this,Details_of_places_kandy.class));
            }
        });

        bahirawakanda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] destination_arguments_local;

                destination_arguments_local= destination_arguments_facts.destination_arguments("bahirawakanda");
                destination_name_around_kandy = destination_arguments_local[0];
                destination_latitude_around_kandy = destination_arguments_local[1];
                destination_longitude_around_kandy = destination_arguments_local[2];
                destination_url_around_kandy = destination_arguments_local[3];
                destination_description_around_kandy = destination_arguments_local[4];

                startActivity(new Intent(details_seeker_kandy.this,Details_of_places_kandy.class));
            }
        });

        pera_garden.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] destination_arguments_local;

                destination_arguments_local= destination_arguments_facts.destination_arguments("pera_garden");
                destination_name_around_kandy = destination_arguments_local[0];
                destination_latitude_around_kandy = destination_arguments_local[1];
                destination_longitude_around_kandy = destination_arguments_local[2];
                destination_url_around_kandy = destination_arguments_local[3];
                destination_description_around_kandy = destination_arguments_local[4];

                startActivity(new Intent(details_seeker_kandy.this,Details_of_places_kandy.class));
            }
        });

        hanthana.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] destination_arguments_local;

                destination_arguments_local= destination_arguments_facts.destination_arguments("hanthana");
                destination_name_around_kandy = destination_arguments_local[0];
                destination_latitude_around_kandy = destination_arguments_local[1];
                destination_longitude_around_kandy = destination_arguments_local[2];
                destination_url_around_kandy = destination_arguments_local[3];
                destination_description_around_kandy = destination_arguments_local[4];

                startActivity(new Intent(details_seeker_kandy.this,Details_of_places_kandy.class));
            }
        });

        udawatta_lake.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] destination_arguments_local;

                destination_arguments_local= destination_arguments_facts.destination_arguments("udawatta_lake");
                destination_name_around_kandy = destination_arguments_local[0];
                destination_latitude_around_kandy = destination_arguments_local[1];
                destination_longitude_around_kandy = destination_arguments_local[2];
                destination_url_around_kandy = destination_arguments_local[3];
                destination_description_around_kandy = destination_arguments_local[4];

                startActivity(new Intent(details_seeker_kandy.this,Details_of_places_kandy.class));
            }
        });

        ambakke.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] destination_arguments_local;

                destination_arguments_local= destination_arguments_facts.destination_arguments("ambakke");
                destination_name_around_kandy = destination_arguments_local[0];
                destination_latitude_around_kandy = destination_arguments_local[1];
                destination_longitude_around_kandy = destination_arguments_local[2];
                destination_url_around_kandy = destination_arguments_local[3];
                destination_description_around_kandy = destination_arguments_local[4];

                startActivity(new Intent(details_seeker_kandy.this,Details_of_places_kandy.class));
            }
        });

        lankathilaka.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] destination_arguments_local;

                destination_arguments_local= destination_arguments_facts.destination_arguments("lankathilaka");
                destination_name_around_kandy = destination_arguments_local[0];
                destination_latitude_around_kandy = destination_arguments_local[1];
                destination_longitude_around_kandy = destination_arguments_local[2];
                destination_url_around_kandy = destination_arguments_local[3];
                destination_description_around_kandy = destination_arguments_local[4];

                startActivity(new Intent(details_seeker_kandy.this,Details_of_places_kandy.class));
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
