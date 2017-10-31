package com.domily.android.domily.Fragments;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.domily.android.domily.Activities.RegistrarTienda;
import com.domily.android.domily.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapFragment extends Fragment implements OnMapReadyCallback {

    private View mRootView;
    private MapView mMapView;
    private GoogleMap mGMap;
    private Button mConfirmarUbicacion;
    LatLng place;
    Location mLocation;

    public MapFragment() {  }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mRootView = inflater.inflate(R.layout.fragment_map, container, false);

        mConfirmarUbicacion = (Button) mRootView.findViewById(R.id.buttonConfirmar);
        mConfirmarUbicacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Regresa la ubicación exacta de el dispositivo
                mLocation = mGMap.getMyLocation();
                Intent i = new Intent(getActivity(), RegistrarTienda.class);
                i.putExtra("longitud", String.valueOf(mLocation.getLongitude()));
                i.putExtra("latitud",String.valueOf(mLocation.getLatitude()));
                startActivity(i);
            }
        });
        return mRootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mMapView = (MapView) mRootView.findViewById(R.id.map);
        if (mMapView != null) {
            // Ciclo de vida
            mMapView.onCreate(null);
            mMapView.onResume();
            mMapView.getMapAsync(this);
        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mGMap = googleMap;
        //Agrega la ubicacion Exacta de el dispositivo
        if (ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {
            mGMap.setMyLocationEnabled(true);
        } else {
            // Show rationale and request permission.
        }
        place = new LatLng(19.0133,-98.3933); // Puebla
        mGMap.addMarker(new MarkerOptions().position(place).title("Marcador in Puebla"));

        CameraPosition camara = new CameraPosition.Builder()
                .target(place)
                .zoom(15)
                .bearing(0)     // limite -> 21
                .tilt(30)       // 0 -> 365º
                .build();       // limite -> 90
        mGMap.animateCamera(CameraUpdateFactory.newCameraPosition(camara));
    }


}
