package com.example.btl_android_studyapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.btl_android_studyapp.model.Note;
import com.example.btl_android_studyapp.model.Todo;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "school_management.db";
    private static final int DATABASE_VERSION = 1;

    // Todos Table
    public static final String TABLE_TODOS = "todos";
    public static final String COLUMN_TODO_ID = "id";
    public static final String COLUMN_TODO_USER_ID = "user_id";
    public static final String COLUMN_TODO_TITLE = "title";
    public static final String COLUMN_TODO_IS_DONE = "is_done";
    public static final String COLUMN_TODO_DUE_DATE = "due_date";
    public static final String COLUMN_TODO_NOTE_ID = "note_id";

    public static final String TABLE_NOTE = "notes";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_USER_ID = "user_id";
    public static final String COLUMN_TITLE = "title";
    public static final String COLUMN_CONTENT = "content";
    public static final String COLUMN_CREATED_AT = "created_at";

    private Context context;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTodosTable = "CREATE TABLE " + TABLE_TODOS + " ("
                + COLUMN_TODO_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + COLUMN_TODO_USER_ID + " TEXT,"
                + COLUMN_TODO_TITLE + " TEXT,"
                + COLUMN_TODO_IS_DONE + " INTEGER,"
                + COLUMN_TODO_DUE_DATE + " TEXT,"
                + COLUMN_TODO_NOTE_ID + " INTEGER)";
        String createTableNotes = "CREATE TABLE " + TABLE_NOTE + "(" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                COLUMN_USER_ID + " TEXT," +
                COLUMN_TITLE + " TEXT," +
                COLUMN_CONTENT + " TEXT," +
                COLUMN_CREATED_AT + " TEXT)";
        db.execSQL(createTableNotes);
        db.execSQL(createTodosTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_TODOS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NOTE);
        onCreate(db);
    }

    public long addTodo(Todo todo) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_TODO_USER_ID, todo.getUserId());
        values.put(COLUMN_TODO_TITLE, todo.getTitle());
        values.put(COLUMN_TODO_IS_DONE, todo.isDone() ? 1 : 0);
        values.put(COLUMN_TODO_DUE_DATE, todo.getDueDate());
        values.put(COLUMN_TODO_NOTE_ID, todo.getNoteId());
        return db.insert(TABLE_TODOS, null, values);
    }

    public List<Todo> getTodosByUserId(String userId) {
        SQLiteDatabase db = this.getReadableDatabase();

        List<Todo> list = new ArrayList<>();
        Cursor cursor = db.query(TABLE_TODOS, null, COLUMN_TODO_USER_ID + " = ?",
                new String[]{userId}, null, null, COLUMN_TODO_DUE_DATE + " ASC");


        if (cursor.moveToFirst()) {
            if (cursor != null && cursor.moveToFirst()) {
                do {
                    long id = cursor.getLong(cursor.getColumnIndexOrThrow(COLUMN_TODO_ID));
                    String title = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_TODO_TITLE));
                    boolean isDone = cursor.getInt(cursor.getColumnIndexOrThrow(COLUMN_TODO_IS_DONE)) == 1;
                    String dueDate = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_TODO_DUE_DATE));
                    long noteId = cursor.getLong(cursor.getColumnIndexOrThrow(COLUMN_TODO_NOTE_ID));

                    list.add(new Todo(id, userId, title, isDone, dueDate, noteId));
                } while (cursor.moveToNext());
                cursor.close();
            }
        }
        return list;
    }
    // READ BY USER_ID
    public List<Note> getNotesByUserId(String userId) {
        List<Note> noteList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_NOTE, null,
                COLUMN_USER_ID + " = ?", new String[]{userId},
                null, null, COLUMN_CREATED_AT + " DESC");

        if (cursor.moveToFirst()) {
            if (cursor != null && cursor.moveToFirst()) {
                do {
                    long id = cursor.getLong(cursor.getColumnIndexOrThrow(COLUMN_ID));
                    String title = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_TITLE));
                    String content = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_CONTENT));
                    String createdAt = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_CREATED_AT));

                    noteList.add(new Note(id, userId, title, content, createdAt));
                } while (cursor.moveToNext());
                cursor.close();
            }
        }
        return noteList;
    }

    public int updateTodoById(Todo todo) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_TODO_TITLE, todo.getTitle());
        values.put(COLUMN_TODO_IS_DONE, todo.isDone() ? 1 : 0);
        values.put(COLUMN_TODO_DUE_DATE, todo.getDueDate());
        values.put(COLUMN_TODO_NOTE_ID, todo.getNoteId());
        return db.update(TABLE_TODOS, values, COLUMN_TODO_ID + " = ?",
                new String[]{String.valueOf(todo.getId())});
    }
    public int updateNoteById(Note note) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_TITLE, note.getTitle());
        values.put(COLUMN_CONTENT, note.getContent());
        values.put(COLUMN_CREATED_AT, note.getCreatedAt());

        return db.update(TABLE_NOTE, values,
                COLUMN_ID + " = ?",
                new String[]{String.valueOf(note.getId())});
    }

    public int deleteTodoById(long id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_TODOS, COLUMN_TODO_ID + " = ?",
                new String[]{String.valueOf(id)});
    }
    // DELETE NOTE BY ID
    public int deleteNoteById(long id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NOTE,
                COLUMN_ID + " = ?",
                new String[]{String.valueOf(id)});
    }

    // ADD NEW NOTE
    public long addNote(Note note) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_USER_ID, note.getUserId());
        values.put(COLUMN_TITLE, note.getTitle());
        values.put(COLUMN_CONTENT, note.getContent());
        values.put(COLUMN_CREATED_AT, note.getCreatedAt());

        return db.insert(TABLE_NOTE, null, values); // trả về ID mới hoặc -1 nếu lỗi
    }
}