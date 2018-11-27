package com.example.gerrie.myapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MapStyleOptions;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity_main extends FragmentActivity implements OnMapReadyCallback {

    private static GoogleMap mMap;
    private Button fit_button_main;

    public static String destination_name_main;
    public static String destination_latitude_main;
    public static String destination_longitude_main;
    public static String destination_url_main;
    public static String destination_description_main;

    private static Marker marker_nagadeepa;
    private static Marker marker_nallur;
    private static Marker marker_kadurugoda;
    private static Marker marker_dambakolapatuna;
    private static Marker marker_nilavaraiWell;
    private static Marker marker_kasurinabeach;
    private static Marker marker_fortjaffna;
    private static Marker marker_kks;
    private static Marker marker_kyts;
    private static Marker marker_keeramale;
    private static Marker marker_delphtIsland;
    private static Marker marker_publiclibrary;
    private static Marker marker_elephatpassmemorial;
    private static Marker marker_pointpadro;

    private static Marker marker_mihinthale;
    private static Marker marker_jaya_sri_maha_bodhi;
    private static Marker marker_ruwanwelisaya;
    private static Marker marker_isurumuniya;
    private static Marker marker_jethavanaramaya;
    private static Marker marker_thuparamaya;
    private static Marker marker_abayagiri;
    private static Marker marker_lovamahapaya;
    private static Marker marker_kuttampokuna;
    private static Marker marker_ranmasuuyana;
    private static Marker marker_nuwarawewa;
    private static Marker marker_thisawewa;

    private static Marker marker_temple_of_tooth;
    private static Marker marker_pinnawala;
    private static Marker marker_kandy_lake;
    private static Marker marker_hulu;
    private static Marker marker_knuckles;
    private static Marker marker_bahirawakanda;
    private static Marker marker_gardden_peradeniya;
    private static Marker marker_hanthana;
    private static Marker marker_udawaththakele;
    private static Marker marker_ambakke;
    private static Marker marker_lankathilaka;

    private static Marker marker_unawatuna;
    private static Marker marker_gungle_beach;
    private static Marker marker_galle_fort;
    private static Marker marker_hikkaduwa;
    private static Marker marker_kaneliya;
    private static Marker marker_mirissa;
    private static Marker marker_galle_lighthouse;
    private static Marker marker_dutch_church_galle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps_main);

        fit_button_main=(Button) findViewById (R.id.fit_map_main);
        //Check=(Button) findViewById (R.id.check);

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map_main);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {

        final GoogleMap googleMap1=googleMap;
        mMap=googleMap;

        //styled map
        googleMap.setMapStyle(new MapStyleOptions(getResources().getString(R.string.style_json)));

        //Contole the features
        googleMap.getUiSettings().setZoomControlsEnabled(true);
        googleMap.getUiSettings().setRotateGesturesEnabled(false);
        googleMap.getUiSettings().setScrollGesturesEnabled(true);
        googleMap.getUiSettings().setTiltGesturesEnabled(false);

        fit_map(googleMap);

        fit_button_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fit_map(googleMap1);
            }
        });

        /*Check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toast(Long.toString(filter_nearby_maps.Nearby_filter_spinner.getSelectedItemId()));
            }
        });*/

        setup_map();

        googleMap.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
            @Override
            public void onInfoWindowClick(Marker marker) {

                final Destination_arguments destination_arguments_facts = new Destination_arguments();
                String[] destination_arguments_local=new String[]{" "};

                if (marker.equals(marker_nagadeepa)) {
                    destination_arguments_local= destination_arguments_facts.destination_arguments("nagadeepaya");
                }if (marker.equals(marker_nallur)) {
                    destination_arguments_local= destination_arguments_facts.destination_arguments("nallur");
                }if (marker.equals(marker_kadurugoda)) {
                    destination_arguments_local= destination_arguments_facts.destination_arguments("kadurugoda");
                }if (marker.equals(marker_dambakolapatuna)) {
                    destination_arguments_local= destination_arguments_facts.destination_arguments("dambakolapatuna");
                }if (marker.equals(marker_nilavaraiWell)) {
                    destination_arguments_local= destination_arguments_facts.destination_arguments("nilavarai");
                }if (marker.equals(marker_kasurinabeach)) {
                    destination_arguments_local= destination_arguments_facts.destination_arguments("casurina");
                }if (marker.equals(marker_fortjaffna)) {
                    destination_arguments_local = destination_arguments_facts.destination_arguments("fortjaffna");
                }if (marker.equals(marker_kks)) {
                    destination_arguments_local= destination_arguments_facts.destination_arguments("kks");
                }if (marker.equals(marker_keeramale)) {
                    destination_arguments_local= destination_arguments_facts.destination_arguments("keeramale");
                }if (marker.equals(marker_kyts)) {
                    destination_arguments_local= destination_arguments_facts.destination_arguments("kytes");
                }if (marker.equals(marker_delphtIsland)) {
                    destination_arguments_local= destination_arguments_facts.destination_arguments("delpht");
                }if (marker.equals(marker_publiclibrary)) {
                    destination_arguments_local= destination_arguments_facts.destination_arguments("jaffna_library");
                }if (marker.equals(marker_elephatpassmemorial)) {
                    destination_arguments_local= destination_arguments_facts.destination_arguments("elephantpass_memorial");
                }if (marker.equals(marker_pointpadro)) {
                    destination_arguments_local= destination_arguments_facts.destination_arguments("point_pedro");
                }

                if (marker.equals(marker_mihinthale)) {
                    destination_arguments_local= destination_arguments_facts.destination_arguments("mihinathale");
                }if (marker.equals(marker_jaya_sri_maha_bodhi)) {
                    destination_arguments_local= destination_arguments_facts.destination_arguments("jaya_sri_maha_bodhi");
                }if (marker.equals(marker_ruwanwelisaya)) {
                    destination_arguments_local= destination_arguments_facts.destination_arguments("ruwanwelisaya");
                }if (marker.equals(marker_isurumuniya)) {
                    destination_arguments_local= destination_arguments_facts.destination_arguments("isurumuniya");
                }if (marker.equals(marker_jethavanaramaya)) {
                    destination_arguments_local= destination_arguments_facts.destination_arguments("jethavanaramaya");
                }if (marker.equals(marker_thuparamaya)) {
                    destination_arguments_local= destination_arguments_facts.destination_arguments("thuparamaya");
                }if (marker.equals(marker_abayagiri)) {
                    destination_arguments_local= destination_arguments_facts.destination_arguments("abayagiriya");
                }if (marker.equals(marker_lovamahapaya)) {
                    destination_arguments_local= destination_arguments_facts.destination_arguments("lovahamahapaya");
                }if (marker.equals(marker_kuttampokuna)) {
                    destination_arguments_local= destination_arguments_facts.destination_arguments("kuttampokuna");
                }if (marker.equals(marker_ranmasuuyana)) {
                    destination_arguments_local= destination_arguments_facts.destination_arguments("ranmasu_uyana");
                }if (marker.equals(marker_thisawewa)) {
                    destination_arguments_local= destination_arguments_facts.destination_arguments("thisawewa");
                }if (marker.equals(marker_nuwarawewa)) {
                    destination_arguments_local= destination_arguments_facts.destination_arguments("nuwarawewa");
                }

                if (marker.equals(marker_temple_of_tooth)) {
                    destination_arguments_local= destination_arguments_facts.destination_arguments("temple_of_tooth");
                }if (marker.equals(marker_pinnawala)) {
                    destination_arguments_local= destination_arguments_facts.destination_arguments("pinnawala");
                }if (marker.equals(marker_kandy_lake)) {
                    destination_arguments_local= destination_arguments_facts.destination_arguments("kandy_lake");
                }if (marker.equals(marker_hulu)) {
                    destination_arguments_local= destination_arguments_facts.destination_arguments("hulu");
                }if (marker.equals(marker_knuckles)) {
                    destination_arguments_local= destination_arguments_facts.destination_arguments("knuckles");
                }if (marker.equals(marker_bahirawakanda)) {
                    destination_arguments_local= destination_arguments_facts.destination_arguments("bahirawakanda");
                }if (marker.equals(marker_gardden_peradeniya)) {
                    destination_arguments_local= destination_arguments_facts.destination_arguments("pera_garden");
                }if (marker.equals(marker_hanthana)) {
                    destination_arguments_local= destination_arguments_facts.destination_arguments("hanthana");
                }if (marker.equals(marker_udawaththakele)) {
                    destination_arguments_local= destination_arguments_facts.destination_arguments("udawatta_lake");
                }if (marker.equals(marker_ambakke)) {
                    destination_arguments_local= destination_arguments_facts.destination_arguments("ambakke");
                }if (marker.equals(marker_lankathilaka)) {
                    destination_arguments_local= destination_arguments_facts.destination_arguments("lankathilaka");
                }

                if (marker.equals(marker_unawatuna)) {
                    destination_arguments_local= destination_arguments_facts.destination_arguments("unawatuna");
                }if (marker.equals(marker_gungle_beach)) {
                    destination_arguments_local= destination_arguments_facts.destination_arguments("gungle_beach");
                }if (marker.equals(marker_galle_fort)) {
                    destination_arguments_local= destination_arguments_facts.destination_arguments("galle_fort");
                }if (marker.equals(marker_hikkaduwa)) {
                    destination_arguments_local= destination_arguments_facts.destination_arguments("hikkaduwa");
                }if (marker.equals(marker_kaneliya)) {
                    destination_arguments_local= destination_arguments_facts.destination_arguments("kaneliya");
                }if (marker.equals(marker_mirissa)) {
                    destination_arguments_local= destination_arguments_facts.destination_arguments("mirissa");
                }if (marker.equals(marker_galle_lighthouse)) {
                    destination_arguments_local= destination_arguments_facts.destination_arguments("galle_lighthouse");
                }if (marker.equals(marker_dutch_church_galle)) {
                    destination_arguments_local= destination_arguments_facts.destination_arguments("dutch_church");
                }

                try {
                    destination_name_main = destination_arguments_local[0];
                    destination_latitude_main = destination_arguments_local[1];
                    destination_longitude_main = destination_arguments_local[2];
                    destination_url_main = destination_arguments_local[3];
                    destination_description_main = destination_arguments_local[4];

                    startActivity(new Intent(MapsActivity_main.this,Details_of_places_main.class));
                }
                catch(ArrayIndexOutOfBoundsException exception) {

                }
            }
        });
    }

    public void fit_map(GoogleMap googleMap){
        //Limit the map area
        LatLng one = new LatLng(10.192759, 79.315157);
        LatLng two = new LatLng(5.766603, 82.141730);

        LatLngBounds.Builder builder = new LatLngBounds.Builder();

        builder.include(one);
        builder.include(two);

        LatLngBounds bounds = builder.build();

        int width = getResources().getDisplayMetrics().widthPixels;
        int height = getResources().getDisplayMetrics().heightPixels;


        int padding =0;

        googleMap.setLatLngBoundsForCameraTarget(bounds);

        //move camera to fill the bound to screen
        googleMap.moveCamera(CameraUpdateFactory.newLatLngBounds(bounds, width, height, padding));

        //set zoom to level to current so that you won't be able to zoom out viz. move outside bounds
        googleMap.setMinZoomPreference(googleMap.getCameraPosition().zoom);
    }

    public static void setup_map(){
        mMap.clear();
        long destination_type_id;
        long destination_city_id;

        destination_type_id=filter_maps_main.Main_filter_type.getSelectedItemId();
        destination_city_id=filter_maps_main.Main_filter_city.getSelectedItemId();

        if(destination_city_id==1){

            LatLng fortjaffna = new LatLng(9.662031, 80.007878);

            if (destination_type_id==0){
                LatLng nagadeepa = new LatLng(9.612745, 79.774096);
                marker_nagadeepa = mMap.addMarker(new MarkerOptions().position(nagadeepa).title("Nagadeepa Raja maha Viharaya").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));

                LatLng nallur = new LatLng(9.674573, 80.029415);
                marker_nallur = mMap.addMarker(new MarkerOptions().position(nallur).title("Nallur Kandaswamy Kovil").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));

                LatLng kadurugoda = new LatLng(9.746810, 80.006695);
                marker_kadurugoda = mMap.addMarker(new MarkerOptions().position(kadurugoda).title("Kadurugoda Ruins").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));

                LatLng dambakolapatuna = new LatLng(9.7874099,79.94457);
                marker_dambakolapatuna = mMap.addMarker(new MarkerOptions().position(dambakolapatuna).title("Dabakolapatuna- Sri Sangamiththa Viharaya").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));

                LatLng nilavarai = new LatLng(9.754390, 80.088261);
                marker_nilavaraiWell = mMap.addMarker(new MarkerOptions().position(nilavarai).title("Nilavarai Well").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));

                LatLng casurina = new LatLng(9.763213, 79.887927);
                marker_kasurinabeach = mMap.addMarker(new MarkerOptions().position(casurina).title("Casurina Beach").icon(BitmapDescriptorFactory.defaultMarker(33)));

                marker_fortjaffna = mMap.addMarker(new MarkerOptions().position(fortjaffna).title("Fort Jaffna").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));

                LatLng kks = new LatLng(9.816119, 80.044789);
                marker_kks = mMap.addMarker(new MarkerOptions().position(kks).title("Kankasanthurai").icon(BitmapDescriptorFactory.defaultMarker(33)));

                LatLng keeramale = new LatLng(9.814898, 80.011243);
                marker_keeramale = mMap.addMarker(new MarkerOptions().position(keeramale).title("Keerimalai Fresh water Spring").icon(BitmapDescriptorFactory.defaultMarker(33)));

                LatLng kytes = new LatLng(9.652540, 79.908060);
                marker_kyts = mMap.addMarker(new MarkerOptions().position(kytes).title("Kayts").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));

                LatLng delpht = new LatLng(9.5153026,79.6558134);
                marker_delphtIsland = mMap.addMarker(new MarkerOptions().position(delpht).title("Delpht Island").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));

                LatLng jaffna_library = new LatLng(9.662084, 80.011893);
                marker_publiclibrary = mMap.addMarker(new MarkerOptions().position(jaffna_library).title("Public Library, Jaffna").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));

                LatLng elephantpass_memorial = new LatLng(9.5237050,80.4070640);
                marker_elephatpassmemorial = mMap.addMarker(new MarkerOptions().position(elephantpass_memorial).title("Elephant Pass War Memorial").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));

                LatLng point_pedro = new LatLng(9.826881, 80.249676);
                marker_pointpadro = mMap.addMarker(new MarkerOptions().position(point_pedro).title("Point Pedro").icon(BitmapDescriptorFactory.defaultMarker(33)));

            }else if(destination_type_id==1){

                LatLng nagadeepa = new LatLng(9.612745, 79.774096);
                marker_nagadeepa = mMap.addMarker(new MarkerOptions().position(nagadeepa).title("Nagadeepa Raja maha Viharaya").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));

                LatLng nallur = new LatLng(9.674573, 80.029415);
                marker_nallur = mMap.addMarker(new MarkerOptions().position(nallur).title("Nallur Kandaswamy Kovil").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));

                LatLng kadurugoda = new LatLng(9.746810, 80.006695);
                marker_kadurugoda = mMap.addMarker(new MarkerOptions().position(kadurugoda).title("Kadurugoda Ruins").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));

                LatLng dambakolapatuna = new LatLng(9.7874099,79.94457);
                marker_dambakolapatuna = mMap.addMarker(new MarkerOptions().position(dambakolapatuna).title("Dabakolapatuna- Sri Sangamiththa Viharaya").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));

            }else if(destination_type_id==2){

                marker_fortjaffna = mMap.addMarker(new MarkerOptions().position(fortjaffna).title("Fort Jaffna").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));

                LatLng kytes = new LatLng(9.816119, 80.044789);
                marker_kyts = mMap.addMarker(new MarkerOptions().position(kytes).title("Kayts").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));

                LatLng delpht = new LatLng(9.5153026,79.6558134);
                marker_delphtIsland = mMap.addMarker(new MarkerOptions().position(delpht).title("Delpht Island").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));

                LatLng jaffna_library = new LatLng(9.662084, 80.011893);
                marker_publiclibrary = mMap.addMarker(new MarkerOptions().position(jaffna_library).title("Public Library, Jaffna").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));

                LatLng elephantpass_memorial = new LatLng(9.5237050,80.4070640);
                marker_elephatpassmemorial = mMap.addMarker(new MarkerOptions().position(elephantpass_memorial).title("Elephant Pass War Memorial").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));

            }else if(destination_type_id==3){

                LatLng casurina = new LatLng(9.763213, 79.887927);
                marker_kasurinabeach = mMap.addMarker(new MarkerOptions().position(casurina).title("Casurina Beach").icon(BitmapDescriptorFactory.defaultMarker(33)));

                LatLng kks = new LatLng(9.816119, 80.044789);
                marker_kks = mMap.addMarker(new MarkerOptions().position(kks).title("Kankasanthurai").icon(BitmapDescriptorFactory.defaultMarker(33)));

                LatLng point_pedro = new LatLng(9.826881, 80.249676);
                marker_pointpadro = mMap.addMarker(new MarkerOptions().position(point_pedro).title("Point Pedro").icon(BitmapDescriptorFactory.defaultMarker(33)));

                LatLng keeramale = new LatLng(9.814898, 80.011243);
                marker_keeramale = mMap.addMarker(new MarkerOptions().position(keeramale).title("Keerimalai Fresh water Spring").icon(BitmapDescriptorFactory.defaultMarker(33)));

            }

            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(fortjaffna, 9.1f));

        } else if(destination_city_id==2){

            LatLng thuparamaya = new LatLng(8.355365, 80.396467);

            if (destination_type_id==0){

                LatLng mihinathale = new LatLng(8.350614,80.4879211);
                marker_mihinthale = mMap.addMarker(new MarkerOptions().position(mihinathale).title("Mihinthale").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));

                LatLng jaya_sri_maha_bodhi = new LatLng(8.344822, 80.397239);
                marker_jaya_sri_maha_bodhi = mMap.addMarker(new MarkerOptions().position(jaya_sri_maha_bodhi).title("Jaya Sri Maha Bodhiya").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));

                LatLng ruwanwelisaya = new LatLng(8.3499732,80.3942283);
                marker_ruwanwelisaya = mMap.addMarker(new MarkerOptions().position(ruwanwelisaya).title("Ruwanwelisaya Dagaba").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));

                LatLng isurumuniya = new LatLng(8.334576, 80.390256);
                marker_isurumuniya = mMap.addMarker(new MarkerOptions().position(isurumuniya).title("Isurumuniya temple").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));

                LatLng jethavanaramaya = new LatLng(8.351548, 80.403146);
                marker_jethavanaramaya = mMap.addMarker(new MarkerOptions().position(jethavanaramaya).title("Jethavanaramaya temple").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));

                marker_thuparamaya = mMap.addMarker(new MarkerOptions().position(thuparamaya).title("Thuparamaya temple").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));

                LatLng abayagiriya = new LatLng(8.370952, 80.395280);
                marker_abayagiri = mMap.addMarker(new MarkerOptions().position(abayagiriya).title("Abhayagiriya temple").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));

                LatLng lovahamahapaya = new LatLng(8.345933, 80.397969);
                marker_lovamahapaya = mMap.addMarker(new MarkerOptions().position(lovahamahapaya).title("Lovamahapaya").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));

                LatLng kuttampokuna = new LatLng(8.371205, 80.401631);
                marker_kuttampokuna = mMap.addMarker(new MarkerOptions().position(kuttampokuna).title("Kuttam pokuna").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));

                LatLng ranmasu_uyana = new LatLng(8.337299, 80.389820);
                marker_ranmasuuyana = mMap.addMarker(new MarkerOptions().position(ranmasu_uyana).title("Ranmasu Uyana").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));

                LatLng thisawewa = new LatLng(8.3352228,80.3755581);
                marker_thisawewa = mMap.addMarker(new MarkerOptions().position(thisawewa).title("Thissa Wewa").icon(BitmapDescriptorFactory.defaultMarker(33)));

                LatLng nuwarawewa = new LatLng(8.341082, 80.427075);
                marker_nuwarawewa = mMap.addMarker(new MarkerOptions().position(nuwarawewa).title("Nuwara Wewa").icon(BitmapDescriptorFactory.defaultMarker(33)));

            }else if(destination_type_id==1){
                LatLng mihinathale = new LatLng(8.350614,80.4879211);
                marker_mihinthale = mMap.addMarker(new MarkerOptions().position(mihinathale).title("Mihinthale").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));

                LatLng jaya_sri_maha_bodhi = new LatLng(8.344822, 80.397239);
                marker_jaya_sri_maha_bodhi = mMap.addMarker(new MarkerOptions().position(jaya_sri_maha_bodhi).title("Jaya Sri Maha Bodhiya").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));

                LatLng ruwanwelisaya = new LatLng(8.3499732,80.3942283);
                marker_ruwanwelisaya = mMap.addMarker(new MarkerOptions().position(ruwanwelisaya).title("Ruwanwelisaya Dagaba").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));

                LatLng isurumuniya = new LatLng(8.334576, 80.390256);
                marker_isurumuniya = mMap.addMarker(new MarkerOptions().position(isurumuniya).title("Isurumuniya temple").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));

                LatLng jethavanaramaya = new LatLng(8.351548, 80.403146);
                marker_jethavanaramaya = mMap.addMarker(new MarkerOptions().position(jethavanaramaya).title("Jethavanaramaya temple").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));

                marker_thuparamaya = mMap.addMarker(new MarkerOptions().position(thuparamaya).title("Thuparamaya temple").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));

                LatLng abayagiriya = new LatLng(8.370952, 80.395280);
                marker_abayagiri = mMap.addMarker(new MarkerOptions().position(abayagiriya).title("Abhayagiriya temple").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));

            }else if(destination_type_id==2){

                LatLng lovahamahapaya = new LatLng(8.345933, 80.397969);
                marker_lovamahapaya = mMap.addMarker(new MarkerOptions().position(lovahamahapaya).title("Lovamahapaya").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));

                LatLng kuttampokuna = new LatLng(8.371205, 80.401631);
                marker_kuttampokuna = mMap.addMarker(new MarkerOptions().position(kuttampokuna).title("Kuttam pokuna").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));

                LatLng ranmasu_uyana = new LatLng(8.337299, 80.389820);
                marker_ranmasuuyana = mMap.addMarker(new MarkerOptions().position(ranmasu_uyana).title("Ranmasu Uyana").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));

            }else if(destination_type_id==3){

                LatLng thisawewa = new LatLng(8.3352228,80.3755581);
                marker_thisawewa = mMap.addMarker(new MarkerOptions().position(thisawewa).title("Thissa Wewa").icon(BitmapDescriptorFactory.defaultMarker(33)));

                LatLng nuwarawewa = new LatLng(8.341082, 80.427075);
                marker_nuwarawewa = mMap.addMarker(new MarkerOptions().position(nuwarawewa).title("Nuwara Wewa").icon(BitmapDescriptorFactory.defaultMarker(33)));

            }

            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(thuparamaya, 11.2f));

        } else if(destination_city_id==3){

            LatLng pera_garden = new LatLng(7.268274, 80.596600);

            if (destination_type_id==0){

                LatLng temple_of_tooth = new LatLng(7.293775, 80.640981);
                marker_temple_of_tooth = mMap.addMarker(new MarkerOptions().position(temple_of_tooth).title("Temple of the Sacred Tooth Relic").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));

                LatLng pinnawala = new LatLng(7.3009705,80.3849623);
                marker_pinnawala = mMap.addMarker(new MarkerOptions().position(pinnawala).title("Pinnawala Elephant Orphanage").icon(BitmapDescriptorFactory.defaultMarker(33)));

                LatLng kandy_lake = new LatLng(7.291205, 80.642056);
                marker_kandy_lake = mMap.addMarker(new MarkerOptions().position(kandy_lake).title("Kandy Lake").icon(BitmapDescriptorFactory.defaultMarker(33)));

                LatLng hulu = new LatLng(7.401192, 80.742098);
                marker_hulu = mMap.addMarker(new MarkerOptions().position(hulu).title("Huluganga Ella Waterfall").icon(BitmapDescriptorFactory.defaultMarker(33)));

                LatLng knuckles = new LatLng(7.442664, 80.780962);
                marker_knuckles = mMap.addMarker(new MarkerOptions().position(knuckles).title("Knuckles mountain range").icon(BitmapDescriptorFactory.defaultMarker(33)));

                LatLng bahirawakanda = new LatLng(7.291159, 80.629193);
                marker_bahirawakanda = mMap.addMarker(new MarkerOptions().position(bahirawakanda).title("Bahirawakanda Temple").icon(BitmapDescriptorFactory.defaultMarker(33)));

                marker_gardden_peradeniya = mMap.addMarker(new MarkerOptions().position(pera_garden).title("Royal Botanic Gardens- Peradeniya").icon(BitmapDescriptorFactory.defaultMarker(33)));

                LatLng hanthana = new LatLng(7.256448, 80.628354);
                marker_hanthana = mMap.addMarker(new MarkerOptions().position(hanthana).title("Hanthana Mountain").icon(BitmapDescriptorFactory.defaultMarker(33)));

                LatLng udawatta_lake = new LatLng(7.298881, 80.642403);
                marker_udawaththakele = mMap.addMarker(new MarkerOptions().position(udawatta_lake).title("Udawatta Kele Sanctuary").icon(BitmapDescriptorFactory.defaultMarker(33)));

                LatLng ambakke = new LatLng(7.217946, 80.567719);
                marker_ambakke = mMap.addMarker(new MarkerOptions().position(ambakke).title("Embekka Dewalaya").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));

                LatLng lankathilaka = new LatLng(7.233871, 80.565041);
                marker_lankathilaka = mMap.addMarker(new MarkerOptions().position(lankathilaka).title("Lankathilaka Temple").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));

            }else if(destination_type_id==1){

                LatLng temple_of_tooth = new LatLng(7.293775, 80.640981);
                marker_temple_of_tooth = mMap.addMarker(new MarkerOptions().position(temple_of_tooth).title("Temple of the Sacred Tooth Relic- Sri Daladha Maligawa").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));

                LatLng ambakke = new LatLng(7.217946, 80.567719);
                marker_ambakke = mMap.addMarker(new MarkerOptions().position(ambakke).title("Embekka Dewalaya").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));

                LatLng lankathilaka = new LatLng(7.233871, 80.565041);
                marker_lankathilaka = mMap.addMarker(new MarkerOptions().position(lankathilaka).title("Lankathilaka Temple").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));

            }else if(destination_type_id==2){


            }else if(destination_type_id==3){

                LatLng pinnawala = new LatLng(7.3009705,80.3849623);
                marker_pinnawala = mMap.addMarker(new MarkerOptions().position(pinnawala).title("Pinnawala Elephant Orphanage").icon(BitmapDescriptorFactory.defaultMarker(33)));

                LatLng kandy_lake = new LatLng(7.291205, 80.642056);
                marker_kandy_lake = mMap.addMarker(new MarkerOptions().position(kandy_lake).title("Kandy Lake").icon(BitmapDescriptorFactory.defaultMarker(33)));

                LatLng hulu = new LatLng(7.401192, 80.742098);
                marker_hulu = mMap.addMarker(new MarkerOptions().position(hulu).title("Huluganga Ella Waterfall").icon(BitmapDescriptorFactory.defaultMarker(33)));

                LatLng knuckles = new LatLng(7.442664, 80.780962);
                marker_knuckles = mMap.addMarker(new MarkerOptions().position(knuckles).title("Knuckles mountain range").icon(BitmapDescriptorFactory.defaultMarker(33)));

                LatLng bahirawakanda = new LatLng(7.291159, 80.629193);
                marker_bahirawakanda = mMap.addMarker(new MarkerOptions().position(bahirawakanda).title("Bahirawakanda Temple").icon(BitmapDescriptorFactory.defaultMarker(33)));

                marker_gardden_peradeniya = mMap.addMarker(new MarkerOptions().position(pera_garden).title("Royal Botanic Gardens- Peradeniya").icon(BitmapDescriptorFactory.defaultMarker(33)));

                LatLng hanthana = new LatLng(7.256448, 80.628354);
                marker_hanthana = mMap.addMarker(new MarkerOptions().position(hanthana).title("Hanthana Mountain").icon(BitmapDescriptorFactory.defaultMarker(33)));

                LatLng udawatta_lake = new LatLng(7.298881, 80.642403);
                marker_udawaththakele = mMap.addMarker(new MarkerOptions().position(udawatta_lake).title("Udawatta Kele Sanctuary").icon(BitmapDescriptorFactory.defaultMarker(33)));

            }

            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(pera_garden, 10.0f));

        } else if(destination_city_id==4){

            LatLng gungle_beach = new LatLng(6.018492, 80.235362);

            if (destination_type_id==0){

                LatLng unawatuna = new LatLng(6.009670, 80.248423);
                marker_unawatuna = mMap.addMarker(new MarkerOptions().position(unawatuna).title("Unawatuna Beach").icon(BitmapDescriptorFactory.defaultMarker(33)));

                marker_gungle_beach = mMap.addMarker(new MarkerOptions().position(gungle_beach).title("Jungle Beach-Roomassala").icon(BitmapDescriptorFactory.defaultMarker(33)));

                LatLng hikkaduwa = new LatLng(6.138549, 80.099454);
                marker_hikkaduwa = mMap.addMarker(new MarkerOptions().position(hikkaduwa).title("Hikkaduwa Beach").icon(BitmapDescriptorFactory.defaultMarker(33)));

                LatLng kaneliya = new LatLng(6.250979, 80.337903);
                marker_kaneliya = mMap.addMarker(new MarkerOptions().position(kaneliya).title("Kanneliya Rainforest").icon(BitmapDescriptorFactory.defaultMarker(33)));

                LatLng mirissa = new LatLng(5.944472, 80.456293);
                marker_mirissa = mMap.addMarker(new MarkerOptions().position(mirissa).title("Mirissa Beach").icon(BitmapDescriptorFactory.defaultMarker(33)));

                LatLng galle_lighthouse = new LatLng(6.024736,80.2192564);
                marker_galle_lighthouse = mMap.addMarker(new MarkerOptions().position(galle_lighthouse).title("Galle Lighthouse").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));

                LatLng galle_fort = new LatLng(6.024766, 80.216736);
                marker_galle_fort = mMap.addMarker(new MarkerOptions().position(galle_fort).title("Galle Dutch Fort").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));

                LatLng dutch_church = new LatLng(6.026428, 80.217851);
                marker_dutch_church_galle = mMap.addMarker(new MarkerOptions().position(dutch_church).title("Dutch Church").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));

            }else if(destination_type_id==1){

                LatLng dutch_church = new LatLng(6.026428, 80.217851);
                marker_dutch_church_galle = mMap.addMarker(new MarkerOptions().position(dutch_church).title("Dutch Church").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));

            }else if(destination_type_id==2){

                LatLng galle_lighthouse = new LatLng(6.024736,80.2192564);
                marker_galle_lighthouse = mMap.addMarker(new MarkerOptions().position(galle_lighthouse).title("Galle Lighthouse").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));

                LatLng galle_fort = new LatLng(6.024766, 80.216736);
                marker_galle_fort = mMap.addMarker(new MarkerOptions().position(galle_fort).title("Galle Dutch Fort").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));

            }else if(destination_type_id==3){

                LatLng unawatuna = new LatLng(6.009670, 80.248423);
                marker_unawatuna = mMap.addMarker(new MarkerOptions().position(unawatuna).title("Unawatuna Beach").icon(BitmapDescriptorFactory.defaultMarker(33)));

                marker_gungle_beach = mMap.addMarker(new MarkerOptions().position(gungle_beach).title("Jungle Beach").icon(BitmapDescriptorFactory.defaultMarker(33)));

                LatLng hikkaduwa = new LatLng(6.138549, 80.099454);
                marker_hikkaduwa = mMap.addMarker(new MarkerOptions().position(hikkaduwa).title("Hikkaduwa Beach").icon(BitmapDescriptorFactory.defaultMarker(33)));

                LatLng kaneliya = new LatLng(6.250979, 80.337903);
                marker_kaneliya = mMap.addMarker(new MarkerOptions().position(kaneliya).title("Kanneliya Rainforest").icon(BitmapDescriptorFactory.defaultMarker(33)));

                LatLng mirissa = new LatLng(5.944472, 80.456293);
                marker_mirissa = mMap.addMarker(new MarkerOptions().position(mirissa).title("Mirissa Beach").icon(BitmapDescriptorFactory.defaultMarker(33)));

            }
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(gungle_beach, 10.0f));
        }
    }

}
