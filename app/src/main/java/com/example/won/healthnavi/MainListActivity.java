package com.example.won.healthnavi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainListActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private FirebaseUser currentUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_list);
        mAuth = FirebaseAuth.getInstance();

        currentUser = mAuth.getCurrentUser();
        if(currentUser == null){
            startActivity(new Intent(this, MainActivity.class));
            finish();
        }

        Button logoutBtn = (Button)findViewById(R.id.button5);
        Button useCheckBtn = (Button)findViewById(R.id.button6);
        Button resBtn = (Button)findViewById(R.id.button2);

        logoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                logoutStart();
            }
        });

        resBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainListActivity.this, ReservationActivity.class));
                finish();
            }
        });

    }

    public void logoutStart(){
        mAuth.signOut();
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }
}
