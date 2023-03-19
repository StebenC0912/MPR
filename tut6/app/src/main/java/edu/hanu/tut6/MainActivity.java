package edu.hanu.tut6;

import static android.provider.MediaStore.Video.VideoColumns.LANGUAGE;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import org.intellij.lang.annotations.Language;

public class MainActivity extends AppCompatActivity {
    private SharedPreferences sharedPreferences;
    private String language;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView view = findViewById(R.id.view);
        sharedPreferences = this.getSharedPreferences(getPackageName(), Context.MODE_PRIVATE);
        language = sharedPreferences.getString(LANGUAGE, null);
        if (language == null)
            new AlertDialog.Builder(this).setIcon(android.R.drawable.ic_dialog_alert)
                    .setMessage(R.string.which_language)
                    .setTitle(R.string.choose_lang)
                    .setPositiveButton("Vietnamese", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            sharedPreferences.edit().putString(LANGUAGE, "Vietnamese").apply();
                            view.setText(language);
                        }
                    }).setPositiveButton("English", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            sharedPreferences.edit().putString(LANGUAGE, "English").apply();
                            view.setText(language);
                        }
                    });
    }
}