package com.example.runnablehandler;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    TextView timerTextView;
    Button startButton;
    Button stopButton;
    Runnable runnable;
    Handler handler = new Handler();
    int seconds = 0;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        timerTextView = findViewById(R.id.timerTextView);
        startButton = findViewById(R.id.startButton);
        stopButton = findViewById(R.id.stopButton);
    }

    public void start(View view){
        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                timerTextView.setText("Timer: " + seconds);
                seconds++;
                timerTextView.setText("Timer: " + seconds);
                handler.postDelayed(runnable, 1000);
            }
        };
        handler.post(runnable);
        startButton.setEnabled(false);
        stopButton.setEnabled(true);
    }

    public void stop(View view){
        handler.removeCallbacks(runnable);
        startButton.setEnabled(true);
        stopButton.setEnabled(false);
        seconds = 0;
        timerTextView.setText("Timer: " + seconds);
    }
}