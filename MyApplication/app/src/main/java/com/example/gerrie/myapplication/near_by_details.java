package com.example.gerrie.myapplication;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.tasks.OnSuccessListener;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Locale;

/**
 * Created by Gerrie on 11/5/2018.
 */

public class near_by_details extends AppCompatActivity {

    private Button close;
    private Button Nearby_places;
    private Button Weather_current;
    private Button Nearby_map_filter;
    private Button Details_nearby;
    private Button Plans_nearby;

    public static double current_latitude;
    public static double current_longitude;
    public static String near_travelling_city="";

    private FusedLocationProviderClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.near_by_details);

        Nearby_places = (Button) findViewById(R.id.nearby_places);
        Weather_current = (Button) findViewById(R.id.weather_current);
        Nearby_map_filter = (Button) findViewById(R.id.nearby_map_filter);
        Details_nearby = (Button) findViewById(R.id.details_nearby);
        Plans_nearby= (Button) findViewById(R.id.plans_nearby);
        close = (Button) findViewById(R.id.Close_near_by);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int) (width), (int) (height * 0.8));

        Nearby_places.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lat_lang_taker();
                if (current_latitude==0.0 && current_longitude==0.0){
                    if (statusCheck()){
                        toast("Your location service is in active state, but still location cannot be detected. Try again in few minutes");
                    }else{
                        buildAlertMessageNoGps();
                    }
                }else{
                    toast("Select your desired service type in Explore Nearby section");
                    String uri = String.format(Locale.ENGLISH, "geo:%f,%f",current_latitude,current_longitude);
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                    near_by_details.this.startActivity(intent);
                    //finish();
                }
            }
        });

        Weather_current.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lat_lang_taker();
                if (current_latitude==0.0 && current_longitude==0.0){
                    if (statusCheck()){
                        toast("Your location service is in active state, but still location cannot be detected. Try again in few minutes");
                    }else{
                        buildAlertMessageNoGps();
                    }
                }else{
                    startActivity(new Intent(near_by_details.this,weather_lat_lang_Activity.class));
                    //finish();
                }
            }
        });

        Nearby_map_filter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //startActivity(new Intent(near_by_details.this,MapsActivity.class));

                lat_lang_taker();

                /*current_latitude=8.3161458;
                current_longitude=80.4110444;*/

                if (current_latitude==0.0 && current_longitude==0.0){
                    if (statusCheck()){
                        toast("Your location service is in active state, but still location cannot be detected. Try again in few minutes");
                    }else{
                        buildAlertMessageNoGps();
                    }
                }else{
                    String[] near_city= select_near_city();
                    if (near_city[0].equals("No")){
                        toast("Unfortunately there are no travelling destinations around your current location. But if you feel there are any, please check them with the previous map");
                    }else{
                        near_travelling_city=near_city[0];
                        toast("You are nearly "+near_city[1]+" km s far from historical city, "+near_city[0]);
                        startActivity(new Intent(near_by_details.this,MapsActivity.class));
                        //finish();
                    }
                }
            }
        });

        Details_nearby.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            lat_lang_taker();

                /*current_latitude=9.656926;
                current_longitude=80.029971;*/

            if (current_latitude==0.0 && current_longitude==0.0){
                if (statusCheck()){
                    toast("Your location service is in active state, but still location cannot be detected. Try again in few minutes");
                }else{
                    buildAlertMessageNoGps();
                }
            }else{
                String[] near_city= select_near_city();
                if (near_city[0].equals("No")){
                    toast("Unfortunately there are no travelling destinations around your current location. But if you feel there are any, please check them with the previous map");
                }else {
                    near_travelling_city = near_city[0];
                    toast("You are nearly " + near_city[1] + " km s far from historical city, " + near_city[0]);
                    if (near_city[0].equals("Jaffna")) {
                        details_seeker_jaffna.general_state_jaffna = false;
                        startActivity(new Intent(near_by_details.this, details_seeker_jaffna.class));
                    } else if (near_city[0].equals("Anuradhapura")) {
                        details_seeker_anuradhapura.general_state_anuradhapura = false;
                        startActivity(new Intent(near_by_details.this, details_seeker_anuradhapura.class));
                    } else if (near_city[0].equals("Kandy")) {
                        details_seeker_kandy.general_state_kandy = false;
                        startActivity(new Intent(near_by_details.this, details_seeker_kandy.class));
                    } else if (near_city[0].equals("Galle")) {
                        details_seeker_galle.general_state_galle = false;
                        startActivity(new Intent(near_by_details.this, details_seeker_galle.class));
                    }
                    //finish();
                }
            }}
        });

        Plans_nearby.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lat_lang_taker();

                /*current_latitude=9.656926;
                current_longitude=80.029971;*/

                if (current_latitude==0.0 && current_longitude==0.0){
                    if (statusCheck()){
                        toast("Your location service is in active state, but still location cannot be detected. Try again in few minutes");
                    }else{
                        buildAlertMessageNoGps();
                    }
                }else{
                    String[] near_city= select_near_city();
                    if (near_city[0].equals("No")){
                        toast("Unfortunately there are no defined travelling plans regarding your current location. But if you feel there would be any, please check them with the drawer menu");
                    }else {
                        near_travelling_city = near_city[0];
                        toast("You are nearly " + near_city[1] + " km s far from historical city, " + near_city[0]);
                        if (near_city[0].equals("Jaffna")) {
                            plans_jaffna.general_plan_jaffna = false;
                            startActivity(new Intent(near_by_details.this, plans_jaffna.class));
                        } else if (near_city[0].equals("Anuradhapura")) {
                            plans_apura.general_plan_apura = false;
                            startActivity(new Intent(near_by_details.this, plans_apura.class));
                        } else if (near_city[0].equals("Kandy")) {
                            plans_kandy.general_plan_kandy = false;
                            startActivity(new Intent(near_by_details.this, plans_kandy.class));
                        } else if (near_city[0].equals("Galle")) {
                            plans_galle.general_plan_galle = false;
                            startActivity(new Intent(near_by_details.this, plans_galle.class));
                        }
                        //finish();
                    }
                }
            }
        });

        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    public void lat_lang_taker(){

        client = LocationServices.getFusedLocationProviderClient(this);

        if (ActivityCompat.checkSelfPermission(near_by_details.this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            return;
        }
        client.getLastLocation().addOnSuccessListener(near_by_details.this, new OnSuccessListener<Location>() {
            @Override
            public void onSuccess(Location location) {
                if (location!=null){
                    current_latitude=location.getLatitude();
                    current_longitude=location.getLongitude();
                }
            }
        });
    }

    public void toast(String toast1) {
        Context context = getApplicationContext();
        CharSequence text = toast1;
        int duration = Toast.LENGTH_LONG;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }

    public String[] select_near_city(){

        HashMap<String, double[]> city_details = new HashMap<String, double[]>();
        double[] lat_lon_value;
        double distance;
        double distance_min=10000.0;
        String distance_min_city="";

        city_details.put("Jaffna",new double[] {9.661302, 80.025513});
        city_details.put("Anuradhapura",new double[] {8.322950, 80.402722});
        city_details.put("Kandy",new double[] {7.293146, 80.635009});
        city_details.put("Galle",new double[] {6.032861, 80.214905});

        LatLng latLngA = new LatLng(current_latitude,current_longitude);
        Location locationA = new Location("point A");
        locationA.setLatitude(latLngA.latitude);
        locationA.setLongitude(latLngA.longitude);

        for (String key : city_details.keySet()) {
            lat_lon_value = city_details.get(key);

            LatLng latLngB = new LatLng(lat_lon_value[0],lat_lon_value[1]);
            Location locationB = new Location("point B");
            locationB.setLatitude(latLngB.latitude);
            locationB.setLongitude(latLngB.longitude);

            distance = locationA.distanceTo(locationB)*0.0009941936;

            if(distance<distance_min){
                distance_min=distance;
                distance_min_city=key;
            }
        }

        String[] nearby_city_details = new String[] {"No","0"};

        if (distance_min<=11){
            distance_min*=1.3;  //approximately air distance multiply by a constant(1.3) to have the road distance
            DecimalFormat numberFormat = new DecimalFormat("#0.0");
            nearby_city_details[0]=distance_min_city;
            nearby_city_details[1]=numberFormat.format(distance_min);
        }
        return nearby_city_details;
    }

    public boolean statusCheck() {
        final LocationManager manager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        if (!manager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
            //buildAlertMessageNoGps();
            return false;
        }
        return true;
    }

    private void buildAlertMessageNoGps() {

        android.app.AlertDialog.Builder alertDialog = new android.app.AlertDialog.Builder(near_by_details.this);
        alertDialog.setTitle("Turn location services on");
        alertDialog.setMessage("Your GPS seems to be disabled, do you want to enable it?")
                .setPositiveButton("No",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        })

                .setNegativeButton("Yes",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                startActivity(new Intent(android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS));
                            }
                        });

        alertDialog.show();
    }
}
