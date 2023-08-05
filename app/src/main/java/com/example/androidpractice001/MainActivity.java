package com.example.androidpractice001;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getName();

    private EditText editName,editAge,editUniversity;

    Button btnRegister;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editName=findViewById(R.id.edit_name);
        editAge = findViewById(R.id.edit_age);
        editUniversity = findViewById(R.id.edit_university);
        btnRegister = findViewById(R.id.register_btn);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkCredentials();
            }
        });
    }

private void checkCredentials(){
        String name = editName.getText().toString();
        String age = editAge.getText().toString();
        String university = editUniversity.getText().toString();

        User user =new User(name,age,university);

        Intent intent= new Intent(this,RegisterformActivity.class);
        if (name.isEmpty())
        {
            showError(editName,"Name is empty");
        }
        else if (age.isEmpty())
        {
            showError(editAge,"Age is empty");
        }
        else if (university.isEmpty())
        {
            showError(editUniversity,"University is empty");
        }
        else
        {
            intent.putExtra("user",user);

            startActivity(intent);
        }
}
    private void showError(EditText input, String s)
    {
        input.setError(s);
        input.requestFocus();
    }

}

