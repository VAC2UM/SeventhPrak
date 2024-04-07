package com.itproger.seventhprak;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private int hour;
    private int minute;
    private int year;
    private int month;
    private int day;

    TextView textView;
    EditText inputText;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Запуск сервиса для воспроизведения музыки
//        Intent startIntent = new Intent(this, MusicService.class);
//        startService(startIntent);

        // AlertDialod
//        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
//        // Установка заголовка и сообщения диалогового окна
//        builder.setTitle("Подтверждение");
//        builder.setMessage("Вы уверены, что хотите выполнить это действие?");
//        builder.setIcon(android.R.drawable.ic_dialog_alert);
//
//        // Установка кнопки "Да" и ее обработчика
//        builder.setPositiveButton("Да", new  DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                // Обработка подтверждения
//            }
//        });
//        // Установка кнопки "Отмена" и ее обработчика
//        builder.setNegativeButton("Отмена", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                // Обработка отмены действия
//                dialog.dismiss();
//            }
//        });
//        // Создание и отображение AlertDialog
//        AlertDialog dialog = builder.create();
//        dialog.show();

        // Создание и отображение TimePickerDialog
//        TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
//            @Override
//            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
//            // Обработка выбранного времени
//            // Пример: установка времени в TextView
//            // textView.setText(hourOfDay + ":" + minute);
//            }
//        }, hour, minute, true); // Использование 24- часового формата
//        timePickerDialog.show();

        textView = findViewById(R.id.text_view);
        inputText = findViewById(R.id.editText);
        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String dateText = inputText.getText().toString();
                // Разбиваем текст на число, месяц и год
                String[] dateParts = dateText.split("/");
                int day = Integer.parseInt(dateParts[0]);
                int month = Integer.parseInt(dateParts[1]) - 1; // Уменьшаем на 1, так как в Java месяцы начинаются с 0
                int year = Integer.parseInt(dateParts[2]);

                // Передаем значения во вторую активность
                Intent intent = new Intent(MainActivity.this, DateActivity.class);
                intent.putExtra("day", day);
                intent.putExtra("month", month);
                intent.putExtra("year", year);
                startActivity(intent);
            }
        });
    }

    public void updateText() {
        textView.setText("This date " + inputText.getText());
        System.out.println("Button clicked");
    }
//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        // Остановка сервиса и музыки при уничтожении активности
//        Intent stopIntent = new Intent(this, MusicService.class);
//        stopService(stopIntent);
//    }
}