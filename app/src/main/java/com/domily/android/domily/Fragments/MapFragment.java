package com.domily.android.domily.Fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.domily.android.domily.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapFragment extends Fragment implements OnMapReadyCallback {

    private View mRootView;
    private MapView mMapView;
    private GoogleMap mGMap;

    public MapFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mRootView = inflater.inflate(R.layout.fragment_map, container, false);
        return mRootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        // Vista cargada
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

        LatLng place = new LatLng(19.0133,-98.3933);
        mGMap.addMarker(new MarkerOptions().position(place).title("Marcador in Puebla"));
        mGMap.moveCamera(CameraUpdateFactory.newLatLng(place));
    }
}
