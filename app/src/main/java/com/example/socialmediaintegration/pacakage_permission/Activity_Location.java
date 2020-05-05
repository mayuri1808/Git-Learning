package com.example.socialmediaintegration.pacakage_permission;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.widget.Toast;
import com.example.socialmediaintegration.R;
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

public class Activity_Location extends FragmentActivity implements OnMapReadyCallback {

        Location mLoaction;
        FusedLocationProviderClient fusedLocationProviderClient;
        private static final int REQUESRT_CODE=101;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_permission);
            fusedLocationProviderClient= LocationServices.getFusedLocationProviderClient(this);
            GetLastLocation();
        }
    //Check Location Permission already granted or not
    private void GetLastLocation() {
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                    != PackageManager.PERMISSION_GRANTED) {

                ActivityCompat.requestPermissions(this,//If permission is not granted then we need to request the permission
                                                                //by requestPermission method
                        new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                        REQUESRT_CODE);
            }

            Task<Location> task=fusedLocationProviderClient.getLastLocation();
            task.addOnSuccessListener(new OnSuccessListener<Location>() {
                @Override
                public void onSuccess(Location location) {
                    if(location !=null){
                        mLoaction=location;
                        Toast.makeText(getApplicationContext(),mLoaction.getLatitude()+""+mLoaction.getLongitude(),
                                Toast.LENGTH_LONG).show();
                        SupportMapFragment supportMapFragment=(SupportMapFragment)getSupportFragmentManager()
                                .findFragmentById(R.id.map1);
                        supportMapFragment.getMapAsync(Activity_Location.this);
                    }
                }
            });

        }

        @Override
        public void onMapReady(GoogleMap googleMap) {

            LatLng latLng=new LatLng(mLoaction.getLatitude(),mLoaction.getLongitude());
            MarkerOptions markerOptions=new MarkerOptions().position(latLng).title("You are Here");
            googleMap.animateCamera(CameraUpdateFactory.newLatLng(latLng));
            googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng,6));
            googleMap.addMarker(markerOptions);
        }

        @Override
        public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
            //this method return the user response
            switch (REQUESRT_CODE){
                case REQUESRT_CODE:
                    if(grantResults.length>0 && grantResults[0]== PackageManager.PERMISSION_GRANTED){
                        GetLastLocation();
                    }
                    break;
            }
        }

}
