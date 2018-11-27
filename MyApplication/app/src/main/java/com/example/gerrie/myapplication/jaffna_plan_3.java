package com.example.gerrie.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by Gerrie on 11/20/2018.
 */

public class jaffna_plan_3 extends AppCompatActivity {

    private Button info_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.jaffna_plan_3);

        info_button = (Button) findViewById(R.id.plan_close_jaffna3);

        info_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(jaffna_plan_3.this,icon_info.class));
            }
        });

    }
}
