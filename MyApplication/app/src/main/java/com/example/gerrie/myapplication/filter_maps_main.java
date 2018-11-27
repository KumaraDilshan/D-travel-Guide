package com.example.gerrie.myapplication;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

/**
 * Created by Gerrie on 11/6/2018.
 */

public class filter_maps_main extends AppCompatActivity{

    public static Spinner Main_filter_city;
    public static Spinner Main_filter_type;
    private Button Apply_main_mapfilter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.filter_maps_main);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int) (width), (int) (height * 0.54));

        Main_filter_city = (Spinner) findViewById(R.id.main_filter_city);

        String[] items_city = new String[]{"Not selected","Jaffnna","Anuradhapura","Kandy","Galle","Mannar","Trincomalee","Dambulla","Baticaloa","Colombo","Mathale","Mathara","Nuwaraeliya","Badulla","Vilpattu","Yala","Kegalle","Rathnapura","Haputhale","Ella","Bandarawela","Katharagama","Polonnaruwa","Dehiwala-Mount Laviniya","Kalmunai","Dambadeniya","Udawalawe","Hatton","Mineriya"};
        ArrayAdapter<String> adapter_city = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_activated_1,items_city);
        Main_filter_city.setAdapter(adapter_city);

        Main_filter_type = (Spinner) findViewById(R.id.main_filter_type);

        String[] items_type = new String[]{"Don't specify","Religious destinations","Cultural destinations","Naturally valued destinations"};
        ArrayAdapter<String> adapter_type = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_activated_1,items_type);
        Main_filter_type.setAdapter(adapter_type);

        Apply_main_mapfilter=(Button) findViewById (R.id.Apply_main_mapfilter);

        Apply_main_mapfilter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Main_filter_city.getSelectedItemId()==0){
                    toast("Please select a city to specify it's destinations");
                }else {
                    if (Main_filter_type.getSelectedItemId()==0){
                        toast("You can observe all destinations around " + Main_filter_city.getSelectedItem());
                    }else{
                        toast("You can observe only " + Main_filter_type.getSelectedItem() + " around " + Main_filter_city.getSelectedItem());
                    }
                    startActivity(new Intent(filter_maps_main.this,MapsActivity_main.class));
                    finish();
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
}
