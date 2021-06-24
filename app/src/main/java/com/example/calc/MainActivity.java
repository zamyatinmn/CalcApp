package com.example.calc;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, IMainActivity {

    private final String KEY_TOP = "1";
    private final String KEY_BOT = "2";
    private final String KEY_VAL1 = "3";
    private final String KEY_VAL2 = "4";
    private TextView tvTop;
    private TextView tvBot;
    private Button b1;
    private Button b2;
    private Button b3;
    private Button b4;
    private Button b5;
    private Button b6;
    private Button b7;
    private Button b8;
    private Button b9;
    private Button b0;
    private Button dot;
    private Button result;
    private Button plus;
    private Button minus;
    private Button div;
    private Button mul;
    private Button percent;
    private Button del;
    private Button clear;
    private final IPresenter presenter = new Presenter(this);
    private boolean theme = true;
    private final String PREFS_KEY = "prefs";
    private final String NIGHT_MODE_KEY = "mode";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        theme = getSharedPreferences(PREFS_KEY, MODE_PRIVATE).getBoolean(NIGHT_MODE_KEY, true);
        if (theme){
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        }
        setContentView(R.layout.activity_main);
        initViews();
        setListeners();
        findViewById(R.id.view).setOnLongClickListener(v -> {
            SharedPreferences prefs = getSharedPreferences(PREFS_KEY, MODE_PRIVATE);
            prefs.edit().putBoolean(NIGHT_MODE_KEY, !theme).apply();
            recreate();
            return false;
        });
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(KEY_TOP, tvTop.getText().toString());
        outState.putString(KEY_BOT, tvBot.getText().toString());
        outState.putDouble(KEY_VAL1, presenter.getVal1());
        outState.putDouble(KEY_VAL2, presenter.getVal2());
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        tvTop.setText(savedInstanceState.getString(KEY_TOP));
        tvBot.setText(savedInstanceState.getString(KEY_BOT));
        presenter.setValues(savedInstanceState.getDouble(KEY_VAL1)
                , savedInstanceState.getDouble(KEY_VAL2));
    }

    private void initViews() {
        tvTop = findViewById(R.id.tvTop);
        tvBot = findViewById(R.id.tvBot);
        tvTop.setMovementMethod(new ScrollingMovementMethod());
        tvBot.setMovementMethod(new ScrollingMovementMethod());
        b1 = findViewById(R.id.btn1);
        b2 = findViewById(R.id.btn2);
        b3 = findViewById(R.id.btn3);
        b4 = findViewById(R.id.btn4);
        b5 = findViewById(R.id.btn5);
        b6 = findViewById(R.id.btn6);
        b7 = findViewById(R.id.btn7);
        b8 = findViewById(R.id.btn8);
        b9 = findViewById(R.id.btn9);
        b0 = findViewById(R.id.btn0);
        dot = findViewById(R.id.btnDot);
        result = findViewById(R.id.btnResult);
        plus = findViewById(R.id.btnPlus);
        minus = findViewById(R.id.btnMinus);
        div = findViewById(R.id.btnDivision);
        mul = findViewById(R.id.btnMultiply);
        percent = findViewById(R.id.btnPercent);
        del = findViewById(R.id.btnDel);
        clear = findViewById(R.id.btnClear);
    }

    private void setListeners() {
        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        b4.setOnClickListener(this);
        b5.setOnClickListener(this);
        b6.setOnClickListener(this);
        b7.setOnClickListener(this);
        b8.setOnClickListener(this);
        b9.setOnClickListener(this);
        b0.setOnClickListener(this);
        dot.setOnClickListener(this);
        result.setOnClickListener(this);
        plus.setOnClickListener(this);
        minus.setOnClickListener(this);
        div.setOnClickListener(this);
        mul.setOnClickListener(this);
        percent.setOnClickListener(this);
        del.setOnClickListener(this);
        clear.setOnClickListener(this);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn1:
                presenter.b1Clicked();
                break;
            case R.id.btn2:
                presenter.b2Clicked();
                break;
            case R.id.btn3:
                presenter.b3Clicked();
                break;
            case R.id.btn4:
                presenter.b4Clicked();
                break;
            case R.id.btn5:
                presenter.b5Clicked();
                break;
            case R.id.btn6:
                presenter.b6Clicked();
                break;
            case R.id.btn7:
                presenter.b7Clicked();
                break;
            case R.id.btn8:
                presenter.b8Clicked();
                break;
            case R.id.btn9:
                presenter.b9Clicked();
                break;
            case R.id.btn0:
                presenter.b0Clicked();
                break;
            case R.id.btnDot:
                presenter.dotClicked();
                break;
            case R.id.btnResult:
                presenter.resultClicked();
                break;
            case R.id.btnPlus:
                presenter.plusClicked();
                break;
            case R.id.btnMinus:
                presenter.minusClicked();
                break;
            case R.id.btnDivision:
                presenter.divClicked();
                break;
            case R.id.btnMultiply:
                presenter.mulClicked();
                break;
            case R.id.btnPercent:
                presenter.percentClicked();
                break;
            case R.id.btnDel:
                presenter.delClicked();
                break;
            case R.id.btnClear:
                presenter.clearClicked();
                break;
        }
    }

    @Override
    public String getTop() {
        return tvTop.getText().toString();
    }

    @Override
    public String getBot() {
        return tvBot.getText().toString();
    }

    @Override
    public void setTop(String text) {
        tvTop.setText(text);
    }

    @Override
    public void setBot(String text) {
        tvBot.setText(text);
    }
}