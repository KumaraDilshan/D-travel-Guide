package com.example.gerrie.myapplication;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by Gerrie on 10/28/2018.
 */

public class register_user extends AppCompatActivity {

    private Button create_account;
    private Button create_account_cancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_me);

        create_account =(Button) findViewById(R.id.create_account);
        create_account_cancel=(Button) findViewById(R.id.register_cancel);

        create_account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //work do be done with registration
                toast("Your account had been created successfully. Enter the credentials to sign in");
                finish();
            }
        });

        create_account_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
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

}
