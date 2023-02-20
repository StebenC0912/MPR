package com.example.helloapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn = findViewById(R.id.button);
        TextView input = findViewById(R.id.inputName);
        btn.setOnClickListener(view -> {
            try {
                String name =  input.getText().toString();
                Toast.makeText(this, "Bạn " + name + " ơi", Toast.LENGTH_LONG).show();
            } catch (Exception e) {
                Toast.makeText(this, "Blank input", Toast.LENGTH_LONG).show();
            }
        });
    }
}