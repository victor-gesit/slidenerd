package com.example.android.myapplication;

import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TextView textView = new TextView(this);
        textView.setText("Hello, it's me!");
        textView.setTextSize(20);
        textView.setTypeface(Typeface.defaultFromStyle(2));
        textView.setTextColor(Color.GREEN);
        setContentView(textView);
    }
}
