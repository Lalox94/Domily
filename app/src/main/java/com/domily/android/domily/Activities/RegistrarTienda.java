package com.domily.android.domily.Activities;


import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
// Google Maps API

import com.domily.android.domily.Fragments.MapFragment;
import com.google.android.gms.maps.GoogleMap;


import com.domily.android.domily.R;

public class RegistrarTienda extends AppCompatActivity {


    private GoogleMap mMap;
    private Button mButtonUbicacion;
    private TextView mUbicacionActual;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_tienda);

        mUbicacionActual = (TextView) findViewById(R.id.textViewUbicacionActual);
        mButtonUbicacion = (Button) findViewById(R.id.buttonUbicacionActual);
        mButtonUbicacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(RegistrarTienda.this, UbicacionActvity.class);
                startActivity(i);
            }
        });

        Intent i = getIntent();
        Bundle bundle = i.getExtras();
        if(bundle != null) {
            String longitud = (String) bundle.get("longitud");
            String latitud = (String) bundle.get("latitud");
            mUbicacionActual.setText("Coordenadas: "+latitud+" , "+longitud);
        }
    }


}

