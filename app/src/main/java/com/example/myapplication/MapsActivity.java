package com.example.myapplication;

import android.Manifest;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback
{
    public static final String PREFS_NAME = "MyPrefsFile";
    Location currentLocation;
    FusedLocationProviderClient fusedLocationProviderClient;
    private static final int REQUEST_CODE = 101;
    Button getDirection;
    private int trasa = 0;
    private MarkerOptions place2;
    private MarkerOptions markerOptions;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);
        SharedPreferences settings = getSharedPreferences(PREFS_NAME,0);
        trasa = settings.getInt("trasa",trasa);
        SharedPreferences.Editor editor = settings.edit();
        editor.putInt("trasa",trasa);
        editor.commit();
        Button btn_menu = (Button)findViewById(R.id.btn_menu);

        btn_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MapsActivity.this, Menu.class));
                finish();
            }
        });
        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);
        fetchLastLocation();


    }

    private void fetchLastLocation() {
        if (ActivityCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,new String[]{
                    Manifest.permission.ACCESS_FINE_LOCATION},REQUEST_CODE);

            return;

        }
        Task<Location> task = fusedLocationProviderClient.getLastLocation();
        task.addOnSuccessListener(new OnSuccessListener<Location>() {
            @Override
            public void onSuccess(Location location) {
                if(location != null){
                    currentLocation = location;
                    Toast.makeText(getApplicationContext(),currentLocation.getLatitude()+""+currentLocation.getLongitude(),Toast.LENGTH_SHORT).show();
                    SupportMapFragment supportMapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.google_map);
                    supportMapFragment.getMapAsync(MapsActivity.this);
                }
            }
        });
    }

    public static int getRandomInteger(int maximum, int minimum){
        return ((int) (Math.random()*(maximum - minimum))) + minimum;
    }



    @Override
    public void onMapReady(final GoogleMap googleMap) {
        LatLng latLng = new LatLng(currentLocation.getLatitude(),currentLocation.getLongitude());
         markerOptions = new MarkerOptions().position(latLng).title("Start");
        googleMap.animateCamera(CameraUpdateFactory.newLatLng(latLng));
        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng,15));
        googleMap.addMarker(markerOptions);
        int random = getRandomInteger(3,0);
        switch(random) {
            case 0:
                place2 = new MarkerOptions().position(new LatLng(latLng.latitude+0.005, latLng.longitude)).title("Cil");
                break;
            case 1:
                place2 = new MarkerOptions().position(new LatLng(latLng.latitude-0.005, latLng.longitude)).title("Cil");
                break;
            case 2:
                place2 = new MarkerOptions().position(new LatLng(latLng.latitude, latLng.longitude+0.005)).title("Cil");
                break;
            case 3:
                place2 = new MarkerOptions().position(new LatLng(latLng.latitude, latLng.longitude-0.005)).title("Cil");
                break;

        }

        googleMap.addMarker(place2);
        getDirection = findViewById(R.id.btnGetDirection);

        getDirection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            googleMap.clear();
                    SharedPreferences settings = getSharedPreferences(PREFS_NAME,0);
                    SharedPreferences.Editor editor = settings.edit();
                    trasa++;
                    editor.putInt("trasa",trasa);
                    editor.commit();

                markerOptions = new MarkerOptions().position(new LatLng(place2.getPosition().latitude, place2.getPosition().longitude)).title("Start");
                googleMap.addMarker(markerOptions);
                int random = getRandomInteger(3,0);
                switch(random) {
                    case 0:
                        place2 = new MarkerOptions().position(new LatLng(markerOptions.getPosition().latitude+0.005, markerOptions.getPosition().longitude+0.001)).title("Cil");
                        break;
                    case 1:
                        place2 = new MarkerOptions().position(new LatLng(markerOptions.getPosition().latitude-0.005, markerOptions.getPosition().longitude+0.001)).title("Cil");
                        break;
                    case 2:
                        place2 = new MarkerOptions().position(new LatLng(markerOptions.getPosition().latitude+0.001, markerOptions.getPosition().longitude+0.005)).title("Cil");
                        break;
                    case 3:
                        place2 = new MarkerOptions().position(new LatLng(markerOptions.getPosition().latitude+0.001, markerOptions.getPosition().longitude-0.005)).title("Cil");
                        break;

                }

                googleMap.addMarker(place2);
                googleMap.animateCamera(CameraUpdateFactory.newLatLng(markerOptions.getPosition()));


            }
        });

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode){
            case REQUEST_CODE:
                if(grantResults.length>0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    fetchLastLocation();
                }
                break;
        }
    }
}


