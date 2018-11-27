package com.example.gerrie.myapplication;

import android.content.Context;
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

public class filter_nearby_maps extends AppCompatActivity{

    public static Spinner Nearby_filter_spinner;
    private Button Apply_nearby_mapfilter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.nearby_map_filter);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int) (width), (int) (height * 0.37));

        Nearby_filter_spinner = (Spinner) findViewById(R.id.nearby_filter_spinner);

        String[] items = new String[]{"Don't specify","Religious destinations","Cultural destinations","Naturally valued destinations"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_activated_1,items);
        Nearby_filter_spinner.setAdapter(adapter);

        Apply_nearby_mapfilter=(Button) findViewById (R.id.apply_nearby_mapfilter);

        Apply_nearby_mapfilter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MapsActivity.setup_map();
                if (Nearby_filter_spinner.getSelectedItemId()==0){
                    toast("You can observe all destinations around "+near_by_details.near_travelling_city);
                }else if (Nearby_filter_spinner.getSelectedItemId()==1){
                    toast("You can only observe religious destinations around "+near_by_details.near_travelling_city);
                }else if (Nearby_filter_spinner.getSelectedItemId()==2){
                    toast("You can only observe cultural destinations around "+near_by_details.near_travelling_city);
                }else if (Nearby_filter_spinner.getSelectedItemId()==3){
                    toast("You can only observe naturally valued destinations around "+near_by_details.near_travelling_city);
                }
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
