package com.example.calulation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button convertButton = findViewById(R.id.convertBtn);
    }
    public void convertFunction(View view) {
        TextView input = findViewById(R.id.editTextNumberDecimal);
        int result = Integer.parseInt(input.toString());
        Log.i(input.toString(), "Answer");
        Toast.makeText(this, "Your money is:" + result, Toast.LENGTH_LONG).show();
    }
}