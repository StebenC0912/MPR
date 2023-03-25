package edu.hanu.tut7.db;

import android.provider.BaseColumns;

public class NoteContract {
    private NoteContract() {}
    public static class NoteEntry implements BaseColumns {
        public static final String TABLE_NAME = "note";
        public static final String COLUMN_NAME_TITLE = "title";
        public static final String COLUMN_NAME_CONTENT = "content";
    }
}
