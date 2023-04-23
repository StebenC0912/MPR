package edu.hanu.tut10;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.os.HandlerCompat;
import androidx.fragment.app.FragmentManager;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.provider.SyncStateContract;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

import edu.hanu.tut10.model.Constant;

public class MainActivity extends AppCompatActivity {
    private int id =1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        int id= 1;
        // initially display team member with id =1;
        setId(1);
        ImageView btnView = findViewById(R.id.btnPrev);
        btnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setId(id-1);
            }
        });

        ImageView btnView2 = findViewById(R.id.btnNext);
        btnView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setId(id+1);
            }
        });


    }
    // tao 1 fragment moi
     private void setId(int id){
        if(id >=1 && id<=10){
            // cap nhat gia tri
            this.id= id;

            // display fragment
            FragmentManager fragmentManager= getSupportFragmentManager();
            ProfileFragment profileFragment= new ProfileFragment();
            Bundle data= new Bundle();
            data.putInt("ID", id);
            profileFragment.setArguments(data);
            fragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, profileFragment)
                    .addToBackStack("profile_fragment")
                    .commit();

        }
     }


}