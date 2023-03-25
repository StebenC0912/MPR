package edu.hanu.tut7;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
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
    private NoteAdapter noteAdapter;
    private RecyclerView noteRecyclerView;
    private DbHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        noteRecyclerView = findViewById(R.id.note_recycler_view);
        noteRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        noteAdapter = new NoteAdapter(notes);
        noteRecyclerView.setAdapter(noteAdapter);

        dbHelper = new DbHelper(this);
        notes.addAll(dbHelper.getAllNotes());
        noteAdapter.notifyDataSetChanged();

        findViewById(R.id.add_note_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showAddNoteDialog();
            }
        });
    }

    private void showAddNoteDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Add Note");

        LayoutInflater inflater = getLayoutInflater();
        View dialogLayout = inflater.inflate(R.layout.add_note_dialog, null);

        final EditText titleEditText = dialogLayout.findViewById(R.id.note_title_edit_text);
        final EditText contentEditText = dialogLayout.findViewById(R.id.note_content_edit_text);

        builder.setView(dialogLayout);

        builder.setPositiveButton("Add", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String title = titleEditText.getText().toString();
                String content = contentEditText.getText().toString();
                if (!title.isEmpty() || !content.isEmpty()) {
                    addNoteToDatabase(title, content);
                } else {
                    Toast.makeText(MainActivity.this, "Please enter a title or content", Toast.LENGTH_SHORT).show();
                }
            }
        });

        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        builder.create().show();
    }

    private void addNoteToDatabase(String title, String content) {
        long id = dbHelper.insert(title, content, new Date().getTime());
        Note note = dbHelper.getNoteById(id);
        notes.add(0, note);
        noteAdapter.notifyItemInserted(0);
        noteRecyclerView.scrollToPosition(0);
    }
}
