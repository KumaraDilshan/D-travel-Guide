package com.example.gerrie.myapplication;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import org.json.JSONException;
import org.json.JSONObject;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

public class weather_lat_lang_Activity extends AppCompatActivity {

    TextView selectCity, cityField, detailsField, currentTemperatureField, humidity_field, pressure_field, weatherIcon, updatedField;
    ProgressBar loader;
    Typeface weatherFont;
    String city = "Colombo";
    /* Please Put your API KEY here */
    String OPEN_WEATHER_MAP_API = "8576f2ea5b0104b9942387b98d7f0409";
    /* Please Put your API KEY here */
    private RelativeLayout relativelayout;
    private double latitude=near_by_details.current_latitude;
    private double longitude=near_by_details.current_longitude;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.weather_lat_lang_layout);

        loader = (ProgressBar) findViewById(R.id.loader);
        /*selectCity = (TextView) findViewById(R.id.selectCity);*/
        cityField = (TextView) findViewById(R.id.city_field);
        updatedField = (TextView) findViewById(R.id.updated_field);
        detailsField = (TextView) findViewById(R.id.details_field);
        currentTemperatureField = (TextView) findViewById(R.id.current_temperature_field);
        humidity_field = (TextView) findViewById(R.id.humidity_field);
        pressure_field = (TextView) findViewById(R.id.pressure_field);
        weatherIcon = (TextView) findViewById(R.id.weather_icon);
        weatherFont = Typeface.createFromAsset(getAssets(), "fonts/weathericons-regular-webfont.ttf");
        weatherIcon.setTypeface(weatherFont);

        relativelayout = (RelativeLayout) findViewById(R.id.background);
        taskLoadUp(city);
    }

    public void taskLoadUp(String query) {
        if (Function_weather_latlang.isNetworkAvailable(getApplicationContext())) {
            DownloadWeather task = new DownloadWeather();
            task.execute(query);
        } else {
            Toast.makeText(getApplicationContext(), "No Internet Connection", Toast.LENGTH_LONG).show();
        }
    }



    class DownloadWeather extends AsyncTask < String, Void, String > {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            loader.setVisibility(View.VISIBLE);

        }
        protected String doInBackground(String...args) {
            String lat=Double.toString(latitude);
            String lon=Double.toString(longitude);
            String xml = Function_weather_latlang.excuteGet("http://api.openweathermap.org/data/2.5/weather?lat="+lat+"&lon="+lon+"&appid=" + OPEN_WEATHER_MAP_API);
            return xml;
        }
        @Override
        protected void onPostExecute(String xml) {

            try {
                JSONObject json = new JSONObject(xml);
                if (json != null) {
                    JSONObject details = json.getJSONArray("weather").getJSONObject(0);
                    JSONObject main = json.getJSONObject("main");
                    DateFormat df = DateFormat.getDateTimeInstance();


                    cityField.setText(json.getString("name").toUpperCase(Locale.US) + ", " + json.getJSONObject("sys").getString("country"));
                    detailsField.setText(details.getString("description").toUpperCase(Locale.US));
                    currentTemperatureField.setText(String.format("%.2f", ((main.getDouble("temp"))/10)) + "°");
                    humidity_field.setText("Humidity: " + main.getString("humidity") + "%");
                    pressure_field.setText("Pressure: " + main.getString("pressure") + " hPa");
                    updatedField.setText(df.format(new Date(json.getLong("dt") * 1000)));
                    weatherIcon.setText(Html.fromHtml(Function_weather_latlang.setWeatherIcon(details.getInt("id"),
                            json.getJSONObject("sys").getLong("sunrise") * 1000,
                            json.getJSONObject("sys").getLong("sunset") * 1000)));

                    loader.setVisibility(View.GONE);

                    if(detailsField.getText().equals("CLEAR SKY")){
                        relativelayout.setBackgroundColor(Color.parseColor("#a29e1b"));
                    }
                    else if(detailsField.getText().equals("HAZE")){
                        relativelayout.setBackgroundColor(Color.parseColor("#FF696B74"));
                    }
                    else if(detailsField.getText().equals("FEW CLOUDS")){
                        relativelayout.setBackgroundColor(Color.parseColor("#FF95969C"));
                    }
                    else if(detailsField.getText().equals("SCATTERED CLOUDS")){
                        relativelayout.setBackgroundColor(Color.parseColor("#FF95969C"));
                    }
                    else if(detailsField.getText().equals("BROKEN CLOUDS")){
                        relativelayout.setBackgroundColor(Color.parseColor("#FF95969C"));
                    }
                    else if(detailsField.getText().equals("MODERATE RAIN")){
                        relativelayout.setBackgroundColor(Color.parseColor("#3F51B5"));
                    }
                    else if(detailsField.getText().equals("SHOWER RAIN")){
                        relativelayout.setBackgroundColor(Color.parseColor("#3F51B5"));
                    }
                    else if(detailsField.getText().equals("LIGHT RAIN")){
                        relativelayout.setBackgroundColor(Color.parseColor("#3F51B5"));
                    }
                    else if(detailsField.getText().equals("RAIN")){
                        relativelayout.setBackgroundColor(Color.parseColor("#3F51B5"));
                    }
                    else if(detailsField.getText().equals("THUNDERSTORM")){
                        relativelayout.setBackgroundColor(Color.parseColor("#FF2D303C"));
                    }
                    else if(detailsField.getText().equals("SNOW")){
                        relativelayout.setBackgroundColor(Color.parseColor("#FF696B74"));
                    }
                    else if(detailsField.getText().equals("MIST")){
                        relativelayout.setBackgroundColor(Color.parseColor("#FF696B74"));
                    }
                    else if(detailsField.getText().equals("OVERCAST CLOUDS")){
                        relativelayout.setBackgroundColor(Color.parseColor("#FF95969C"));
                    }
                    else{
                        relativelayout.setBackgroundColor(Color.parseColor("#3F51B5"));
                    }

                }
            } catch (JSONException e) {
                Toast.makeText(getApplicationContext(), "Error, Check the city again", Toast.LENGTH_LONG).show();
            }
        }
    }
}