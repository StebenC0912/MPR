package com.example.mytube;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageButton play = findViewById(R.id.playButton);
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText input = findViewById(R.id.inputLink);
                String link = "https://drive.google.com/uc?export=download&id=1NCF3nZ1DidCRiGmxnjarkXdk2mk0a0IS";
                Intent intent = new Intent(MainActivity.this, PlayActivity.class);
                intent.putExtra("link", link);
                startActivity(intent);
            }
        });
    }
}