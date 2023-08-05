package com.example.androidpractice001;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterformActivity extends AppCompatActivity {
    Button closeBtn;
    private static final String TAG=RegisterformActivity.class.getName();

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registerform);


        Intent intent= getIntent();
        String name = intent.getStringExtra(MainActivity.EXTRA_NAME);
        String age = intent.getStringExtra(MainActivity.EXTRA_AGE);
        String university = intent.getStringExtra(MainActivity.EXTRA_UNIVERSITY);

        TextView textName = findViewById(R.id.get_name);
        TextView textAge = findViewById(R.id.get_age);
        TextView textUniversity = findViewById(R.id.get_university);
        textName.setText("Name :  " + name);
        textAge.setText("Age :  " + age);
        textUniversity.setText("University :  " + university);


        closeBtn=(Button) findViewById(R.id.close_btn);
        closeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                moveTaskToBack(true);
                android.os.Process.killProcess(android.os.Process.myPid());
                System.exit(1);
            }
        });
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Toast.makeText(RegisterformActivity.this,"Welcome back", Toast.LENGTH_SHORT).show();
    }
}