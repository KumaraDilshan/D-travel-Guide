package com.example.gerrie.myapplication;

import android.app.Fragment;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.LevelListDrawable;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MapStyleOptions;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnSuccessListener;

/**
 * Created by Gerrie on 10/12/2018.
 */

public class MapsActivities extends Fragment implements OnMapReadyCallback {

    private Button fit_button;
    private Button filter_map_main_button;
    private FusedLocationProviderClient client;

    public static String destination_name;
    public static String destination_latitude;
    public static String destination_longitude;
    public static String destination_url;
    public static String destination_description;

    private Marker marker_jaffna;
    private Marker marker_anuradhapura;
    private Marker marker_kandy;
    private Marker marker_galle;

    private Marker marker_Mannar;
    private Marker marker_Trincomalee;
    private Marker marker_Dambulla;
    private Marker marker_Baticaloa;
    private Marker marker_Colombo;
    private Marker marker_Mathale;
    private Marker marker_Mathara;
    private Marker marker_Nuwaraeliya;
    private Marker marker_Badulla;
    private Marker marker_Vilpattu;
    private Marker marker_Yala;
    private Marker marker_Kegalle;
    private Marker marker_Rathnapura;
    private Marker marker_Haputhale;
    private Marker marker_Ella;
    private Marker marker_Bandarawela;
    private Marker marker_Katharagama;
    private Marker marker_Polonnaruwa;
    private Marker marker_Dehiwala_Mount_Laviniya;
    private Marker marker_Kalmunai;
    private Marker marker_Dambadeniya;
    private Marker marker_Udawalawe;
    private Marker marker_Hatton;
    private Marker marker_Mineriya;
    private Marker marker_puttalam;
    private Marker marker_mahiyganaya;
    private Marker marker_aru_gam_bay;
    private Marker marker_hambantota;
    private Marker marker_kaluthara;

    private Marker marker_nagadeepa;
    private Marker marker_nallur;
    private Marker marker_kadurugoda;
    private Marker marker_dambakolapatuna;
    private Marker marker_nilavaraiWell;
    private Marker marker_kasurinabeach;
    private Marker marker_fortjaffna;
    private Marker marker_kks;
    private Marker marker_keeramale;
    private Marker marker_kyts;
    private Marker marker_delphtIsland;
    private Marker marker_publiclibrary;
    private Marker marker_elephatpassmemorial;
    private Marker marker_pointpadro;

    private Marker marker_mihinthale;
    private Marker marker_jaya_sri_maha_bodhi;
    private Marker marker_ruwanwelisaya;
    private Marker marker_isurumuniya;
    private Marker marker_jethavanaramaya;
    private Marker marker_thuparamaya;
    private Marker marker_abayagiri;
    private Marker marker_lovamahapaya;
    private Marker marker_kuttampokuna;
    private Marker marker_ranmasuuyana;
    private Marker marker_nuwarawewa;
    private Marker marker_thisawewa;

    private Marker marker_temple_of_tooth;
    private Marker marker_pinnawala;
    private Marker marker_kandy_lake;
    private Marker marker_hulu;
    private Marker marker_knuckles;
    private Marker marker_bahirawakanda;
    private Marker marker_gardden_peradeniya;
    private Marker marker_hanthana;
    private Marker marker_udawaththakele;
    private Marker marker_ambakke;
    private Marker marker_lankathilaka;

    private Marker marker_unawatuna;
    private Marker marker_gungle_beach;
    private Marker marker_galle_fort;
    private Marker marker_hikkaduwa;
    private Marker marker_kaneliya;
    private Marker marker_mirissa;
    private Marker marker_galle_lighthouse;
    private Marker marker_dutch_church_galle;


