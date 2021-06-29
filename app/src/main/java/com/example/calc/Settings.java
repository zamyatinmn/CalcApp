package com.example.calc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.RadioButton;

public class Settings extends AppCompatActivity {
    RadioButton lightBtn;
    RadioButton darkBtn;
    static final int LIGHT = 1;
    static final int DARK = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        initViews();
        switch (getIntent().getExtras().getInt("mode")){
            case LIGHT:
                lightBtn.setChecked(true);
                break;
            case DARK:
                darkBtn.setChecked(true);
                break;
        }
    }

    private void initViews() {
        lightBtn = findViewById(R.id.lightTheme);
        darkBtn = findViewById(R.id.darkTheme);
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent();
        if (lightBtn.isChecked()){
            intent.putExtra("mode", LIGHT);
        } else {
            intent.putExtra("mode", DARK);
        }

        setResult(RESULT_OK, intent);
        finish();
        super.onBackPressed();
    }
}