package com.domily.android.domily.Activities;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.domily.android.domily.Fragments.MapFragment;
import com.domily.android.domily.R;

public class UbicacionActvity extends AppCompatActivity{

    Fragment mMapFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ubicacion);

        // Cambia hacia el Fragment de Google Maps
        mMapFragment = new MapFragment();
        changeFragment(mMapFragment);

    }

    public void changeFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, fragment).commit();
    }

}
