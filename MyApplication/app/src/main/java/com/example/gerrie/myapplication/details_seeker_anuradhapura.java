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

public class details_seeker_anuradhapura extends AppCompatActivity {

    private Button mihinthale;
    private Button jaya_sri_maha_bodhi;
    private Button ruwanwelisaya;
    private Button isurumuniya;
    private Button jethavanaramaya;
    private Button thuparamaya;
    private Button abayagiri;
    private Button lovamahapaya;
    private Button kuttampokuna;
    private Button ranmasuuyana;
    private Button nuwarawewa;
    private Button thisawewa;
    private android.support.v7.widget.Toolbar toolbar;

    private Button Nearby_details_close;

    public static boolean general_state_anuradhapura=false;

    public static String destination_name_around_anuradhapura;
    public static String destination_latitude_around_anuradhapura;
    public static String destination_longitude_around_anuradhapura;
    public static String destination_url_around_anuradhapura;
    public static String destination_description_around_anuradhapura;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.details_seeker_layout_anuradhapura);

        mihinthale=(Button) findViewById (R.id.mihinathale);
        jaya_sri_maha_bodhi=(Button) findViewById (R.id.jaya_sri_maha_bodhi);
        ruwanwelisaya=(Button) findViewById (R.id.ruwanwelisaya);
        isurumuniya=(Button) findViewById (R.id.isurumuniya);
        jethavanaramaya=(Button) findViewById (R.id.jethavanaramaya);
        thuparamaya=(Button) findViewById (R.id.thuparamaya);
        abayagiri=(Button) findViewById (R.id.abayagiriya);
        lovamahapaya=(Button) findViewById (R.id.lovahamahapaya);
        kuttampokuna=(Button) findViewById (R.id.kuttampokuna);
        ranmasuuyana=(Button) findViewById (R.id.ranmasu_uyana);
        nuwarawewa=(Button) findViewById (R.id.nuwarawewa);
        thisawewa=(Button) findViewById (R.id.thisawewa);

        toolbar = (android.support.v7.widget.Toolbar) findViewById (R.id.toolbar_details_apura);

        Nearby_details_close=(Button) findViewById (R.id.nearby_details_close_anuradhapura);

        if (!general_state_anuradhapura){
            toolbar.setTitle("Explore nearby travel destinations");
            android.app.AlertDialog.Builder alertDialog_weather = new android.app.AlertDialog.Builder(details_seeker_anuradhapura.this);
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
                                    startActivity(new Intent(details_seeker_anuradhapura.this,weather_lat_lang_Activity_notify_weather.class));
                                }
                            });

            alertDialog_weather.show();
        }else{
            toolbar.setTitle("Explore travel destinations");
        }

        final Destination_arguments destination_arguments_facts = new Destination_arguments();

        mihinthale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] destination_arguments_local;

                destination_arguments_local= destination_arguments_facts.destination_arguments("mihinathale");
                destination_name_around_anuradhapura = destination_arguments_local[0];
                destination_latitude_around_anuradhapura = destination_arguments_local[1];
                destination_longitude_around_anuradhapura = destination_arguments_local[2];
                destination_url_around_anuradhapura = destination_arguments_local[3];
                destination_description_around_anuradhapura = destination_arguments_local[4];

                startActivity(new Intent(details_seeker_anuradhapura.this,Details_of_places_anuradhapura.class));
            }
        });

        jaya_sri_maha_bodhi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] destination_arguments_local;

                destination_arguments_local= destination_arguments_facts.destination_arguments("jaya_sri_maha_bodhi");
                destination_name_around_anuradhapura = destination_arguments_local[0];
                destination_latitude_around_anuradhapura = destination_arguments_local[1];
                destination_longitude_around_anuradhapura = destination_arguments_local[2];
                destination_url_around_anuradhapura = destination_arguments_local[3];
                destination_description_around_anuradhapura = destination_arguments_local[4];

                startActivity(new Intent(details_seeker_anuradhapura.this,Details_of_places_anuradhapura.class));
            }
        });

        ruwanwelisaya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] destination_arguments_local;

                destination_arguments_local= destination_arguments_facts.destination_arguments("ruwanwelisaya");
                destination_name_around_anuradhapura = destination_arguments_local[0];
                destination_latitude_around_anuradhapura = destination_arguments_local[1];
                destination_longitude_around_anuradhapura = destination_arguments_local[2];
                destination_url_around_anuradhapura = destination_arguments_local[3];
                destination_description_around_anuradhapura = destination_arguments_local[4];

                startActivity(new Intent(details_seeker_anuradhapura.this,Details_of_places_anuradhapura.class));
            }
        });

        isurumuniya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] destination_arguments_local;

                destination_arguments_local= destination_arguments_facts.destination_arguments("isurumuniya");
                destination_name_around_anuradhapura = destination_arguments_local[0];
                destination_latitude_around_anuradhapura = destination_arguments_local[1];
                destination_longitude_around_anuradhapura = destination_arguments_local[2];
                destination_url_around_anuradhapura = destination_arguments_local[3];
                destination_description_around_anuradhapura = destination_arguments_local[4];

                startActivity(new Intent(details_seeker_anuradhapura.this,Details_of_places_anuradhapura.class));
            }
        });

        jethavanaramaya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] destination_arguments_local;

                destination_arguments_local= destination_arguments_facts.destination_arguments("jethavanaramaya");
                destination_name_around_anuradhapura = destination_arguments_local[0];
                destination_latitude_around_anuradhapura = destination_arguments_local[1];
                destination_longitude_around_anuradhapura = destination_arguments_local[2];
                destination_url_around_anuradhapura = destination_arguments_local[3];
                destination_description_around_anuradhapura = destination_arguments_local[4];

                startActivity(new Intent(details_seeker_anuradhapura.this,Details_of_places_anuradhapura.class));
            }
        });

        thuparamaya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] destination_arguments_local;

                destination_arguments_local= destination_arguments_facts.destination_arguments("thuparamaya");
                destination_name_around_anuradhapura = destination_arguments_local[0];
                destination_latitude_around_anuradhapura = destination_arguments_local[1];
                destination_longitude_around_anuradhapura = destination_arguments_local[2];
                destination_url_around_anuradhapura = destination_arguments_local[3];
                destination_description_around_anuradhapura = destination_arguments_local[4];

                startActivity(new Intent(details_seeker_anuradhapura.this,Details_of_places_anuradhapura.class));
            }
        });

        abayagiri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] destination_arguments_local;

                destination_arguments_local= destination_arguments_facts.destination_arguments("abayagiriya");
                destination_name_around_anuradhapura = destination_arguments_local[0];
                destination_latitude_around_anuradhapura = destination_arguments_local[1];
                destination_longitude_around_anuradhapura = destination_arguments_local[2];
                destination_url_around_anuradhapura = destination_arguments_local[3];
                destination_description_around_anuradhapura = destination_arguments_local[4];

                startActivity(new Intent(details_seeker_anuradhapura.this,Details_of_places_anuradhapura.class));
            }
        });

        lovamahapaya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] destination_arguments_local;

                destination_arguments_local= destination_arguments_facts.destination_arguments("lovahamahapaya");
                destination_name_around_anuradhapura = destination_arguments_local[0];
                destination_latitude_around_anuradhapura = destination_arguments_local[1];
                destination_longitude_around_anuradhapura = destination_arguments_local[2];
                destination_url_around_anuradhapura = destination_arguments_local[3];
                destination_description_around_anuradhapura = destination_arguments_local[4];

                startActivity(new Intent(details_seeker_anuradhapura.this,Details_of_places_anuradhapura.class));
            }
        });

        kuttampokuna.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] destination_arguments_local;

                destination_arguments_local= destination_arguments_facts.destination_arguments("kuttampokuna");
                destination_name_around_anuradhapura = destination_arguments_local[0];
                destination_latitude_around_anuradhapura = destination_arguments_local[1];
                destination_longitude_around_anuradhapura = destination_arguments_local[2];
                destination_url_around_anuradhapura = destination_arguments_local[3];
                destination_description_around_anuradhapura = destination_arguments_local[4];

                startActivity(new Intent(details_seeker_anuradhapura.this,Details_of_places_anuradhapura.class));
            }
        });

        ranmasuuyana.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] destination_arguments_local;

                destination_arguments_local= destination_arguments_facts.destination_arguments("ranmasu_uyana");
                destination_name_around_anuradhapura = destination_arguments_local[0];
                destination_latitude_around_anuradhapura = destination_arguments_local[1];
                destination_longitude_around_anuradhapura = destination_arguments_local[2];
                destination_url_around_anuradhapura = destination_arguments_local[3];
                destination_description_around_anuradhapura = destination_arguments_local[4];

                startActivity(new Intent(details_seeker_anuradhapura.this,Details_of_places_anuradhapura.class));
            }
        });

        nuwarawewa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] destination_arguments_local;

                destination_arguments_local= destination_arguments_facts.destination_arguments("nuwarawewa");
                destination_name_around_anuradhapura = destination_arguments_local[0];
                destination_latitude_around_anuradhapura = destination_arguments_local[1];
                destination_longitude_around_anuradhapura = destination_arguments_local[2];
                destination_url_around_anuradhapura = destination_arguments_local[3];
                destination_description_around_anuradhapura = destination_arguments_local[4];

                startActivity(new Intent(details_seeker_anuradhapura.this,Details_of_places_anuradhapura.class));
            }
        });

        thisawewa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] destination_arguments_local;

                destination_arguments_local= destination_arguments_facts.destination_arguments("thisawewa");
                destination_name_around_anuradhapura = destination_arguments_local[0];
                destination_latitude_around_anuradhapura = destination_arguments_local[1];
                destination_longitude_around_anuradhapura = destination_arguments_local[2];
                destination_url_around_anuradhapura = destination_arguments_local[3];
                destination_description_around_anuradhapura = destination_arguments_local[4];

                startActivity(new Intent(details_seeker_anuradhapura.this,Details_of_places_anuradhapura.class));
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
