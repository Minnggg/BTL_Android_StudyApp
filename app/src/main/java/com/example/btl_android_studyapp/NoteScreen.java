package com.example.btl_android_studyapp;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.btl_android_studyapp.adapter.NoteAdapter;
import com.example.btl_android_studyapp.model.Note;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class NoteScreen extends AppCompatActivity implements NoteAdapter.onLongClickItem  {
    DatabaseHelper db;
    List<Note> allNote;
    RecyclerView rvListNote;
    ImageButton btnAdd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_note_screen);
        db = new DatabaseHelper(NoteScreen.this);
        rvListNote = findViewById(R.id.rvListNote);
        btnAdd = findViewById(R.id.btnAddNote);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAddNoteDialog();
            }
        });
        displayAllNote();
    }

    private void displayAllNote() {
        allNote = db.getNotesByUserId(Contanst.userCurrent.getUserName());
        rvListNote.setLayoutManager(new LinearLayoutManager(NoteScreen.this));
        NoteAdapter adapter = new NoteAdapter(allNote, NoteScreen.this);
        adapter.setInterfaces(this);
        rvListNote.setAdapter(adapter);
    }

    @Override
    public void onLongClick(Note note) {
        showEditOrDeleteNoteDialog(note);
    }

    private void showEditOrDeleteNoteDialog(Note note) {
        AlertDialog.Builder builder = new AlertDialog.Builder(NoteScreen.this);
        builder.setTitle("Chỉnh sửa ghi chú");

        View view = LayoutInflater.from(NoteScreen.this).inflate(R.layout.dialog_add_note, null);
        builder.setView(view);

        EditText edtContent = view.findViewById(R.id.edtNoteContent);
        EditText edtNoteTitle = view.findViewById(R.id.edtNoteTitle);

        edtContent.setText(note.getContent());
        edtNoteTitle.setText(note.getTitle());
        builder.setPositiveButton("Lưu", (dialog, which) -> {
            String newContent = edtContent.getText().toString().trim();
            String title = edtNoteTitle.getText().toString().trim();

            if (!newContent.isEmpty() && !title.isEmpty()) {
                note.setContent(newContent);
                note.setCreatedAt(new SimpleDateFormat("dd/MM/yyyy HH:mm", Locale.getDefault()).format(new Date()));
                db.updateNoteById(note);
                displayAllNote();
            } else {
                Toast.makeText(NoteScreen.this, "Tiêu đề và nội dung không được để trống", Toast.LENGTH_SHORT).show();
            }
        });

        builder.setNeutralButton("Xoá", (dialog, which) -> {
            db.deleteNoteById(note.getId());
            displayAllNote();
            Toast.makeText(NoteScreen.this, "Đã xoá ghi chú", Toast.LENGTH_SHORT).show();
        });

        builder.setNegativeButton("Huỷ", null);

        builder.show();
    }

    private void showAddNoteDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(NoteScreen.this);
        builder.setTitle("Thêm ghi chú");

        View view = getLayoutInflater().inflate(R.layout.dialog_add_note, null);
        builder.setView(view);

        EditText edtNoteContent = view.findViewById(R.id.edtNoteContent);
        EditText edtNoteTitle = view.findViewById(R.id.edtNoteTitle);

        builder.setPositiveButton("Lưu", (dialog, which) -> {
            String content = edtNoteContent.getText().toString().trim();
            String title = edtNoteTitle.getText().toString().trim();
            String createdAt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(new Date());

            if (content.isEmpty()) {
                Toast.makeText(NoteScreen.this, "Nội dung không được để trống", Toast.LENGTH_LONG).show();
                return;
            }

            if (title.isEmpty()) {
                Toast.makeText(NoteScreen.this, "Tiêu đề không được để trống", Toast.LENGTH_LONG).show();
                return;
            }

            Note newNote = new Note(Contanst.userCurrent.getUserName(), title, content, createdAt);
            db.addNote(newNote);
            Toast.makeText(NoteScreen.this, "Đã thêm ghi chú", Toast.LENGTH_SHORT).show();
            displayAllNote();
        });

        builder.setNegativeButton("Hủy", null);
        builder.show();
    }
}