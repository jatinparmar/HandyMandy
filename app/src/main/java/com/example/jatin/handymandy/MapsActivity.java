package com.example.jatin.handymandy;

import android.location.Geocoder;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.EditText;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.List;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    public void onZoom(View view){

        if(view.getId()==R.id.bzoomin){

            mMap.animateCamera(CameraUpdateFactory.zoomIn());
        }
        if(view.getId()==R.id.bzoomout){

            mMap.animateCamera(CameraUpdateFactory.zoomOut());
        }
    }

    public void onSearch(View view){

        EditText location_tf=(EditText)findViewById(R.id.search);
        String location=location_tf.getText().toString();

        List<android.location.Address> addressList=null ;
        if(location!=null || !location.equals("")){


            Geocoder geocoder=new Geocoder(this);
            try {
               addressList = geocoder.getFromLocationName(location,1);
            } catch (IOException e) {
                e.printStackTrace();
            }
            android.location.Address address=addressList.get(0);
            LatLng latLng=new LatLng(address.getLatitude(),address.getLongitude());
            mMap.addMarker(new MarkerOptions().position(latLng).title("Marker"));
            mMap.animateCamera(CameraUpdateFactory.newLatLng(latLng));
        }
    }

    public void changeType(View view){

        if(mMap.getMapType()==GoogleMap.MAP_TYPE_NORMAL){
            mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);

        }

        else
            mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
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
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng india = new LatLng(29.9082, 77.9263);
        mMap.addMarker(new MarkerOptions().position(india).title("Roorkee College Of Engineering, Roorkee"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(india));




    }



}
