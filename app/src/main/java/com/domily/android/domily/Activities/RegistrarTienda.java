package com.domily.android.domily.Activities;

import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.location.LocationProvider;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
// Google Maps API
import com.domily.android.domily.Manifest;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.LocationSource;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import com.domily.android.domily.R;

public class RegistrarTienda extends AppCompatActivity {

    private GoogleMap mMap;

    private Button mButtonUbicacion;
    private TextView mTextViewUbicacion;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_tienda);

        mButtonUbicacion = (Button) findViewById(R.id.buttonUbicacionActual);
        mTextViewUbicacion = (TextView) findViewById(R.id.textViewUbicacionActual);

        mButtonUbicacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mTextViewUbicacion.setText("Hola weyes jeje");
            }
        });
    }


}
