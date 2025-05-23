package com.example.btl_android_studyapp;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.btl_android_studyapp.adapter.TodoAdapter;
import com.example.btl_android_studyapp.model.Todo;

import java.util.Calendar;
import java.util.List;

public class ToDoScreen extends AppCompatActivity {

    ImageButton btnAddTodo;
    RecyclerView rvListTodo;
    List<Todo> listTodo;
    DatabaseHelper db;
    TodoAdapter todoAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_to_do_screen);
        btnAddTodo = findViewById(R.id.btnAddTodo);
        rvListTodo = findViewById(R.id.rvListTodo);

        db = new DatabaseHelper(ToDoScreen.this);
        btnAddTodo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAddTodoDialog();
            }
        });

        listTodo = db.getTodosByUserId(Contanst.userCurrent.getUserName());
        rvListTodo.setLayoutManager(new LinearLayoutManager(ToDoScreen.this));
        todoAdapter = new TodoAdapter(ToDoScreen.this, listTodo, new TodoAdapter.OnTodoClickListener() {
            @Override
            public void onTodoClick(Todo todo) {
                showEditDeleteTodoDialog(todo);
            }

            @Override
            public void onStatusChanged(Todo todo, boolean isDone) {
                todo.setDone(isDone);
                db.updateTodoById(todo);
            }
        });
        rvListTodo.setAdapter(todoAdapter);
    }

    private void showAddTodoDialog() {
        View view = LayoutInflater.from(ToDoScreen.this).inflate(R.layout.dialog_add_todo, null);
        EditText etTitle = view.findViewById(R.id.etTitle);
        EditText etDueDate = view.findViewById(R.id.etDueDate);

        // Tạo dialog
        AlertDialog.Builder builder = new AlertDialog.Builder(ToDoScreen.this);
        builder.setTitle("Thêm To-Do")
                .setView(view)
                .setPositiveButton("Lưu", (dialog, which) -> {
                    String title = etTitle.getText().toString();
                    String dueDate = etDueDate.getText().toString();
                    if (!title.isEmpty() && !dueDate.isEmpty()) {
                        Todo newTodo = new Todo(Contanst.userCurrent.getUserName(), title, false, dueDate, 0);
                        db.addTodo(newTodo);
                        listTodo.add(newTodo);
                        todoAdapter.notifyDataSetChanged();
                    } else {
                        Toast.makeText(ToDoScreen.this, "Vui lòng điền đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                    }
                })
                .setNegativeButton("Hủy", (dialog, which) -> dialog.dismiss())
                .create()
                .show();

        etDueDate.setOnClickListener(v -> showDateTimePicker(etDueDate));
    }

    private void showDateTimePicker(final EditText etDueDate) {
        final Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);

        DatePickerDialog datePickerDialog = new DatePickerDialog(ToDoScreen.this, (view, selectedYear, selectedMonth, selectedDay) -> {
            TimePickerDialog timePickerDialog = new TimePickerDialog(ToDoScreen.this, (timeView, selectedHour, selectedMinute) -> {
                String dueDate = String.format("%02d/%02d/%04d %02d:%02d", selectedDay, selectedMonth + 1, selectedYear, selectedHour, selectedMinute);
                etDueDate.setText(dueDate);
            }, hour, minute, true);
            timePickerDialog.show();
        }, year, month, day);

        datePickerDialog.show();
    }

    private void showEditDeleteTodoDialog(Todo todo) {
        View view = LayoutInflater.from(ToDoScreen.this).inflate(R.layout.dialog_add_todo, null);
        EditText etTitle = view.findViewById(R.id.etTitle);
        EditText etDueDate = view.findViewById(R.id.etDueDate);

        etTitle.setText(todo.getTitle());
        etDueDate.setText(todo.getDueDate());

        AlertDialog.Builder builder = new AlertDialog.Builder(ToDoScreen.this);
        builder.setTitle("Chỉnh sửa To-Do")
                .setView(view)
                .setPositiveButton("Lưu", (dialog, which) -> {
                    String title = etTitle.getText().toString();
                    String dueDate = etDueDate.getText().toString();

                    if (!title.isEmpty() && !dueDate.isEmpty()) {
                        todo.setTitle(title);
                        todo.setDueDate(dueDate);
                        db.updateTodoById(todo);
                        todoAdapter.notifyDataSetChanged();
                    } else {
                        Toast.makeText(ToDoScreen.this, "Vui lòng điền đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                    }
                })
                .setNeutralButton("Xóa", (dialog, which) -> {
                    db.deleteTodoById(todo.getId());
                    listTodo.remove(todo);
                    todoAdapter.notifyDataSetChanged();
                })
                .setNegativeButton("Hủy", (dialog, which) -> dialog.dismiss())
                .create()
                .show();

        etDueDate.setOnClickListener(v -> showDateTimePicker(etDueDate));
    }

}