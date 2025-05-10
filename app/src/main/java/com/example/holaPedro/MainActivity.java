package com.example.holaPedro;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;              // <-- Import añadido
import android.os.Bundle;
import android.view.View;                  // <-- Import añadido
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.snackbar.Snackbar;

import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.CalendarView;
import android.widget.ImageButton;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    private Button btnShow;
    private EditText edtMessage;
    private CheckBox chkConfirmed;
    private CalendarView calendarView;
    private ImageButton imgNavigate;
    private String selectedDate = "";

    @SuppressLint("SimpleDateFormat")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Cambia el color de fondo a celeste
        View root = findViewById(R.id.main);
        root.setBackgroundColor(Color.parseColor("#ADD8E6"));

        // Ajuste de márgenes para sistema de barras
        ViewCompat.setOnApplyWindowInsetsListener(root, (view, insets) -> {
            Insets bars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            view.setPadding(bars.left, bars.top, bars.right, bars.bottom);
            return insets;
        });

        // Obtener hora actual
        String currentTime = new SimpleDateFormat("HH:mm").format(new Date());

        // Referencias a vistas
        btnShow     = findViewById(R.id.btnHola);
        edtMessage  = findViewById(R.id.textView);
        chkConfirmed= findViewById(R.id.checkBox);
        calendarView= findViewById(R.id.calendarView);
        imgNavigate = findViewById(R.id.imageButton);

        // Listener para selección de fecha
        calendarView.setOnDateChangeListener((view, year, month, dayOfMonth) -> {
            selectedDate = String.format("%02d/%02d/%04d", dayOfMonth, month + 1, year);
        });

        // Evento del botón principal
        btnShow.setOnClickListener(v -> {
            String toastMsg = String.join(", ",
                    edtMessage.getText().toString(),
                    String.valueOf(chkConfirmed.isChecked()),
                    currentTime,
                    selectedDate
            );
            Toast.makeText(this, toastMsg, Toast.LENGTH_LONG).show();

            Snackbar.make(v, "¡Hola a todo el Mundo! Esto es Desarrollo Móvil", Snackbar.LENGTH_LONG)
                    .show();
        });

        // Navegación a segunda actividad
        imgNavigate.setOnClickListener(v -> startActivity(new Intent(this, MainActivity2.class)));
    }
}
