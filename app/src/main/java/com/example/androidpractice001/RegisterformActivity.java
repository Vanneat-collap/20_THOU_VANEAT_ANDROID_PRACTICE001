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

    TextView textName, textAge, textUniversity;
    Button closeBtn;
    private static final String TAG=RegisterformActivity.class.getName();

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registerform);

       textName = findViewById(R.id.get_name);
       textAge = findViewById(R.id.get_age);
       textUniversity = findViewById(R.id.get_university);

        User user=getIntent().getParcelableExtra("user");
        textName.setText("Name : " + user.name);
        textAge.setText("Age : " + user.age);
        textUniversity.setText("University : " + user.university);

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