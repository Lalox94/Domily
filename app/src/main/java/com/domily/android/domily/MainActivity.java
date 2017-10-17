package com.domily.android.domily;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.firebase.ui.auth.AuthUI;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    // FIREBASE
    private FirebaseAuth mFirebaseAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListener;
    public static final int RC_SIGN_IN = 1;

    // LAYOUT
    private Button mButtonBuscarTienda;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mButtonBuscarTienda = (Button)findViewById(R.id.ButtonBuscarTienda);
        mButtonBuscarTienda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, TiendaActivity.class);
                startActivity(i);
            }
        });


        // Acceso al registro de los usuarios
        mFirebaseAuth = FirebaseAuth.getInstance();
        // Login
        mAuthStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                // Check if the user is login or not
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if(user != null) {
                    // User is sign in
                    onSignedInInitialize(user.getDisplayName());

                } else {
                    // User is signed out
                    onSignedOutCleanup();
                    startActivityForResult(
                            AuthUI.getInstance()
                                    .createSignInIntentBuilder()
                                    .setIsSmartLockEnabled(false)
                                    .setProviders(
                                            AuthUI.EMAIL_PROVIDER,
                                            AuthUI.GOOGLE_PROVIDER)

                                    .build(),
                            RC_SIGN_IN);
                }
            }
        };


    }

    private void onSignedOutCleanup() {
        // Prueba
    }

    private void onSignedInInitialize(String username) {
    }


    @Override
    protected void onResume() {
        super.onResume();
        mFirebaseAuth.addAuthStateListener(mAuthStateListener);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mFirebaseAuth.addAuthStateListener(mAuthStateListener);
    }

}
