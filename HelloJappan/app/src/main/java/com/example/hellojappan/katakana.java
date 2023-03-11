package com.example.hellojappan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class katakana extends AppCompatActivity {
    private MediaPlayer mediaPlayerA;
    private MediaPlayer mediaPlayerI;
    private MediaPlayer mediaPlayerU;
    private MediaPlayer mediaPlayerE;
    private MediaPlayer mediaPlayerO;
    private MediaPlayer mediaPlayerKA;
    private MediaPlayer mediaPlayerKI;
    private MediaPlayer mediaPlayerKU;
    private MediaPlayer mediaPlayerKE;
    private MediaPlayer mediaPlayerKO;
    private MediaPlayer mediaPlayerSA;
    private MediaPlayer mediaPlayerSHI;
    private MediaPlayer mediaPlayerSU;
    private MediaPlayer mediaPlayerSE;
    private MediaPlayer mediaPlayerSO;
    private MediaPlayer mediaPlayerTA;
    private MediaPlayer mediaPlayerCHI;
    private MediaPlayer mediaPlayerTSU;
    private MediaPlayer mediaPlayerTE;
    private MediaPlayer mediaPlayerTO;
    private MediaPlayer mediaPlayerNA;
    private MediaPlayer mediaPlayerNI;
    private MediaPlayer mediaPlayerNU;
    private MediaPlayer mediaPlayerNE;
    private MediaPlayer mediaPlayerNO;
    private MediaPlayer mediaPlayerHA;
    private MediaPlayer mediaPlayerHI;
    private MediaPlayer mediaPlayerFU;
    private MediaPlayer mediaPlayerHE;
    private MediaPlayer mediaPlayerHO;
    private MediaPlayer mediaPlayerMA;
    private MediaPlayer mediaPlayerMI;
    private MediaPlayer mediaPlayerMU;
    private MediaPlayer mediaPlayerME;
    private MediaPlayer mediaPlayerMO;
    private MediaPlayer mediaPlayerYA;
    private MediaPlayer mediaPlayerYU;
    private MediaPlayer mediaPlayerYO;
    private MediaPlayer mediaPlayerRA;
    private MediaPlayer mediaPlayerRI;
    private MediaPlayer mediaPlayerRU;
    private MediaPlayer mediaPlayerRE;
    private MediaPlayer mediaPlayerRO;
    private MediaPlayer mediaPlayerWA;
    private MediaPlayer mediaPlayerWO;
    private MediaPlayer mediaPlayerN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_katakana);
        // create media player
        mediaPlayerA = MediaPlayer.create(this, R.raw.a);
        mediaPlayerI = MediaPlayer.create(this, R.raw.i);
        mediaPlayerU = MediaPlayer.create(this, R.raw.u);
        mediaPlayerE = MediaPlayer.create(this, R.raw.e);
        mediaPlayerO = MediaPlayer.create(this, R.raw.o);
        mediaPlayerKA = MediaPlayer.create(this, R.raw.ka);
        mediaPlayerKI = MediaPlayer.create(this, R.raw.ki);
        mediaPlayerKU = MediaPlayer.create(this, R.raw.ku);
        mediaPlayerKE = MediaPlayer.create(this, R.raw.ke);
        mediaPlayerKO = MediaPlayer.create(this, R.raw.ko);
        mediaPlayerSA = MediaPlayer.create(this, R.raw.sa);
        mediaPlayerSHI = MediaPlayer.create(this, R.raw.shi);
        mediaPlayerSU = MediaPlayer.create(this, R.raw.su);
        mediaPlayerSE = MediaPlayer.create(this, R.raw.se);
        mediaPlayerSO = MediaPlayer.create(this, R.raw.so);
        mediaPlayerTA = MediaPlayer.create(this, R.raw.ta);
        mediaPlayerCHI = MediaPlayer.create(this, R.raw.chi);
        mediaPlayerTSU = MediaPlayer.create(this, R.raw.tsu);
        mediaPlayerTE = MediaPlayer.create(this, R.raw.te);
        mediaPlayerTO = MediaPlayer.create(this, R.raw.to);
        mediaPlayerNA = MediaPlayer.create(this, R.raw.na);
        mediaPlayerNI = MediaPlayer.create(this, R.raw.ni);
        mediaPlayerNU = MediaPlayer.create(this, R.raw.nu);
        mediaPlayerNE = MediaPlayer.create(this, R.raw.ne);
        mediaPlayerNO = MediaPlayer.create(this, R.raw.no);
        mediaPlayerHA = MediaPlayer.create(this, R.raw.ha);
        mediaPlayerHI = MediaPlayer.create(this, R.raw.hi);
        mediaPlayerFU = MediaPlayer.create(this, R.raw.fu);
        mediaPlayerHE = MediaPlayer.create(this, R.raw.he);
        mediaPlayerHO = MediaPlayer.create(this, R.raw.ho);
        mediaPlayerMA = MediaPlayer.create(this, R.raw.ma);
        mediaPlayerMI = MediaPlayer.create(this, R.raw.mi);
        mediaPlayerMU = MediaPlayer.create(this, R.raw.mu);
        mediaPlayerME = MediaPlayer.create(this, R.raw.me);
        mediaPlayerMO = MediaPlayer.create(this, R.raw.mo);
        mediaPlayerYA = MediaPlayer.create(this, R.raw.ya);
        mediaPlayerYU = MediaPlayer.create(this, R.raw.yu);
        mediaPlayerYO = MediaPlayer.create(this, R.raw.yo);
        mediaPlayerRA = MediaPlayer.create(this, R.raw.ra);
        mediaPlayerRI = MediaPlayer.create(this, R.raw.ri);
        mediaPlayerRU = MediaPlayer.create(this, R.raw.ru);
        mediaPlayerRE = MediaPlayer.create(this, R.raw.re);
        mediaPlayerRO = MediaPlayer.create(this, R.raw.ro);
        mediaPlayerWA = MediaPlayer.create(this, R.raw.wa);
        mediaPlayerWO = MediaPlayer.create(this, R.raw.wo);
        mediaPlayerN = MediaPlayer.create(this, R.raw.n);
        // make sound
        ImageButton buttonA = findViewById(R.id.a);
        buttonA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayerA.start();
            }
        });

        ImageButton buttonI = findViewById(R.id.i);
        buttonI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayerI.start();
            }
        });

        ImageButton buttonU = findViewById(R.id.u);
        buttonU.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayerU.start();
            }
        });

        ImageButton buttonE = findViewById(R.id.e);
        buttonE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayerE.start();
            }
        });

        ImageButton buttonO = findViewById(R.id.o);
        buttonO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayerO.start();
            }
        });

        ImageButton buttonKA = findViewById(R.id.ka);
        buttonKA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayerKA.start();
            }
        });

        ImageButton buttonKI = findViewById(R.id.ki);
        buttonKI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayerKI.start();
            }
        });

        ImageButton buttonKU = findViewById(R.id.ku);
        buttonKU.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayerKU.start();
            }
        });

        ImageButton buttonKE = findViewById(R.id.ke);
        buttonKE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayerKE.start();
            }
        });

        ImageButton buttonKO = findViewById(R.id.ko);
        buttonKO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayerKO.start();
            }
        });

        ImageButton buttonSA = findViewById(R.id.sa);
        buttonSA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayerSA.start();
            }
        });

        ImageButton buttonSHI = findViewById(R.id.shi);
        buttonSHI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayerSHI.start();
            }
        });

        ImageButton buttonSU = findViewById(R.id.su);
        buttonSU.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayerSU.start();
            }
        });

        ImageButton buttonSE = findViewById(R.id.se);
        buttonSE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayerSE.start();
            }
        });

        ImageButton buttonSO = findViewById(R.id.so);
        buttonSO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayerSO.start();
            }
        });

        ImageButton buttonTA = findViewById(R.id.ta);
        buttonTA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayerTA.start();
            }
        });

        ImageButton buttonCHI = findViewById(R.id.chi);
        buttonCHI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayerCHI.start();
            }
        });

        ImageButton buttonTSU = findViewById(R.id.tsu);
        buttonTSU.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayerTSU.start();
            }
        });

        ImageButton buttonTE = findViewById(R.id.te);
        buttonTE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayerTE.start();
            }
        });

        ImageButton buttonTO = findViewById(R.id.to);
        buttonTO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayerTO.start();
            }
        });

        ImageButton buttonNA = findViewById(R.id.na);
        buttonNA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayerNA.start();
            }
        });

        ImageButton buttonNI = findViewById(R.id.ni);
        buttonNI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayerNI.start();
            }
        });

        ImageButton buttonNU = findViewById(R.id.nu);
        buttonNU.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayerNU.start();
            }
        });

        ImageButton buttonNE = findViewById(R.id.ne);
        buttonNE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayerNE.start();
            }
        });

        ImageButton buttonNO = findViewById(R.id.no);
        buttonNO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayerNO.start();
            }
        });

        ImageButton buttonHA = findViewById(R.id.ha);
        buttonHA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayerHA.start();
            }
        });

        ImageButton buttonHI = findViewById(R.id.hi);
        buttonHI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayerHI.start();
            }
        });

        ImageButton buttonFU = findViewById(R.id.fu);
        buttonFU.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayerFU.start();
            }
        });

        ImageButton buttonHE = findViewById(R.id.he);
        buttonHE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayerHE.start();
            }
        });

        ImageButton buttonHO = findViewById(R.id.ho);
        buttonHO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayerHO.start();
            }
        });

        ImageButton buttonMA = findViewById(R.id.ma);
        buttonMA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayerMA.start();
            }
        });

        ImageButton buttonMI = findViewById(R.id.mi);
        buttonMI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayerMI.start();
            }
        });

        ImageButton buttonMU = findViewById(R.id.mu);
        buttonMU.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayerMU.start();
            }
        });

        ImageButton buttonME = findViewById(R.id.me);
        buttonME.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayerME.start();
            }
        });

        ImageButton buttonMO = findViewById(R.id.mo);
        buttonMO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayerMO.start();
            }
        });

        ImageButton buttonYA = findViewById(R.id.ya);
        buttonYA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayerYA.start();
            }
        });

        ImageButton buttonYU = findViewById(R.id.yu);
        buttonYU.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayerYU.start();
            }
        });

        ImageButton buttonYO = findViewById(R.id.yo);
        buttonYO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayerYO.start();
            }
        });

        ImageButton buttonRA = findViewById(R.id.ra);
        buttonRA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayerRA.start();
            }
        });

        ImageButton buttonRI = findViewById(R.id.ri);
        buttonRI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayerRI.start();
            }
        });

        ImageButton buttonRU = findViewById(R.id.ru);
        buttonRU.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayerRU.start();
            }
        });

        ImageButton buttonRE = findViewById(R.id.re);
        buttonRE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayerRE.start();
            }
        });

        ImageButton buttonRO = findViewById(R.id.ro);
        buttonRO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayerRO.start();
            }
        });

        ImageButton buttonWA = findViewById(R.id.wa);
        buttonWA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayerWA.start();
            }
        });

        ImageButton buttonWO = findViewById(R.id.wo);
        buttonWO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayerWO.start();
            }
        });

        ImageButton buttonN = findViewById(R.id.n);
        buttonN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayerN.start();
            }
        });

        Button hiragana = findViewById(R.id.hiragana_button);
        hiragana.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(katakana.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}