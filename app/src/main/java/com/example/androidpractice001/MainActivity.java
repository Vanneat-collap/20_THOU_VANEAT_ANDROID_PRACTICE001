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
    public static final String EXTRA_NAME ="com.example.androidpractice001.NAME";
    public static final String EXTRA_AGE ="com.example.androidpractice001.AGE";
    public static final String EXTRA_UNIVERSITY ="com.example.androidpractice001.UNIVERSITY";

    private EditText editName,editAge,editUniversity;

    TextView btn;
    Button btnRegister;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn=findViewById(R.id.registerText);
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

         btn.setOnClickListener((v)->{
             startActivity(new Intent(MainActivity.this,RegisterformActivity.class));
         });
    }

private void checkCredentials(){
    Intent intent= new Intent(this,RegisterformActivity.class);
        String name = editName.getText().toString();
        String age = editAge.getText().toString();
        String university = editUniversity.getText().toString();

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
            intent.putExtra(EXTRA_NAME,name);
            intent.putExtra(EXTRA_AGE,age);
            intent.putExtra(EXTRA_UNIVERSITY,university);

            startActivity(intent);
        }
}
    private void showError(EditText input, String s)
    {
        input.setError(s);
        input.requestFocus();
    }

}

