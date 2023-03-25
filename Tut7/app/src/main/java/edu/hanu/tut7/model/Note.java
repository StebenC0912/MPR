package edu.hanu.tut7.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import edu.hanu.tut7.db.DbHelper;
import edu.hanu.tut7.db.NoteContract;

public class Note {
    private long id;
    private String title;
    private String content;

    public Note(long id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }

    public Note(String title, String content) {
        this.title = title;
        this.content = content;
    }
    public void update(Context context) {
        DbHelper dbHelper = new DbHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(NoteContract.NoteEntry.COLUMN_NAME_TITLE, this.title);
        values.put(NoteContract.NoteEntry.COLUMN_NAME_CONTENT, this.content);

        String selection = NoteContract.NoteEntry._ID + " = ?";
        String[] selectionArgs = { String.valueOf(this.id) };

        int count = db.update(
                NoteContract.NoteEntry.TABLE_NAME,
                values,
                selection,
                selectionArgs
        );
    }
    public void delete(Context context) {
        DbHelper dbHelper = new DbHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        String selection = NoteContract.NoteEntry._ID + " = ?";
        String[] selectionArgs = { String.valueOf(this.id) };

        int deletedRows = db.delete(NoteContract.NoteEntry.TABLE_NAME, selection, selectionArgs);
    }

    public void insert(Context context) {
        DbHelper dbHelper = new DbHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(NoteContract.NoteEntry.COLUMN_NAME_TITLE, this.title);
        values.put(NoteContract.NoteEntry.COLUMN_NAME_CONTENT, this.content);

        long newRowId = db.insert(NoteContract.NoteEntry.TABLE_NAME, null, values);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}

