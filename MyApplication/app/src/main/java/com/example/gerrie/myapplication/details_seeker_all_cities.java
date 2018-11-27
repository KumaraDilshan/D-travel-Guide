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

public class details_seeker_all_cities extends AppCompatActivity {

    private Button jaffnna;
    private Button apura;
    private Button kandy;
    private Button galle;
    private Button mannar;
    private Button trincomalee;
    private Button dambulla;
    private Button baticaloa;
    private Button colombo;
    private Button mathale;
    private Button mathara;
    private Button nuwaraeliya;
    private Button badulla;
    private Button vilpattu;
    private Button yala;
    private Button kegalle;
    private Button rathnapura;
    private Button haputhale;
    private Button ella;
    private Button katharagama;
    private Button polonnaruwa;
    private Button dehiwala_mount_laviniya;
    private Button kalmunai;
    private Button dambadeniya;
    private Button udawalawe;
    private Button hatton;
    private Button mineriya;

    private Button close_all_cities;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.details_seeker_layout_all_cities);

        jaffnna=(Button) findViewById (R.id.jaffna_all_cities);
        apura=(Button) findViewById (R.id.apura_all_cities);
        kandy=(Button) findViewById (R.id.kandy_all_cities);
        galle=(Button) findViewById (R.id.galle_all_cities);
        mannar=(Button) findViewById (R.id.mannar_all_cities);
        trincomalee=(Button) findViewById (R.id.trinco_all_cities);
        dambulla=(Button) findViewById (R.id.dambulla_all_cities);
        baticaloa=(Button) findViewById (R.id.baticaloa_all_cities);
        colombo=(Button) findViewById (R.id.colombo_all_cities);
        mathale=(Button) findViewById (R.id.mathale_all_cities);
        mathara=(Button) findViewById (R.id.mathara_all_cities);
        nuwaraeliya=(Button) findViewById (R.id.nuwara_eliya_all_cities);
        badulla=(Button) findViewById (R.id.dambulla_all_cities);
        vilpattu=(Button) findViewById (R.id.vilpattu_all_cities);
        yala=(Button) findViewById (R.id.yala_all_cities);
        kegalle=(Button) findViewById (R.id.kegalle_all_cities);
        haputhale=(Button) findViewById (R.id.haputhale_all_cities);
        ella=(Button) findViewById (R.id.ella_all_cities);
        katharagama=(Button) findViewById (R.id.katharagama_all_cities);
        polonnaruwa=(Button) findViewById (R.id.polonnaruwa_all_cities);
        dehiwala_mount_laviniya=(Button) findViewById (R.id.dehiwala_mount_laviniya_all_cities);
        kalmunai=(Button) findViewById (R.id.kalmunei_all_cities);
        dambadeniya=(Button) findViewById (R.id.dambadeniya_all_cities);
        udawalawe=(Button) findViewById (R.id.udawalawe_all_cities);
        hatton=(Button) findViewById (R.id.hatton_all_cities);
        mineriya=(Button) findViewById (R.id.minneriya_all_cities);
        rathnapura=(Button) findViewById (R.id.rathnapura_all_cities);

        close_all_cities=(Button) findViewById (R.id.close_all_cities);

        close_all_cities.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        jaffnna.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                details_seeker_jaffna.general_state_jaffna=true;
                startActivity(new Intent(details_seeker_all_cities.this,details_seeker_jaffna.class));
                //finish();
            }
        });

        apura.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                details_seeker_anuradhapura.general_state_anuradhapura=true;
                startActivity(new Intent(details_seeker_all_cities.this,details_seeker_anuradhapura.class));
                //finish();
            }
        });

        kandy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                details_seeker_kandy.general_state_kandy=true;
                startActivity(new Intent(details_seeker_all_cities.this,details_seeker_kandy.class));
                //finish();
            }
        });

        galle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                details_seeker_galle.general_state_galle=true;
                startActivity(new Intent(details_seeker_all_cities.this,details_seeker_galle.class));
                //finish();
            }
        });
    }
}
