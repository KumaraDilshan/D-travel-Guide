package com.example.gerrie.myapplication;

import android.app.FragmentManager;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    public static String destination_name_lanka;
    public static String destination_url_lanka;
    public static String destination_description_lanka;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.description_toolbar_galle);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        FragmentManager fm = getFragmentManager();
        fm.beginTransaction().replace(R.id.content_main, new MapsActivities()).commit();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            int pid = android.os.Process.myPid();
            android.os.Process.killProcess(pid);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_nearby) {
            //startActivity(new Intent(MainActivity.this, new1.class));
            startActivity(new Intent(MainActivity.this, near_by_details.class));
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.

        final Destination_arguments destination_arguments_facts = new Destination_arguments();

        int id = item.getItemId();

        if (id == R.id.about_sri_lanka) {

            String[] destination_arguments_local;

            destination_arguments_local= destination_arguments_facts.destination_arguments("sri_lanka");
            destination_name_lanka = destination_arguments_local[0];
            destination_url_lanka = destination_arguments_local[3];
            destination_description_lanka = destination_arguments_local[4];

            startActivity(new Intent(MainActivity.this,Intro_sri_lanka.class));

        } else if (id == R.id.explore_travel_destinations) {

            startActivity(new Intent(MainActivity.this,details_seeker_all_cities.class));

        } else if (id == R.id.weather) {

            startActivity(new Intent(MainActivity.this,General_weather_Activity.class));

        } else if (id == R.id.hotels) {

            String url_hotels = "https://booki.ng/2T6ozMF";

            Intent i_hotels = new Intent(Intent.ACTION_VIEW);
            i_hotels.setData(Uri.parse(url_hotels));
            startActivity(i_hotels);

        } else if (id == R.id.events) {

            String url = "https://www.event.lk/";

            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(url));
            startActivity(i);

        } else if (id == R.id.travelling_plans) {

            startActivity(new Intent(MainActivity.this,plans_all_cities.class));

        } else if (id == R.id.todo_list) {

            startActivity(new Intent(MainActivity.this,TaskHome.class));

        } else if (id == R.id.favourite_places) {

            startActivity(new Intent(MainActivity.this, TaskHome_favourite.class));

        } else if (id == R.id.Help) {

            startActivity(new Intent(MainActivity.this, help.class));

        } else if (id == R.id.about_the_app) {

            startActivity(new Intent(MainActivity.this, about_app.class));

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        //drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
