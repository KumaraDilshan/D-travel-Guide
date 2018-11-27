package com.example.gerrie.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by Gerrie on 11/18/2018.
 */

public class plans_all_cities extends AppCompatActivity {

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

    private Button close_plans;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.plan_layout_all_cities);

        jaffnna=(Button) findViewById (R.id.jaffna_plans);
        apura=(Button) findViewById (R.id.apura_plans);
        kandy=(Button) findViewById (R.id.kandy_plans);
        galle=(Button) findViewById (R.id.galle_plans);
        mannar=(Button) findViewById (R.id.mannar_plans);
        trincomalee=(Button) findViewById (R.id.trinco_plans);
        dambulla=(Button) findViewById (R.id.dambulla_plans);
        baticaloa=(Button) findViewById (R.id.baticaloa_plans);
        colombo=(Button) findViewById (R.id.colombo_plans);
        mathale=(Button) findViewById (R.id.mathale_plans);
        mathara=(Button) findViewById (R.id.mathara_plans);
        nuwaraeliya=(Button) findViewById (R.id.nuwara_eliya_plans);
        badulla=(Button) findViewById (R.id.dambulla_plans);
        vilpattu=(Button) findViewById (R.id.vilpattu_plans);
        yala=(Button) findViewById (R.id.yala_plans);
        kegalle=(Button) findViewById (R.id.kegalle_plans);
        haputhale=(Button) findViewById (R.id.haputhale_plans);
        ella=(Button) findViewById (R.id.ella_plans);
        katharagama=(Button) findViewById (R.id.katharagama_plans);
        polonnaruwa=(Button) findViewById (R.id.polonnaruwa_plans);
        dehiwala_mount_laviniya=(Button) findViewById (R.id.dehiwala_mount_laviniya_plans);
        kalmunai=(Button) findViewById (R.id.kalmunei_plans);
        dambadeniya=(Button) findViewById (R.id.dambadeniya_plans);
        udawalawe=(Button) findViewById (R.id.udawalawe_plans);
        hatton=(Button) findViewById (R.id.hatton_plans);
        mineriya=(Button) findViewById (R.id.minneriya_plans);
        rathnapura=(Button) findViewById (R.id.rathnapura_plans);

        close_plans=(Button) findViewById (R.id.close_plans);

        close_plans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        jaffnna.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                plans_jaffna.general_plan_jaffna=true;
                startActivity(new Intent(plans_all_cities.this,plans_jaffna.class));
                //finish();
            }
        });

        apura.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                plans_apura.general_plan_apura=true;
                startActivity(new Intent(plans_all_cities.this,plans_apura.class));
                //finish();
            }
        });

        kandy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                plans_kandy.general_plan_kandy=true;
                startActivity(new Intent(plans_all_cities.this,plans_kandy.class));
                //finish();
            }
        });

        galle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                plans_galle.general_plan_galle=true;
                startActivity(new Intent(plans_all_cities.this,plans_galle.class));
                //finish();
            }
        });


    }

}
