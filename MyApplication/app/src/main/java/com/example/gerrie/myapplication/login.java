package com.example.gerrie.myapplication;

import android.content.Context;
import android.content.Intent;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Gerrie on 10/18/2018.
 */

public class login  extends AppCompatActivity {

    private EditText editText_username;
    private EditText editText;
    private Button button;
    private Button sign_up_button;
    private RelativeLayout Login_view;
    private CheckBox Chechbox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout10);

        /*if (notregistered){

        }else{
            Render_background();
        }*/

        //Render_background();

        Chechbox= (CheckBox) findViewById(R.id.checkBox);
        editText_username = (EditText) findViewById(R.id.email);
        editText = (EditText) findViewById(R.id.password10);
        button = (Button) findViewById(R.id.email_sign_in_button);
        sign_up_button = (Button) findViewById(R.id.button_register);

        if (Chechbox.isChecked()){
            editText_username.setText("admin");
            editText.setText("admin");
        }

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = editText_username.getText().toString();
                String password = editText.getText().toString();
                if (email.equals("admin") && password.equals("admin")) {
                    Intent intent = new Intent(login.this, MainActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                    finish();
                } else {
                    toast("Wrong credentials. Please enter the correct username and password");
                }
            }
        });

        sign_up_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(login.this,register_user.class));
            }
        });
    }

    @Override
    public void onBackPressed() {
        int pid = android.os.Process.myPid();
        android.os.Process.killProcess(pid);
    }

    /*public void Render_background(){
        Login_view= (RelativeLayout) findViewById(R.id.login_view);

        Date time = new java.util.Date(System.currentTimeMillis());
        String str1=new SimpleDateFormat("HH:mm:ss").format(time);
        String sb = new StringBuilder().append(str1.charAt(3)).append(str1.charAt(4)).toString();
        int minute = Integer.parseInt(sb);
        int backgrounds[]={R.drawable.m1,R.drawable.m2,R.drawable.m3,R.drawable.m4,R.drawable.m5,R.drawable.m6,R.drawable.m7,R.drawable.m8,R.drawable.m9,R.drawable.m10,R.drawable.m11,R.drawable.m12,R.drawable.m14,R.drawable.m16,R.drawable.m17,R.drawable.m18,R.drawable.m19,R.drawable.m20,R.drawable.m21,R.drawable.m22,R.drawable.m23,R.drawable.m24,R.drawable.m25,R.drawable.m26,R.drawable.m27,R.drawable.m28,R.drawable.m29,R.drawable.m30,R.drawable.m31,R.drawable.m32,R.drawable.m33,R.drawable.m35,R.drawable.m36,R.drawable.m37,R.drawable.m38,R.drawable.m39,R.drawable.m40,R.drawable.m41,R.drawable.m42,R.drawable.m43,R.drawable.m44,R.drawable.m45,R.drawable.m46,R.drawable.m47,R.drawable.m48,R.drawable.m49,R.drawable.m50,R.drawable.m51,R.drawable.m52,R.drawable.m53,R.drawable.m54,R.drawable.m55,R.drawable.m56,R.drawable.m57,R.drawable.m59,R.drawable.m60,R.drawable.m61,R.drawable.m62,R.drawable.m63,R.drawable.m64};

        Login_view.setBackgroundResource(backgrounds[minute]);

    }*/

    public void toast(String toast1) {
        Context context = getApplicationContext();
        CharSequence text = toast1;
        int duration = Toast.LENGTH_LONG;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }
}