package com.example.calulation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView input = findViewById(R.id.editTextNumberDecimal);
        TextView resultView = findViewById(R.id.result);
        Button convertButton = findViewById(R.id.convertBtn);
        convertButton.setOnClickListener(view -> {
            try {
                Double result = Double.parseDouble(input.getText().toString()) * 24000;
                resultView.setText("Your money in VND is: "+ result);
            } catch (Exception e) {
                resultView.setText("Wrong input!!!");
            }
        });
    }
}