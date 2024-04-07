package com.itproger.seventhprak;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.widget.DatePicker;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class DateActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date);

        // Получаем переданные значения из Intent
        int day = getIntent().getIntExtra("day", 1); // По умолчанию 1
        int month = getIntent().getIntExtra("month", 0); // По умолчанию 0
        int year = getIntent().getIntExtra("year", 2022); // По умолчанию 2022

        // Создание обработчика выбора даты
        DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                // Обработка выбора даты
            }
        };
        // Создание и отображение DatePickerDialog
        DatePickerDialog datePickerDialog = new DatePickerDialog(DateActivity.this, dateSetListener,
                year, month, day);
        datePickerDialog.show();
    }
}