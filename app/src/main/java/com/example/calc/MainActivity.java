package com.example.calc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView tvTop = findViewById(R.id.tvTop);
        final TextView tvBot = findViewById(R.id.tvBot);
        tvTop.setMovementMethod(new ScrollingMovementMethod());
        tvBot.setMovementMethod(new ScrollingMovementMethod());
    }
}