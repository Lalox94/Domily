package com.domily.android.domily;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.firebase.ui.auth.AuthUI;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.messaging.FirebaseMessaging;


public class MainActivity extends AppCompatActivity {

    private FirebaseAuth mFirebaseAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListener;
    public static final int RC_SIGN_IN = 1;
    private DatabaseReference mMessagesReference;
    public static final String ANONYMOUS = "anonymous";
    private FirebaseDatabase mDatabase;


    private String mUsername;
    private EditText mMessageEditText;
    private Button btn;
    private Button btn1;
    private Button btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mUsername = ANONYMOUS;
        mDatabase = FirebaseDatabase.getInstance();
        mMessagesReference = mDatabase.getReference().child("messages");

         btn = (Button) findViewById(R.id.ButtonSendMessage);
         btn1 = (Button) findViewById(R.id.ButtonSubscribe);
         btn2 = (Button) findViewById(R.id.ButtonUnsubscribe);
         mMessageEditText = (EditText) findViewById(R.id.EditTextSend);



        //  Envia un valor a la Base de datos
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO: Send messages on click
                Message message = new Message(mMessageEditText.getText().toString(), mUsername, null);
                mMessagesReference.push().setValue(message);
                mMessageEditText.setText("");

            }
        });

        //  Envia un valor a la Base de datos
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO: Send messages on click
                FirebaseMessaging.getInstance().subscribeToTopic("pushNotifications");
                Toast.makeText(MainActivity.this, "Subscribed to Topic: Push Notifications", Toast.LENGTH_SHORT).show();
            }
        });
        //  Envia un valor a la Base de datos
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO: Send messages on click
                FirebaseMessaging.getInstance().unsubscribeFromTopic("pushNotifications");
                Toast.makeText(MainActivity.this, "Unsubscribed to Topic: Push Notifications", Toast.LENGTH_SHORT).show();

            }
        });



        // Access Point
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
