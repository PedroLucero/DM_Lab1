package com.example.holaPedro;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {
    private static final String TAG = MainActivity2.class.getSimpleName();
    private Button btnFinish;
    private EditText edtNumber;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);

        // Ajuste de márgenes para barras del sistema
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (view, insets) -> {
            Insets bars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            view.setPadding(bars.left, bars.top, bars.right, bars.bottom);
            return insets;
        });

        logState("onCreate");

        edtNumber = findViewById(R.id.cajaNum);
        btnFinish = findViewById(R.id.button);
        btnFinish.setOnClickListener(v -> finish());
    }

    private void logState(String state) {
        Log.d(TAG, "Activity " + state);
    }

    @Override
    protected void onStart() {
        super.onStart();
        logState("started");
    }

    @Override
    protected void onResume() {
        super.onResume();
        logState("resumed");
    }

    @Override
    protected void onPause() {
        super.onPause();
        logState("paused");
        edtNumber.setText("");
    }

    @Override
    protected void onStop() {
        super.onStop();
        logState("stopped");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        edtNumber.setText("1");
        logState("restarted");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        logState("destroyed");
    }
}
