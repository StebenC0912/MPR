package edu.hanu.tut7;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import edu.hanu.tut7.adapter.NoteAdapter;
import edu.hanu.tut7.db.DbHelper;
import edu.hanu.tut7.model.Note;

public class MainActivity extends AppCompatActivity {
    private List<Note> notes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView noteRecyclerView = findViewById(R.id.note_recycler_view);
        noteRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        noteRecyclerView.setAdapter(new NoteAdapter(notes));

        Button addNoteButton = findViewById(R.id.add_note_button);
        addNoteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("New Note");

                final EditText titleEditText = new EditText(MainActivity.this);
                titleEditText.setInputType(InputType.TYPE_CLASS_TEXT);
                builder.setView(titleEditText);

                final EditText contentEditText = new EditText(MainActivity.this);
                contentEditText.setInputType(InputType.TYPE_CLASS_TEXT);
                builder.setView(contentEditText);

                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String title = titleEditText.getText().toString();
                        String content = contentEditText.getText().toString();
                        Note newNote = new Note(title, content);
                        notes.add(newNote);
                        noteRecyclerView.getAdapter().notifyDataSetChanged();
                    }
                });

                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

                builder.show();
            }
        });
        // implement the delete when long click on the note
        // after that a dialog will appear to confirm the deletion
        // if the user click on OK, the note will be deleted
        // if the user click on Cancel, the dialog will be dismissed
        

    }
}
