package com.example.gerrie.myapplication;

import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;

public class latlang extends AppCompatActivity {

    private FusedLocationProviderClient client;
    private Button latLang5;
    private String ACCESS_FINE_LOCATION;
    private TextView textview_data;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.latlang);

        requestPermission();

        client = LocationServices.getFusedLocationProviderClient(this);

        textview_data=(TextView) findViewById(R.id.textview101);
        latLang5 = (Button) findViewById(R.id.button75);

        latLang5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ActivityCompat.checkSelfPermission(latlang.this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

                    return;
                }
                client.getLastLocation().addOnSuccessListener(latlang.this, new OnSuccessListener<Location>() {
                    @Override
                    public void onSuccess(Location location) {
                        if (location!=null){
                            textview_data.setText(location.toString());
                        }
                        else{
                            textview_data.setText("Null");
                        }
                    }
                });
            }
        });
    }
    
    private void requestPermission(){
        ActivityCompat.requestPermissions(this,new String[]{ACCESS_FINE_LOCATION},1);
    }
}

