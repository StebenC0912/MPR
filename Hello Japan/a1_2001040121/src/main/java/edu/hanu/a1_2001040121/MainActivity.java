package edu.hanu.a1_2001040121;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private MediaPlayer mediaPlayer;
    private Map<Integer, Integer> soundMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Create MediaPlayer and sound map
        mediaPlayer = new MediaPlayer();
        soundMap = new HashMap<>();
        soundMap.put(R.id.a, R.raw.a);
        soundMap.put(R.id.i, R.raw.i);
        soundMap.put(R.id.u, R.raw.u);
        soundMap.put(R.id.e, R.raw.e);
        soundMap.put(R.id.o, R.raw.o);
        soundMap.put(R.id.ka, R.raw.ka);
        soundMap.put(R.id.ki, R.raw.ki);
        soundMap.put(R.id.ku, R.raw.ku);
        soundMap.put(R.id.ke, R.raw.ke);
        soundMap.put(R.id.ko, R.raw.ko);
        soundMap.put(R.id.sa, R.raw.sa);
        soundMap.put(R.id.shi, R.raw.shi);
        soundMap.put(R.id.su, R.raw.su);
        soundMap.put(R.id.se, R.raw.se);
        soundMap.put(R.id.so, R.raw.so);
        soundMap.put(R.id.ta, R.raw.ta);
        soundMap.put(R.id.chi, R.raw.chi);
        soundMap.put(R.id.tsu, R.raw.tsu);
        soundMap.put(R.id.te, R.raw.te);
        soundMap.put(R.id.to, R.raw.to);
        soundMap.put(R.id.na, R.raw.na);
        soundMap.put(R.id.ni, R.raw.ni);
        soundMap.put(R.id.nu, R.raw.nu);
        soundMap.put(R.id.ne, R.raw.ne);
        soundMap.put(R.id.no, R.raw.no);
        soundMap.put(R.id.ha, R.raw.ha);
        soundMap.put(R.id.hi, R.raw.hi);
        soundMap.put(R.id.fu, R.raw.fu);
        soundMap.put(R.id.he, R.raw.he);
        soundMap.put(R.id.ho, R.raw.ho);
        soundMap.put(R.id.ma, R.raw.ma);
        soundMap.put(R.id.mi, R.raw.mi);
        soundMap.put(R.id.mu, R.raw.mu);
        soundMap.put(R.id.me, R.raw.me);
        soundMap.put(R.id.mo, R.raw.mo);
        soundMap.put(R.id.ya, R.raw.ya);
        soundMap.put(R.id.yu, R.raw.yu);
        soundMap.put(R.id.yo, R.raw.yo);
        soundMap.put(R.id.ra, R.raw.ra);
        soundMap.put(R.id.ri, R.raw.ri);
        soundMap.put(R.id.ru, R.raw.ru);
        soundMap.put(R.id.re, R.raw.re);
        soundMap.put(R.id.ro, R.raw.ro);
        soundMap.put(R.id.wa, R.raw.wa);
        soundMap.put(R.id.wo, R.raw.wo);
        soundMap.put(R.id.n, R.raw.n);
        // Set click listener for all ImageButtons
        for (int id : soundMap.keySet()) {
            ImageButton button = findViewById(id);
            button.setOnClickListener(this);
        }
        //define the button for each character
        ImageButton buttonA = findViewById(R.id.a);
        ImageButton buttonI = findViewById(R.id.i);
        ImageButton buttonU = findViewById(R.id.u);
        ImageButton buttonE = findViewById(R.id.e);
        ImageButton buttonO = findViewById(R.id.o);
        ImageButton buttonKA = findViewById(R.id.ka);
        ImageButton buttonKI = findViewById(R.id.ki);
        ImageButton buttonKU = findViewById(R.id.ku);
        ImageButton buttonKE = findViewById(R.id.ke);
        ImageButton buttonKO = findViewById(R.id.ko);
        ImageButton buttonSA = findViewById(R.id.sa);
        ImageButton buttonSHI = findViewById(R.id.shi);
        ImageButton buttonSU = findViewById(R.id.su);
        ImageButton buttonSE = findViewById(R.id.se);
        ImageButton buttonSO = findViewById(R.id.so);
        ImageButton buttonTA = findViewById(R.id.ta);
        ImageButton buttonCHI = findViewById(R.id.chi);
        ImageButton buttonTSU = findViewById(R.id.tsu);
        ImageButton buttonTE = findViewById(R.id.te);
        ImageButton buttonTO = findViewById(R.id.to);
        ImageButton buttonNA = findViewById(R.id.na);
        ImageButton buttonNI = findViewById(R.id.ni);
        ImageButton buttonNU = findViewById(R.id.nu);
        ImageButton buttonNE = findViewById(R.id.ne);
        ImageButton buttonNO = findViewById(R.id.no);
        ImageButton buttonHA = findViewById(R.id.ha);
        ImageButton buttonHI = findViewById(R.id.hi);
        ImageButton buttonFU = findViewById(R.id.fu);
        ImageButton buttonHE = findViewById(R.id.he);
        ImageButton buttonHO = findViewById(R.id.ho);
        ImageButton buttonMA = findViewById(R.id.ma);
        ImageButton buttonMI = findViewById(R.id.mi);
        ImageButton buttonMU = findViewById(R.id.mu);
        ImageButton buttonME = findViewById(R.id.me);
        ImageButton buttonMO = findViewById(R.id.mo);
        ImageButton buttonYA = findViewById(R.id.ya);
        ImageButton buttonYU = findViewById(R.id.yu);
        ImageButton buttonYO = findViewById(R.id.yo);
        ImageButton buttonRA = findViewById(R.id.ra);
        ImageButton buttonRI = findViewById(R.id.ri);
        ImageButton buttonRU = findViewById(R.id.ru);
        ImageButton buttonRE = findViewById(R.id.re);
        ImageButton buttonRO = findViewById(R.id.ro);
        ImageButton buttonWA = findViewById(R.id.wa);
        ImageButton buttonWO = findViewById(R.id.wo);
        ImageButton buttonN = findViewById(R.id.n);
        // handle the switch to Katakana
        Button katakana = findViewById(R.id.katakana_button);
        Button hiragana = findViewById(R.id.hiragana_button);
        TextView titleBar = findViewById(R.id.titleBar);
        katakana.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // change the title bar
                titleBar.setText(R.string.katakana);
                // change the style of switch
                katakana.setBackgroundResource(R.drawable.border);
                hiragana.setBackgroundResource(R.drawable.black_border);
                buttonA.setImageResource(R.drawable.a1);
                buttonI.setImageResource(R.drawable.i1);
                buttonU.setImageResource(R.drawable.u1);
                buttonE.setImageResource(R.drawable.e1);
                buttonO.setImageResource(R.drawable.o1);
                buttonKA.setImageResource(R.drawable.ka1);
                buttonKI.setImageResource(R.drawable.ki1);
                buttonKU.setImageResource(R.drawable.ku1);
                buttonKE.setImageResource(R.drawable.ke1);
                buttonKO.setImageResource(R.drawable.ko1);
                buttonSA.setImageResource(R.drawable.sa1);
                buttonSHI.setImageResource(R.drawable.shi1);
                buttonSU.setImageResource(R.drawable.su1);
                buttonSE.setImageResource(R.drawable.se1);
                buttonSO.setImageResource(R.drawable.so1);
                buttonTA.setImageResource(R.drawable.ta1);
                buttonCHI.setImageResource(R.drawable.chi1);
                buttonTSU.setImageResource(R.drawable.tsu1);
                buttonTE.setImageResource(R.drawable.te1);
                buttonTO.setImageResource(R.drawable.to1);
                buttonNA.setImageResource(R.drawable.na1);
                buttonNI.setImageResource(R.drawable.ni1);
                buttonNU.setImageResource(R.drawable.nu1);
                buttonNE.setImageResource(R.drawable.ne1);
                buttonNO.setImageResource(R.drawable.no1);
                buttonHA.setImageResource(R.drawable.ha1);
                buttonHI.setImageResource(R.drawable.hi1);
                buttonFU.setImageResource(R.drawable.fu1);
                buttonHE.setImageResource(R.drawable.he1);
                buttonHO.setImageResource(R.drawable.ho1);
                buttonMA.setImageResource(R.drawable.ma1);
                buttonMI.setImageResource(R.drawable.mi1);
                buttonMU.setImageResource(R.drawable.mu1);
                buttonME.setImageResource(R.drawable.me1);
                buttonMO.setImageResource(R.drawable.mo1);
                buttonYA.setImageResource(R.drawable.ya1);
                buttonYU.setImageResource(R.drawable.yu1);
                buttonYO.setImageResource(R.drawable.yo1);
                buttonRA.setImageResource(R.drawable.ra1);
                buttonRI.setImageResource(R.drawable.ri1);
                buttonRU.setImageResource(R.drawable.ru1);
                buttonRE.setImageResource(R.drawable.re1);
                buttonRO.setImageResource(R.drawable.ro1);
                buttonWA.setImageResource(R.drawable.wa1);
                buttonWO.setImageResource(R.drawable.wo1);
                buttonN.setImageResource(R.drawable.n1);
            }
        });


        hiragana.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // change the title bar
                titleBar.setText(R.string.hiragana);
                // change the style of switch
                katakana.setBackgroundResource(R.drawable.black_border);
                hiragana.setBackgroundResource(R.drawable.border);
                buttonA.setImageResource(R.drawable.a);
                buttonI.setImageResource(R.drawable.i);
                buttonU.setImageResource(R.drawable.u);
                buttonE.setImageResource(R.drawable.e);
                buttonO.setImageResource(R.drawable.o);
                buttonKA.setImageResource(R.drawable.ka);
                buttonKI.setImageResource(R.drawable.ki);
                buttonKU.setImageResource(R.drawable.ku);
                buttonKE.setImageResource(R.drawable.ke);
                buttonKO.setImageResource(R.drawable.ko);
                buttonSA.setImageResource(R.drawable.sa);
                buttonSHI.setImageResource(R.drawable.shi);
                buttonSU.setImageResource(R.drawable.su);
                buttonSE.setImageResource(R.drawable.se);
                buttonSO.setImageResource(R.drawable.so);
                buttonTA.setImageResource(R.drawable.ta);
                buttonCHI.setImageResource(R.drawable.chi);
                buttonTSU.setImageResource(R.drawable.tsu);
                buttonTE.setImageResource(R.drawable.te);
                buttonTO.setImageResource(R.drawable.to);
                buttonNA.setImageResource(R.drawable.na);
                buttonNI.setImageResource(R.drawable.ni);
                buttonNU.setImageResource(R.drawable.nu);
                buttonNE.setImageResource(R.drawable.ne);
                buttonNO.setImageResource(R.drawable.no);
                buttonHA.setImageResource(R.drawable.ha);
                buttonHI.setImageResource(R.drawable.hi);
                buttonFU.setImageResource(R.drawable.fu);
                buttonHE.setImageResource(R.drawable.he);
                buttonHO.setImageResource(R.drawable.ho);
                buttonMA.setImageResource(R.drawable.ma);
                buttonMI.setImageResource(R.drawable.mi);
                buttonMU.setImageResource(R.drawable.mu);
                buttonME.setImageResource(R.drawable.me);
                buttonMO.setImageResource(R.drawable.mo);
                buttonYA.setImageResource(R.drawable.ya);
                buttonYU.setImageResource(R.drawable.yu);
                buttonYO.setImageResource(R.drawable.yo);
                buttonRA.setImageResource(R.drawable.ra);
                buttonRI.setImageResource(R.drawable.ri);
                buttonRU.setImageResource(R.drawable.ru);
                buttonRE.setImageResource(R.drawable.re);
                buttonRO.setImageResource(R.drawable.ro);
                buttonWA.setImageResource(R.drawable.wa);
                buttonWO.setImageResource(R.drawable.wo);
                buttonN.setImageResource(R.drawable.n);
            }
        });
    }

    @Override
    public void onClick(View v) {
        // Determine which button was clicked
        int id = v.getId();

        // Get sound resource ID for clicked button from sound map
        int soundId = soundMap.get(id);

        // Stop and reset MediaPlayer to play new sound
        mediaPlayer.stop();
        mediaPlayer.reset();
        mediaPlayer = MediaPlayer.create(this, soundId);

        // Play sound
        mediaPlayer.start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        // Release MediaPlayer resources
        mediaPlayer.release();
    }
}