    @Nullable

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.frag_map, container, false);
        fit_button=(Button) view.findViewById (R.id.fit_map);
        filter_map_main_button=(Button) view.findViewById (R.id.filter_map_main);
        //return inflater.inflate(R.layout.frag_map, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        try {
            MapFragment mapFragment1 = (MapFragment) getFragmentManager().findFragmentById(R.id.map100);
            mapFragment1.getMapAsync(this);
        } catch (NullPointerException e) {
            MapFragment mapFragment2 = (MapFragment) getChildFragmentManager().findFragmentById(R.id.map100);
            mapFragment2.getMapAsync(this);
        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

        final GoogleMap googleMap1=googleMap;

        getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        //styled map
        googleMap.setMapStyle(new MapStyleOptions(getResources().getString(R.string.style_json)));

        //current location
        if (!(ActivityCompat.checkSelfPermission(getActivity().getApplicationContext(), android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getActivity().getApplicationContext(), android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED)) {
            googleMap.setMyLocationEnabled(true);
        }

        //Contole the features
        googleMap.getUiSettings().setZoomControlsEnabled(true);
        googleMap.getUiSettings().setRotateGesturesEnabled(false);
        googleMap.getUiSettings().setScrollGesturesEnabled(true);
        googleMap.getUiSettings().setTiltGesturesEnabled(false);

        fit_map(googleMap);
        clean_map(googleMap);

        statusCheck();

        filter_map_main_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(),filter_maps_main.class));
            }
        });

        fit_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fit_map(googleMap1);
            }
        });

        googleMap.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
            @Override
            public void onInfoWindowClick(Marker marker) {

                if (marker.equals(marker_jaffna)) {

                    clean_map(googleMap1);

                    LatLng nagadeepa = new LatLng(9.612745, 79.774096);
                    marker_nagadeepa = googleMap1.addMarker(new MarkerOptions().position(nagadeepa).title("Nagadeepa Raja maha Viharaya").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));

                    LatLng nallur = new LatLng(9.674573, 80.029415);
                    marker_nallur = googleMap1.addMarker(new MarkerOptions().position(nallur).title("Nallur Kandaswamy Kovil").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));

                    LatLng kadurugoda = new LatLng(9.746810, 80.006695);
                    marker_kadurugoda = googleMap1.addMarker(new MarkerOptions().position(kadurugoda).title("Kadurugoda Ruins").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));

                    LatLng dambakolapatuna = new LatLng(9.7874099,79.94457);
                    marker_dambakolapatuna = googleMap1.addMarker(new MarkerOptions().position(dambakolapatuna).title("Dabakolapatuna- Sri Sangamiththa Viharaya").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));

                    LatLng nilavarai = new LatLng(9.754390, 80.088261);
                    marker_nilavaraiWell = googleMap1.addMarker(new MarkerOptions().position(nilavarai).title("Nilavarai Well").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));

                    LatLng casurina = new LatLng(9.763213, 79.887927);
                    marker_kasurinabeach = googleMap1.addMarker(new MarkerOptions().position(casurina).title("Casurina Beach").icon(BitmapDescriptorFactory.defaultMarker(33)));

                    LatLng fortjaffna = new LatLng(9.662031, 80.007878);
                    marker_fortjaffna = googleMap1.addMarker(new MarkerOptions().position(fortjaffna).title("Fort Jaffna").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));

                    LatLng kks = new LatLng(9.816119, 80.044789);
                    marker_kks = googleMap1.addMarker(new MarkerOptions().position(kks).title("Kankasanthurai").icon(BitmapDescriptorFactory.defaultMarker(33)));

                    LatLng keeramale = new LatLng(9.814898, 80.011243);
                    marker_keeramale = googleMap1.addMarker(new MarkerOptions().position(keeramale).title("Keerimalai Fresh water Spring").icon(BitmapDescriptorFactory.defaultMarker(33)));

                    LatLng kytes = new LatLng(9.652540, 79.908060);
                    marker_kyts = googleMap1.addMarker(new MarkerOptions().position(kytes).title("Kayts island").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));

                    LatLng delpht = new LatLng(9.5153026,79.6558134);
                    marker_delphtIsland = googleMap1.addMarker(new MarkerOptions().position(delpht).title("Delpht Island").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));

                    LatLng jaffna_library = new LatLng(9.662084, 80.011893);
                    marker_publiclibrary = googleMap1.addMarker(new MarkerOptions().position(jaffna_library).title("Public Library, Jaffna").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));

                    LatLng elephantpass_memorial = new LatLng(9.5237050,80.4070640);
                    marker_elephatpassmemorial = googleMap1.addMarker(new MarkerOptions().position(elephantpass_memorial).title("Elephant Pass War Memorial").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));

                    LatLng point_pedro = new LatLng(9.826881, 80.249676);
                    marker_pointpadro = googleMap1.addMarker(new MarkerOptions().position(point_pedro).title("Point Pedro").icon(BitmapDescriptorFactory.defaultMarker(33)));

                    googleMap1.moveCamera(CameraUpdateFactory.newLatLngZoom(fortjaffna, 9.1f));
                }

                if (marker.equals(marker_anuradhapura)){

                    clean_map(googleMap1);

                    LatLng mihinathale = new LatLng(8.350614,80.4879211);
                    marker_mihinthale = googleMap1.addMarker(new MarkerOptions().position(mihinathale).title("Mihinthale").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));

                    LatLng jaya_sri_maha_bodhi = new LatLng(8.344822, 80.397239);
                    marker_jaya_sri_maha_bodhi = googleMap1.addMarker(new MarkerOptions().position(jaya_sri_maha_bodhi).title("Jaya Sri Maha Bodhiya").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));

                    LatLng ruwanwelisaya = new LatLng(8.3499732,80.3942283);
                    marker_ruwanwelisaya = googleMap1.addMarker(new MarkerOptions().position(ruwanwelisaya).title("Ruwanwelisaya Dagaba").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));

                    LatLng isurumuniya = new LatLng(8.334576, 80.390256);
                    marker_isurumuniya = googleMap1.addMarker(new MarkerOptions().position(isurumuniya).title("Isurumuniya temple").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));

                    LatLng jethavanaramaya = new LatLng(8.351548, 80.403146);
                    marker_jethavanaramaya = googleMap1.addMarker(new MarkerOptions().position(jethavanaramaya).title("Jethavanaramaya temple").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));

                    LatLng thuparamaya = new LatLng(8.355365, 80.396467);
                    marker_thuparamaya = googleMap1.addMarker(new MarkerOptions().position(thuparamaya).title("Thuparamaya temple").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));

                    LatLng abayagiriya = new LatLng(8.370952, 80.395280);
                    marker_abayagiri = googleMap1.addMarker(new MarkerOptions().position(abayagiriya).title("Abhayagiriya temple").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));

                    LatLng lovahamahapaya = new LatLng(8.345933, 80.397969);
                    marker_lovamahapaya = googleMap1.addMarker(new MarkerOptions().position(lovahamahapaya).title("Lovamahapaya").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));

                    LatLng kuttampokuna = new LatLng(8.371205, 80.401631);
                    marker_kuttampokuna = googleMap1.addMarker(new MarkerOptions().position(kuttampokuna).title("Kuttam pokuna").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));

                    LatLng ranmasu_uyana = new LatLng(8.337299, 80.389820);
                    marker_ranmasuuyana = googleMap1.addMarker(new MarkerOptions().position(ranmasu_uyana).title("Ranmasu Uyana").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));

                    LatLng thisawewa = new LatLng(8.3352228,80.3755581);
                    marker_thisawewa = googleMap1.addMarker(new MarkerOptions().position(thisawewa).title("Thissa Wewa").icon(BitmapDescriptorFactory.defaultMarker(33)));

                    LatLng nuwarawewa = new LatLng(8.341082, 80.427075);
                    marker_nuwarawewa = googleMap1.addMarker(new MarkerOptions().position(nuwarawewa).title("Nuwara Wewa").icon(BitmapDescriptorFactory.defaultMarker(33)));

                    googleMap1.moveCamera(CameraUpdateFactory.newLatLngZoom(thuparamaya, 11.2f));
                }

                if (marker.equals(marker_kandy)) {

                    clean_map(googleMap1);

                    LatLng temple_of_tooth = new LatLng(7.293775, 80.640981);
                    marker_temple_of_tooth = googleMap1.addMarker(new MarkerOptions().position(temple_of_tooth).title("Temple of the Sacred Tooth Relic").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));

                    LatLng pinnawala = new LatLng(7.3009705,80.3849623);
                    marker_pinnawala = googleMap1.addMarker(new MarkerOptions().position(pinnawala).title("Pinnawala Elephant Orphanage").icon(BitmapDescriptorFactory.defaultMarker(33)));

                    LatLng kandy_lake = new LatLng(7.291205, 80.642056);
                    marker_kandy_lake = googleMap1.addMarker(new MarkerOptions().position(kandy_lake).title("Kandy Lake").icon(BitmapDescriptorFactory.defaultMarker(33)));

                    LatLng hulu = new LatLng(7.401192, 80.742098);
                    marker_hulu = googleMap1.addMarker(new MarkerOptions().position(hulu).title("Huluganga Ella Waterfall").icon(BitmapDescriptorFactory.defaultMarker(33)));

                    LatLng knuckles = new LatLng(7.442664, 80.780962);
                    marker_knuckles = googleMap1.addMarker(new MarkerOptions().position(knuckles).title("Knuckles mountain range").icon(BitmapDescriptorFactory.defaultMarker(33)));

                    LatLng bahirawakanda = new LatLng(7.291159, 80.629193);
                    marker_bahirawakanda = googleMap1.addMarker(new MarkerOptions().position(bahirawakanda).title("Bahirawakanda Temple").icon(BitmapDescriptorFactory.defaultMarker(33)));

                    LatLng pera_garden = new LatLng(7.268274, 80.596600);
                    marker_gardden_peradeniya = googleMap1.addMarker(new MarkerOptions().position(pera_garden).title("Royal Botanic Gardens- Peradeniya").icon(BitmapDescriptorFactory.defaultMarker(33)));

                    LatLng hanthana = new LatLng(7.256448, 80.628354);
                    marker_hanthana = googleMap1.addMarker(new MarkerOptions().position(hanthana).title("Hanthana Mountain").icon(BitmapDescriptorFactory.defaultMarker(33)));

                    LatLng udawatta_lake = new LatLng(7.298881, 80.642403);
                    marker_udawaththakele = googleMap1.addMarker(new MarkerOptions().position(udawatta_lake).title("Udawatta Kele Sanctuary").icon(BitmapDescriptorFactory.defaultMarker(33)));

                    LatLng ambakke = new LatLng(7.217946, 80.567719);
                    marker_ambakke = googleMap1.addMarker(new MarkerOptions().position(ambakke).title("Embekka Dewalaya").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));

                    LatLng lankathilaka = new LatLng(7.233871, 80.565041);
                    marker_lankathilaka = googleMap1.addMarker(new MarkerOptions().position(lankathilaka).title("Lankathilaka Temple").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));

                    googleMap1.moveCamera(CameraUpdateFactory.newLatLngZoom(pera_garden, 10.0f));
                }

                if (marker.equals(marker_galle)) {

                    clean_map(googleMap1);

                    LatLng unawatuna = new LatLng(6.009670, 80.248423);
                    marker_unawatuna = googleMap1.addMarker(new MarkerOptions().position(unawatuna).title("Unawatuna Beach").icon(BitmapDescriptorFactory.defaultMarker(33)));

                    LatLng gungle_beach = new LatLng(6.018492, 80.235362);
                    marker_gungle_beach = googleMap1.addMarker(new MarkerOptions().position(gungle_beach).title("Jungle Beach-Roomassala").icon(BitmapDescriptorFactory.defaultMarker(33)));

                    LatLng galle_fort = new LatLng(6.024766, 80.216736);
                    marker_galle_fort = googleMap1.addMarker(new MarkerOptions().position(galle_fort).title("Galle Dutch Fort").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));

                    LatLng hikkaduwa = new LatLng(6.138549, 80.099454);
                    marker_hikkaduwa = googleMap1.addMarker(new MarkerOptions().position(hikkaduwa).title("Hikkaduwa Beach").icon(BitmapDescriptorFactory.defaultMarker(33)));

                    LatLng kaneliya = new LatLng(6.250979, 80.337903);
                    marker_kaneliya = googleMap1.addMarker(new MarkerOptions().position(kaneliya).title("Kanneliya Rainforest").icon(BitmapDescriptorFactory.defaultMarker(33)));

                    LatLng mirissa = new LatLng(5.944472, 80.456293);
                    marker_mirissa = googleMap1.addMarker(new MarkerOptions().position(mirissa).title("Mirissa Beach").icon(BitmapDescriptorFactory.defaultMarker(33)));

                    LatLng galle_lighthouse = new LatLng(6.024736,80.2192564);
                    marker_galle_lighthouse = googleMap1.addMarker(new MarkerOptions().position(galle_lighthouse).title("Galle Lighthouse").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));

                    LatLng dutch_church = new LatLng(6.026428, 80.217851);
                    marker_dutch_church_galle = googleMap1.addMarker(new MarkerOptions().position(dutch_church).title("Dutch Church").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));

                    googleMap1.moveCamera(CameraUpdateFactory.newLatLngZoom(gungle_beach, 10.0f));
                }

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
                    destination_name = destination_arguments_local[0];
                    destination_latitude = destination_arguments_local[1];
                    destination_longitude = destination_arguments_local[2];
                    destination_url = destination_arguments_local[3];
                    destination_description = destination_arguments_local[4];
                    startActivity(new Intent(getActivity(),new3.class));
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

    public void clean_map(GoogleMap googleMap){
        googleMap.clear();

        LatLng jaffna = new LatLng(9.661302, 80.025513);
        marker_jaffna = googleMap.addMarker(new MarkerOptions().position(jaffna).title("Show destinations around Jaffna").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));

        LatLng anuradhapura = new LatLng(8.3161458,80.4110444);
        marker_anuradhapura = googleMap.addMarker(new MarkerOptions().position(anuradhapura).title("Show destinations around Anuradhapura").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));

        LatLng kandy = new LatLng(7.293146, 80.635009);
        marker_kandy = googleMap.addMarker(new MarkerOptions().position(kandy).title("Show destinations around Kandy").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));

        LatLng galle = new LatLng(6.032861, 80.214905);
        marker_galle = googleMap.addMarker(new MarkerOptions().position(galle).title("Show destinations around Galle").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));

        LatLng Mannar = new LatLng(8.975925, 79.916950);
        marker_Mannar = googleMap.addMarker(new MarkerOptions().position(Mannar).title("Show destinations around Mannar").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));

        LatLng Trincomalee = new LatLng(8.691855, 81.187516);
        marker_Trincomalee = googleMap.addMarker(new MarkerOptions().position(Trincomalee).title("Show destinations around Trincomalee").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));

        LatLng Dambulla = new LatLng(7.856690, 80.648371);
        marker_Dambulla = googleMap.addMarker(new MarkerOptions().position(Dambulla).title("Show destinations around Dambulla").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));

        LatLng Baticaloa = new LatLng(7.734394, 81.710566);
        marker_Baticaloa = googleMap.addMarker(new MarkerOptions().position(Baticaloa).title("Show destinations around Baticaloa").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));

        LatLng Colombo = new LatLng(6.925746, 79.843856);
        marker_Colombo = googleMap.addMarker(new MarkerOptions().position(Colombo).title("Show destinations around Colombo").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));

        LatLng Mathale = new LatLng(7.467925, 80.624421);
        marker_Mathale = googleMap.addMarker(new MarkerOptions().position(Mathale).title("Show destinations around Mathale").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));

        LatLng Mathara = new LatLng(5.936257, 80.526049);
        marker_Mathara = googleMap.addMarker(new MarkerOptions().position(Mathara).title("Show destinations around Mathara").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));

        LatLng Nuwaraeliya = new LatLng(6.953388, 80.780461);
        marker_Nuwaraeliya = googleMap.addMarker(new MarkerOptions().position(Nuwaraeliya).title("Show destinations around Nuwaraeliya").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));

        LatLng Badulla = new LatLng(7.007942, 80.996316);
        marker_Badulla = googleMap.addMarker(new MarkerOptions().position(Badulla).title("Show destinations around Badulla").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));

        LatLng Vilpattu = new LatLng(8.471469, 80.038066);
        marker_Vilpattu = googleMap.addMarker(new MarkerOptions().position(Vilpattu).title("Show destinations around Wilpattu").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));

        LatLng Yala = new LatLng(6.454331, 81.563043);
        marker_Yala = googleMap.addMarker(new MarkerOptions().position(Yala).title("Show destinations around Yala").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));

        LatLng Rathnapura = new LatLng(6.705051, 80.401997);
        marker_Rathnapura = googleMap.addMarker(new MarkerOptions().position(Rathnapura).title("Show destinations around Rathnapura").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));

        LatLng Haputhale = new LatLng(6.764675, 80.952182);
        marker_Haputhale = googleMap.addMarker(new MarkerOptions().position(Haputhale).title("Show destinations around Haputhale").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));

        LatLng Ella = new LatLng(6.855977, 81.052540);
        marker_Ella = googleMap.addMarker(new MarkerOptions().position(Ella).title("Show destinations around Ella").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));

        LatLng Bandarawela = new LatLng(6.825206, 80.997043);
        marker_Bandarawela = googleMap.addMarker(new MarkerOptions().position(Bandarawela).title("Show destinations around Bandarawela").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));

        LatLng Katharagama = new LatLng(6.4239815,81.3317629);
        marker_Katharagama = googleMap.addMarker(new MarkerOptions().position(Katharagama).title("Show destinations around Katharagama").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));

        LatLng Polonnaruwa = new LatLng(7.966057, 81.004949);
        marker_Polonnaruwa = googleMap.addMarker(new MarkerOptions().position(Polonnaruwa).title("Show destinations around Polonnaruwa").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));

        LatLng Dehiwala_Mount_Laviniya = new LatLng(6.841759, 79.862408);
        marker_Dehiwala_Mount_Laviniya = googleMap.addMarker(new MarkerOptions().position(Dehiwala_Mount_Laviniya).title("Show destinations around Dehiwala-Mount Laviniya").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));

        LatLng Kalmunai = new LatLng(7.412398, 81.839439);
        marker_Kalmunai = googleMap.addMarker(new MarkerOptions().position(Kalmunai).title("Show destinations around Kalmunai").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));

        LatLng Dambadeniya = new LatLng(7.364618, 80.151100);
        marker_Dambadeniya = googleMap.addMarker(new MarkerOptions().position(Dambadeniya).title("Show destinations around Dambadeniya").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));

        LatLng Udawalawe = new LatLng(6.474678, 80.898858);
        marker_Udawalawe = googleMap.addMarker(new MarkerOptions().position(Udawalawe).title("Show destinations around Udawalawe").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));

        LatLng Hatton = new LatLng(6.900651, 80.574213);
        marker_Hatton = googleMap.addMarker(new MarkerOptions().position(Hatton).title("Show destinations around Hatton").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));

        LatLng Mineriya = new LatLng(8.027568, 80.870608);
        marker_Mineriya = googleMap.addMarker(new MarkerOptions().position(Mineriya).title("Show destinations around Mineriya").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));

        LatLng Kegalle = new LatLng(7.251289, 80.346200);
        marker_Kegalle = googleMap.addMarker(new MarkerOptions().position(Kegalle).title("Show destinations around Kegalle").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));

        LatLng puttalam = new LatLng(8.046413, 79.814102);
        marker_puttalam = googleMap.addMarker(new MarkerOptions().position(puttalam).title("Show destinations around Puttalam").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));

        LatLng mahiyganaya = new LatLng(7.413572, 81.108368);
        marker_mahiyganaya = googleMap.addMarker(new MarkerOptions().position(mahiyganaya).title("Show destinations around Mahiyganaya").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));

        LatLng aru_gam_bay = new LatLng(6.843691, 81.827518);
        marker_aru_gam_bay = googleMap.addMarker(new MarkerOptions().position(aru_gam_bay).title("Show destinations around Arugambay").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));

        LatLng hambantota = new LatLng(6.142345, 81.121124);
        marker_hambantota = googleMap.addMarker(new MarkerOptions().position(hambantota).title("Show destinations around Hambantota").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));

        LatLng kaluthara = new LatLng(6.587062, 79.959486);
        marker_kaluthara = googleMap.addMarker(new MarkerOptions().position(kaluthara).title("Show destinations around kalutara").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));
    }

    public void statusCheck() {
        final LocationManager manager = (LocationManager) getActivity().getSystemService(Context.LOCATION_SERVICE);

        if (!manager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
            buildAlertMessageNoGps();
        }
    }

    private void buildAlertMessageNoGps() {

        android.app.AlertDialog.Builder alertDialog = new android.app.AlertDialog.Builder(getActivity());
        alertDialog.setTitle("Turn location services on");
        alertDialog.setMessage("Your GPS seems to be disabled, do you want to enable it?")
                .setPositiveButton("No",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        })

                .setNegativeButton("Yes",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                startActivity(new Intent(android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS));
                            }
                        });

        alertDialog.show();
    }

    public Bitmap resizeMapIcons(String iconName,int width, int height){
        Bitmap imageBitmap = BitmapFactory.decodeResource(getResources(),getResources().getIdentifier(iconName, "drawable", getActivity().getPackageName()));
        Bitmap resizedBitmap = Bitmap.createScaledBitmap(imageBitmap, width, height, false);
        return resizedBitmap;
    }
}
