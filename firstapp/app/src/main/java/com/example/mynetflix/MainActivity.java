package com.example.mynetflix;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    public void onClick(View view) {
        Log.i("Info", "onClick: Logging");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button LoginBtn = findViewById(R.id.LoginBtn);
        LoginBtn.setText("Login");
        String text = LoginBtn.getText().toString();
    }
}