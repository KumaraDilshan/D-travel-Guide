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

public class details_seeker_jaffna extends AppCompatActivity {

    private Button nagadeepa;
    private Button nallur;
    private Button kadurugoda;
    private Button dambakolapatuna;
    private Button nilavaraiWell;
    private Button kasurinabeach;
    private Button fortjaffna;
    private Button kks;
    private Button kyts;
    private Button delphtIsland;
    private Button publiclibrary;
    private Button elephatpassmemorial;
    private Button pointpadro;
    private Button Keeramalei;
    private android.support.v7.widget.Toolbar toolbar;

    private Button Nearby_details_close;

    public static boolean general_state_jaffna=false;

    public static String destination_name_around_jaffna;
    public static String destination_latitude_around_jaffna;
    public static String destination_longitude_around_jaffna;
    public static String destination_url_around_jaffna;
    public static String destination_description_around_jaffna;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.details_seeker_layout_jaffna);

        nagadeepa=(Button) findViewById (R.id.nagadeepa);
        nallur=(Button) findViewById (R.id.nallur);
        kadurugoda=(Button) findViewById (R.id.kadurugoda);
        dambakolapatuna=(Button) findViewById (R.id.dambakolapatuna);
        nilavaraiWell=(Button) findViewById (R.id.nilavaraiWell);
        kasurinabeach=(Button) findViewById (R.id.kasurinabeach);
        fortjaffna=(Button) findViewById (R.id.fortjaffna);
        kks=(Button) findViewById (R.id.kks);
        kyts=(Button) findViewById (R.id.kyts);
        delphtIsland=(Button) findViewById (R.id.delphtIsland);
        publiclibrary=(Button) findViewById (R.id.publiclibrary);
        elephatpassmemorial=(Button) findViewById (R.id.elephatpassmemorial);
        pointpadro=(Button) findViewById (R.id.pointpadro);
        Keeramalei=(Button) findViewById (R.id.keeramalei);

        toolbar = (android.support.v7.widget.Toolbar) findViewById (R.id.toolbar_details_jaffna);

        Nearby_details_close=(Button) findViewById (R.id.nearby_details_close_jaffna);

        if (!general_state_jaffna){
            toolbar.setTitle("Explore nearby travel destinations");
            android.app.AlertDialog.Builder alertDialog_weather = new android.app.AlertDialog.Builder(details_seeker_jaffna.this);
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
                                    startActivity(new Intent(details_seeker_jaffna.this,weather_lat_lang_Activity_notify_weather.class));
                                }
                            });

            alertDialog_weather.show();
        }else{
            toolbar.setTitle("Explore travel destinations");
        }

        final Destination_arguments destination_arguments_facts = new Destination_arguments();

        nagadeepa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] destination_arguments_local;

                destination_arguments_local= destination_arguments_facts.destination_arguments("nagadeepaya");
                destination_name_around_jaffna = destination_arguments_local[0];
                destination_latitude_around_jaffna = destination_arguments_local[1];
                destination_longitude_around_jaffna = destination_arguments_local[2];
                destination_url_around_jaffna = destination_arguments_local[3];
                destination_description_around_jaffna = destination_arguments_local[4];

                startActivity(new Intent(details_seeker_jaffna.this,Details_of_places_jaffna.class));
            }
        });

        nallur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] destination_arguments_local;

                destination_arguments_local= destination_arguments_facts.destination_arguments("nallur");
                destination_name_around_jaffna = destination_arguments_local[0];
                destination_latitude_around_jaffna = destination_arguments_local[1];
                destination_longitude_around_jaffna = destination_arguments_local[2];
                destination_url_around_jaffna = destination_arguments_local[3];
                destination_description_around_jaffna = destination_arguments_local[4];

                startActivity(new Intent(details_seeker_jaffna.this,Details_of_places_jaffna.class));
            }
        });

        kadurugoda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] destination_arguments_local;

                destination_arguments_local= destination_arguments_facts.destination_arguments("kadurugoda");
                destination_name_around_jaffna = destination_arguments_local[0];
                destination_latitude_around_jaffna = destination_arguments_local[1];
                destination_longitude_around_jaffna = destination_arguments_local[2];
                destination_url_around_jaffna = destination_arguments_local[3];
                destination_description_around_jaffna = destination_arguments_local[4];

                startActivity(new Intent(details_seeker_jaffna.this,Details_of_places_jaffna.class));
            }
        });

        dambakolapatuna.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] destination_arguments_local;

                destination_arguments_local= destination_arguments_facts.destination_arguments("dambakolapatuna");
                destination_name_around_jaffna = destination_arguments_local[0];
                destination_latitude_around_jaffna = destination_arguments_local[1];
                destination_longitude_around_jaffna = destination_arguments_local[2];
                destination_url_around_jaffna = destination_arguments_local[3];
                destination_description_around_jaffna = destination_arguments_local[4];

                startActivity(new Intent(details_seeker_jaffna.this,Details_of_places_jaffna.class));
            }
        });

        nilavaraiWell.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] destination_arguments_local;

                destination_arguments_local= destination_arguments_facts.destination_arguments("nilavarai");
                destination_name_around_jaffna = destination_arguments_local[0];
                destination_latitude_around_jaffna = destination_arguments_local[1];
                destination_longitude_around_jaffna = destination_arguments_local[2];
                destination_url_around_jaffna = destination_arguments_local[3];
                destination_description_around_jaffna = destination_arguments_local[4];

                startActivity(new Intent(details_seeker_jaffna.this,Details_of_places_jaffna.class));
            }
        });

        kasurinabeach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] destination_arguments_local;

                destination_arguments_local= destination_arguments_facts.destination_arguments("casurina");
                destination_name_around_jaffna = destination_arguments_local[0];
                destination_latitude_around_jaffna = destination_arguments_local[1];
                destination_longitude_around_jaffna = destination_arguments_local[2];
                destination_url_around_jaffna = destination_arguments_local[3];
                destination_description_around_jaffna = destination_arguments_local[4];

                startActivity(new Intent(details_seeker_jaffna.this,Details_of_places_jaffna.class));
            }
        });

        fortjaffna.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] destination_arguments_local;

                destination_arguments_local= destination_arguments_facts.destination_arguments("fortjaffna");
                destination_name_around_jaffna = destination_arguments_local[0];
                destination_latitude_around_jaffna = destination_arguments_local[1];
                destination_longitude_around_jaffna = destination_arguments_local[2];
                destination_url_around_jaffna = destination_arguments_local[3];
                destination_description_around_jaffna = destination_arguments_local[4];

                startActivity(new Intent(details_seeker_jaffna.this,Details_of_places_jaffna.class));
            }
        });

        kks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] destination_arguments_local;

                destination_arguments_local= destination_arguments_facts.destination_arguments("kks");
                destination_name_around_jaffna = destination_arguments_local[0];
                destination_latitude_around_jaffna = destination_arguments_local[1];
                destination_longitude_around_jaffna = destination_arguments_local[2];
                destination_url_around_jaffna = destination_arguments_local[3];
                destination_description_around_jaffna = destination_arguments_local[4];

                startActivity(new Intent(details_seeker_jaffna.this,Details_of_places_jaffna.class));
            }
        });

        kyts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] destination_arguments_local;

                destination_arguments_local= destination_arguments_facts.destination_arguments("kytes");
                destination_name_around_jaffna = destination_arguments_local[0];
                destination_latitude_around_jaffna = destination_arguments_local[1];
                destination_longitude_around_jaffna = destination_arguments_local[2];
                destination_url_around_jaffna = destination_arguments_local[3];
                destination_description_around_jaffna = destination_arguments_local[4];

                startActivity(new Intent(details_seeker_jaffna.this,Details_of_places_jaffna.class));
            }
        });

        delphtIsland.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] destination_arguments_local;

                destination_arguments_local= destination_arguments_facts.destination_arguments("delpht");
                destination_name_around_jaffna = destination_arguments_local[0];
                destination_latitude_around_jaffna = destination_arguments_local[1];
                destination_longitude_around_jaffna = destination_arguments_local[2];
                destination_url_around_jaffna = destination_arguments_local[3];
                destination_description_around_jaffna = destination_arguments_local[4];

                startActivity(new Intent(details_seeker_jaffna.this,Details_of_places_jaffna.class));
            }
        });

        publiclibrary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] destination_arguments_local;

                destination_arguments_local= destination_arguments_facts.destination_arguments("jaffna_library");
                destination_name_around_jaffna = destination_arguments_local[0];
                destination_latitude_around_jaffna = destination_arguments_local[1];
                destination_longitude_around_jaffna = destination_arguments_local[2];
                destination_url_around_jaffna = destination_arguments_local[3];
                destination_description_around_jaffna = destination_arguments_local[4];

                startActivity(new Intent(details_seeker_jaffna.this,Details_of_places_jaffna.class));
            }
        });

        elephatpassmemorial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] destination_arguments_local;

                destination_arguments_local= destination_arguments_facts.destination_arguments("elephantpass_memorial");
                destination_name_around_jaffna = destination_arguments_local[0];
                destination_latitude_around_jaffna = destination_arguments_local[1];
                destination_longitude_around_jaffna = destination_arguments_local[2];
                destination_url_around_jaffna = destination_arguments_local[3];
                destination_description_around_jaffna = destination_arguments_local[4];

                startActivity(new Intent(details_seeker_jaffna.this,Details_of_places_jaffna.class));
            }
        });

        pointpadro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] destination_arguments_local;

                destination_arguments_local= destination_arguments_facts.destination_arguments("point_pedro");
                destination_name_around_jaffna = destination_arguments_local[0];
                destination_latitude_around_jaffna = destination_arguments_local[1];
                destination_longitude_around_jaffna = destination_arguments_local[2];
                destination_url_around_jaffna = destination_arguments_local[3];
                destination_description_around_jaffna = destination_arguments_local[4];

                startActivity(new Intent(details_seeker_jaffna.this,Details_of_places_jaffna.class));
            }
        });

        Keeramalei.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] destination_arguments_local;

                destination_arguments_local= destination_arguments_facts.destination_arguments("keeramale");
                destination_name_around_jaffna = destination_arguments_local[0];
                destination_latitude_around_jaffna = destination_arguments_local[1];
                destination_longitude_around_jaffna = destination_arguments_local[2];
                destination_url_around_jaffna = destination_arguments_local[3];
                destination_description_around_jaffna = destination_arguments_local[4];

                startActivity(new Intent(details_seeker_jaffna.this,Details_of_places_jaffna.class));
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
