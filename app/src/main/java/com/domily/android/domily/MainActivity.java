package com.domily.android.domily;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.firebase.ui.auth.AuthUI;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    private FirebaseAuth mFirebaseAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListener;
    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference mMessagesDatabaseReference;

    public static final int RC_SIGN_IN = 1;
    public static final String ANONYMOUS = "anonymous";
    private String mUsername;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mUsername = ANONYMOUS;

        Button btn = (Button) findViewById(R.id.ButtonSendMessage);

        //  Envia un valor a la Base de datos
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO: Send messages on click
                mMessagesDatabaseReference.push().setValue("Sup my nigga");

            }
        });

        // Access Point
        mFirebaseDatabase = FirebaseDatabase.getInstance();
        //mFirebaseAuth = FirebaseAuth.getInstance();
        mMessagesDatabaseReference = mFirebaseDatabase.getReference().child("messages");



        /*

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
        */

    }

    private void onSignedOutCleanup() {
        // Prueba
    }

    private void onSignedInInitialize(String username) {
    }


    @Override
    protected void onResume() {
        super.onResume();
      //  mFirebaseAuth.addAuthStateListener(mAuthStateListener);
    }

    @Override
    protected void onPause() {
        super.onPause();
       // mFirebaseAuth.addAuthStateListener(mAuthStateListener);
    }
}
