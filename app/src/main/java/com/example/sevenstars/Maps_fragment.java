package com.example.sevenstars;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.sevenstars.databinding.ActivityMapsFragmentBinding;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class Maps_fragment extends FragmentActivity implements OnMapReadyCallback {

    private ActivityMapsFragmentBinding binding;
    private GoogleMap map;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMapsFragmentBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {

        map=googleMap;

//        Intent intent=getIntent();
//        String location=intent.getStringExtra("location");

            LatLng trust_loc = new LatLng(22.973423,  78.656891);
            map.addMarker(new MarkerOptions().position(trust_loc).title("Demo_API"));
            map.animateCamera(CameraUpdateFactory.newLatLngZoom(trust_loc,15));

    }
}