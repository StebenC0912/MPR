package com.example.mynetflix;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public void onClick(View view) {
        Log.i("Info", "onClick: Logging");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button LoginBtn = findViewById(R.id.LoginBtn);
        TextView password = findViewById(R.id.pass);
        LoginBtn.setOnClickListener(view -> {

                String text = password.getText().toString();
                if (text.equals("1234")) Toast.makeText(this, "Login", Toast.LENGTH_LONG).show();
                else Toast.makeText(this, "Wrong password!!!", Toast.LENGTH_LONG).show();

        });
    }
}